package com.example.healthyapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.healthyapp.LabTest;
import com.example.healthyapp.LabTestsAdapter;

import java.util.ArrayList;
import java.util.List;

public class LabTestHomeActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private LabTestsAdapter adapter;
    private List<LabTest> labTestsList;
    private Button btnBookLabTest, btnViewPastResults, btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test_home);


        recyclerView = findViewById(R.id.recyclerViewLabTests);
        btnBookLabTest = findViewById(R.id.btnBookLabTest);
        btnViewPastResults = findViewById(R.id.btnViewPastResults);
        btnBack = findViewById(R.id.btnBack);

        // Sample Lab Tests Data
        labTestsList = new ArrayList<>();
        labTestsList.add(new LabTest("Complete Blood Count (CBC)", R.drawable.cbc_test_image));
        labTestsList.add(new LabTest("Lipid Profile", R.drawable.lipid_profile_image));
        labTestsList.add(new LabTest("Blood Sugar Test", R.drawable.blood_sugar_image));
        labTestsList.add(new LabTest("Thyroid Function Test", R.drawable.thyroid_test_image));

        // Setting up RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new LabTestsAdapter(labTestsList);
        recyclerView.setAdapter(adapter);

        // Button Click Listeners
        btnBookLabTest.setOnClickListener(v -> {
            Intent intent = new Intent(LabTestHomeActivity.this, BookLabTestActivity.class);
            startActivity(intent);
        });

        btnViewPastResults.setOnClickListener(v -> {
            Intent intent = new Intent(LabTestHomeActivity.this, TestResultActivity.class);
            startActivity(intent);
        });

        btnBack.setOnClickListener(v -> {
            Intent intent = new Intent(LabTestHomeActivity.this, homeActivity.class);
            startActivity(intent);
        });
    }
}
