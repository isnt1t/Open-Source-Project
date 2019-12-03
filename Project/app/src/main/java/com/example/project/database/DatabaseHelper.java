package com.example.project.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.project.MainActivity;
import com.example.project.model.Product;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DBNAME = "CVS.db";
    public static final String DBLOCATION = "/data/data/com.example.project/databases/";
    private Context mContext;
    private SQLiteDatabase mDatabase;

    public DatabaseHelper(Context context){
        super(context, DBNAME, null , 1);
        this.mContext = context;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void openDatabase(){
        String dbPath = mContext.getDatabasePath(DBNAME).getPath();
        if(mDatabase != null && mDatabase.isOpen()){
            return;
        }
        mDatabase = SQLiteDatabase.openDatabase(dbPath, null, SQLiteDatabase.OPEN_READWRITE);
    }

    public void closeDatabase(){
        if(mDatabase != null){
            mDatabase.close();
        }
    }

    public List<Product> getListProduct() {
        Product product = null;
        List<Product> productList = new ArrayList<>();

        String name = MainActivity.name;
        String category = MainActivity.record2;
        String cvs = MainActivity.record;
        String plus = MainActivity.record3;

        String nameQuery;
        String categoryQuery;
        String cvsQuery;
        String plusQuery;

        int flag = 0;

        if(name.equals("")){
            nameQuery = "";
            flag = 1;
        }
        else {
            nameQuery = "WHERE product_name LIKE '%" + name + "%' ";
        }

        if (category.equals("상품 분류 전체")) {
            categoryQuery = "";
        }
        else {
            if(flag == 1){
                categoryQuery = "WHERE product_category = '"+category+"' ";
                flag = 0;
            }
            else {
                categoryQuery = "AND product_category = '"+category+"' ";
            }
        }

        if (cvs.equals("편의점 전체")) {
            cvsQuery = "";
        }
        else {
            if (flag == 1) {
                cvsQuery = "WHERE cvs_name = '"+cvs+"' ";
                flag = 0;
            }
            else {
                cvsQuery = "AND cvs_name = '"+cvs+"' ";
            }
        }

        if (plus.equals("플러스 전체")) {
            plusQuery = "";
        }
        else {
            if(flag == 1){
                plusQuery = "WHERE plus = '"+plus+"'";
            }
            else {
                plusQuery = "AND plus = '"+plus+"'";
            }
        }

        openDatabase();
        Cursor cursor = mDatabase.rawQuery("SELECT id, product_name, price, cvs_name, image, plus, product_category " +
                                                "FROM CVS " +
                                                nameQuery +
                                                categoryQuery  +
                                                cvsQuery +
                                                plusQuery, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            product = new Product(cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getInt(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5),
                    cursor.getString(6)
                    );
            productList.add(product);
            cursor.moveToNext();
        }
        cursor.close();
        closeDatabase();
        return productList;
    }
}
