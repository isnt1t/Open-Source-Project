package com.example.project.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.project.R;
import com.example.project.model.Product;

import java.util.List;

public class ListProductAdapter extends BaseAdapter {
    private Context mContext;
    private List<Product> mProductList;

    public ListProductAdapter(Context mContext, List<Product> mProductList) {
        this.mContext = mContext;
        this.mProductList = mProductList;
    }

    @Override
    public int getCount() {
        return mProductList.size();
    }

    @Override
    public Object getItem(int position) {
        return mProductList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return mProductList.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = View.inflate(mContext, R.layout.db_listview, null );
        TextView Name = (TextView)v.findViewById(R.id.product_name);
        TextView Price = (TextView)v.findViewById(R.id.product_price);
        TextView Category = (TextView)v.findViewById(R.id.product_category);
        Name.setText(mProductList.get(position).getProduct_name());
        Price.setText(String.valueOf(mProductList.get(position).getPrice()) + " 원");
        Category.setText(mProductList.get(position).getProduct_category());

        return null;
    }
}
