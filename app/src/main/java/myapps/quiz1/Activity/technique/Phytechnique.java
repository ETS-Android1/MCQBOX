package myapps.quiz1.Activity.technique;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import myapps.quiz1.Adapter.Short1stAdapter;
import myapps.quiz1.Api.ApiService;
import myapps.quiz1.Api.ApiUrl;
import myapps.quiz1.Model.Shortcut;
import myapps.quiz1.Model.Shortcutdata;
import myapps.quiz1.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by comsol on 13-Feb-18.
 */
public class Phytechnique  extends AppCompatActivity {
    ListView listview;
    Short1stAdapter adapter;
    private ProgressDialog pDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.phy_technique);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        listview = (ListView) findViewById(R.id.listview);
        getAlltechniques();
    }
    private void getAlltechniques() {
        pDialog = ProgressDialog.show(Phytechnique.this,"Loading...",
                "Loading data, please wait...", false, false);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiUrl.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();

        ApiService api = retrofit.create(ApiService.class);

        Call<Shortcutdata> call =  api.getAlltechniques();

        call.enqueue(new Callback<Shortcutdata>() {
            @Override
            public void onResponse(Call<Shortcutdata> call, Response<Shortcutdata> response) {
                pDialog.dismiss();
                ArrayList<Shortcut> allshort = response.body().getAlltechniques();

                //creating adapter object
                adapter = new Short1stAdapter(getApplicationContext(), allshort);

                //adding it to adapterview flipper
                listview.setAdapter(adapter);


            }

            @Override
            public void onFailure(Call<Shortcutdata> call, Throwable t) {
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



