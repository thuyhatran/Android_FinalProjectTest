package example.thuya.com.finalproject.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import example.thuya.com.finalproject.R;

/**
 * Created by thuyha on 13/09/2016.
 */
public class ObjectListAdapter extends ArrayAdapter<String>{

    private final Context context;
    private final String[] values;

    public ObjectListAdapter(Context context, String[] values) {
        super(context, R.layout.image_text_view, values);
        this.context = context;
        this.values = values;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.image_text_view, parent, false);
        TextView textView = (TextView) rowView.findViewById(R.id.label);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.logo);
        textView.setText(values[position]);

        // Change icon based on name
        String s = values[position];

        System.out.println(s);

        if (s.equals("image1")) {
            imageView.setImageResource(R.drawable.image1);
        } else if (s.equals("image2")) {
            imageView.setImageResource(R.drawable.image2);
        } else if (s.equals("image3")) {
            imageView.setImageResource(R.drawable.image3);
        } else {
            imageView.setImageResource(R.drawable.image4);
        }

        return rowView;
    }



}
