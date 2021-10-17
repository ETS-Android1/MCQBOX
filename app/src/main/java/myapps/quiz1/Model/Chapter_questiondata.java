package myapps.quiz1.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by comsol on 30-May-18.
 */
public class Chapter_questiondata {
    @SerializedName("data")
    private ArrayList<Chapter_question> chapterDatas;

    public ArrayList<Chapter_question> getChapterQuestion() {
        return chapterDatas;
    }

    public void setChapterDatas(ArrayList<Chapter_question> chapterDatas) {
        this.chapterDatas = chapterDatas;
    }
}
