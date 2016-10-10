package example.thuya.com.finalproject;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.GroundOverlay;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import example.thuya.com.finalproject.model.ObjectList;
import example.thuya.com.finalproject.model.Objects;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback,
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener,
        LocationListener,
        GoogleMap.OnGroundOverlayClickListener {

    private GoogleMap mMap;
    GoogleApiClient mGoogleApiClient;
    Location mLastLocation;
    Marker mCurrLocationMarker;
    LocationRequest mLocationRequest;

    private Button b_toHome,b_toObjects, b_ZoomIn, b_ZoomOut;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        b_toHome = (Button) findViewById(R.id.b_reHome);
        b_toObjects = (Button) findViewById(R.id.b_toObject);
        b_ZoomIn = (Button) findViewById(R.id.zoomin);
        b_ZoomOut = (Button) findViewById(R.id.zoomout);

        b_toObjects.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (ObjectList.getExistedObjectsList().size()==0){
                    Toast.makeText(getApplicationContext(),"No object found",Toast.LENGTH_LONG).show();
                }else {

                    LatLng objectPlaces = ObjectList.getExistedObjectsList().get(0).getLatLng();
                    // mMap.addMarker(new MarkerOptions().position(montreal).title("Welcome to Montreal"));
                    CameraUpdate objectPlacesLocation = CameraUpdateFactory.newLatLngZoom(objectPlaces, 8);
                    mMap.animateCamera(objectPlacesLocation);
                }

            }
        });


        b_toHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MapsActivity.this,MainActivity.class);
                startActivity(intent);

            }
        });

        b_ZoomIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMap.animateCamera(CameraUpdateFactory.zoomIn());
            }
        });

        b_ZoomOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMap.animateCamera(CameraUpdateFactory.zoomOut());
            }
        });


    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;

        if (ObjectList.getExistedObjectsList().size()==0){
            // Add a marker in my home town and move the camera
            LatLng hometown = new LatLng(16.34, 107.5);
            mMap.addMarker(new MarkerOptions().position(hometown).title("Welcome to my hometown, Hue City"));
            CameraUpdate hometownnPlace = CameraUpdateFactory.newLatLngZoom(hometown, 5);
            mMap.animateCamera(hometownnPlace);

            mMap.moveCamera(CameraUpdateFactory.newLatLng(hometown));
        }else {
            LatLng objectPlaces = ObjectList.getExistedObjectsList().get(0).getLatLng();
            // mMap.addMarker(new MarkerOptions().position(montreal).title("Welcome to Montreal"));
            CameraUpdate objectPlacesLocation = CameraUpdateFactory.newLatLngZoom(objectPlaces, 8);
            mMap.animateCamera(objectPlacesLocation);
        }



        //Initialize Google Play Services
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)
                    == PackageManager.PERMISSION_GRANTED) {
                buildGoogleApiClient();
                mMap.setMyLocationEnabled(true);
            }
        } else {
            buildGoogleApiClient();
            mMap.setMyLocationEnabled(true);
        }


        //Add an Overlay Image
        for (Objects ob:ObjectList.getExistedObjectsList()){
           MapActivitiesMethods.addOverlayImage(mMap,ob);
        }

        //Listeners
        mMap.setOnGroundOverlayClickListener(this);

    }

    protected synchronized void buildGoogleApiClient() {
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
        mGoogleApiClient.connect();
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(1000);
        mLocationRequest.setFastestInterval(1000);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, this);
        }

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    public void onLocationChanged(Location location) {
        mLastLocation = location;
        if (mCurrLocationMarker != null) {
            mCurrLocationMarker.remove();
        }


        //Place current location marker
        LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(latLng);
        markerOptions.title("Current Position");
        markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA));
        mCurrLocationMarker = mMap.addMarker(markerOptions);


        //move map camera
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(14));


        //stop location updates
        if (mGoogleApiClient != null) {
            LocationServices.FusedLocationApi.removeLocationUpdates(mGoogleApiClient, this);
        }

    }

    @Override
    public void onGroundOverlayClick(GroundOverlay groundOverlay) {

        Toast.makeText(this, "Image is picked off the map at: " + groundOverlay.getPosition().toString() ,
                Toast.LENGTH_SHORT).show();

        //Find object was clicked on the Object List
        Objects obj = ObjectList.findObjectByPosition(ObjectList.getExistedObjectsList(),groundOverlay.getPosition());

        //Add Object to Pick up Object List
        ObjectList.addToPickuObjectsList(obj);
        //Remove object from Existing Object List
        ObjectList.removeFromExistedObjectsList(obj);

        //groundOverlay.setImage(BitmapDescriptorFactory.fromResource(R.drawable.image2));
        groundOverlay.setVisible(false);
        groundOverlay.remove();

    }
}
