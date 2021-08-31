package io.rajshah.inclass02;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String Tag ="MainActivity";
    EditText textTicketPrice;
    RadioGroup discountRadioGroup;
    double discountedPrice=0.95;
    TextView finalPrice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        discountRadioGroup= findViewById(R.id.discountRadioGroup);
        discountRadioGroup.setOnCheckedChangeListener((radioGroup, checkedId) -> {
            if(checkedId == R.id.radioButton){
                discountedPrice=  0.95;
            }else if(checkedId == R.id.radioButton2){
                discountedPrice=  0.90;
            }else if(checkedId == R.id.radioButton3){
                discountedPrice= 0.85;
            }else if(checkedId == R.id.radioButton4){
                discountedPrice= 0.80;
            }
            else if(checkedId == R.id.radioButton5){
                discountedPrice= 0.50;
            }
            Log.d(Tag, "Application Inclass02 - discountedPrice is  "+discountedPrice);
        });
    }
    public void calculatePrice(View view){
        Log.d(Tag, "Application Inclass02 - Calculate Button Clicked ! (START) ");
        textTicketPrice = findViewById(R.id.TextTicketPrice);
        finalPrice=findViewById(R.id.finalPrice);
        if(textTicketPrice.getText().toString().matches("")){
            Toast.makeText(this, "Please Enter Valid Price :", Toast.LENGTH_SHORT).show();
            return;
        }
        int price=Integer.parseInt(textTicketPrice.getText().toString());
        finalPrice.setText(String.valueOf(price*discountedPrice));
        Log.d(Tag, "Application DemoApp - Send Button Clicked ! (END) ");
    }



    public void clearField(View view){
        textTicketPrice = findViewById(R.id.TextTicketPrice);
        textTicketPrice.setText("");
        discountRadioGroup= findViewById(R.id.discountRadioGroup);
        RadioButton fivePercent=findViewById(R.id.radioButton);
        fivePercent.setChecked(true);
        finalPrice=findViewById(R.id.finalPrice);
        finalPrice.setText("");
    }
    public void hideKeyboard(View view) {
        InputMethodManager inputMethodManager =(InputMethodManager)getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}