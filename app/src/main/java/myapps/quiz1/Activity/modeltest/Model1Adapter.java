package myapps.quiz1.Activity.modeltest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import myapps.quiz1.Model.Chapter_test1;
import myapps.quiz1.R;

/**
 * Created by comsol on 31-May-18.
 */
public class Model1Adapter extends BaseAdapter {

    private final Context context;
    private final ArrayList<Chapter_test1> chapterDatas;

    public Model1Adapter(Context context, ArrayList<Chapter_test1> chapterDatas) {

        this.context = context;
        this.chapterDatas = chapterDatas;
    }

    @Override
    public int getCount() {
        return chapterDatas.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // 2. Get rowView from inflater
        View rowView = inflater.inflate(R.layout.modellist, parent, false);

        // 3. Get the two text view from the rowView
        TextView labelView = (TextView) rowView.findViewById(R.id.label);

        // 4. Set the text for textView
        labelView.setText(chapterDatas.get(position).getModel());


        // 5. retrn rowView
        return rowView;
    }
}


/*public class ModelATestAdapter extends ArrayAdapter<ModelList> {

    private final Context context;
    private final ArrayList<Chapter_test> itemsArrayList;

    public ModelATestAdapter(Context context, ArrayList<Chapter_test> itemsArrayList) {

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
    }*/
