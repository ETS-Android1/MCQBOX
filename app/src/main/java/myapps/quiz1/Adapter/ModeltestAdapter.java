package myapps.quiz1.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

import myapps.quiz1.Model.AllData;
import myapps.quiz1.R;

/**
 * Created by comsol on 09-Feb-18.
 */
public class ModeltestAdapter extends BaseAdapter {
    private Context mCtx;
    private ArrayList<AllData> allDatas;
    private ArrayList<AllData> mFilteredList;
    int score=0,qid=0;
    RadioButton answer,rda,rdb,rdc;
    RadioGroup radioGroup;
    TextView text;
    AllData hero;
    Button butNext;


    public ModeltestAdapter(Context mCtx, ArrayList<AllData> allDatas){
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
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(mCtx);
         final View view = inflater.inflate(R.layout.model_list, null);

        hero = allDatas.get(qid);

        text = (TextView) view.findViewById(R.id.question1);
        rda = (RadioButton) view.findViewById(R.id.radio0);
        rdb = (RadioButton) view.findViewById(R.id.radio1);
        rdc = (RadioButton) view.findViewById(R.id.radio2);
        butNext=(Button)view.findViewById(R.id.button1);
        setQuestionView();
      /*  butNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                radioGroup = (RadioGroup) view.findViewById(R.id.radioGroup);
                answer=(RadioButton)view.findViewById(radioGroup.getCheckedRadioButtonId());
                Log.d("yourans", hero.getAns()+" "+answer.getText());
                if(hero.getAns().equals(answer.getText()))
                {
                    score++;
                    Log.d("score", "Your score"+score);
                }
                     Intent myIntent = new Intent(view.getContext(), ResultActivity.class);
                           myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                           Bundle b = new Bundle();
                           b.putInt("score", score); //Your score
                           myIntent.putExtras(b); //Put your score to your next Intent
                           mCtx.startActivity(myIntent);

            }
        });
       /* // answer = (RadioButton) view.findViewById(radioGroup.getCheckedRadioButtonId());
               rda.setOnClickListener(new View.OnClickListener() {

                   @Override
                   public void onClick(View v) {
                       answer = (RadioButton) view.findViewById(radioGroup.getCheckedRadioButtonId());
                       if (answer.equals(hero.getAns())) {

                           score++;
                           Log.d("score", "Your score" + score);
                       }
                       /*if(qid<5){
                           hero=allDatas.get(qid);
                           setQuestionView();
                       }/*else{
                           Intent myIntent = new Intent(view.getContext(), ResultActivity.class);
                           myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                           Bundle b = new Bundle();
                           b.putInt("score", score); //Your score
                           myIntent.putExtras(b); //Put your score to your next Intent
                           mCtx.startActivity(myIntent);
                       }
                  }
              });*/





        return view;
    }

    private void setQuestionView() {


        text.setText(hero.getquestion());
        rda.setText(hero.getoption1());
        rdb.setText(hero.getoption2());
        rdc.setText(hero.getoption3());
        qid++;
    }

}
