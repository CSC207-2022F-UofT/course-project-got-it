package deliveryEntities;

import java.util.Timer;

public class ItemDelivery implements Delivery {

    @Override
    public long totalTime() {
        return 0;
    }

    @Override
    public long elapsedTime() {
        return System.currentTimeMillis();
    }

    @Override
    public boolean itemDelivered() {
        return totalTime() - elapsedTime() == 0;
    }

    @Override
    public String getStatus() {
        if (itemDelivered()) {
            return "Your item has been delivered!";
        }
        else {
            return "Your item is on the way!";

        }
    }
}
