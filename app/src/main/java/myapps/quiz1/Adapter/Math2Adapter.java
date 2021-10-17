package myapps.quiz1.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import myapps.quiz1.Model.SubjectList8;
import myapps.quiz1.R;

/**
 * Created by comsol on 01-Feb-18.
 */
public class Math2Adapter extends ArrayAdapter<SubjectList8> {

    private final Context context;
    private final ArrayList<SubjectList8> itemsArrayList;

    public Math2Adapter(Context context, ArrayList<SubjectList8> itemsArrayList) {

        super(context, R.layout.textlist, itemsArrayList);

        this.context = context;
        this.itemsArrayList = itemsArrayList;
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // 1. Create inflater
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // 2. Get rowView from inflater
        View rowView = inflater.inflate(R.layout.textlist, parent, false);

        // 3. Get the two text view from the rowView
        TextView labelView = (TextView) rowView.findViewById(R.id.label);
        TextView valueView = (TextView) rowView.findViewById(R.id.value);

        // 4. Set the text for textView
        labelView.setText(itemsArrayList.get(position).getTitle());
        valueView.setText(itemsArrayList.get(position).getDescription());

        // 5. retrn rowView
        return rowView;
    }
}
