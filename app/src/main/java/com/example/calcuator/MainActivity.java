package com.example.calcuator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.text.method.ScrollingMovementMethod;
import android.widget.EditText;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {
    EditText arithmeticExpression;
    TextView display_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        arithmeticExpression = findViewById(R.id.expressionString);
        arithmeticExpression.setClickable(true);
        arithmeticExpression.setFocusable(false);
        arithmeticExpression.setInputType(InputType.TYPE_NULL);
        if (savedInstanceState == null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.frameLayout_keys, new fragment_main());
            fragmentTransaction.commit();
        }

        arithmeticExpression.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int length = arithmeticExpression.getText().toString().length();
                if (length < 12)
                    arithmeticExpression.setTextSize(48);
                else if (length > 12 && length < 20)
                    arithmeticExpression.setTextSize(30);
                else if (length > 20)
                    arithmeticExpression.setTextSize(18);
            }
        });
        display_result = findViewById(R.id.displayResult);
        display_result.setSelected(true);
    }

}