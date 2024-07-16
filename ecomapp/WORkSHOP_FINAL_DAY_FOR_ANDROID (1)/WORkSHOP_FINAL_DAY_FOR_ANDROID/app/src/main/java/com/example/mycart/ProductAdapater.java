package com.example.mycart;

import android.content.Context;
import android.content.Intent;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

public class ProductAdapater  extends RecyclerView.Adapter<ProductAdapater.ProductViewHolder> {


    // My Step 1
    //Coming From Activity
    int rowLayout ;
    List<Product> productList;
    Context context;


    // My Step 2

    //Cell
    public static class ProductViewHolder  extends RecyclerView.ViewHolder{

        TextView productTitle;
        TextView prodcutDesc;
        ImageView  mProductImage;
        LinearLayout baseLayout;




        public ProductViewHolder(View v) {
            super(v);
            productTitle = (TextView) v.findViewById(R.id.productTitle);
            prodcutDesc = (TextView) v.findViewById(R.id.productDesc);
            mProductImage = (ImageView) v.findViewById(R.id.productImage);
            baseLayout = (LinearLayout) v.findViewById(R.id.product_layout);
        }

    }





    // this are my work to do
    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {

        holder.productTitle.setText(productList.get(position).getTitle());
        holder.prodcutDesc.setText(productList.get(position).getDescription());

        Glide.with(context)
                .load(productList.get(position).getImage())
                .apply(RequestOptions.circleCropTransform())
                .into(holder.mProductImage);

        holder.baseLayout.setOnClickListener(view -> {

            Intent intent = new Intent(context,ProductDetailActivity.class);
            intent.putExtra("PRODUCT",productList.get(position));
            context.startActivity(intent);

        });

    }

    @Override
    public int getItemCount() {
        return productList.size();
    }




    public ProductAdapater(Context context,int rowLayout, List<Product> productList) {
        this.context = context;
        this.rowLayout = rowLayout;
        this.productList = productList;
    }
}
