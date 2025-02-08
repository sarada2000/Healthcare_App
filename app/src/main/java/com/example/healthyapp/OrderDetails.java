package com.example.healthyapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class OrderDetails extends AppCompatActivity {
    Button btn_back;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_order_details);

        // Back button functionality
        btn_back = findViewById(R.id.btn_back);
        btn_back.setOnClickListener(v -> {
            // Moving to Home Activity
            Intent homeIntent = new Intent(OrderDetails.this, homeActivity.class);
            startActivity(homeIntent);
        });



    }
}
