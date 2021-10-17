package myapps.quiz1.Activity.course.physics;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by comsol on 27-Nov-17.
 */
public class Physics1Helper extends SQLiteOpenHelper {

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 2;

    // Database Name
    private static final String DATABASE_NAME = "Courselist";

    // Contacts table name
    private static final String TABLE_physics1list = "physics1list";

    // Contacts Table Columns names
    public static final String KEY_ID = "_id";
    public static final String KEY_text1 = "text1";
    public static final String KEY_ans1 = "option1";
    public static final String KEY_ans2 = "option2";
    public static final String KEY_ans3 = "option3";
    public static final String KEY_ans4 = "option4";
    public static final String KEY_realans = "ans";
    public static final String KEY_help = "help";



    public Physics1Helper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_physics1list_TABLE = "CREATE TABLE " + TABLE_physics1list + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_text1 + " TEXT,"
                + KEY_ans1 + " TEXT,"+ KEY_ans2 + " TEXT,"+ KEY_ans3 +
                " TEXT,"+ KEY_ans4 + " TEXT,"+ KEY_realans + " TEXT,"
                + KEY_help + " TEXT" +" )";
        db.execSQL(CREATE_physics1list_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_physics1list);

        // Create tables again
        onCreate(db);
    }

    /**
     * All CRUD(Create, Read, Update, Delete) Operations
     */

    public boolean addDonners(String text1, String option1, String option2, String option3, String option4,String realans,String help) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_text1, text1);
        values.put(KEY_ans1, option1);
        values.put(KEY_ans2,option2);
        values.put(KEY_ans3, option3);
        values.put(KEY_ans4, option4);
        values.put(KEY_realans, realans);
        values.put(KEY_help, help);
        // Inserting Row
        db.insert(TABLE_physics1list, null, values);
        //  db.close();
        return true;// Closing database connection
    }

    public Cursor getDonner_list(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor res =  db.rawQuery("SELECT * FROM " + TABLE_physics1list + " WHERE " +
                KEY_ID + "=?", new String[]{Integer.toString(id)});
        return res;
    }


    // Getting All Contacts
    public Cursor getAllDonners() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "SELECT * FROM " + TABLE_physics1list, null );
        return res;
    }
    // Updating single contact
    public boolean updatedonner(Integer id, String text1, String option1, String option2, String option3,
                                String option4,String realans,String help) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_text1, text1);
        values.put(KEY_ans1, option1);
        values.put(KEY_ans2,option2);
        values.put(KEY_ans3, option3);
        values.put(KEY_ans4, option4);
        values.put(KEY_realans, realans);
        values.put(KEY_help, help);

        // updating row
        db.update(TABLE_physics1list, values, KEY_ID + " = ?",new String[]  { Integer.toString(id) });
        return true;
    }

    // Deleting single contact
    public int deletedonner(Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_physics1list,
                KEY_ID + " = ? ",
                new String[] { Integer.toString(id) });
    }


    // Getting contacts Count
    public int getdonnerCount() {
        String countQuery = "SELECT  * FROM " + TABLE_physics1list;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }





}

