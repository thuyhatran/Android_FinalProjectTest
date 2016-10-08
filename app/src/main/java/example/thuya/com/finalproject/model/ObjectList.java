package example.thuya.com.finalproject.model;

/**
 * Created by thuyha on 07/10/2016.
 */

public class ObjectList {

    private static String[] ALL_OBJECTS_LIST = new String[] { "image1", "image2", "image3", "image4"};

    private static String[] PICKUP_OBJECTS_LIST = new String[] { "image1", "image2"};

    public static String[] getAllObjectsList() {
        return ALL_OBJECTS_LIST;
    }

    public static void setAllObjectsList(String[] allObjectsList) {
        ALL_OBJECTS_LIST = allObjectsList;
    }

    public static String[] getPickupObjectsList() {
        return PICKUP_OBJECTS_LIST;
    }

    public static void setPickupObjectsList(String[] pickupObjectsList) {
        PICKUP_OBJECTS_LIST = pickupObjectsList;
    }
}
