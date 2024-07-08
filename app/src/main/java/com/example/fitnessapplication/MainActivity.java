package com.example.fitnessapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;


import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.messaging.FirebaseMessaging;

public class MainActivity extends AppCompatActivity {



    Button button1, button2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar toolbar = findViewById(R.id.toobar);
        setSupportActionBar(toolbar);



        FirebaseMessaging.getInstance().subscribeToTopic("News")
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        String msg = "Done";
                        if (!task.isSuccessful()) {
                            msg = "Failed";
                        }

                    }
                });


        Animation animation = AnimationUtils.loadAnimation(this, R.anim.bounce);


        button1 = findViewById(R.id.startex);
        button2 = findViewById(R.id.startex2);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                button1.startAnimation(animation);
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                button2.startAnimation(animation);
                Intent intent = new Intent(MainActivity.this, SecondActivity2.class);
                startActivity(intent);
            }
        });
    }






    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.id_privacy) {


            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://gymplanapp.com/privacy-policy/"));
            startActivity(intent);
            return true;
        }
        if (id == R.id.id_term) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://gymplanapp.com/terms/"));
            startActivity(intent);
            return true;
        }
        if (id == R.id.rate) {

            try {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + getPackageName())));
            } catch (Exception ex) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + getPackageName())));
            }

            return true;
        }

        if (id == R.id.share) {

            Intent myIntent = new Intent(Intent.ACTION_SEND);
            myIntent.setType("text/plain");
            String sharebody = "This is the Best Fitness app \n Make yourself FIt to the Modern World \n Free app you can Downlord Now \n " + "https://play.google.com/store/apps/details?id=com.example.fitnessapplication&hl=en";
            String sharehub = "Fiteness App";
            myIntent.putExtra(Intent.EXTRA_SUBJECT, sharehub);
            myIntent.putExtra(Intent.EXTRA_SUBJECT, sharebody);
            startActivity(Intent.createChooser(myIntent, "Share Using"));


            return true;
        }
        if (id == R.id.more) {
            FirebaseAuth.getInstance().signOut();
            Intent intent = new Intent(MainActivity.this, LogInActivity.class);
            startActivity(intent);
            finish();
            return true;
        }
        return true;
    }

    public void greaterthan18(View view) {

        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        startActivity(intent);

    }

    public void lessthan18(View view) {
        Intent intent = new Intent(MainActivity.this, SecondActivity2.class);
        startActivity(intent);
    }

    public void food(View view) {
        Intent intent = new Intent(MainActivity.this, FoodActivity.class);
        startActivity(intent);
    }



}
