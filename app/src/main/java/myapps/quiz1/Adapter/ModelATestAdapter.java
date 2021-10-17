package myapps.quiz1.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import myapps.quiz1.Model.ModelList;
import myapps.quiz1.R;

/**
 * Created by comsol on 12-Feb-18.
 */
public class ModelATestAdapter extends ArrayAdapter<ModelList> {

    private final Context context;
    private final ArrayList<ModelList> itemsArrayList;

    public ModelATestAdapter(Context context, ArrayList<ModelList> itemsArrayList) {

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
        View rowView = inflater.inflate(R.layout.modellist, parent, false);

        // 3. Get the two text view from the rowView
        TextView labelView = (TextView) rowView.findViewById(R.id.label);

        // 4. Set the text for textView
        labelView.setText(itemsArrayList.get(position).getTitle());


        // 5. retrn rowView
        return rowView;
    }
}
