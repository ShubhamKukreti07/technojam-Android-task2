package com.example.recipebook;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.List;

public class RecipeListInfo implements Serializable {
    public String title;
    public String image;
    public String timeTaken;

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public List<String> ingredients;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String Image) {
        this.image = Image;
    }

    public String getTimeTaken() {
        return timeTaken;
    }

    public void setTimeTaken(String timeTaken) {
        this.timeTaken = timeTaken;
    }

//    public Array getIngredients() {
//        return ingredients;
//    }
//
//    public void setIngredients(Array ingredients) {
//        this.ingredients = ingredients;
//    }

    RecipeListInfo(){}

}
