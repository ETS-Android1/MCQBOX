package myapps.quiz1.Adapter;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import myapps.quiz1.Activity.help.Physics1;
import myapps.quiz1.Model.AllData;
import myapps.quiz1.R;

/**
 * Created by comsol on 02-Feb-18.
 */
public class Chapter1Adapter extends BaseAdapter {
    private Context mCtx;
    private ArrayList<AllData> allDatas;
    private ArrayList<AllData> mFilteredList;
    private ProgressDialog pDialog;


    public Chapter1Adapter(Context mCtx, ArrayList<AllData> allDatas){
        this.mCtx = mCtx;
        this.allDatas = allDatas;
        this.mFilteredList = allDatas;


    }
    @Override
    public int getCount() {
        return allDatas.size();

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

        final AllData hero = allDatas.get(position);

        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.simple_list, null);


        int numtest = position + 1;
        TextView text = (TextView) view.findViewById(R.id.num);
        text.setText(""+numtest+".");
        TextView textView = (TextView) view.findViewById(R.id.question);
        textView.setText(hero.getquestion());
        TextView textView1 = (TextView) view.findViewById(R.id.option1);
        textView1.setText(hero.getoption1());
        TextView textView2 = (TextView) view.findViewById(R.id.option2);
        textView2.setText(hero.getoption2());
        TextView textView3 = (TextView) view.findViewById(R.id.option3);
         textView3.setText(hero.getoption3());
        TextView textView4 = (TextView) view.findViewById(R.id.option4);
        textView4.setText(hero.getoption4());
        final TextView textView5 = (TextView) view.findViewById(R.id.ans);
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
                Intent myIntent = new Intent(v.getContext(), Physics1.class);
                myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mCtx.startActivity(myIntent);
            }


        });



       /* if(position %2 == 1)
        {
            // Set a background color for ListView regular row/item
            view.setBackgroundColor(Color.parseColor("#e573a6"));
        }
        else
        {
            // Set the background color for alternate row/item
            view.setBackgroundColor(Color.parseColor("#373f4c"));
        }*/
        numtest++;
        return view;




    }



}


