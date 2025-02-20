package com.example.healthyapp;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class AppointmentActivity extends AppCompatActivity {

    // Declare the UI elements at the class level, outside of onCreate()
    private EditText aName, aAge, aAddress, aCNumber;
    private TextView selectDate, selectTime;
    private Button btnDate, btnTime, btnBook, btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment);

        // Initialize UI elements
        aName = findViewById(R.id.aName);
        aAge = findViewById(R.id.aAge);
        aAddress = findViewById(R.id.aAddress);
        aCNumber = findViewById(R.id.aCNumber);
        selectDate = findViewById(R.id.select_date);
        selectTime = findViewById(R.id.selecte_time);
        btnDate = findViewById(R.id.btn_date);
        btnTime = findViewById(R.id.btn_time);
        btnBook = findViewById(R.id.btn_book);
        btnBack = findViewById(R.id.btn_back);

        // Reference the Spinner
        Spinner doctorSpinner = findViewById(R.id.spinner_doctors);

        // List of doctors
        String[] doctors = {"Dr. John Doe - Family Physicion", "Dr. Sarah Smith - Dentist", "Dr. Alex Brown - Surgeon", "Dr. Michel Lee - Dietician", "Dr. Selie Fernando - Cardiologist", "Dr. Selie Fernando - Cardiologist", "Dr.Ravi Perera - Neurologist"};

        // Create Adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, doctors);
        doctorSpinner.setAdapter(adapter);

        // Handle Selection
        doctorSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedDoctor = parent.getItemAtPosition(position).toString();
                Toast.makeText(AppointmentActivity.this, "Selected: " + selectedDoctor, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing
            }
        });

        // Date Picker
        btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(AppointmentActivity.this,
                        (view, year1, month1, dayOfMonth) -> {
                            String date = dayOfMonth + "/" + (month1 + 1) + "/" + year1;
                            selectDate.setText("Selected Date: " + date);
                        }, year, month, day);
                datePickerDialog.show();
            }
        });

        // Time Picker
        btnTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int hour = calendar.get(Calendar.HOUR_OF_DAY);
                int minute = calendar.get(Calendar.MINUTE);

                TimePickerDialog timePickerDialog = new TimePickerDialog(AppointmentActivity.this,
                        (view, hourOfDay, minute1) -> {
                            String time = hourOfDay + ":" + String.format("%02d", minute1);
                            selectTime.setText("Selected Time: " + time);
                        }, hour, minute, true);
                timePickerDialog.show();
            }
        });

        // Book Appointment
        btnBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = aName.getText().toString().trim();
                String age = aAge.getText().toString().trim();
                String address = aAddress.getText().toString().trim();
                String contact = aCNumber.getText().toString().trim();
                String date = selectDate.getText().toString();
                String time = selectTime.getText().toString();

                if (name.isEmpty() || age.isEmpty() || address.isEmpty() || contact.isEmpty() || date.equals("Selected Date: ") || time.equals("Selected Time: ")) {
                    Toast.makeText(AppointmentActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(AppointmentActivity.this, "Appointment Booked Successfully!", Toast.LENGTH_LONG).show();
                }
            }
        });

        // Back Button
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AppointmentActivity.this, DoctorListActivity.class);
                startActivity(intent);
            }
        });
    }
}
