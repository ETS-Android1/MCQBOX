package myapps.quiz1.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by comsol on 28-May-18.
 */
public class Course_data {
    @SerializedName("data")
    private ArrayList<Course_listdata> allDatass;



    public ArrayList<Course_listdata> getAllDatass() {
        return allDatass;
    }
    public ArrayList<Course_listdata> getAlltest() {
        return allDatass;
    }

    public void setAllDatass(ArrayList<Course_listdata> allDatass) {
        this.allDatass = allDatass;
    }


}
