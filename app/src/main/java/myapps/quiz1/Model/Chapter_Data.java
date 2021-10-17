package myapps.quiz1.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by comsol on 29-May-18.
 */
public class Chapter_Data {

    @SerializedName("data")
    private ArrayList<ChapterData> chapterDatas;

    public ArrayList<ChapterData> getChapterDatas() {
        return chapterDatas;
    }

    public void setChapterDatas(ArrayList<ChapterData> chapterDatas) {
        this.chapterDatas = chapterDatas;
    }
}
