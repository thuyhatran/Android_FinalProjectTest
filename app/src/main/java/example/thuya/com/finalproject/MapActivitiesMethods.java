package example.thuya.com.finalproject;

import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.GroundOverlay;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

import example.thuya.com.finalproject.model.ObjectList;
import example.thuya.com.finalproject.model.Objects;

/**
 * Created by thuyha on 04/10/2016.
 */

public class MapActivitiesMethods {
    public static void addOverlayImage(GoogleMap mMap, LatLngBounds bounds, int image_id) {

        //Add an overlay
        //Add overlay image
        BitmapDescriptor image = BitmapDescriptorFactory.fromResource(image_id); // get an image.

        // Adds a ground overlay with 50% transparency.
        GroundOverlayOptions groundOverlayOptions = new GroundOverlayOptions();
        GroundOverlay groundOverlay = mMap.addGroundOverlay(groundOverlayOptions
                .image(image)
                .positionFromBounds(bounds)
                .transparency((float) 0.5));
        groundOverlayOptions.clickable(true);
        mMap.addGroundOverlay(groundOverlayOptions);
    }



    public static void addOverlayImage(GoogleMap mMap, Objects object) {

        //Add an overlay
        //Add overlay image
        BitmapDescriptor image = BitmapDescriptorFactory.fromResource(object.getDrawable_id()); // get an image.

        // Adds a ground overlay with 30% transparency.
        GroundOverlayOptions groundOverlayOptions = new GroundOverlayOptions();
        GroundOverlay groundOverlay = mMap.addGroundOverlay(groundOverlayOptions
                .image(image)
                .position(object.getLatLng(), Objects.getWidth_height(), Objects.getWidth_height())
                .transparency((float) 0.3));
        groundOverlayOptions.clickable(true);
        mMap.addGroundOverlay(groundOverlayOptions);

    }

}
