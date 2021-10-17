package myapps.quiz1.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by comsol on 22-Feb-18.
 */
public class Shortcutdata {
    @SerializedName("data")
    private ArrayList<Shortcut> allshort;
    public ArrayList<Shortcut> getAlltechniques() {
        return allshort;
    }
    public ArrayList<Shortcut> getChetechniques() {
        return allshort;
    }


}
