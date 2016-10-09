package example.thuya.com.finalproject.model;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

/**
 * Created by thuyha on 07/10/2016.
 */

public class Objects {

    private String groundOverlayID;
    private LatLng latLng;
    private float width, height;
    private String name;
    private int drawable_id;

    private static float width_height = 1600f;

    public Objects() {
    }

    public Objects(LatLng latLng, float width, float height, String name, int drawable_id) {
        this.latLng = latLng;
        this.width = width;
        this.height = height;
        this.name = name;
        this.drawable_id = drawable_id;
    }

    public Objects(LatLng latLng, float width_height, String name, int drawable_id) {
        this.latLng = latLng;
        this.width = width_height;
        this.height = width_height;
        this.name = name;
        this.drawable_id = drawable_id;
    }

    public Objects(String name, int drawable_id) {
        this.name = name;
        this.drawable_id = drawable_id;
    }


    public String getGroundOverlayID() {
        return groundOverlayID;
    }

    public void setGroundOverlayID(String groundOverlayID) {
        this.groundOverlayID = groundOverlayID;
    }

    public LatLng getLatLng() {
        return latLng;
    }

    public void setLatLng(LatLng latLng) {
        this.latLng = latLng;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDrawable_id() {
        return drawable_id;
    }

    public void setDrawable_id(int drawable_id) {
        this.drawable_id = drawable_id;
    }

    public static float getWidth_height() {
        return width_height;
    }

    public static void setWidth_height(float width_height) {
        Objects.width_height = width_height;
    }
}
