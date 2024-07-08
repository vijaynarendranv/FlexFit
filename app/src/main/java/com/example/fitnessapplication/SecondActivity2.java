package com.example.fitnessapplication;

import android.content.Intent;

import android.net.Uri;
import android.os.Bundle;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class SecondActivity2 extends AppCompatActivity {

    int [] newArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second2);


        Toolbar toolbar= findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        newArray = new int[]{

                R.id.boat_pose,R.id.boat_pose1,R.id.boat_pose2,R.id.boat_pose3,R.id.boat_pose4,R.id.boat_pose5,R.id.boat_pose6,R.id.boat_pose7,R.id.boat_pose8,R.id.boat_pose9,R.id.boat_pose10,R.id.boat_pose11,R.id.boat_pose12,R.id.boat_pose13,R.id.boat_pose14,




        };
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
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
            Intent intent = new Intent(SecondActivity2.this, LogInActivity.class);
            startActivity(intent);
            finish();
            return true;
        }
        return true;
    }



    public void Imagebuttonclicked(View view) {

        for(int i=0;i<newArray.length;i++){
            if(view.getId()==newArray[i]){
                int value =i+1;
                Log.i("FIRST",String.valueOf(value));
                Intent intent=new Intent(SecondActivity2.this,ThirdActivity2.class);
                intent.putExtra("value",String.valueOf(value));
                startActivity(intent);


            }
        }

    }
}