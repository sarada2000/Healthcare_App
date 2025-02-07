package com.example.healthyapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.concurrent.Callable;

public class DoctorListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_doctor_list);

        CardView exit = findViewById(R.id.cardback);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DoctorListActivity.this, FindDoctorsActivity.class);
                startActivity(intent);
            }

        });

        CardView Famity_Physicion = findViewById(R.id.cardFamity_Physicion);
        Famity_Physicion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(DoctorListActivity.this, DoctorDetailsActivity.class);
                it.putExtra("title","Family Physicians");
                startActivity(it);
            }

        });

        CardView Dentician = findViewById(R.id.cardDentician);
        Dentician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(DoctorListActivity.this, DoctorDetailsActivity.class);
                it.putExtra("title","Dentician");
                startActivity(it);
            }

        });

        CardView Dietician = findViewById(R.id.cardDietician);
        Dietician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(DoctorListActivity.this, DoctorDetailsActivity.class);
                it.putExtra("title","Dietician");
                startActivity(it);
            }

        });

        CardView Surgeon = findViewById(R.id.cardSurgeon);
        Surgeon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(DoctorListActivity.this, DoctorDetailsActivity.class);
                it.putExtra("title","Surgeon");
                startActivity(it);
            }

        });

        CardView Cardiologists = findViewById(R.id.cardCardiolodists);
        Cardiologists.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(DoctorListActivity.this, DoctorDetailsActivity.class);
                it.putExtra("title","Surgeon");
                startActivity(it);
            }

        });
    }
}
