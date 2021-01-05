package com.example.hospitalhealthcare;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.strictmode.SqliteObjectLeakedViolation;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;

import androidx.annotation.Nullable;

import java.util.concurrent.Callable;

public class DatabaseHelper extends SQLiteOpenHelper {
   // public static final String DATABASE_NAME="register.db";
    public static final String TABLE_NAME="registeruser3";
    public static final String col_1="username";
    public static final String col_2="ID";
  //  public static final String col_3="gender";
    public static final String col_4="email";
    public static final String col_5="phone_no";
  //  public static final String col_6="spinner";
    public static final String col_7="password";

    public DatabaseHelper(@Nullable Context context) {
        super(context, "register14.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE registeruser3 (email text PRIMARY KEY,username text,phone_no text,spinner text,password TEXT)");



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS registeruser3");


    }
    public boolean addUser(String email, String username , String phone_no,String spinner, String password){

        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
       contentValues.put("username",username);

       // contentValues.put("ID",id);
       // contentValues.put("gender", String.valueOf(gender));
        contentValues.put("email",email);
        contentValues.put("phone_no",phone_no);
        //contentValues.put("spinner", String.valueOf(spinner));
      contentValues.put("spinner",spinner);
        contentValues.put("password",password);
        long res=db.insert("registeruser3",null,contentValues);
       if (res==-1) return false;
       else return true;
    }
    public boolean addsppiner( String spinner){

        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("spinner",spinner);

        long res=db.insert("registeruser3",null,contentValues);
        if (res==-1) return false;
        else return true;
    }
    public  boolean verify_mobile(String phone){

        String[] columns={ col_4 };
        SQLiteDatabase db=getReadableDatabase();
        String selection= col_5 + "=?";
        String[] selectArgument={phone};
        Cursor cursor=db.query(TABLE_NAME,columns,selection,selectArgument,null,null,null);
        int count=cursor.getCount();
        cursor.close();
        db.close();
        if (count>0){
            return true;
        }
        else {
            return false;
        }

    }
    public  boolean chk_email(String email)
    {
        SQLiteDatabase database=this.getReadableDatabase();
        Cursor cursor=database.rawQuery("select * from registeruser3 where email=?",new String[]{email});
        if (cursor.getCount()>0) return false;
        else return true;

    }
    public  boolean chk_mobile(String mobile_no)
    {
        SQLiteDatabase database=this.getReadableDatabase();
        Cursor cursor=database.rawQuery("select * from registeruser3 where phone_no=?",new String[]{mobile_no});
        if (cursor.getCount()>0) return false;
        else return true;
    }
    public  boolean checkUser(String email ,String password){
        SQLiteDatabase database=this.getReadableDatabase();
        Cursor cursor=database.rawQuery("select * from registeruser3 where email=? and password=?",new String[]{email,password});
        if (cursor.getCount()>0) return true;
        else return false;

    }
    public  boolean checkUserSpinner(String spinning,String email2){
        SQLiteDatabase database=this.getReadableDatabase();
        Cursor cursor=database.rawQuery("select * from registeruser3 where spinner=? and email=?",new String[]{spinning,email2});
        if (cursor.getCount()>0) return true;
        else return false;

    }
    public  boolean checkUser_mobile(String email ,String phone){
        SQLiteDatabase database=this.getReadableDatabase();
        Cursor cursor=database.rawQuery("select * from registeruser3 where email=? and phone_no=?",new String[]{email,phone});
        if (cursor.getCount()>0) return true;
        else return false;
    }
    public  boolean checkUser_email_spin(String email ,String spining){
        SQLiteDatabase database=this.getReadableDatabase();
        Cursor cursor=database.rawQuery("select * from registeruser3 where email=? and spinner=?",new String[]{email,spining});
        if (cursor.getCount()>0) return true;
        else return false;
    }

    public Cursor allData(){
        SQLiteDatabase database=this.getWritableDatabase();
      //  String love="Doctor Login";
        Cursor cursor=database.rawQuery("select * from registeruser3 where spinner='Patient_Login'",null);
        return cursor;
    }
    public Cursor allData2(){
        SQLiteDatabase database2=this.getWritableDatabase();
        //  String love="Doctor Login";
        Cursor cursor=database2.rawQuery("select * from registeruser3 where spinner='Doctor_Login'",null);
        return cursor;
    }
  /*  public  boolean verify_mobile(String phone1){
        SQLiteDatabase database=this.getReadableDatabase();
        Cursor cursor=database.rawQuery("select * from registeruser1 where phone_no=?",new String[]{phone1});
        if (cursor.getCount()>0) return true;
        else return false;
    }*/
}
