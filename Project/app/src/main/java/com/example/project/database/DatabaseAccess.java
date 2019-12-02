//package com.example.project.database;
//
//import android.content.Context;
//import android.database.Cursor;
//import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteOpenHelper;
//
//public class DatabaseAccess {
//    private SQLiteOpenHelper openHelper;
//    private SQLiteDatabase db;
//    private static DatabaseAccess instance;
//    Cursor c = null;
//
//    // private constructor so that object creation from outside the class is avoided
//    private DatabaseAccess(Context context) {
//        this.openHelper = new DatabaseHelper(context);
//
//    }
//
//    // to return the single instance of database
//
//    public static DatabaseAccess getInstance(Context context) {
//        if(instance == null) {
//            instance = new DatabaseAccess(context);
//        }
//        return instance;
//    }
//
//    // to open the database
//
//    public void open() {
//        this.db = openHelper.getWritableDatabase();
//    }
//
//    // closing the database connection
//
//    public void close() {
//        if(db != null) {
//            this.db.close();
//        }
//    }
//
//    public String getProductName(String cvs_name) {
//        c = db.rawQuery("select product_name from test_db where CVS_NAME = '"+cvs_name+"'", new String[]{});
//        StringBuffer buffer = new StringBuffer();
//        while(c.moveToNext()) {
//            String product_name = c.getString(0);
//            buffer.append(""+product_name);
//        }
//        return buffer.toString();
//    }
//
//}
