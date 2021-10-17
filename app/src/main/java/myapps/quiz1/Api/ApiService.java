package myapps.quiz1.Api;

import myapps.quiz1.Model.AllDataEntry;
import myapps.quiz1.Model.Biology1data;
import myapps.quiz1.Model.Chapter_Data;
import myapps.quiz1.Model.Chapter_questiondata;
import myapps.quiz1.Model.Chapter_test;
import myapps.quiz1.Model.Chemistry1data;
import myapps.quiz1.Model.Course_data;
import myapps.quiz1.Model.ForLogin;
import myapps.quiz1.Model.Formuladata;
import myapps.quiz1.Model.Shortcutdata;
import myapps.quiz1.Model.modeltest;
import myapps.quiz1.Model.physics1_paper;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by comsol on 30-May-18.
 */
public interface ApiService {

    @FormUrlEncoded
    @POST("test1")
    Call<ForLogin> userLogIn(@Field("username") String username,
                             @Field("phone ") String phone,
                             @Field("password") String password
    );

    @GET("phychapter1/{id}")
    Call<AllDataEntry> getAllDataEntry1();

   // @GET("phy1chapter1/{id}}")
   // Call<AllDataEntry> getAllDataEntry2();

    @GET("questionlist/{id}}")
    Call<Chapter_questiondata> getAllDataEntry2(@Path("id") int id);

    @GET("phychapter1/{id}/{second_id}/{third_id}")
    Call<AllDataEntry> getAllDataEntry3();

    @GET("phy1chapter1/{id}}")
    Call<AllDataEntry> getAllDataEntry4();

    @GET("phychapter4/{id}/{second_id}")
    Call<AllDataEntry> getAllDataEntry5();

    @GET("phychapter4/{id}/{second_id}/{third_id}")
    Call<AllDataEntry> getAllDataEntry6();

    @GET("phy1modeltest")
    Call<AllDataEntry> getAllDataEntry();

    @GET("phy1shortcut/{id}")
    Call<Shortcutdata> getAlltechniques();

    @GET("chemistry1/{id}")
    Call<Chemistry1data> getChe1data();

    @GET("chemistry1test/{id}")
    Call<Chemistry1data> Chmemodeltest();

    @GET("chemistry1short/{id}")
    Call<Shortcutdata> getChetechniques();

    @GET("biology1/{id}")
    Call<Biology1data> getBiology1data();

    @GET("biology2model/{id}")
    Call<Shortcutdata> getBiology1short();

    @GET("formula")
    Call<Formuladata> getAllrules();
    @GET("math1/{id}")
    Call<AllDataEntry> getAllDataEntry11();
    @GET("courses")
    Call<Course_data> getcourse_list();
    @GET("courses")
    Call<Course_data> getcourse_list1();

    @GET("chaptername/{id}")
    Call<Chapter_Data>getChapterData(
            @Path("id") int id);

    @GET("showmodel/{id}")
    Call<Chapter_test> getChapterTest( @Path("id") int id);

    @GET("phy1modeltest")
    Call<physics1_paper> getModeltest();
    @GET("showmodellist")
    Call<modeltest> getmodel_list1();
}
