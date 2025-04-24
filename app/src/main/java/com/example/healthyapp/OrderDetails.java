package com.example.healthyapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;

public class OrderDetails extends AppCompatActivity {

    Button btn_back;
    Button deletebtn;
    LinearLayout orderLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);

        // Initialize buttons and layout
        btn_back = findViewById(R.id.btn_back);
        deletebtn = findViewById(R.id.deletebtn);  // Button for clearing all orders


        // Back button functionality
        btn_back.setOnClickListener(v -> {
            // Navigate to Home Activity
            Intent homeIntent = new Intent(OrderDetails.this, homeActivity.class);
            startActivity(homeIntent);
        });

        // Delete all orders button functionality
        deletebtn.setOnClickListener(v -> {
            deleteAllOrders(); // Deletes all orders
        });

        // Delete Order Item 1
        Button deleteOrderItem1 = findViewById(R.id.deletebtn);
        deleteOrderItem1.setOnClickListener(v -> {
            deleteOrderItem(findViewById(R.id.item1)); // Deletes the specific order item
        });

        // Delete Order Item 2
        Button deleteOrderItem2 = findViewById(R.id.deletebtn);
        deleteOrderItem2.setOnClickListener(v -> {
            deleteOrderItem(findViewById(R.id.item2)); // Deletes the specific order item
        });
    }

    // Delete all orders
    private void deleteAllOrders() {
        orderLayout.removeAllViews(); // Removes all views from the layout
    }

    // Delete a specific order item
    private void deleteOrderItem(View orderItemView) {
        orderLayout.removeView(orderItemView); // Removes the specific order view (item)
    }
}
