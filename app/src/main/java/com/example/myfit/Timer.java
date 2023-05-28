
package com.example.myfit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myfit.R;

import org.w3c.dom.Text;

public class Timer extends AppCompatActivity {

    private EditText bmiweight,bmifeet;
    private TextView bmiresult,bmiverdict;
    Button btncalculate;
    double weight;
    int feet,inches;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);
        weight=0;
        feet=0;
        bmiweight=findViewById(R.id.bmiweight);
        bmifeet=findViewById(R.id.bmifeet);
        bmiresult=findViewById(R.id.bmiresult);
        btncalculate=findViewById(R.id.calbutton);
        bmiverdict=findViewById(R.id.bmiverdict);
        btncalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String weight_text=bmiweight.getText().toString();
                String feet_text=bmifeet.getText().toString();

                if(weight_text.equals("")) {
                    bmiweight.setError("Can't be Empty");
                }
                else {
                    weight = Double.parseDouble(weight_text);

                }
                if(feet_text.equals("")){
                    bmifeet.setError("Can't be Empty");

                }
                else{
                    feet = Integer.parseInt(feet_text);

                }

                double heightInMeters = feet / 100.0; // Convert height from centimeters to meters
                double bmi = weight / (heightInMeters * heightInMeters);

                bmiresult.setText("Your BMI: " + String.format("%.2f", bmi));

                Toast.makeText(Timer.this, "BMI Calculated", Toast.LENGTH_SHORT).show();

                if (bmi < 18.5) {
                    bmiverdict.setText("You are Underweight");
                } else if (bmi >= 18.5 && bmi < 25.0) {
                    bmiverdict.setText("You are Normal weight");
                } else if (bmi >= 25.0 && bmi < 30.0) {
                    bmiverdict.setText("You are Overweight");
                } else if (bmi >= 30.0) {
                    bmiverdict.setText("You are Obese");
                }
            }
        });

    }
}