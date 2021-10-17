package myapps.quiz1.Activity.modeltest;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import myapps.quiz1.Activity.ResultActivity;
import myapps.quiz1.Api.ApiService;
import myapps.quiz1.Api.ApiUrl;
import myapps.quiz1.Model.AllData;
import myapps.quiz1.Model.AllDataEntry;
import myapps.quiz1.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by comsol on 01-Mar-18.
 */
public class Test1Activity extends AppCompatActivity {

    private static final String TAG = null;
    int score=0,qid=0;
    int real;
    RadioButton answer,rda,rdb,rdc,rdd;
    RadioGroup radioGroup;
    TextView text,questionid,times;
    AllData hero;
    Button butNext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.model_list);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        //currentQ=quesList.get(qid);
        questionid = (TextView) findViewById(R.id.quid);
        text = (TextView) findViewById(R.id.question1);
        rda = (RadioButton) findViewById(R.id.radio0);
        rdb = (RadioButton) findViewById(R.id.radio1);
        rdc = (RadioButton)  findViewById(R.id.radio2);
        rdd = (RadioButton)  findViewById(R.id.radio3);
        butNext=(Button)  findViewById(R.id.button1);
        times = (TextView) findViewById(R.id.timers);

        getAllDataEntry();
    }

    private void getAllDataEntry() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiUrl.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();

        ApiService api = retrofit.create(ApiService.class);

        Call<AllDataEntry> call =  api.getAllDataEntry();

        call.enqueue(new Callback<AllDataEntry>() {
            @Override
            public void onResponse(Call<AllDataEntry> call, Response<AllDataEntry> response) {
                final ArrayList<AllData> allDatas = response.body().getAllDataEntry();
                //qid=0;
                hero=allDatas.get(qid);
                questionid.setText(String.valueOf(1));
                text.setText(hero.getquestion());
                rda.setText(hero.getoption1());
                rdb.setText(hero.getoption2());
                rdc.setText(hero.getoption3());
                rdd.setText(hero.getoption4());
                setQuestionView();
                times.setText("00:10:00");
                CounterClass timer = new CounterClass(60000, 1000);
                timer.start();


                butNext.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
                        int  answer=radioGroup.getCheckedRadioButtonId();
                        int  user = getSelectedAnswer(answer);

                        Log.d("yourans","user=" + user);
                        //           int real=hero.getAns();
                        int size=  allDatas.size();
                        if(qid<size) {


                            Log.d("yourans", "real=" + real);
                            hero = allDatas.get(qid);
                            setQuestionView();
                            if (real == user) {

                                score++;
                                Log.d("score", "Your score=" + score);
                                Toast.makeText(Test1Activity.this, "score = " + score, Toast.LENGTH_LONG).show();
                                //qid++;
                            }
                        }
                        else {

                            Intent myIntent = new Intent(Test1Activity.this, ResultActivity.class);
                            myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            Bundle b = new Bundle();
                            b.putInt("score", score); //Your score
                            myIntent.putExtras(b); //Put your score to your next Intent
                            startActivity(myIntent);
                            finish();
                        }

                    }
                });

            }



            private int getSelectedAnswer(int answer) {
                int answerSelected = 0;

                if(answer == R.id.radio0){

                    answerSelected = 1;

                }

                if(answer == R.id.radio1){

                    answerSelected = 2;

                }

                if(answer == R.id.radio2){

                    answerSelected = 3;

                }

                if(answer == R.id.radio3){

                    answerSelected = 4;

                }

                return answerSelected;
            }
            private void setQuestionView() {

                qid++;
                questionid.setText(String.valueOf(qid));
                text.setText(hero.getquestion());
                rda.setText(hero.getoption1());
                rdb.setText(hero.getoption2());
                rdc.setText(hero.getoption3());
                rdd.setText(hero.getoption4());
            }

            @Override
            public void onFailure(Call<AllDataEntry> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }

        });
    }
    public class CounterClass extends CountDownTimer {

        public CounterClass(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
            // TODO Auto-generated constructor stub
        }


        @Override
        public void onFinish() {
            times.setText("Time is up");
        }

        @Override
        public void onTick(long millisUntilFinished) {
            // TODO Auto-generated method stub

            long millis = millisUntilFinished;
            String hms = String.format(
                    "%02d:%02d:%02d",
                    TimeUnit.MILLISECONDS.toHours(millis),
                    TimeUnit.MILLISECONDS.toMinutes(millis)
                            - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS
                            .toHours(millis)),
                    TimeUnit.MILLISECONDS.toSeconds(millis)
                            - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS
                            .toMinutes(millis)));
            System.out.println(hms);
            times.setText(hms);
        }


    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == android.R.id.home) {
            // finish the activity
            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
