package com.example.healthyapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class OrderDetails extends AppCompatActivity {
    Button btnBack1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_order_details);

        // Back button functionality
        btnBack1 = findViewById(R.id.btnBack1); // Assuming you have a "Home" button in your layout
        btnBack1.setOnClickListener(v -> {
            // Moving to Home Activity
            Intent homeIntent = new Intent(OrderDetails.this, MainActivity.class);
            startActivity(homeIntent);
        });



    }
}