package com.example.healthyapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class CheckOut extends AppCompatActivity {
    Button place_btn;
    Button btn_back;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_check_out);
        // Back button functionality
        btn_back = findViewById(R.id.btn_back); // Assuming you have a "Home" button in your layout
        btn_back.setOnClickListener(v -> {
            // Moving to Cart Activity
            Intent homeIntent = new Intent(CheckOut.this, CartActivity.class);
            startActivity(homeIntent);
        });

        // Place Order button Function
        place_btn = findViewById(R.id.place_btn);
        place_btn.setOnClickListener(v -> {
            Toast.makeText(CheckOut.this, "Order Successful!", Toast.LENGTH_SHORT).show();

        });



    }
}