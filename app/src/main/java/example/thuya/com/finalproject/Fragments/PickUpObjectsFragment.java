package example.thuya.com.finalproject.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import example.thuya.com.finalproject.R;

/**
 * Created by thuyha on 05/10/2016.
 */

public class PickUpObjectsFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup containner, Bundle saveInstanceState){
        View rootView = inflater.inflate(R.layout.fragment_pickup_objects, containner, false);
        return rootView;
    }

}
