package com.melikerdemkoc.myvetapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.melikerdemkoc.myapplication.MainActivity2;
import com.melikerdemkoc.myapplication.R;

public class MainActivity extends AppCompatActivity {

    Button btnNext;
    Context context = this;
    private EditText eName;
    private EditText ePassword;
    private TextView eAttemptsInfo;
    private Button eLogin;
    private int counter = 5;

    String userName = "thisuserissuper";
    String userPassword = "thisuserissuper123";

    class Credentials
    {
        String name = "thisuserissuper";
        String password = "thisuserissuper123";
    }

    boolean isValid = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        eName = findViewById(R.id.denemetestemaişl);
        ePassword = findViewById(R.id.userpassword);
        eAttemptsInfo = findViewById(R.id.kalandeneme);
        eLogin = findViewById(R.id.girişyapbutton);


        eLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                userName = eName.getText().toString();
                userPassword = ePassword.getText().toString();

                if(userName.isEmpty() || userPassword.isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Bir email adresi veya şifre girin!", Toast.LENGTH_LONG).show();

                }else {

                    isValid = validate(userName, userPassword);


                    if (!isValid) {

                        counter--;

                        eAttemptsInfo.setText("Kalan deneme haklarınız: " + String.valueOf(counter));

                        if (counter == 0) {
                            eLogin.setEnabled(false);
                            Toast.makeText(MainActivity.this, "Tüm deneme haklarınızı kullandınız!", Toast.LENGTH_LONG).show();
                        }
                        else {
                            Toast.makeText(MainActivity.this, "Bilgileriniz yanlış tekrar kontrol edin!", Toast.LENGTH_LONG).show();
                        }
                    }
                    /* If valid */
                    else {

                        startActivity(new Intent(MainActivity.this, MainActivity2.class));
                    }

                }
            }
        });
    }

    private boolean validate(String userName, String userPassword)
    {
        Credentials credentials = new Credentials();

        if(userName.equals(credentials.name) && userPassword.equals(credentials.password))
        {
            return true;
        }

        return false;
    }

}
