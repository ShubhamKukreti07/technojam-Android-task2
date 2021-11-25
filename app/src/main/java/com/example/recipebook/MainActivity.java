package com.example.recipebook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<RecipeListInfo> list =new ArrayList();
    RecyclerView rvRecipe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvRecipe=findViewById(R.id.rvRecipe);

        setupFireStore();
    }


    public void setupFireStore(){
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("recipes")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                RecipeListInfo recipe = document.toObject(RecipeListInfo.class);
                                list.add(recipe);
                                Log.d("FirestorData", document.getId() + " => " + document.getData());

                            }
                            rvRecipe.setAdapter(new RecipeAdapter(MainActivity.this,list));
                        } else {
                            Log.d("FirestorData", "Error getting documents.", task.getException());
                        }
                    }
                });


    }
}