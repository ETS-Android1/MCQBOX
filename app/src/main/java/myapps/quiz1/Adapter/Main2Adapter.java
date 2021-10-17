package myapps.quiz1.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import myapps.quiz1.R;

/**
 * Created by comsol on 28-Feb-18.
 */
public class Main2Adapter  extends BaseAdapter {
    private Context mContext;
    TextView textView, textView1 , textView2;
    private final String[] course2;
    private final int[] Imageid2;

    public Main2Adapter(Context c, String[] course2,int[] Imageid2) {
        mContext = c;
        this.course2 = course2;
        this.Imageid2 = Imageid2;

    }



    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return Imageid2.length;

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
          /* if(position==0) {
              // grid = new View(mContext);
               grid = inflater.inflate(R.layout.model_grid, null);
               TextView textView = (TextView) grid.findViewById(R.id.grid_text);
               ImageView imageView = (ImageView) grid.findViewById(R.id.grid_image);
               textView.setText(course[position]);
               imageView.setImageResource(Imageid[position]);
           }*/

            grid = inflater.inflate(R.layout.third_grid, null);
            textView = (TextView) grid.findViewById(R.id.grid_text);
            textView.setText(course2[position]);
          //  textView1 = (TextView) grid.findViewById(R.id.grid_text1);
           // textView2 = (TextView) grid.findViewById(R.id.grid_text2);
            ImageView imageView = (ImageView) grid.findViewById(R.id.grid_image);
            imageView.setImageResource(Imageid2[position]);
            //ImageView imageView1 = (ImageView) grid.findViewById(R.id.grid_image1);
            //imageView1.setImageResource(Imageid4[position]);





        } else {
            grid = (View) convertView;
        }

        return grid;
    }
}
