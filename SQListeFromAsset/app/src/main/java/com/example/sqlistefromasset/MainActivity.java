package com.example.sqlistefromasset;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.icu.util.Output;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.example.sqlistefromasset.adapter.ListProductAdapter;
import com.example.sqlistefromasset.database.DatabaseHelper;
import com.example.sqlistefromasset.model.Product;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView lvProduct;
    private ListProductAdapter adapter;
    private List<Product> mProductList;
    private DatabaseHelper mDBHelpter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvProduct = findViewById(R.id.listview_product);
        mDBHelpter = new DatabaseHelper(this);

        // check exists database
        File database = getApplicationContext().getDatabasePath(DatabaseHelper.DBNAME);
        if(!database.exists()){
            mDBHelpter.getReadableDatabase();
            if(copyDatabase(this)){
                Toast.makeText(this, "Copy Database success", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "Copy data error", Toast.LENGTH_SHORT).show();
                return;
            }
        }
        mProductList = mDBHelpter.getListProduct();
        adapter = new ListProductAdapter(this, mProductList);
        lvProduct.setAdapter(adapter);
    }

    private boolean copyDatabase(Context context){
        try{
            InputStream inputStream = context.getAssets().open(DatabaseHelper.DBNAME);
            String outFileName = DatabaseHelper.DBLOCATION + DatabaseHelper.DBNAME;
            OutputStream outputStream = new FileOutputStream(outFileName);
            byte[]buff = new byte[1024];
            int length = 0;
            while ((length = inputStream.read(buff)) > 0){
                outputStream.write(buff, 0, length);
            }
            outputStream.flush();
            outputStream.close();
            Log.w("MainActivity", "DB copied");
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
