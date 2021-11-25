package com.example.recipebook;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.common.reflect.TypeToken;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.MyViewHolder> {
    ArrayList<RecipeListInfo> list;
    Context context;
    RecipeAdapter(Context context, ArrayList<RecipeListInfo> list){
        this.list=list;
        this.context=context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // infalte the item Layout
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recipe, parent, false);
        // set the view's size, margins, paddings and layout parameters
        MyViewHolder vh = new MyViewHolder(v); // pass the view to View Holder
        return vh;
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        // set the data in items
        holder.recipeName.setText(list.get(position).title);
        Glide.with(context)
                .load(list.get(position).image)
                .into( holder.ivRecipe);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent= new Intent(context,RecipeDetailActivity.class);
                intent.putExtra("Recipe_info",list.get(position));
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView recipeName;
        ImageView ivRecipe;// init the item view's
        public MyViewHolder(View itemView) {
            super(itemView);

// get the reference of item view's
            recipeName = (TextView) itemView.findViewById(R.id.recipeName);
            ivRecipe = (ImageView) itemView.findViewById(R.id.recipeImage);
        }
    }
}
