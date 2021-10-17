package myapps.quiz1.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by comsol on 03-Jun-18.
 */
public class modeltest {

    @SerializedName("data")
    private ArrayList<modeltest1> test;


    public void setPhysics1(ArrayList<modeltest1> physics1stpaper) {
        this.test = test;
    }

    public ArrayList<modeltest1> getModeltest1() {
        return test;
    }
}
