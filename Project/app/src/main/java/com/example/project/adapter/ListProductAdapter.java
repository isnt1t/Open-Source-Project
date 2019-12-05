package com.example.project.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.project.R;
import com.example.project.model.Product;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ListProductAdapter extends BaseAdapter{
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

        TextView Name = v.findViewById(R.id.product_name);
        TextView Price = v.findViewById(R.id.price);
        TextView CVS = v.findViewById(R.id.cvs_name);
        TextView Plus = v.findViewById(R.id.plus);
        TextView Category = v.findViewById(R.id.product_category);
        ImageView Image = v.findViewById(R.id.image);
        ImageView Coin = v.findViewById(R.id.coin);

        Name.setText(mProductList.get(position).getName());
        Price.setText(mProductList.get(position).getPrice() + "원 (개당 가격)");
        CVS.setText(mProductList.get(position).getCvs());
        Plus.setText(mProductList.get(position).getPlus());
        Category.setText(mProductList.get(position).getCategory());
        Picasso.get().load(mProductList.get(position).getImage()).into(Image);
        Coin.setImageResource(R.drawable.coin_img);

        return v;
    }
}