package com.example.calcuator;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class fragment_main extends Fragment {
    EditText arithmeticExpression;
    TextView display_result;
    ArithmeticExpressionBuilder expression;
    boolean equalClicked;

    public fragment_main() {
        //Required Empty Fragment
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main, container, false);


        TextView calcMode = requireActivity().findViewById(R.id.calcMode);
        calcMode.setText("");

        arithmeticExpression = requireActivity().findViewById(R.id.expressionString);
        display_result = requireActivity().findViewById(R.id.displayResult);
        expression = new ArithmeticExpressionBuilder();// object of builder + evaluator class(ArithmeticExpressionBuilder)


        Bundle bundle = this.getArguments();
        if (bundle != null){
            expression.evalExpression = bundle.getString("key");
            expression.openBracket = bundle.getInt("openBrackets");
        }
        AppCompatButton func_to_Adv = view.findViewById(R.id.func_to_adv);

        func_to_Adv.setOnClickListener(v -> {
            Bundle mainBundle = new Bundle();
            mainBundle.putString("key", expression.evalExpression);
            mainBundle.putInt("openBrackets",expression.openBracket);
            advanced_operation_fragment fragAdv = new advanced_operation_fragment();
            fragAdv.setArguments(mainBundle);


            calcMode.setText(getString(R.string.deg));
            FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
            fragmentTransaction.setCustomAnimations(R.anim.from_left, R.anim.exit_to_right, R.anim.from_left, R.anim.exit_to_right);
            fragmentTransaction.replace(R.id.frameLayout_keys, fragAdv);
            fragmentTransaction.commit();
        });




        AppCompatButton seven_Main = view.findViewById(R.id.sevenMain);
        AppCompatButton eight_Main = view.findViewById(R.id.eightMain);
        AppCompatButton nine_Main = view.findViewById(R.id.nineMain);
        AppCompatButton four_Main = view.findViewById(R.id.fourMain);
        AppCompatButton five_Main = view.findViewById(R.id.fiveMain);
        AppCompatButton six_Main = view.findViewById(R.id.sixMain);
        AppCompatButton one_Main = view.findViewById(R.id.oneMain);
        AppCompatButton two_Main = view.findViewById(R.id.twoMain);
        AppCompatButton three_Main = view.findViewById(R.id.threemain);
        AppCompatButton zero_Main = view.findViewById(R.id.zeroMain);
        AppCompatButton clear_Main = view.findViewById(R.id.clearMain);
        AppCompatButton del_Main = view.findViewById(R.id.delMain);
        AppCompatButton divide_Main = view.findViewById(R.id.divideMain);
        AppCompatButton multiply_Main = view.findViewById(R.id.multiplyMain);
        AppCompatButton minus_Main = view.findViewById(R.id.minusMain);
        AppCompatButton add_Main = view.findViewById(R.id.addMain);
        AppCompatButton percent_Main = view.findViewById(R.id.percentMain);
        AppCompatButton decimal_main = view.findViewById(R.id.decimalMain);
        AppCompatButton equal_Main = view.findViewById(R.id.equalMain);

        seven_Main.setOnClickListener(v -> {
            colorChangeDelay(seven_Main);
            reConfigResultPanel();
            if (equalClicked) {
                cleanSlate();
                equalClicked = false;
            }
            String exp;
            exp = arithmeticExpression.getText().toString();
            exp = expression.insertOperand(exp, '7');
            setResultPanel(exp);
        });
        eight_Main.setOnClickListener(v -> {
            colorChangeDelay(eight_Main);
            reConfigResultPanel();
            if (equalClicked) {
                cleanSlate();
                equalClicked = false;
            }
            String exp;
            exp = arithmeticExpression.getText().toString();
            exp = expression.insertOperand(exp, '8');
            setResultPanel(exp);
        });
        nine_Main.setOnClickListener(v -> {
            colorChangeDelay(nine_Main);
            reConfigResultPanel();
            if (equalClicked) {
                cleanSlate();
                equalClicked = false;
            }
            String exp;
            exp = arithmeticExpression.getText().toString();
            exp = expression.insertOperand(exp, '9');
            setResultPanel(exp);
        });
        four_Main.setOnClickListener(v -> {
            colorChangeDelay(four_Main);
            reConfigResultPanel();
            if (equalClicked) {
                cleanSlate();
                equalClicked = false;
            }
            String exp;
            exp = arithmeticExpression.getText().toString();
            exp = expression.insertOperand(exp, '4');
            setResultPanel(exp);
        });
        five_Main.setOnClickListener(v -> {
            colorChangeDelay(five_Main);
            reConfigResultPanel();
            if (equalClicked) {
                cleanSlate();
                equalClicked = false;
            }
            String exp;
            exp = arithmeticExpression.getText().toString();
            exp = expression.insertOperand(exp, '5');
            setResultPanel(exp);
        });
        six_Main.setOnClickListener(v -> {
            colorChangeDelay(six_Main);
            reConfigResultPanel();
            if (equalClicked) {
                cleanSlate();
                equalClicked = false;
            }
            String exp;
            exp = arithmeticExpression.getText().toString();
            exp = expression.insertOperand(exp, '6');
            setResultPanel(exp);
        });
        one_Main.setOnClickListener(v -> {
            colorChangeDelay(one_Main);
            reConfigResultPanel();
            if (equalClicked) {
                cleanSlate();
                equalClicked = false;
            }
            String exp;
            exp = arithmeticExpression.getText().toString();
            exp = expression.insertOperand(exp, '1');
            setResultPanel(exp);
        });
        two_Main.setOnClickListener(v -> {
            colorChangeDelay(two_Main);
            reConfigResultPanel();
            if (equalClicked) {
                cleanSlate();
                equalClicked = false;
            }
            String exp;
            exp = arithmeticExpression.getText().toString();
            exp = expression.insertOperand(exp, '2');
            setResultPanel(exp);
        });
        three_Main.setOnClickListener(v -> {
            colorChangeDelay(three_Main);
            reConfigResultPanel();
            if (equalClicked) {
                cleanSlate();
                equalClicked = false;
            }
            String exp;
            exp = arithmeticExpression.getText().toString();
            exp = expression.insertOperand(exp, '3');
            setResultPanel(exp);
        });
        zero_Main.setOnClickListener(v -> {
            colorChangeDelay(zero_Main);
            reConfigResultPanel();
            if (equalClicked) {
                cleanSlate();
                equalClicked = false;
            }
            String exp;
            exp = arithmeticExpression.getText().toString();
            exp = expression.insertOperand(exp, '0');
            setResultPanel(exp);
        });
        clear_Main.setOnClickListener(v -> {
            colorChangeDelay(clear_Main);
            reConfigResultPanel();
            if (equalClicked) {
                equalClicked = false;
            }
            arithmeticExpression.setText("");
            expression.evalExpression = "";
            display_result.setText("");
            arithmeticExpression.setSelection(arithmeticExpression.getText().length());

        });
        del_Main.setOnClickListener(v -> {
            colorChangeDelay(del_Main);
            String exp = arithmeticExpression.getText().toString();
            reConfigResultPanel();
            if (equalClicked) {
                equalClicked = false;
            } else if (exp.isEmpty()) {
            } else {
                exp = expression.pop(exp);
                setResultPanel(exp);
            }
        });
        divide_Main.setOnClickListener(v -> {
            colorChangeDelay(divide_Main);
            reConfigResultPanel();
            if (equalClicked) {
                equalClicked = false;
            }
            String exp;
            exp = arithmeticExpression.getText().toString();
            exp = expression.insertOperator(exp, '/');
            setResultPanel(exp);
        });
        multiply_Main.setOnClickListener(v -> {
            colorChangeDelay(multiply_Main);
            reConfigResultPanel();
            if (equalClicked) {
                equalClicked = false;
            }
            String exp;
            exp = arithmeticExpression.getText().toString();
            exp = expression.insertOperator(exp, '*');
            setResultPanel(exp);
        });
        add_Main.setOnClickListener(v -> {
            colorChangeDelay(add_Main);
            reConfigResultPanel();
            if (equalClicked) {
                equalClicked = false;
            }
            String exp;
            exp = arithmeticExpression.getText().toString();
            exp = expression.insertOperator(exp, '+');
            setResultPanel(exp);
        });
        minus_Main.setOnClickListener(v -> {
            colorChangeDelay(minus_Main);
            reConfigResultPanel();
            if (equalClicked) {
                equalClicked = false;
            }
            String exp;
            exp = arithmeticExpression.getText().toString();
            exp = expression.insertOperator(exp, '-');
            setResultPanel(exp);
        });
        percent_Main.setOnClickListener(v -> {
            colorChangeDelay(percent_Main);
            reConfigResultPanel();
            if (equalClicked) {
                equalClicked = false;
            }
            String exp;
            exp = arithmeticExpression.getText().toString();
            exp = expression.insertOperator(exp, '%');
            setResultPanel(exp);
        });
        decimal_main.setOnClickListener(v -> {
            colorChangeDelay(decimal_main);
            reConfigResultPanel();
            if (equalClicked) {
                cleanSlate();
                equalClicked = false;
            }
            String exp;
            exp = arithmeticExpression.getText().toString();
            exp = expression.insertDot(exp);
            setResultPanel(exp);
        });
        equal_Main.setOnClickListener(v -> {
            colorChangeDelay(equal_Main);
            if (ArithmeticExpressionBuilder.isNumeric(arithmeticExpression.getText().toString()) || arithmeticExpression.getText().toString().isEmpty()) {
                return;
            }
            if (arithmeticExpression.getCurrentTextColor() == Color.RED) {
                arithmeticExpression.setTextColor(Color.WHITE);
                arithmeticExpression.setTextSize(48);
                cleanSlate();
                return;
            }
            String exp = expression.evaluateExpression();
            if (exp.equals("Invalid Expression") || exp.equals("Infinity")) {
                arithmeticExpression.setTextColor(Color.RED);
                arithmeticExpression.setTextSize(24);
            }
            String displayExp = arithmeticExpression.getText().toString();
            display_result.setText(displayExp);
            adjustDisplayResult();
            setResultPanel(exp);
            equalClicked = true;
        });


        return view;
    }

    public void reConfigResultPanel() {
        display_result.setText("");
        if (arithmeticExpression.getCurrentTextColor() == Color.RED) {
            arithmeticExpression.setTextColor(Color.WHITE);
            arithmeticExpression.setTextSize(48);
            arithmeticExpression.setText("");
            expression.evalExpression = "";
        }
    }

    public void cleanSlate() {
        arithmeticExpression.setText("");
        display_result.setText("");
        expression.evalExpression = "";
    }

    public void setResultPanel(String exp) {
        arithmeticExpression.setText(exp);
        arithmeticExpression.setSelection(arithmeticExpression.getText().length());
    }

    public void colorChangeDelay(Button btn) {
        btn.setTextColor(Color.YELLOW);
        new Handler().postDelayed(() -> btn.setTextColor(Color.WHITE), 150);
        /*new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                btn.setTextColor(Color.WHITE);
            }
        },150);*/
    }
    public void adjustDisplayResult(){
        int length = display_result.getText().toString().length();
        if (length < 12)
            display_result.setTextSize(48);
        else if (length > 12 && length < 20)
            display_result.setTextSize(30);
        else if (length > 20)
            display_result.setTextSize(18);
    }

}