package com.example.applicationwithtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {


    EditText edtEmail, edtPassword;
    Button btnReg;
    ArrayList<User> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);
        btnReg = findViewById(R.id.btnReg);

        btnReg.setOnClickListener(this::btnClickReg);
    }

    public void btnClickReg(View view){
        String email = edtEmail.getText().toString();
        String password = edtPassword.getText().toString();
        addUser(email, password, list);
    }

    public static boolean addUser(String email, String password, ArrayList<User> list){
        if(checkEmail(email, list) && checkPassword(password)){
            User user = new User(email, password);
            list.add(user);
            return true;
        }
        return false;
    }

    public static boolean checkPassword(String password){

        String regex = "^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=.*[@#$%^&+=])"
                + "(?=\\S+$).{8,20}$";

        Pattern p = Pattern.compile(regex);

        if (password == null) {
            return false;
        }

        Matcher m = p.matcher(password);

        return m.matches();
    }

    public static boolean checkEmail(String email, ArrayList<User> list){
        if(email == null || email.length() == 0)
            return false;
        for (User u : list) {
            if(u.getEmail().equals(email))
                return false;
        }
        return true;
    }
}