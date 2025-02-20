package com.example.healthyapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class DoctorDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_doctor_details);

            Button btnBack = findViewById(R.id.btn_appoback);
            btnBack.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // Navigate to the next activity
                Intent intent = new Intent(DoctorDetailsActivity.this, homeActivity.class);
                startActivity(intent);
            }
        });
        Button btnAppoinment1 = findViewById(R.id.btn_appoinment1);
        btnAppoinment1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // Navigate to the next activity
                Intent intent = new Intent(DoctorDetailsActivity.this, AppointmentActivity.class);
                startActivity(intent);
            }
        });
        Button btnAppoinment2 = findViewById(R.id.btn_appoinment2);
        btnAppoinment2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // Navigate to the next activity
                Intent intent = new Intent(DoctorDetailsActivity.this, AppointmentActivity.class);
                startActivity(intent);
            }
        });
        Button btnAppoinment3 = findViewById(R.id.btn_appoinment3);
        btnAppoinment3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // Navigate to the next activity
                Intent intent = new Intent(DoctorDetailsActivity.this, AppointmentActivity.class);
                startActivity(intent);
            }
        });
        Button btnAppoinment4 = findViewById(R.id.btn_appoinment4);
        btnAppoinment4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // Navigate to the next activity
                Intent intent = new Intent(DoctorDetailsActivity.this, AppointmentActivity.class);
                startActivity(intent);
            }
        });
        Button btnAppoinment5 = findViewById(R.id.btn_appoinment5);
        btnAppoinment5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // Navigate to the next activity
                Intent intent = new Intent(DoctorDetailsActivity.this, AppointmentActivity.class);
                startActivity(intent);
            }
        });
        Button btnAppoinment6 = findViewById(R.id.btn_appoinment6);
        btnAppoinment6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // Navigate to the next activity
                Intent intent = new Intent(DoctorDetailsActivity.this, AppointmentActivity.class);
                startActivity(intent);
            }
        });
    }
}