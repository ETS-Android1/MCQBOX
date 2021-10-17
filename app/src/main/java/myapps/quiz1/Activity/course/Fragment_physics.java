package myapps.quiz1.Activity.course;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import myapps.quiz1.Activity.physics1stpaper.Chapter11st;
import myapps.quiz1.Adapter.DataAdapter;
import myapps.quiz1.Api.ApiService;
import myapps.quiz1.Api.ApiUrl;
import myapps.quiz1.Model.ChapterData;
import myapps.quiz1.Model.Chapter_Data;
import myapps.quiz1.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Fragment_physics extends AppCompatActivity {
    private ListView listview;
    private ProgressDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_physics1);
        // 1. pass context and data to the custom adapter
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent mIntent = getIntent();
        int course_id = mIntent.getIntExtra("Course_ID", 0);

       // Log.d("CourseIDFragment: ", String.valueOf(course_id));

        listview = (ListView) findViewById(R.id.listview);



        getChapterData(course_id);



/*
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {


                // Launch ViewImage.java using intent
                if (position == 0) {

                    Intent i = new Intent(view.getContext(), Chapter11st.class);
                    startActivityForResult(i, 0);


                }
                if (position == 1) {
                    Intent myIntent = new Intent(view.getContext(), Chapter11st.class);
                    startActivityForResult(myIntent, 0);
                }

                if (position == 2) {
                    Intent myIntent = new Intent(view.getContext(), Chapter11st.class);
                    startActivityForResult(myIntent, 0);
                }

                if (position == 3) {
                    Intent myIntent = new Intent(view.getContext(), Chapter11st.class);
                    startActivityForResult(myIntent, 0);
                }

                if (position == 4) {
                    Intent myIntent = new Intent(view.getContext(), Chapter11st.class);
                    startActivityForResult(myIntent, 0);
                }

                if (position == 5) {
                    Intent myIntent = new Intent(view.getContext(), Chapter11st.class);
                    startActivityForResult(myIntent, 0);
                }

                if (position == 6) {
                    Intent myIntent = new Intent(view.getContext(), Chapter11st.class);
                    startActivityForResult(myIntent, 0);
                }

                if (position == 7) {
                    Intent myIntent = new Intent(view.getContext(), Chapter11st.class);
                    startActivityForResult(myIntent, 0);
                }
                if (position == 8) {
                    Intent myIntent = new Intent(view.getContext(), Chapter11st.class);
                    startActivityForResult(myIntent, 0);
                }
                if (position == 9) {
                    Intent myIntent = new Intent(view.getContext(), Chapter11st.class);
                    startActivityForResult(myIntent, 0);
                }
                if (position == 10) {
                    Intent myIntent = new Intent(view.getContext(), Chapter11st.class);
                    startActivityForResult(myIntent, 0);
                }

            }
        });
*/
    }

    public void getChapterData(int course_id) {
        pDialog = ProgressDialog.show(Fragment_physics.this,"Loading...",
                "Loading data, please wait...", false, false);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiUrl.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();

        ApiService api = retrofit.create(ApiService.class);

        Call<Chapter_Data> call =  api.getChapterData(course_id);

        call.enqueue(new Callback<Chapter_Data>() {
            @Override
            public void onResponse(Call<Chapter_Data> call, final Response<Chapter_Data> response) {
             pDialog.dismiss();
                final ArrayList<ChapterData> allDatass = response.body().getChapterDatas();
                DataAdapter adapter = new DataAdapter(getApplicationContext(), allDatass);
                listview.setAdapter(adapter);


                listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> parent, View view,
                                            int position, long id) {
                        Intent intent =  new Intent(Fragment_physics.this, Chapter11st.class);
                       // Log.d("Course: ", String.valueOf(response.body().getChapterDatas().get(position).getId()));
                        intent.putExtra("Course", response.body().getChapterDatas().get(position).getId());
                        startActivity(intent);
                    }

                });
            }
            @Override
            public void onFailure(Call<Chapter_Data> call, Throwable t) {
                pDialog.dismiss();
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }


        });

    }

    /*private ArrayList<SubjectList> generateData() {
        ArrayList<SubjectList> items = new ArrayList<SubjectList>();
        items.add(new SubjectList(" ১ম অধ্যায়", " ভৌতজগৎও পরিমাপ"));
        items.add(new SubjectList("২য় অধ্যায়", "ভেক্টর"));
        items.add(new SubjectList("৩য় অধ্যায়", "গতিবিদ্যা"));
        items.add(new SubjectList("৪র্থ অধ্যায়", "নিউটনিয়ান বলবিদ্যা"));
        items.add(new SubjectList("৫ম অধ্যায়", "কাজ, শক্তি ও ক্ষমতা"));
        items.add(new SubjectList("৬ষ্ঠ অধ্যায়", "মহাকর্ষ ও অভিকর্ষ"));
        items.add(new SubjectList("৭ম অধ্যায়", "পদার্থের গাঠনিক ধর্ম"));
        items.add(new SubjectList("৮ম অধ্যায়", "পর্যাবৃত্ত গতি"));
        items.add(new SubjectList("৯ম অধ্যায়", "তরঙ্গ"));
        items.add(new SubjectList("১০ম অধ্যায়", "আদর্শ গ্যাস ও গ্যাসের গতিতত্ত্ব"));
        return items;


    }*/

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