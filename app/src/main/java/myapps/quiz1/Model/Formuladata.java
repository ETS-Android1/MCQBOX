package myapps.quiz1.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by comsol on 14-Mar-18.
 */
public class Formuladata {
    @SerializedName("data")
    private ArrayList<Formula> allshort;
    public ArrayList<Formula> getAllrules() {
        return allshort;
    }
}
