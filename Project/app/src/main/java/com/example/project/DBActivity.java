package com.example.project;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.project.adapter.ListProductAdapter;
import com.example.project.database.DatabaseHelper;
import com.example.project.model.Product;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

public class DBActivity extends AppCompatActivity {
    private ListView lvProduct;
    private ListProductAdapter adapter;
    private List<Product> mProductList;
    private DatabaseHelper mDBHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_db);
        lvProduct = (ListView)findViewById(R.id.listview_product);
        mDBHelper = new DatabaseHelper(this);

        // Check exists database
        File database = getApplicationContext().getDatabasePath(DatabaseHelper.DBNAME);
        if(!database.exists()) {
            mDBHelper.getReadableDatabase();
            // Copy db
            if(copyDatabase(this)) {
                Toast.makeText(this, "Copy database success", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Copy data error", Toast.LENGTH_SHORT).show();
                return;
            }
        }
        // Get Product list in db when db exists
        mProductList = mDBHelper.getListProduct();
        // Init adapter
        adapter = new ListProductAdapter(this, mProductList);
        // Set adapter for listview
        lvProduct.setAdapter(adapter);
    }

    private boolean copyDatabase(Context context) {
        try {
            InputStream inputStream = context.getAssets().open(DatabaseHelper.DBNAME);
            String outFileName = DatabaseHelper.DBLOCATION + DatabaseHelper.DBNAME;
            OutputStream outputStream = new FileOutputStream(outFileName);
            byte[]buff = new byte[1024];
            int length = 0;
            while ((length = inputStream.read(buff)) > 0) {
                outputStream.write(buff, 0, length);
            }
            outputStream.flush();
            outputStream.close();
            Log.w("DB Activity","DB copied");
            return true;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
