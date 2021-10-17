package myapps.quiz1;

import android.app.ProgressDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import myapps.quiz1.Model.Course_listdata;

/**
 * Created by comsol on 27-Feb-18.
 */

public class CourseAdapter extends BaseAdapter {
    private Context mCtx;
    private ArrayList<Course_listdata> allDatass;

    private final int[] Imageid;
    private ArrayList<Course_listdata> mFilteredList;
    private ProgressDialog pDialog;


    public CourseAdapter(Context mCtx, ArrayList<Course_listdata> allDatass,int[] Imageid) {
        this.mCtx = mCtx;
        this.allDatass = allDatass;
        this.mFilteredList = allDatass;

        this.Imageid=Imageid;

    }

    @Override
    public int getCount() {
        return allDatass.size();
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
        final Course_listdata list1 = allDatass.get(position);

        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.course_grid, null);
        TextView textView = (TextView) view.findViewById(R.id.grid_text);
        textView.setText(list1.getcourse());
        ImageView imageView = (ImageView)view.findViewById(R.id.grid_image);
        imageView.setImageResource(Imageid[position]);
        return view;
    }
}
/*public class CourseAdapter  extends BaseAdapter {
    private Context mContext;
    private final String[] course;
    private final int[] Imageid;

    public CourseAdapter(Context c,String[] course,int[] Imageid ) {
        mContext = c;
        this.Imageid = Imageid;
        this.course = course;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return course.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        View grid;
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {

            grid = new View(mContext);
            grid = inflater.inflate(R.layout.course_grid, null);
            TextView textView = (TextView) grid.findViewById(R.id.grid_text);
            ImageView imageView = (ImageView)grid.findViewById(R.id.grid_image);
            textView.setText(course[position]);
            imageView.setImageResource(Imageid[position]);
        } else {
            grid = (View) convertView;
        }

        return grid;
    }
}
*/