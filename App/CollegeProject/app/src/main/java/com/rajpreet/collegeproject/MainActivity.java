package com.rajpreet.collegeproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText eName;
    private EditText ePassword;
    private Button eLogin;
    private TextView eAttemptsInfo;

    private String Username = "Admin";
    private String Password = "1234";

    boolean isValid = false;

    private int counter = 5;

    static public ModelInfer model = new ModelInfer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eName = findViewById(R.id.etName);
        ePassword = findViewById(R.id.etPassword);
        eLogin = findViewById(R.id.btnLogin);
        eAttemptsInfo = findViewById(R.id.tvAttemptInfo);

        eLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String inputName = eName.getText().toString();
                String inputPassword = ePassword.getText().toString();

                if(inputName.isEmpty() || inputPassword.isEmpty())
                {
                    Toast.makeText(MainActivity.this,"Please enter all the details correctly!",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    isValid =  validate(inputName, inputPassword);

                    if (!isValid)
                    {
                        counter--;

                        Toast.makeText(MainActivity.this,"Incorrect Credentials Entered!",Toast.LENGTH_SHORT).show();

                        eAttemptsInfo.setText( "No of Attempts Remaining : " +counter);

                        if(counter==0){
                            eLogin.setEnabled(false);
                        }

                    }else
                    {
                        Toast.makeText(MainActivity.this,"Login Successful!",Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(MainActivity.this,TextRecogintion.class);
                        startActivity(intent);
                    }


                }
            }
        });
    }

    private boolean validate(String name, String password){

        if(name.equals(Username) && password.equals(Password))
        {
            return true;
        }

        return false;
    }
}