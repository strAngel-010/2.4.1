package com.example.testapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView text;
    Button solve;
    EditText ed1, ed2, ed3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = findViewById(R.id.text);
        solve = findViewById(R.id.solve);
        ed1 = findViewById(R.id.a);
        ed2 = findViewById(R.id.b);
        ed3 = findViewById(R.id.c);
        solve.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String t1 = ed1.getText().toString();
        String t2 = ed2.getText().toString();
        String t3 = ed3.getText().toString();
        double a = Double.parseDouble(t1);
        double b = Double.parseDouble(t2);
        double c = Double.parseDouble(t3);
        if (a == 0){
            if (b == 0) {
                if (c == 0){
                    text.setText("x - рациональное");
                } else {
                    text.setText("Нет решений");
                }
            } else {
                text.setText(String.valueOf(-c/b));
            }
        } else {
            double D = (b*b)-(4*a*c);
            Log.i("tag", String.valueOf(D));
            if (D > 0){
                double x1 = (-b-Math.sqrt(D))/(2*a);
                double x2 = (-b+Math.sqrt(D))/(2*a);
                text.setText(String.format("%.2f \n %.2f", x1, x2));
            } else if (D == 0){
                double x = -b/(2*a);
                text.setText(String.format("%.2f", x));
            } else {
                text.setText("Нет решений");
            }
        }
    }
}
