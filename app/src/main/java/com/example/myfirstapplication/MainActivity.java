package com.example.myfirstapplication;

import android.os.Bundle;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TextView result;
    double num1;
    double num2;
    char ch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        result=findViewById(R.id.textViewResult);
        result.setText("");
    }

    public void num(View view) {
        Button button =(Button) view;
        result.append(button.getText().toString());
    }

    public void equalFunction(View view) {

        num2 = Double.parseDouble(result.getText().toString());

        double calculationResult = 0;
        switch (ch) {
            case '+':
                calculationResult = num1 + num2;
                break;
            case '-':
                calculationResult = num1 - num2;
                break;
            case '*':
                calculationResult = num1 * num2;
                break;
            case '/':
                if (num2 != 0) {
                    calculationResult = num1 / num2;
                } else {
                    result.setText("Error");
                    return;
                }
                break;
        }
        result.setText(String.valueOf(calculationResult));

    }

    public void OperationFunction(View view) {
        ch= ((Button) view).getText().toString().charAt(0);
        num1= Double.parseDouble(result.getText().toString());
        result.setText("");

    }

    public void clearconsole(View view) {
        result.setText("");
    }
}