import APIGateway.APIGateway;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Objects;
public class PositionStackAPI implements APIGateway {
    private final String apiKey;
    public PositionStackAPI(String apiKey){
        this.apiKey = apiKey;
    }
    @Override
    public Object[] getGeocode(String address) {
        ArrayList<Double> returnArr = new ArrayList<>();
        String addressFormatted = address.replaceAll(" ", "%20");
        String uriString = "http://api.positionstack.com/v1/forward?access_key=" + this.apiKey + "&query=" +
                addressFormatted + "&limit=1";
        try{
            HttpRequest requestApi = HttpRequest.newBuilder().uri(new URI(uriString)).GET().build();
            HttpClient httpClient = HttpClient.newHttpClient();
            HttpResponse<String> apiResponse  = httpClient.send(requestApi, HttpResponse.BodyHandlers.ofString());
            String responseFormatted = apiResponse.body().replace("{\"data\":[{", "");
            if(responseFormatted.length() < 10){return returnArr.toArray();}
            String[] splitResponses = responseFormatted.split(",");
            for(String keyValue : splitResponses){
                String[] splitValues = keyValue.split(":");
                if(Objects.equals(splitValues[0], "\"latitude\"") || Objects.equals(splitValues[0],
                        "\"longitude\"")){
                    returnArr.add(Double.parseDouble(splitValues[1]));
                }
            }
        }catch(Exception error){
            System.out.println(error);
        }
        return returnArr.toArray();
    }
}
