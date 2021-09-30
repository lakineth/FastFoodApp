package com.example.product;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;


public class SQLiteHelper extends SQLiteOpenHelper {
    private static final String PID = "PID";
    private static final String name = "name";
    private static final String price = "price";
    private static final String description = "description";
    private static final String category = "category";


    public SQLiteHelper( Context context) {
        super(context, "Product.db", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table fooddetails(PID TEXT primary key, name TEXT, price FLOAT, description TEXT, category TEXT)");
        DB.execSQL("create Table categories(CID TEXT primary key , cname TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int oldVersion, int newVersion) {
         DB.execSQL("drop Table if exists fooddetails");
         DB.execSQL("DROP TABLE IF EXISTS categories");


    }
    public Boolean insertfood(String PID, String name, String price, String description, String category){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("PID",PID);
        contentValues.put("name",name);
        contentValues.put("price",price);
        contentValues.put("description",description);
        contentValues.put("category",category);
        long result = DB.insert("fooddetails", null, contentValues);
        if(result == -1){
            return false;
        }else{
            return true;
        }

    }
    public Boolean insertcate(String CID, String cname){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("CID",CID);
        contentValues.put("cname",cname);
        long results = db.insert("categories", null, contentValues);
        if(results == -1){
            return false;
        }else{
            return true;
        }
    }

    public Boolean updatefood(String PID, String name, Float price, String description, String category){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        contentValues.put("price",price);
        contentValues.put("description",description);
        contentValues.put("category",category);

        Cursor cursor = DB.rawQuery("Select * from fooddetails where PID = ?", new String[]{PID});
        if(cursor.getCount()>0) {
            long result = DB.update("fooddetails", contentValues, "PID=?", new String[]{PID});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        }else {
            return false;
        }
    }

    public Boolean deletefood(String PID){
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from fooddetails where PID = ?", new String[]{PID});
        if(cursor.getCount()>0) {
            long result = DB.delete("fooddetails",  "PID=?", new String[]{PID});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        }else {
            return false;
        }
    }
    public Boolean deletecate(String CID){
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from categories where CID = ?", new String[]{CID});
        if(cursor.getCount()>0) {
            long result = DB.delete("categories",  "CID=?", new String[]{CID});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        }else {
            return false;
        }
    }

    public List<FoodModel> getAll(){
        List<FoodModel> foods = new ArrayList<>();
        SQLiteDatabase DB = getReadableDatabase();
        Cursor cursor = DB.rawQuery("Select * FROM fooddetails",null);
        if(cursor.moveToFirst()){
            do{
                FoodModel foodModel = new FoodModel();
                foodModel.setPID(cursor.getString(0));
                foodModel.setName(cursor.getString(1));
                foodModel.setPrice(cursor.getString(2));
                foodModel.setDescription(cursor.getString(3));
                foodModel.setCategory(cursor.getString(4));
                foods.add(foodModel);
            }while (cursor.moveToNext());
        }
        return foods;
    }
    public List<CateModel> getAllCate(){
        List<CateModel> cates = new ArrayList<>();
        SQLiteDatabase DB = getReadableDatabase();
        Cursor cursor = DB.rawQuery("Select * FROM categories",null);
        if(cursor.moveToFirst()){
            do{
                CateModel cateModel = new CateModel();
                cateModel.setCID(cursor.getString(0));
                cateModel.setCname(cursor.getString(1));
                cates.add(cateModel);
            }while (cursor.moveToNext());
        }
        return cates;
    }


    public FoodModel getsingle(String id){
        SQLiteDatabase DB = getWritableDatabase();
        Cursor cursor = DB.query("fooddetails",new String[]{PID,name,price,description,category },
                name +"=?",new String[]{String.valueOf(id)},null,
                null,null);
        FoodModel foodModel;
        if(cursor != null){
             cursor.moveToFirst();
            foodModel = new FoodModel(
                   cursor.getString(0),
                   cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4)

            );
          return foodModel;
        }
       return null;
    }


    public int updateFoods(FoodModel foodModel){

        SQLiteDatabase DB = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(PID,foodModel.getPID());
        contentValues.put(name,foodModel.getName());
        contentValues.put(price,foodModel.getPrice());
        contentValues.put(description,foodModel.getDescription());
        contentValues.put(category,foodModel.getCategory());

        int status = DB.update("fooddetails", contentValues, PID + " =?",
                new String[]{String.valueOf(foodModel.getPID())});

        DB.close();
        return status;
    }

}
