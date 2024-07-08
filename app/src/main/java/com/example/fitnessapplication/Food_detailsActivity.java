package com.example.fitnessapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Food_detailsActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_details);


        textView=findViewById(R.id.txt);
        String dstory=getIntent().getStringExtra("story");
        textView.setText(dstory);

    }

    public void gooback(View view) {

        Intent intent =new Intent(Food_detailsActivity.this,FoodActivity.class);
        startActivity(intent);
        finish();




    }

    /**
     * Called when the activity has detected the user's press of the back
     * key. The {@link #getOnBackPressedDispatcher() OnBackPressedDispatcher} will be given a
     * chance to handle the back button before the default behavior of
     * {@link Activity#onBackPressed()} is invoked.
     *
     * @see #getOnBackPressedDispatcher()
     */
    @Override
    public void onBackPressed() {
        Intent intent =new Intent(Food_detailsActivity.this,FoodActivity.class);
        startActivity(intent);
        finish();
    }
}





















