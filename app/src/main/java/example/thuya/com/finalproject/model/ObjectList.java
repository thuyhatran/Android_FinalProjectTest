package example.thuya.com.finalproject.model;

import com.google.android.gms.maps.model.LatLng;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import example.thuya.com.finalproject.R;

/**
 * Created by thuyha on 07/10/2016.
 */

public class ObjectList {

   // private static List<Objects> ALL_OBJECTS_LIST = new ArrayList<>();


    private static List<Objects> ALL_OBJECTS_LIST = new ArrayList<>(Arrays.asList(
            new Objects(new LatLng(45.52, -73.56),Objects.getWidth_height(),"Red Flower", R.drawable.image1),
            new Objects(new LatLng(45.50, -73.64),Objects.getWidth_height(),"Yellow Flower", R.drawable.image2),
            new Objects(new LatLng(45.55, -73.57),Objects.getWidth_height(),"Leaf", R.drawable.image3),
            new Objects(new LatLng(45.51, -73.48),Objects.getWidth_height(),"Apple", R.drawable.image4)
    ));


    private static List<Objects> PICKUP_OBJECTS_LIST = new ArrayList<>();

 //   private static List<Objects> EXISTED_OBJECTS_LIST = new ArrayList<>();

   private static List<Objects> EXISTED_OBJECTS_LIST = new ArrayList<>(Arrays.asList(
           new Objects(new LatLng(45.52, -73.56),Objects.getWidth_height(),"Red Flower", R.drawable.image1),
           new Objects(new LatLng(45.50, -73.64),Objects.getWidth_height(),"Yellow Flower", R.drawable.image2),
           new Objects(new LatLng(45.55, -73.57),Objects.getWidth_height(),"Leaf", R.drawable.image3),
           new Objects(new LatLng(45.51, -73.48),Objects.getWidth_height(),"Apple", R.drawable.image4)
    ));


 /*  public static void initObjectLists(){

       ALL_OBJECTS_LIST.add(new Objects(new LatLng(45.52, -73.56),Objects.getWidth_height(),"image 1", R.drawable.image1));
       ALL_OBJECTS_LIST.add(new Objects(new LatLng(45.50, -73.64),Objects.getWidth_height(),"image 2", R.drawable.image2));
       ALL_OBJECTS_LIST.add(new Objects(new LatLng(45.55, -73.57),Objects.getWidth_height(),"image 3", R.drawable.image3));
       ALL_OBJECTS_LIST.add(new Objects(new LatLng(45.51, -73.48),Objects.getWidth_height(),"image 4", R.drawable.image4));

       EXISTED_OBJECTS_LIST.add(new Objects(new LatLng(45.52, -73.56),Objects.getWidth_height(),"image 1", R.drawable.image1));
       EXISTED_OBJECTS_LIST.add(new Objects(new LatLng(45.50, -73.64),Objects.getWidth_height(),"image 2", R.drawable.image2));
       EXISTED_OBJECTS_LIST.add(new Objects(new LatLng(45.55, -73.57),Objects.getWidth_height(),"image 3", R.drawable.image3));
       EXISTED_OBJECTS_LIST.add(new Objects(new LatLng(45.51, -73.48),Objects.getWidth_height(),"image 4", R.drawable.image4));
    }*/


    public static List<Objects> getAllObjectsList() {
        return ALL_OBJECTS_LIST;
    }

    public static void setAllObjectsList(List<Objects> allObjectsList) {
        ALL_OBJECTS_LIST = allObjectsList;
    }

    public static List<Objects> getPickupObjectsList() {
        return PICKUP_OBJECTS_LIST;
    }

    public static void setPickupObjectsList(List<Objects> pickupObjectsList) {
        PICKUP_OBJECTS_LIST = pickupObjectsList;
    }

    public static List<Objects> getExistedObjectsList() {
        return EXISTED_OBJECTS_LIST;
    }

    public static void setExistedObjectsList(List<Objects> existedObjectsList) {
        EXISTED_OBJECTS_LIST = existedObjectsList;
    }

    public static void addToPickuObjectsList(Objects ob){
        PICKUP_OBJECTS_LIST.add(ob);
    }

    public static void removeFromExistedObjectsList(Objects ob){
        EXISTED_OBJECTS_LIST.remove(ob);
    }


    public static Objects findObjectByPosition(List<Objects> list_objs, LatLng latLng){
        Objects ob=null;

        int i=0;
        while (i<list_objs.size()){
            double lat = list_objs.get(i).getLatLng().latitude;
            double lng = list_objs.get(i).getLatLng().longitude;

            if ((lat == latLng.latitude) && (lng == latLng.longitude))   {
                ob = list_objs.get(i);
                i = list_objs.size();
            }
            i++;
        }

        return ob;

    }



}
