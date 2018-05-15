package edu.uci.hai.testapp2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private EditText weightET;
    private EditText heightFtET;
    private EditText heightInET;
    private TextView bmiValView;
    private TextView bmiCatView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        weightET = findViewById(R.id.weight);
        heightFtET = findViewById(R.id.height_ft);
        heightInET = findViewById(R.id.height_in);
        bmiValView = findViewById(R.id.bmi_val);
        bmiCatView = findViewById(R.id.bmi_cat);
        
        weightET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                calculateBMI();

            }
        });

        heightFtET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                calculateBMI();
            }
        });

        heightInET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                calculateBMI();
            }
        });
    }


    /*
    * This function calculate the bmi value
    * */
    public void calculateBMI() {
        String weightStr = weightET.getText().toString();
        String heightFtStr = heightFtET.getText().toString();
        String heightInStr = heightInET.getText().toString();

        if (weightStr != null && !"".equals(weightStr)
                && heightFtStr != null && !"".equals(heightFtStr)
                && heightInStr != null && !"".equals(heightInStr)) {

            float weightVal = Float.parseFloat(weightStr);
            int heightFtVal = Integer.parseInt(heightFtStr);
            int heightInVal = Integer.parseInt(heightInStr);

            int heightVal = heightFtVal * 12 + heightInVal;
            float bmiVal = (weightVal / (heightVal * heightVal)) * 703;
            double bmiValRoundOff = Math.round(bmiVal * 10.0) / 10.0;

            displayBMI(bmiValRoundOff);
        }
    }


    /*
    * This function display the bmi value and bmi category on the screen
    * */
    private void displayBMI(double bmiVal) {
        String bmiCat = "";

        if (Double.compare(bmiVal, 18.5) <= 0) {
            bmiCat = "Underweight BMI";
        } else if (Double.compare(bmiVal, 18.5) > 0 && Double.compare(bmiVal, 25) <= 0) {
            bmiCat = "Normal BMI";
        } else if (Double.compare(bmiVal, 25) > 0 && Double.compare(bmiVal, 30) <= 0) {
            bmiCat = "Overweight BMI";
        } else if (Double.compare(bmiVal, 30) > 0) {
            bmiCat = "Obese BMI";
        }

        bmiCatView.setText(bmiCat);

        String bmiValStr = Double.toString(bmiVal);

        bmiValView.setText(bmiValStr);
    }

}
