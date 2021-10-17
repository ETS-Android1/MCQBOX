package myapps.quiz1.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import myapps.quiz1.Model.Shortcut;
import myapps.quiz1.R;

/**
 * Created by comsol on 13-Feb-18.
 */
public class Short1stAdapter extends BaseAdapter {
    private Context mCtx;
    private ArrayList<Shortcut> allshort;
    private ArrayList<Shortcut> mFilteredList;
    int numtest=0,num;


    public Short1stAdapter(Context mCtx, ArrayList<Shortcut> allshort){
        this.mCtx = mCtx;
        this.allshort = allshort;
        this.mFilteredList = allshort;


    }
    @Override
    public int getCount() {
        return allshort.size();

        // return mFilteredList.size();
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
    public View getView(final int position, View convertView, final ViewGroup parent) {

        final Shortcut all = allshort.get(position);

        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.technique_list, null);


        TextView textView = (TextView) view.findViewById(R.id.help);
        textView.setText(all.getHelp());

       /* final TextView textView5 = (TextView) view.findViewById(R.id.ans);
        textView5.setVisibility(View.INVISIBLE);
        textView5.setText(hero.getAns());
        Button button1 = (Button) view.findViewById(R.id.ans1);
        button1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                textView5.setVisibility(View.VISIBLE);
            }


        });
        Button button = (Button) view.findViewById(R.id.help);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), HelpActivity.class);
                myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mCtx.startActivity(myIntent);
            }


        });*/

        return view;




    }



}


