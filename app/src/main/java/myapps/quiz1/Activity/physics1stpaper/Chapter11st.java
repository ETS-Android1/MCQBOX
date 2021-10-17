package myapps.quiz1.Activity.physics1stpaper;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import myapps.quiz1.Adapter.QuestionAdapter;
import myapps.quiz1.Api.ApiService;
import myapps.quiz1.Api.ApiUrl;
import myapps.quiz1.Model.Chapter_question;
import myapps.quiz1.Model.Chapter_questiondata;
import myapps.quiz1.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by comsol on 01-Feb-18.
 */
public class Chapter11st extends AppCompatActivity {
    private ListView listview;
    QuestionAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the view from gridview_main.xml
        setContentView(R.layout.activity_chapter1);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        listview = (ListView) findViewById(R.id.listview);
        Intent mIntent = getIntent();
        int chapter_id = mIntent.getIntExtra("Course", 0);

        //Log.d("CourseFragment: ", String.valueOf(chapter_id));

        listview = (ListView) findViewById(R.id.listview);



       // getChapterData(course_id);
        getAllDataEntry2(chapter_id);
    }

    private void getAllDataEntry2(int chapter_id) {
        final ProgressDialog pDialog = ProgressDialog.show(Chapter11st.this, "Loading...",
                "Loading data, please wait...", false, false);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiUrl.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();

        ApiService api = retrofit.create(ApiService.class);

        Call<Chapter_questiondata> call =  api.getAllDataEntry2(chapter_id);

        call.enqueue(new Callback<Chapter_questiondata>() {
            @Override
            public void onResponse(Call<Chapter_questiondata> call, Response<Chapter_questiondata> response) {
                pDialog.dismiss();
                ArrayList<Chapter_question> chapterDatas = response.body().getChapterQuestion();


                //creating adapter object
                adapter = new QuestionAdapter(getApplicationContext(), chapterDatas);

                //adding it to adapterview flipper
                listview.setAdapter(adapter);


            }

            @Override
            public void onFailure(Call<Chapter_questiondata> call, Throwable t) {
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




