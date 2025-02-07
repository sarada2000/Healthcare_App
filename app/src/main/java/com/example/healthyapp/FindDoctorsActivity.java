package com.example.healthyapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class FindDoctorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_find_doctors);

        Button GetStarted =findViewById(R.id.btn_get_started);
        GetStarted.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // Navigate to the next activity
                Intent intent = new Intent(FindDoctorsActivity.this, DoctorListActivity.class);
                startActivity(intent);
            }
        });
    }
}
