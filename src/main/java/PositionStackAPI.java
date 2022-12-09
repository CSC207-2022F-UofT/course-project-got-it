import APIGateway.APIGateway;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/**
 * API to convert address to geocode and vice-versa.
 */
public class PositionStackAPI implements APIGateway {
    private final String apiKey;
    public PositionStackAPI(String apiKey){
        this.apiKey = apiKey;
    }
    @Override
    public double[] getGeocode(String address) {
        Double[] geocode = new Double[0];
        String addressFormatted = address.replaceAll(" ", "%20");
        String uriString = "http://api.positionstack.com/v1/forward?access_key=" + this.apiKey + "&query=" +
                addressFormatted + "&limit=1";
        try{
            HttpRequest requestApi = HttpRequest.newBuilder().uri(new URI(uriString)).GET().build();
            HttpClient httpClient = HttpClient.newHttpClient();
            HttpResponse<String> apiResponse = httpClient.send(requestApi, HttpResponse.BodyHandlers.ofString());
            String responseFormatted = apiResponse.body().replace("{\"data\":[{", "");
            if(responseFormatted.length() < 10){
                return convertArray(geocode);
            }
            String[] splitResponses = responseFormatted.split(",");
            ArrayList<Double> coordinates = new ArrayList<Double>();
            for(String keyValue : splitResponses){
                String[] splitValues = keyValue.split(":");
                if(Objects.equals(splitValues[0], "\"latitude\"") || Objects.equals(splitValues[0],
                        "\"longitude\"")){
                    coordinates.add(Double.parseDouble(splitValues[1]));
                }
            }
            geocode = coordinates.toArray(new Double[0]);
        }catch(Exception error){
            System.out.println(error);
        }
        System.out.println(Arrays.toString(geocode));
        return convertArray(geocode);
    }

    private double[] convertArray(Double[] arr){
        double[] result = new double[2];
        for(int i=0; i <arr.length; i++){
            result[i] = (double)arr[i];
        }
        return result;
    }

    @Override
    public String getAddress(double[] geoCode){
        String geocodeFormat = Arrays.toString(geoCode)
                .replace("[", "")
                .replace("]", "")
                .replace(" ", "");
        String uriString = "http://api.positionstack.com/v1/reverse?access_key=" + this.apiKey + "&query=" +
                geocodeFormat + "&limit=1";
        try{
            HttpRequest apiRequest = HttpRequest.newBuilder().uri(new URI(uriString)).build();
            HttpClient httpClient = HttpClient.newHttpClient();
            HttpResponse<String> apiResponse = httpClient.send(apiRequest, HttpResponse.BodyHandlers.ofString());
            String[] responseFormatted = apiResponse.body().replace("{\"data\":[{", "").split(",");
            for(String keyVal: responseFormatted){
                String[] splitKeyVal = keyVal.split(":");
                if(Objects.equals(splitKeyVal[0], "\"name\"")){
                    return splitKeyVal[1].replace("\"", "").replace("\"", "");
                }
            }
            return null;
        }catch(Exception error){
            System.out.println(error);
            return error.toString();
        }
    }
}
