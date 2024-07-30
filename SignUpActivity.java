package com.example.fbloginpage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class SignUpActivity extends AppCompatActivity {

    private TextInputEditText firstNameEditText;
    private TextInputEditText lastNameEditText;
    private TextInputEditText emailEditText;
    private TextInputEditText passwordEditText;
    private TextInputEditText confirmPasswordEditText;
    private TextInputEditText mobileEditText;
    private DatePicker datePicker;
    private TextView signInTextView;
    private RadioGroup genderRadioGroup;
    private RadioButton selectedGenderRadioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        // Initialize UI components
        firstNameEditText = findViewById(R.id.first_name);
        lastNameEditText = findViewById(R.id.last_name);
        emailEditText = findViewById(R.id.email);
        passwordEditText = findViewById(R.id.password);
        confirmPasswordEditText = findViewById(R.id.confirmPass);
        mobileEditText = findViewById(R.id.mobile);
        datePicker = findViewById(R.id.date_picker);
        Button registerButton = findViewById(R.id.register_button);
        signInTextView = findViewById(R.id.sign_in);
        genderRadioGroup = findViewById(R.id.gender_radio_group);

        // Set onClickListener for the register button
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get input values
                String firstName = firstNameEditText.getText().toString().trim();
                String lastName = lastNameEditText.getText().toString().trim();
                String email = emailEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();
                String confirmPassword = confirmPasswordEditText.getText().toString().trim();
                String mobile = mobileEditText.getText().toString().trim();
                String birthday = datePicker.getDayOfMonth() + "/" +
                        (datePicker.getMonth() + 1) + "/" +
                        datePicker.getYear();
                int selectedGenderId = genderRadioGroup.getCheckedRadioButtonId();
                selectedGenderRadioButton = findViewById(selectedGenderId);
                String gender = (selectedGenderRadioButton != null) ? selectedGenderRadioButton.getText().toString() : "";

                // Placeholder for actual registration logic
                if (isInputValid(firstName, lastName, email, password, confirmPassword, mobile, gender)) {
                    Toast.makeText(SignUpActivity.this, "Registration successful", Toast.LENGTH_SHORT).show();
                    // You can navigate to another activity or perform further actions here
                } else {
                    Toast.makeText(SignUpActivity.this, "Please fill all fields correctly", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Set onClickListener for the sign in text
        signInTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    // Validate user input
    private boolean isInputValid(String firstName, String lastName, String email, String password, String confirmPassword, String mobile, String gender) {
        return !firstName.isEmpty() && !lastName.isEmpty() && !email.isEmpty() &&
                !password.isEmpty() && !mobile.isEmpty() && !gender.isEmpty() && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}