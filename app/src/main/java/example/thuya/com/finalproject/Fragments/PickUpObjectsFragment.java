package example.thuya.com.finalproject.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import example.thuya.com.finalproject.adapters.ObjectListAdapter;
import example.thuya.com.finalproject.R;
import example.thuya.com.finalproject.model.ObjectList;


/**
 * Created by thuyha on 05/10/2016.
 */

public class PickUpObjectsFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup containner, Bundle saveInstanceState){
        //STEP 1
       /* final String[] PICKUP_OBJECTS_LIST =
                new String[] { "image1", "image2"};*/

        // Use Objects.getPickupObjectsList()

        // ArrayList<String> weekForecast = new ArrayList<String>(Arrays.asList(forecastArray));

        //STEP 2 : Adapter
        //ArrayAdapter adapter = new ArrayAdapter<String>(getActivity(), R.layout.my_textview_container, R.id.textview_item, forecastArray);

        ArrayAdapter adapter = new ObjectListAdapter(getActivity().getApplicationContext(), ObjectList.getPickupObjectsList());

        //STEP 3
        View rootView = inflater.inflate(R.layout.fragment_pickup_objects, containner, false);

        //STEP 4: listView
        ListView list_view = (ListView) rootView.findViewById(R.id.listView_pickupObjects);

        //STEP 5:
        list_view.setAdapter(adapter);

        return rootView;
    }

}
