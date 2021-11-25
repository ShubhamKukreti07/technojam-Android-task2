package com.example.recipebook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class RecipeDetailActivity extends AppCompatActivity {
    TextView title;
    TextView ingredientsList;
    TextView timeTaken;
    ImageView ivRecipe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);
        title=findViewById(R.id.title);
        ivRecipe=findViewById(R.id.ivRecipe);
        ingredientsList=findViewById(R.id.ingredientList);
        timeTaken=findViewById(R.id.tvTimeTaken);

        Intent i = getIntent();
        RecipeListInfo recipeInfo = (RecipeListInfo)i.getSerializableExtra("Recipe_info");

        title.setText(recipeInfo.getTitle());
        timeTaken.setText("Time Taken : "+recipeInfo.getTimeTaken());
        Glide.with(this)
                .load(recipeInfo.image)
                .into(ivRecipe);
        StringBuilder s=new StringBuilder();
        for(String ingredient : recipeInfo.ingredients){
            s=s.append("* "+ingredient+"\n");
        }
        ingredientsList.setText(s);
    }
}