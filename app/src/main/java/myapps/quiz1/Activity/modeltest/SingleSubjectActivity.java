package myapps.quiz1.Activity.modeltest;

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

import myapps.quiz1.Adapter.ModelmixedAdapter;
import myapps.quiz1.Api.ApiService;
import myapps.quiz1.Api.ApiUrl;
import myapps.quiz1.Model.modeltest;
import myapps.quiz1.Model.modeltest1;
import myapps.quiz1.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by comsol on 01-Mar-18.
 */
public class SingleSubjectActivity extends AppCompatActivity {
    ModelmixedAdapter adapter;
    ListView listview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.physics1_test);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        listview = (ListView) findViewById(R.id.listview);

        getmodel_list1();

    }
    private void getmodel_list1() {
        final ProgressDialog pDialog = ProgressDialog.show(SingleSubjectActivity.this, "Loading...",
                "Loading data, please wait...", false, false);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiUrl.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();

        ApiService api = retrofit.create(ApiService.class);

        Call<modeltest> call =  api.getmodel_list1();

        call.enqueue(new Callback<modeltest>() {
            @Override
            public void onResponse(Call<modeltest> call, final Response<modeltest> response) {
                pDialog.dismiss();
                final ArrayList<modeltest1> test = response.body().getModeltest1();
                adapter = new ModelmixedAdapter(getApplicationContext(), test);


                listview.setAdapter( adapter);


                listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> parent, View view,
                                            int position, long id) {
                        Intent intent =  new Intent(SingleSubjectActivity.this, ModelTest.class);
                        // Log.d("Course: ", String.valueOf(response.body().getChapterDatas().get(position).getId()));
                        //   intent.putExtra("Course", response.body().getChapterTests().get(position).getId());
                        startActivity(intent);
                    }

                });
            }

            @Override
            public void onFailure(Call<modeltest> call, Throwable t) {
                pDialog.dismiss();
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }


        });
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
