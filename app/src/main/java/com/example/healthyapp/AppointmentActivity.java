package com.example.healthyapp;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
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

    // Declare UI elements
    private EditText aName, aAge, aAddress, aCNumber;
    private TextView selectDate, selectTime;
    private Button btnDate, btnTime, btnBook, btnCancel, btnBack;
    private Spinner doctorSpinner;

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
        btnCancel = findViewById(R.id.btn_cancel);
        btnBack = findViewById(R.id.btn_back);
        doctorSpinner = findViewById(R.id.spinner_doctors);

        // Populate doctor spinner
        String[] doctors = {
                "Dr. John Doe - Family Physician",
                "Dr. Sarah Smith - Dentist",
                "Dr. Alex Brown - Surgeon",
                "Dr. Michel Lee - Dietician",
                "Dr. Selie Fernando - Cardiologist",
                "Dr. Ravi Perera - Neurologist"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, doctors);
        doctorSpinner.setAdapter(adapter);

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

        // Date picker
        btnDate.setOnClickListener(v -> {
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
        });

        // Time picker
        btnTime.setOnClickListener(v -> {
            Calendar calendar = Calendar.getInstance();
            int hour = calendar.get(Calendar.HOUR_OF_DAY);
            int minute = calendar.get(Calendar.MINUTE);

            TimePickerDialog timePickerDialog = new TimePickerDialog(AppointmentActivity.this,
                    (view, hourOfDay, minute1) -> {
                        String time = hourOfDay + ":" + String.format("%02d", minute1);
                        selectTime.setText("Selected Time: " + time);
                    }, hour, minute, true);
            timePickerDialog.show();
        });

        // Book Appointment
        btnBook.setOnClickListener(v -> {
            String name = aName.getText().toString().trim();
            String age = aAge.getText().toString().trim();
            String address = aAddress.getText().toString().trim();
            String contact = aCNumber.getText().toString().trim();
            String date = selectDate.getText().toString();
            String time = selectTime.getText().toString();
            String doctor = doctorSpinner.getSelectedItem().toString();

            if (name.isEmpty() || age.isEmpty() || address.isEmpty() || contact.isEmpty()
                    || date.equals("Selected Date: ") || time.equals("Selected Time: ")) {
                Toast.makeText(AppointmentActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            } else {
                Database db = new Database(AppointmentActivity.this, "healthcare", null, 1);
                db.bookAppointment(name, age, address, contact, doctor, date, time);
                Toast.makeText(AppointmentActivity.this, "Appointment Booked Successfully!", Toast.LENGTH_LONG).show();
            }
        });

        // Cancel button
        btnCancel.setOnClickListener(v -> showCancelConfirmation());

        // Back button
        btnBack.setOnClickListener(v -> {
            Intent intent = new Intent(AppointmentActivity.this, DoctorListActivity.class);
            startActivity(intent);
        });
    }

    // Show confirmation dialog when canceling
    private void showCancelConfirmation() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Cancel Appointment");
        builder.setMessage("Are you sure you want to cancel the appointment?");
        builder.setPositiveButton("Yes, Cancel", (dialog, which) -> {
            aName.setText("");
            aAge.setText("");
            aAddress.setText("");
            aCNumber.setText("");
            selectDate.setText("Selected Date: ");
            selectTime.setText("Selected Time: ");
            Toast.makeText(AppointmentActivity.this, "Appointment Canceled", Toast.LENGTH_SHORT).show();
            finish();
        });
        builder.setNegativeButton("No", null);
        builder.show();
    }
}
