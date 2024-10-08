package com.example.multiplytable;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText numberET;
    AppCompatButton btnPrint;
    TextView tvTable;
    EditText ED2;
    Button BTN2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); 

        numberET =findViewById(R.id.inputNumber);
        btnPrint = findViewById(R.id.printBtn);
        tvTable = findViewById(R.id.tableTV);
        ED2 = findViewById(R.id.ED2);
        BTN2 = findViewById(R.id.BTN2);

        BTN2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String namevalue = ED2.getText().toString();

                Intent startintent = new Intent(MainActivity.this , MainActivity2.class);
                startintent.putExtra("name" , namevalue);
                startActivity(startintent);
            }
        });

        btnPrint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                multiTable();
            }
        });
    }
    public void multiTable(){
        String numberInput = numberET.getText().toString();
        if (!numberInput.isEmpty()){
            int numbers = Integer.parseInt(numberInput);
            StringBuilder numberTable = new StringBuilder();
            for (int i=1; i<=10;i++){
                numberTable.append(numbers).append(" x ").append(i).append(" = ").append(numbers * i).append("\n");
            }
            tvTable.setText(numberTable.toString());
        }
    }
}