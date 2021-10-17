package myapps.quiz1.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by comsol on 24-Jan-18.
 */
public class physics1_paper {
    @SerializedName("data")
    private ArrayList<physics1> physics1stpaper;

    public ArrayList<physics1> getPhysics1() {
        return physics1stpaper;
    }

    public void setPhysics1(ArrayList<physics1> physics1stpaper) {
        this.physics1stpaper = physics1stpaper;
    }

    public ArrayList<physics1> getModeltest() {
        return physics1stpaper;
    }
}
