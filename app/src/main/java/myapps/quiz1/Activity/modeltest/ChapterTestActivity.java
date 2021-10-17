package myapps.quiz1.Activity.modeltest;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

import myapps.quiz1.Api.ApiService;
import myapps.quiz1.Api.ApiUrl;
import myapps.quiz1.CourseAdapter;
import myapps.quiz1.Model.Course_data;
import myapps.quiz1.Model.Course_listdata;
import myapps.quiz1.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by comsol on 28-Feb-18.
 */
public class ChapterTestActivity extends AppCompatActivity {
    CourseAdapter adapter;
    GridView gridview;
    String[] course_list;
    Course_listdata listdata;
    String[] course;
    int[] Imageid;
    int qid=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        Imageid = new int[]{R.drawable.phy_3, R.drawable.phy_4, R.drawable.che_3, R.drawable.che_6
                , R.drawable.bio_3, R.drawable.bio_5, R.drawable.math_5, R.drawable.math_6, R.drawable.che_6
                , R.drawable.bio_3, R.drawable.bio_5, R.drawable.math_5, R.drawable.math_6, R.drawable.che_6
                , R.drawable.bio_3, R.drawable.bio_5, R.drawable.math_5, R.drawable.math_6};
        gridview  = (GridView) findViewById(R.id.gridview);

        getcourse_list1();

    }
    private void getcourse_list1() {
        final ProgressDialog pDialog = ProgressDialog.show(ChapterTestActivity.this, "Loading...",
                "Loading data, please wait...", false, false);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiUrl.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();

        ApiService api = retrofit.create(ApiService.class);

        Call<Course_data> call =  api.getcourse_list1();

        call.enqueue(new Callback<Course_data>() {
            @Override
            public void onResponse(Call<Course_data> call, final Response<Course_data> response) {
                pDialog.dismiss();
                final ArrayList<Course_listdata> allDatass = response.body().getAlltest();
                adapter = new CourseAdapter(getApplicationContext(), allDatass,Imageid);

                //adding it to adapterview flipper
                gridview.setAdapter(adapter);

                gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        Intent intent =  new Intent(ChapterTestActivity.this, Modelphysics.class);
                        //Log.d("CourseID: ", String.valueOf(response.body().getAllDatass().get(position).getId()));
                        intent.putExtra("Course_ID", response.body().getAlltest().get(position).getId());
                        startActivity(intent);
                    }
                });


            }

            @Override
            public void onFailure(Call<Course_data> call, Throwable t) {
                pDialog.dismiss();
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }


        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_grid_view, menu);
        return true;
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

    /*  adapter = new ModelAdapter(ChapterTestActivity.this, course, Imageid);
        // gridView.setAdapter(CourseAdapter);
        // Set the ImageAdapter into GridView Adapter
        gridview.setAdapter(adapter);
        // Capture GridView item click
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // Launch ViewImage.java using intent
                if (position == 0) {
                    Intent i = new Intent(view.getContext(), Modelphysics.class);
                    startActivityForResult(i, 0);
                }
                if (position == 1) {
                    Intent myIntent = new Intent(view.getContext(), Modelphysics1.class);
                    startActivityForResult(myIntent, 0);
                }

                if (position == 2) {
                    Intent myIntent = new Intent(view.getContext(), Modelchemistry.class);
                    startActivityForResult(myIntent, 0);
                }

                if (position == 3) {
                    Intent myIntent = new Intent(view.getContext(), Modelchemistry1.class);
                    startActivityForResult(myIntent, 0);
                }

                if (position == 4) {
                    Intent myIntent = new Intent(view.getContext(), Modelphysics1.class);
                    startActivityForResult(myIntent, 0);
                }

                if (position == 5) {
                    Intent myIntent = new Intent(view.getContext(), Modelphysics1.class);
                    startActivityForResult(myIntent, 0);
                }

                if (position == 6) {
                    Intent myIntent = new Intent(view.getContext(), Modelphysics1.class);
                    startActivityForResult(myIntent, 0);
                }

                if (position == 7) {
                    Intent myIntent = new Intent(view.getContext(), Modelphysics1.class);
                    startActivityForResult(myIntent, 0);
                }

            }
        });*/
