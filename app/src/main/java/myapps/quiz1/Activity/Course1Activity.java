package myapps.quiz1.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;

import myapps.quiz1.Adapter.Course_listAdapter;
import myapps.quiz1.R;

/**
 * Created by comsol on 28-May-18.
 */
public class Course1Activity extends AppCompatActivity {
    private  GridView gridview;
    Course_listAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the view from gridview_main.xml
        setContentView(R.layout.activity_chapter1);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        gridview = (GridView) findViewById(R.id.gridview);

       // showcourse_list();
    }


  /*  private void showcourse_list() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiUrl.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();

        ApiService api = retrofit.create(ApiService.class);

        Call<AllDataEntry> call =  api.showcourse_list();

        call.enqueue(new Callback<AllDataEntry>() {
            @Override
            public void onResponse(Call<AllDataEntry> call, Response<AllDataEntry> response) {
                ArrayList<AllData> allDatas = response.body().showcourse_list();

                //creating adapter object
                adapter = new Course_listAdapter(getApplicationContext(), allDatas);

                //adding it to adapterview flipper

                gridview.setAdapter(adapter);


            }

            @Override
            public void onFailure(Call<AllDataEntry> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }

        });
    }*/
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




