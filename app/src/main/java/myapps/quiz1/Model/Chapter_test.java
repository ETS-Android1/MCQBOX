package myapps.quiz1.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by comsol on 31-May-18.
 */
public class Chapter_test {


    @SerializedName("data")
    private ArrayList<Chapter_test1> chapterDatas;

    public ArrayList<Chapter_test1> getChapterTests() {
        return chapterDatas;
    }

    public void setChapterTests(ArrayList<Chapter_test1> chapterDatas) {
        this.chapterDatas = chapterDatas;
    }
}
