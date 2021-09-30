package com.example.ordersystem;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DBHandler extends SQLiteOpenHelper {

    private static final int VERSION = 2; /*2*/
    private static final String DB_NAME = "todo";
    private static final String TABLE_NAME = "todo"; /*todo*/

    // Column names
    private static final String ID = "id";
    private static final String TITLE = "title";
    private static final String PRICES = "prices";
    private static final String DESCRIPTION = "description";
    private static final String SIZES = "sizes";
    private static final String EXTRA = "extra";
    private static final String STARTED = "started";
    private static final String FINISHED = "finished";


    public DBHandler(@Nullable Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String TABLE_CREATE_QUERY = "CREATE TABLE " + TABLE_NAME + " " +
                "("
                + ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + TITLE + " TEXT,"
                + PRICES + " TEXT,"
                + DESCRIPTION + " TEXT,"
                + SIZES + " TEXT,"
                + EXTRA + " TEXT,"
                + STARTED + " TEXT,"
                + FINISHED + " TEXT" +
                ");";

        /*
            CREATE TABLE todo (id INTEGER PRIMARY KEY AUTOINCREMENT, title TEXT, description TEXT,
            started TEXT,finished TEXT); */

        db.execSQL(TABLE_CREATE_QUERY);

        db.execSQL("Create table feedback(id INTEGER PRIMARY KEY AUTOINCREMENT, title2 TEXT, email2 TEXT, description2 TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String DROP_TABLE_QUERY = "DROP TABLE IF EXISTS " + TABLE_NAME;
        // Drop older table if existed
        db.execSQL(DROP_TABLE_QUERY);
        // Create tables again
        onCreate(db);

        db.execSQL("Drop table if exists feedback");

    }


    // Add a single todo
    public void addToDo(ToDo toDo) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(TITLE, toDo.getTitle());
        contentValues.put(PRICES, toDo.getPrices());
        contentValues.put(DESCRIPTION, toDo.getDescription());
        contentValues.put(SIZES, toDo.getSizes());
        contentValues.put(EXTRA, toDo.getExtra());
        contentValues.put(STARTED, toDo.getStarted());
        contentValues.put(FINISHED, toDo.getFinished());

        //save to table
        sqLiteDatabase.insert(TABLE_NAME, null, contentValues);
        // close database
        sqLiteDatabase.close();

    }

/*
    public void addfeedback(Feedback feedBack) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(title2, feedBack.getTitle2());
        contentValues.put(email2, feedBack.getEmail2());
        contentValues.put(description2, feedBack.getDescription2());

        //save to table
        db.insert(feedback, null, contentValues);
        // close database
        db.close();

    }
*/

    public Boolean insertfeedback(String title2, String email2, String description2){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("title2",title2);
        contentValues.put("email2",email2);
        contentValues.put("description2",description2);
        long results = db.insert("feedback", null, contentValues);
        if(results == -1){
            return false;
        }else{
            return true;
        }
    }



    public List<Feedback> getAll(){
        List<Feedback> feedbacks = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * FROM feedback",null);
        if(cursor.moveToFirst()){
            do{
                Feedback cateModel = new Feedback();
                cateModel.setTitle2(cursor.getString(0));
                cateModel.setEmail2(cursor.getString(1));
                cateModel.setDescription2(cursor.getString(2));
                feedbacks.add(cateModel);
            }while (cursor.moveToNext());
        }
        return feedbacks;
    }

    public Boolean deleteFeedback(String title2){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from feedback where title2 = ?", new String[]{title2});
        if(cursor.getCount()>0) {
            long result = db.delete("feedback",  "title2=?", new String[]{title2});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        }else {
            return false;
        }
    }




    // Count todo table records
    public int countToDo() {
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;

        Cursor cursor = db.rawQuery(query, null);
        return cursor.getCount();
    }

    // Get all todos into a list
    public List<ToDo> getAllToDos() {

        List<ToDo> toDos = new ArrayList();
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;

        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                // Create new ToDo object
                ToDo toDo = new ToDo();
                // mmgby6hh
                toDo.setId(cursor.getInt(0));
                toDo.setTitle(cursor.getString(1));
                toDo.setPrices(cursor.getString(2));
                toDo.setDescription(cursor.getString(3));
                toDo.setSizes(cursor.getString(4));
                toDo.setExtra(cursor.getString(5));
                toDo.setStarted(cursor.getLong(6));
                toDo.setFinished(cursor.getLong(7));

                //toDos [obj,objs,asas,asa]
                toDos.add(toDo);
            } while (cursor.moveToNext());
        }
        return toDos;
    }

    // Delete item
    public void deleteToDo(int id) {
        SQLiteDatabase db = getWritableDatabase();
        db.delete(TABLE_NAME, "id =?", new String[]{String.valueOf(id)});
        db.close();
    }

    // Get a single todo
    public ToDo getSingleToDo(int id) {
        SQLiteDatabase db = getWritableDatabase();

        Cursor cursor = db.query(TABLE_NAME, new String[]{ID, TITLE, PRICES, DESCRIPTION, SIZES, EXTRA, STARTED, FINISHED},
                ID + "= ?", new String[]{String.valueOf(id)}
                , null, null, null);

        ToDo toDo;
        if (cursor != null) {
            cursor.moveToFirst();
            toDo = new ToDo(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5),
                    cursor.getLong(6),
                    cursor.getLong(7)
            );
            return toDo;
        }
        return null;
    }

    // Update a single todo
    public int updateSingleToDo(ToDo toDo) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(TITLE, toDo.getTitle());
        contentValues.put(PRICES, toDo.getPrices());
        contentValues.put(DESCRIPTION, toDo.getDescription());
        contentValues.put(SIZES, toDo.getSizes());
        contentValues.put(EXTRA, toDo.getExtra());
        contentValues.put(STARTED, toDo.getStarted());
        contentValues.put(FINISHED, toDo.getFinished());

        int status = db.update(TABLE_NAME, contentValues, ID + " =?",
                new String[]{String.valueOf(toDo.getId())});

        db.close();
        return status;

    }

}

















