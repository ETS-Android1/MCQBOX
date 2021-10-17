package myapps.quiz1.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by comsol on 25-Feb-18.
 */
public class Biology1data {
    @SerializedName("data")
    private ArrayList<AllData> allDatas;


    public ArrayList<AllData> getBiology1data() {
        return allDatas;
    }
}
