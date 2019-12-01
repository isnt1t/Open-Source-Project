package com.example.sqlistefromasset.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.sqlistefromasset.R;
import com.example.sqlistefromasset.model.Product;

import org.w3c.dom.Text;

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
        View v = View.inflate(mContext, R.layout.item_listview, null);
        TextView tvName = v.findViewById(R.id.tv_product_name);
        TextView tvPrice = v.findViewById(R.id.tv_product_price);
        TextView tvDescription = v.findViewById(R.id.tv_product_description);
        tvName.setText(mProductList.get(position).getName());
        tvPrice.setText(String.valueOf(mProductList.get(position).getPrice()) + "원");
        tvDescription.setText(mProductList.get(position).getDescription());

        return v;
    }
}
