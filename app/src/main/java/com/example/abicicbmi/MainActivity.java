package com.example.abicicbmi;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myButtonListenerMethod();
    }

    public void myButtonListenerMethod() {
        Button button = findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText heightText = findViewById(R.id.height);
                String heightStr = heightText.getText().toString();
                double height = Double.parseDouble(heightStr);
                double heightM = height/100;
                final EditText weightText = findViewById(R.id.weight);
                String weightStr = weightText.getText().toString();
                double weight = Double.parseDouble(weightStr);
                double BMI = (weight) / (heightM * heightM);

                DecimalFormat df = new DecimalFormat("#.#");
                double BMI_zaokruzen = Double.parseDouble(df.format(BMI));
                final TextView BMIResult = findViewById(R.id.result);
                BMIResult.setText(Double.toString(BMI_zaokruzen));

                String Ispis;
                if (BMI < 15){
                    Ispis = "Znatna pothranjenost.";
                }
                else if (BMI >= 15 && BMI < 16){
                    Ispis = "Pothranjenost.";
                }
                else if (BMI >=16 && BMI < 18.5){
                    Ispis = "Malo ispod normalne zdrave težine.";
                }
                else if (BMI >=18.5 && BMI < 25){
                    Ispis = "Normalna zdrava težina.";
                }
                else if (BMI >= 25 && BMI < 30){
                    Ispis = "Malo iznad normalne zdrave težine.";
                }
                else if (BMI>=30 && BMI < 35 ){
                    Ispis = "Pretilost prve razine.";
                }
                else if (BMI>= 35 && BMI < 40){
                    Ispis = "Znatna pretilost";
                }
                else {
                    Ispis = "Iznimno pretjerana pretilost";

                }
                final TextView BMICategory = findViewById(R.id.bmiCat);
                BMICategory.setText(Ispis);
            }
        });
    }
}