package com.example.sqlitefromasset.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sqlitefromasset.R;
import com.example.sqlitefromasset.model.Product;
import com.squareup.picasso.Picasso;

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

        ImageView Image = v.findViewById(R.id.image);
        TextView Name = v.findViewById(R.id.product_name);
        TextView Price = v.findViewById(R.id.price);
        TextView CSV = v.findViewById(R.id.cvs_name);

        Name.setText(mProductList.get(position).getName());
        Price.setText(mProductList.get(position).getPrice() + "원");
        CSV.setText(mProductList.get(position).getDescription());
//        Image.setImageResource(R.drawable.image1);

        Picasso.get().load(mProductList.get(position).getImage()).fit().into(Image);
//        Picasso.get().load("http://i.imgur.com/DvpvklR.png").into(Image);
        return v;
    }
}