package example.thuya.com.finalproject.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import example.thuya.com.finalproject.ObjectListAdapter;
import example.thuya.com.finalproject.R;

/**
 * Created by thuyha on 05/10/2016.
 */

public class AllObjectsFragment extends Fragment {
  /*  @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup containner, Bundle saveInstanceState){
        View rootView = inflater.inflate(R.layout.fragment_all_objects, containner, false);
        return rootView;
    }
*/

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //STEP 1
         final String[] OBJECTS_LIST =
                new String[] { "image1", "image2", "image3", "image4"};

        // ArrayList<String> weekForecast = new ArrayList<String>(Arrays.asList(forecastArray));

        //STEP 2 : Adapter
        //ArrayAdapter adapter = new ArrayAdapter<String>(getActivity(), R.layout.my_textview_container, R.id.textview_item, forecastArray);

        ArrayAdapter   adapter = new ObjectListAdapter(getActivity().getApplicationContext(),OBJECTS_LIST);

        //STEP 3
        View rootView = inflater.inflate(R.layout.fragment_all_objects, container, false);

        //STEP 4: listView
        ListView list_view = (ListView) rootView.findViewById(R.id.listView_allObjects);

        //STEP 5:
        list_view.setAdapter(adapter);

        return rootView;
    }

}
