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

import myapps.quiz1.Api.ApiService;
import myapps.quiz1.Api.ApiUrl;
import myapps.quiz1.Model.Chapter_test;
import myapps.quiz1.Model.Chapter_test1;
import myapps.quiz1.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by comsol on 31-Jan-18.
 */
public class Modelphysics extends AppCompatActivity {
    ListView listview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.physics1_test);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent mIntent = getIntent();
        int course_id = mIntent.getIntExtra("Course_ID", 0);


        //ModelATestAdapter adapter = new ModelATestAdapter(this, generateData());
      listview= (ListView) findViewById(R.id.listview);
        getChapterTest(course_id);

    }

    private void getChapterTest(int course_id) {

        final ProgressDialog pDialog = ProgressDialog.show(Modelphysics.this, "Loading...",
                "Loading data, please wait...", false, false);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiUrl.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();

        ApiService api = retrofit.create(ApiService.class);

        Call<Chapter_test> call =  api.getChapterTest(course_id);

        call.enqueue(new Callback<Chapter_test>() {
            @Override
            public void onResponse(Call<Chapter_test> call, final Response<Chapter_test> response) {
                pDialog.dismiss();

                final ArrayList<Chapter_test1> chapterDatas = response.body().getChapterTests();
                Model1Adapter adapter = new Model1Adapter(getApplicationContext(), chapterDatas);
                listview.setAdapter(adapter);


                listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> parent, View view,
                                            int position, long id) {
                        Intent intent =  new Intent(Modelphysics.this, ModelTest.class);
                        // Log.d("Course: ", String.valueOf(response.body().getChapterDatas().get(position).getId()));
                    //   intent.putExtra("Course", response.body().getChapterTests().get(position).getId());
                        startActivity(intent);
                    }

                });
            }
            @Override
            public void onFailure(Call<Chapter_test> call, Throwable t) {
                pDialog.dismiss();
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }


        });

    }

  /*  private ArrayList<ModelList> generateData() {
        ArrayList<ModelList> items = new ArrayList<ModelList>();
        items.add(new ModelList(" 1st Chapter Model test"));
        items.add(new ModelList(" 2nd Chapter Model test"));
        items.add(new ModelList(" 3rd Chapter Model test"));
        items.add(new ModelList(" 4th Chapter Model test"));
        items.add(new ModelList(" 5th Chapter Model test"));
        items.add(new ModelList(" 6th Chapter Model test"));
        items.add(new ModelList(" 7th Chapter Model test"));
        items.add(new ModelList(" 8th Chapter Model test"));
        items.add(new ModelList(" 9th Chapter Model test"));
        items.add(new ModelList(" 10th Chapter Model test"));

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
        /*WebView htmlWebView = (WebView) findViewById(R.id.webview);
        htmlWebView.setWebViewClient(new CustomWebViewClient());
        WebSettings webSetting = htmlWebView.getSettings();
        webSetting.setJavaScriptEnabled(true);
        webSetting.setDisplayZoomControls(true);
        htmlWebView.loadUrl("http://www.mbpbd.com/Ruma/Mcq_box/quiz/adminlogin");
         <WebView
            android:id="@+id/webview"
            android:layout_width="365dp"
            android:layout_height="match_parent"
            android:text="Model test "
            android:textSize="18sp"
            android:textStyle="normal"
            android:textColor="#ffffff"
            android:background="#59daa4"
           >
        </WebView>

        Button testButton = (Button) findViewById(R.id.button);
        Button testButton1 = (Button) findViewById(R.id.button1);
        Button testButton2 = (Button) findViewById(R.id.button2);
        Button testButton3 = (Button) findViewById(R.id.button3);
        Button testButton4 = (Button) findViewById(R.id.button4);
        Button testButton5 = (Button) findViewById(R.id.button5);

        testButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(Modelphysics.this, ModelTest.class);
                startActivity(intent);

            }

        });
        testButton1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(Modelphysics.this, HelpActivity.class);
                startActivity(intent);

            }

        });
        testButton2.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(Modelphysics.this, HelpActivity.class);
                startActivity(intent);

            }

        });
        testButton3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
            Intent intent = new Intent(Modelphysics.this, HelpActivity.class);
            startActivity(intent);

            }

        });
        testButton4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

            Intent intent = new Intent(Modelphysics.this, HelpActivity.class);
            startActivity(intent);

            }

        });
        testButton5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
            Intent intent = new Intent(Modelphysics.this, HelpActivity.class);
            startActivity(intent);


            }

        });
          <TextView
        android:layout_width="match_parent"
        android:layout_height="40dp"
        android:text="Test yourself and enjoy"
        android:paddingLeft="90dp"
        android:textSize="18sp"
        android:textStyle="normal"
        android:textColor="#ffffff"
       />

      <Button
          android:id="@+id/button"
          android:layout_width="198dp"
          android:layout_height="50dp"
          android:text="Model test "
          android:textSize="18sp"
          android:textStyle="normal"
          android:textColor="#ffffff"
          android:background="#59daa4"
          android:layout_marginTop="10dp"
          android:layout_marginLeft="80dp"/>

        <Button
            android:id="@+id/button1"
            android:layout_width="200dp"
            android:layout_height="50dp"
            android:text="Model test "
            android:textSize="18sp"
            android:textStyle="normal"
            android:textColor="#ffffff"
            android:background="#59daa4"
            android:layout_marginTop="10dp"
            android:layout_marginLeft="80dp"/>
        <Button
            android:id="@+id/button2"
            android:layout_width="200dp"
            android:layout_height="50dp"
            android:text="Model test "
            android:textSize="18sp"
            android:textStyle="normal"
            android:textColor="#ffffff"
            android:background="#59daa4"
            android:layout_marginTop="10dp"
            android:layout_marginLeft="80dp"/>
        <Button
        android:id="@+id/button3"
            android:layout_width="200dp"
            android:layout_height="50dp"
            android:text="Model test "
            android:textSize="18sp"
            android:textStyle="normal"
            android:textColor="#ffffff"
            android:background="#59daa4"
            android:layout_marginTop="10dp"
            android:layout_marginLeft="80dp"/>
        <Button
        android:id="@+id/button4"
            android:layout_width="200dp"
            android:layout_height="50dp"
            android:text="Model test "
            android:textSize="18sp"
            android:textStyle="normal"
            android:textColor="#ffffff"
            android:background="#59daa4"
            android:layout_marginTop="10dp"
            android:layout_marginLeft="80dp"/>
        <Button
        android:id="@+id/button5"
            android:layout_width="200dp"
            android:layout_height="50dp"
            android:text="Model test "
            android:textSize="18sp"
            android:textStyle="normal"
            android:textColor="#ffffff"
            android:background="#59daa4"
            android:layout_marginTop="10dp"
            android:layout_marginLeft="80dp"/>


        */

    /*  listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // Launch ViewImage.java using intent
                if (position == 0) {
                    Intent i = new Intent(view.getContext(), ModelTest.class);
                    startActivityForResult(i, 0);
                }
                if (position == 1) {
                    Intent myIntent = new Intent(view.getContext(), ModelTest.class);
                    startActivityForResult(myIntent, 0);
                }

                if (position == 2) {
                    Intent myIntent = new Intent(view.getContext(), ModelTest.class);
                    startActivityForResult(myIntent, 0);
                }

                if (position == 3) {
                    Intent myIntent = new Intent(view.getContext(), ModelTest.class);
                    startActivityForResult(myIntent, 0);
                }

                if (position == 4) {
                    Intent myIntent = new Intent(view.getContext(), ModelTest.class);
                    startActivityForResult(myIntent, 0);
                }

                if (position == 5) {
                    Intent myIntent = new Intent(view.getContext(), ModelTest.class);
                    startActivityForResult(myIntent, 0);
                }

                if (position == 6) {
                    Intent myIntent = new Intent(view.getContext(), ModelTest.class);
                    startActivityForResult(myIntent, 0);
                }

                if (position == 7) {
                    Intent myIntent = new Intent(view.getContext(), ModelTest.class);
                    startActivityForResult(myIntent, 0);
                }
                if (position == 8) {
                    Intent myIntent = new Intent(view.getContext(), ModelTest.class);
                    startActivityForResult(myIntent, 0);
                }
                if (position == 9) {
                    Intent myIntent = new Intent(view.getContext(), ModelTest.class);
                    startActivityForResult(myIntent, 0);
                }
                if (position == 10) {
                    Intent myIntent = new Intent(view.getContext(), ModelTest.class);
                    startActivityForResult(myIntent, 0);
                }

            }
        });*/