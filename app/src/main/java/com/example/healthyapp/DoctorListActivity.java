package com.example.healthyapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class DoctorListActivity extends AppCompatActivity {

    private Button btnBackDoctor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_doctor_list);

        Button btnBackDoctor = findViewById(R.id.btnBackDoctor);
        btnBackDoctor.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // Navigate to the next activity
                Intent intent = new Intent(DoctorListActivity.this, homeActivity.class);
                startActivity(intent);
            }
        });

        CardView Neurologist = findViewById(R.id.cardNeurologist);
        Neurologist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DoctorListActivity.this, DoctorDetailsActivity.class);
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
