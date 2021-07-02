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

public class advanced_operation_fragment extends Fragment {
    EditText arithmeticExpression;
    TextView display_result;
    TextView calcMode;
    ArithmeticExpressionBuilder expression;
    boolean equalClicked;

    public advanced_operation_fragment() {
        //Required Empty Fragment
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.advanced_operation_fragment_guidelines, container, false);


        arithmeticExpression = requireActivity().findViewById(R.id.expressionString);

        display_result = requireActivity().findViewById(R.id.displayResult);
        expression = new ArithmeticExpressionBuilder();// object of builder + evaluator class(ArithmeticExpressionBuilder)

        Bundle mainBundle = this.getArguments();
        if (mainBundle != null){
            expression.evalExpression = mainBundle.getString("key");
            expression.openBracket = mainBundle.getInt("openBrackets");
        }

        calcMode = requireActivity().findViewById(R.id.calcMode);
        expression.setCalcMode("DEG");

        AppCompatButton func_to_Main = view.findViewById(R.id.func_to_main);


        //Switch back to main fragment
        func_to_Main.setOnClickListener(v -> {

            Bundle bundle = new Bundle();
            bundle.putString("key", expression.evalExpression);
            bundle.putInt("openBrackets",expression.openBracket);

            fragment_main fragMain = new fragment_main();
            fragMain.setArguments(bundle);


            FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
            fragmentTransaction.setCustomAnimations(R.anim.from_left, R.anim.exit_to_right, R.anim.from_left, R.anim.exit_to_right);
            fragmentTransaction.replace(R.id.frameLayout_keys, fragMain);
            fragmentTransaction.commit();
        });

        //Start
        //Create Basic Operation Button
        AppCompatButton sevenAdv = view.findViewById(R.id.sevenAdv);
        AppCompatButton eightAdv = view.findViewById(R.id.eightAdv);
        AppCompatButton nineAdv = view.findViewById(R.id.nineAdv);
        AppCompatButton fourAdv = view.findViewById(R.id.fourAdv);
        AppCompatButton fiveAdv = view.findViewById(R.id.fiveAdv);
        AppCompatButton sixAdv = view.findViewById(R.id.sixAdv);
        AppCompatButton oneAdv = view.findViewById(R.id.oneAdv);
        AppCompatButton twoAdv = view.findViewById(R.id.twoAdv);
        AppCompatButton threeAdv = view.findViewById(R.id.threeAdv);
        AppCompatButton zeroAdv = view.findViewById(R.id.zeroAdv);
        AppCompatButton clearAdv = view.findViewById(R.id.clearAdv);
        AppCompatButton delAdv = view.findViewById(R.id.delAdv);
        AppCompatButton divideAdv = view.findViewById(R.id.divide_adv);
        AppCompatButton multiplyAdv = view.findViewById(R.id.multiply_adv);
        AppCompatButton minusAdv = view.findViewById(R.id.minus_adv);
        AppCompatButton addAdv = view.findViewById(R.id.add_adv);
        AppCompatButton percentAdv = view.findViewById(R.id.percentAdv);
        AppCompatButton decimalAdv = view.findViewById(R.id.decimalAdv);
        AppCompatButton equalAdv = view.findViewById(R.id.equal_adv);

        //End

        sevenAdv.setOnClickListener(v -> {
            colorChangeDelay(sevenAdv);
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
        eightAdv.setOnClickListener(v -> {
            colorChangeDelay(eightAdv);
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
        nineAdv.setOnClickListener(v -> {
            colorChangeDelay(nineAdv);
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
        fourAdv.setOnClickListener(v -> {
            colorChangeDelay(fourAdv);
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
        fiveAdv.setOnClickListener(v -> {
            colorChangeDelay(fiveAdv);
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
        sixAdv.setOnClickListener(v -> {
            colorChangeDelay(sixAdv);
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
        oneAdv.setOnClickListener(v -> {
            colorChangeDelay(oneAdv);
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
        twoAdv.setOnClickListener(v -> {
            colorChangeDelay(twoAdv);
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
        threeAdv.setOnClickListener(v -> {
            colorChangeDelay(threeAdv);
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
        zeroAdv.setOnClickListener(v -> {
            colorChangeDelay(zeroAdv);
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
        clearAdv.setOnClickListener(v -> {
            colorChangeDelay(clearAdv);
            reConfigResultPanel();
            if (equalClicked) {
                equalClicked = false;
            }
            cleanSlate();

            arithmeticExpression.setSelection(arithmeticExpression.getText().length());

        });
        delAdv.setOnClickListener(v -> {
            colorChangeDelay(delAdv);
            String exp = arithmeticExpression.getText().toString();
            if (equalClicked) {
                equalClicked = false;
            }
            display_result.setText("");
            if (arithmeticExpression.getCurrentTextColor() == Color.RED) {
                arithmeticExpression.setTextColor(Color.WHITE);
                arithmeticExpression.setTextSize(48);
                cleanSlate();
            } else if (exp.isEmpty()) {
                return;
            } else {
                exp = expression.pop(exp);
                setResultPanel(exp);
            }
        });
        divideAdv.setOnClickListener(v -> {
            colorChangeDelayOperators(divideAdv);
            reConfigResultPanel();
            if (equalClicked) {
                equalClicked = false;
            }
            String exp;
            exp = arithmeticExpression.getText().toString();
            exp = expression.insertOperator(exp, '/');

            setResultPanel(exp);
        });
        multiplyAdv.setOnClickListener(v -> {
            colorChangeDelayOperators(multiplyAdv);
            reConfigResultPanel();
            if (equalClicked) {
                equalClicked = false;
            }
            String exp;
            exp = arithmeticExpression.getText().toString();
            exp = expression.insertOperator(exp, '*');

            setResultPanel(exp);
        });
        addAdv.setOnClickListener(v -> {
            colorChangeDelayOperators(addAdv);
            reConfigResultPanel();
            if (equalClicked) {
                equalClicked = false;
            }
            String exp;
            exp = arithmeticExpression.getText().toString();
            exp = expression.insertOperator(exp, '+');

            setResultPanel(exp);
        });
        minusAdv.setOnClickListener(v -> {
            colorChangeDelayOperators(minusAdv);
            reConfigResultPanel();
            if (equalClicked) {
                equalClicked = false;
            }
            String exp;
            exp = arithmeticExpression.getText().toString();
            exp = expression.insertOperator(exp, '-');

            setResultPanel(exp);
        });
        percentAdv.setOnClickListener(v -> {
            colorChangeDelay(percentAdv);
            reConfigResultPanel();
            if (equalClicked) {
                equalClicked = false;
            }
            String exp;
            exp = arithmeticExpression.getText().toString();
            exp = expression.insertOperator(exp, '%');

            setResultPanel(exp);
        });
        decimalAdv.setOnClickListener(v -> {
            colorChangeDelay(decimalAdv);
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
        equalAdv.setOnClickListener(v -> {
            colorChangeDelay(equalAdv);
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
        //Start
        //Initialize advanced calculation button
        AppCompatButton cosButton = view.findViewById(R.id.cosButton);
        AppCompatButton sinButton = view.findViewById(R.id.sinButton);
        AppCompatButton tanButton = view.findViewById(R.id.tanButton);
        AppCompatButton logButton = view.findViewById(R.id.logButton);
        AppCompatButton openBracket = view.findViewById(R.id.openBracketButton);
        AppCompatButton closeBracket = view.findViewById(R.id.closeBracketButton);
        AppCompatButton sqrtButton = view.findViewById(R.id.sqrtButton);
        AppCompatButton lnButton = view.findViewById(R.id.lnButton);
        AppCompatButton piButton = view.findViewById(R.id.pi_advance);
        AppCompatButton eButton = view.findViewById(R.id.e_adv);
        AppCompatButton factorialButton = view.findViewById(R.id.factorial_adv);
        AppCompatButton power_adv = view.findViewById(R.id.power_adv);
        AppCompatButton radian = view.findViewById(R.id.radianButton);
        AppCompatButton degree = view.findViewById(R.id.degreeButton);

        //End


        //Start
        //implement advanced calculation Function

        radian.setOnClickListener(v -> {
            colorChangeDelay(radian);
            calcMode.setText(getString(R.string.rad));
            String mode = "RAD";
            expression.setCalcMode(mode);

        });

        degree.setOnClickListener(v -> {
            colorChangeDelay(degree);
            calcMode.setText(getString(R.string.deg));
            String mode = "DEG";
            expression.setCalcMode(mode);
        });


        piButton.setOnClickListener(v -> {
            colorChangeDelay(piButton);
            reConfigResultPanel();
            if (equalClicked) {
                cleanSlate();
                equalClicked = false;
            }
            String exp;
            exp = arithmeticExpression.getText().toString();
            exp = expression.insertPi(exp);
            setResultPanel(exp);

        });

        eButton.setOnClickListener(v -> {
            colorChangeDelay(eButton);
            reConfigResultPanel();
            if (equalClicked) {
                cleanSlate();
                equalClicked = false;
            }
            String exp;
            exp = arithmeticExpression.getText().toString();
            exp = expression.insertEuler(exp);

            setResultPanel(exp);
        });

        factorialButton.setOnClickListener(v -> {
            colorChangeDelay(factorialButton);
            reConfigResultPanel();
            if (equalClicked) {
                cleanSlate();
                equalClicked = false;
            }
            String exp;
            exp = arithmeticExpression.getText().toString();
            exp = expression.insertFactorial(exp);

            setResultPanel(exp);
        });

        power_adv.setOnClickListener(v -> {
            colorChangeDelay(power_adv);
            reConfigResultPanel();
            if (equalClicked) {
                cleanSlate();
                equalClicked = false;
            }
            String exp;
            exp = arithmeticExpression.getText().toString();
            exp = expression.insertExponent(exp);

            setResultPanel(exp);
        });

        openBracket.setOnClickListener(v -> {
            colorChangeDelay(openBracket);
            reConfigResultPanel();
            if (equalClicked) {
                cleanSlate();
                equalClicked = false;
            }
            String exp;
            exp = arithmeticExpression.getText().toString();
            exp = expression.insertOpenBracket(exp);
            setResultPanel(exp);

        });

        closeBracket.setOnClickListener(v -> {
            colorChangeDelay(closeBracket);
            reConfigResultPanel();
            if (equalClicked) {
                cleanSlate();
                equalClicked = false;
            }
            String exp;
            exp = arithmeticExpression.getText().toString();
            exp = expression.insertCloseBracket(exp);
            setResultPanel(exp);
        });


        sinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                colorChangeDelay(sinButton);
                reConfigResultPanel();
                if (equalClicked) {
                    cleanSlate();
                    equalClicked = false;
                }
                String exp;
                exp = arithmeticExpression.getText().toString();
                exp = expression.insertTrigono(exp, "sin");
                setResultPanel(exp);
            }
        });

        cosButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                colorChangeDelay(cosButton);
                reConfigResultPanel();
                if (equalClicked) {
                    cleanSlate();
                    equalClicked = false;
                }
                String exp;
                exp = arithmeticExpression.getText().toString();
                exp = expression.insertTrigono(exp, "cos");
                setResultPanel(exp);
            }
        });

        tanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                colorChangeDelay(tanButton);
                reConfigResultPanel();
                if (equalClicked) {
                    cleanSlate();
                    equalClicked = false;
                }
                String exp;
                exp = arithmeticExpression.getText().toString();
                exp = expression.insertTrigono(exp, "tan");
                setResultPanel(exp);
            }
        });

        lnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                colorChangeDelay(lnButton);
                reConfigResultPanel();
                if (equalClicked) {
                    cleanSlate();
                    equalClicked = false;
                }
                String exp;
                exp = arithmeticExpression.getText().toString();
                exp = expression.insertLog(exp, "ln");
                setResultPanel(exp);
            }
        });

        logButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                colorChangeDelay(logButton);
                reConfigResultPanel();
                if (equalClicked) {
                    cleanSlate();
                    equalClicked = false;
                }
                String exp;
                exp = arithmeticExpression.getText().toString();
                exp = expression.insertLog(exp, "log10");
                setResultPanel(exp);
            }
        });

        sqrtButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                colorChangeDelay(sqrtButton);
                reConfigResultPanel();
                if (equalClicked) {
                    cleanSlate();
                    equalClicked = false;
                }
                String exp;
                exp = arithmeticExpression.getText().toString();
                exp = expression.insertSqrt(exp);
                setResultPanel(exp);
            }
        });

        //End
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

    public void setResultPanel(String exp) {
        arithmeticExpression.setText(exp);
        arithmeticExpression.setSelection(arithmeticExpression.getText().length());
    }

    public void cleanSlate() {
        arithmeticExpression.setText("");
        display_result.setText("");
        expression.evalExpression = "";
        expression.openBracket = 0;
    }

    public void colorChangeDelay(Button btn) {
        btn.setTextColor(Color.YELLOW);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                btn.setTextColor(Color.WHITE);
            }
        }, 150);
    }

    public void colorChangeDelayOperators(Button btn) {
        btn.setTextColor(Color.WHITE);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                btn.setTextColor(Color.YELLOW);
            }
        }, 150);
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