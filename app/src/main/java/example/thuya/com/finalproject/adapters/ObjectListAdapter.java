package example.thuya.com.finalproject.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import example.thuya.com.finalproject.R;
import example.thuya.com.finalproject.model.Objects;

/**
 * Created by thuyha on 13/09/2016.
 */
public class ObjectListAdapter extends ArrayAdapter<Objects>{

    private final Context context;
    private final List<Objects> values;

    public ObjectListAdapter(Context context, List<Objects>  values) {
        super(context, R.layout.image_text_view, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.image_text_view, parent, false);
        TextView textView = (TextView) rowView.findViewById(R.id.name);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.logo);

        TextView textViewLatLng = (TextView) rowView.findViewById(R.id.latlng);

        //Set Text for Name textview
        textView.setText(values.get(position).getName());

        // set icon for ImageView
        Objects ob = values.get(position);
        imageView.setImageResource(ob.getDrawable_id());

        //Set Text for LatLng TextView
        textViewLatLng.setText(ob.getLatLng().toString());

        return rowView;
    }



}
