package deliveryEntities;

public interface Delivery {

    long totalTime();
    long elapsedTime();
    boolean itemDelivered();
    String getStatus();

}
