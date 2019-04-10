package com.example.bodymassindex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private Button btn1;
    private EditText txt_height,txt_weight;
    private TextView txt_output;
    private static DecimalFormat df2 = new DecimalFormat(".##");

    public boolean validate(){
        boolean checkvalidate=true;
        if (TextUtils.isEmpty(txt_height.getText().toString())) {
            txt_height.setError("Height is required");
            txt_height.requestFocus();
            checkvalidate = false;

        }
        if (TextUtils.isEmpty(txt_weight.getText().toString())) {
            txt_weight.setError("Weight is required");
            txt_weight.requestFocus();
            checkvalidate = false;

        }

        return  checkvalidate;
    }





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt_height=findViewById(R.id.txt_height);
        txt_weight=findViewById(R.id.txt_weight);
        txt_output=findViewById(R.id.txt_output);
        btn1=findViewById(R.id.btn1);

        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(validate()) {
                    float height = Float.parseFloat(txt_height.getText().toString());
                    float weight = Float.parseFloat(txt_weight.getText().toString());

                    Calculation calc = new Calculation();
                    calc.setHeight(height);
                    calc.setWeight(weight);
                    double valueout = calc.calculate_bmi();
                    if (valueout < 18.5) {
                        Toast.makeText(MainActivity.this, "UnderWeight", Toast.LENGTH_SHORT).show();
                    } else if (valueout >= 18.5 && valueout <= 24.9) {
                        Toast.makeText(MainActivity.this, "Normal Weight", Toast.LENGTH_SHORT).show();
                    } else if (valueout >= 25 && valueout <= 29.9) {
                        Toast.makeText(MainActivity.this, "Over Weight", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity.this, "Obesity", Toast.LENGTH_SHORT).show();
                    }


                    txt_output.setText("Your BMI Is " + df2.format(valueout));

                }



            }
        });


    }
}
