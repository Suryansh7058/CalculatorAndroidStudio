package com.example.calcuator;

import org.mariuszgromada.math.mxparser.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

public class ArithmeticExpressionBuilder {
    /*
     *
     * Begin Declare Attributes
     *
     * */
    public String evalExpression = "";
    int openBracket = 0;
    /*
     *
     * End Declare Attributes
     *
     */


    /*
     *
     *
     * Begin Insert Operands(Numbers) && Insert Basic Operators
     *
     * */
    public String insertOperand(String expression, char number) {
        if (!expression.isEmpty() && (expression.charAt(expression.length() - 1) == 'π' || expression.charAt(expression.length() - 1) == 'e' || expression.charAt(expression.length() - 1) == ')')) {
            evalExpression += "*" + number;

        } else {
            evalExpression += number;
        }
        return expression + number;
    }

    public String insertOperator(String expression, char operator) {
        if (expression.isEmpty() || expression.charAt(expression.length() - 1) == '/' || expression.charAt(expression.length() - 1) == '*'
                || expression.charAt(expression.length() - 1) == '-' || expression.charAt(expression.length() - 1) == '+'
                || expression.charAt(expression.length() - 1) == '%' || expression.charAt(expression.length() - 1) == '(') {
            return expression;
        } else if (expression.charAt(expression.length() - 1) == '.') {
            evalExpression += '0' + operator;
            return expression + '0' + operator;
        }
        if (operator == '%') {
            evalExpression += "%*";
            return expression + operator;
        }
        evalExpression += operator;
        return expression + operator;
    }
    /*
     *
     *
     * End Insert Operands(Numbers) && Insert Basic Operators
     *
     * */


    /*
     *
     * Insert Constants Begin
     *
     * */
    public String insertPi(String expression) {
        if (!expression.isEmpty() && (Character.isDigit(expression.charAt(expression.length() - 1)) || expression.charAt(expression.length() - 1) == 'π'
                || expression.charAt(expression.length() - 1) == 'e' || expression.charAt(expression.length() - 1) == '!'
                || expression.charAt(expression.length() - 1) == '^' || expression.charAt(expression.length() - 1) == ')')) {
            expression += "π";
            evalExpression += "*pi";
            return expression;
        }
        evalExpression += "pi";
        return expression + "π";
    }

    public String insertEuler(String expression) {
        if (!expression.isEmpty() && (Character.isDigit(expression.charAt(expression.length() - 1)) || expression.charAt(expression.length() - 1) == 'π'
                || expression.charAt(expression.length() - 1) == 'e')) {
            expression += "e";
            evalExpression += "*e";
            return expression;
        }
        evalExpression += "e";
        return expression + "e";
    }
    /*
     *
     * Insert Constants Ends
     *
     * */


    /*
     *
     *
     * Insert Factorial Begin
     *
     * */
    public String insertFactorial(String expression) {
        if (expression.isEmpty() || expression.charAt(expression.length() - 1) == '/' || expression.charAt(expression.length() - 1) == '*'
                || expression.charAt(expression.length() - 1) == '-' || expression.charAt(expression.length() - 1) == '+'
                || expression.charAt(expression.length() - 1) == '%' || expression.charAt(expression.length() - 1) == '(' || expression.charAt(expression.length() - 1) == ')'
                || expression.charAt(expression.length() - 1) == 'π' || expression.charAt(expression.length() - 1) == 'e' || expression.charAt(expression.length() - 1) == '.') {

            return expression;
        }

        int i = expression.length() - 1;
        boolean decimal = false;
        while (i >= 0) {
            if (expression.charAt(i) == '.') {
                decimal = true;
                break;
            } else if (!Character.isDigit(expression.charAt(i)))
                break;
            else
                i--;
        }
        if (!decimal) {
            evalExpression += "!";
            return expression + "!";
        }
        return expression;
    }
    /*
     *
     * Insert Factorial End
     *
     * */


    /*
     *
     *
     * Insert Exponent Begin
     *
     * */
    public String insertExponent(String expression) {
        if (expression.isEmpty() || expression.charAt(expression.length() - 1) == '/' || expression.charAt(expression.length() - 1) == '*'
                || expression.charAt(expression.length() - 1) == '-' || expression.charAt(expression.length() - 1) == '+'
                || expression.charAt(expression.length() - 1) == '%'
                || expression.charAt(expression.length() - 1) == '(') {
            return expression;
        }
        evalExpression += "^";
        return expression + "^";
    }
    /*
     *
     *
     * Insert Exponent End
     *
     * */


    /*
     *
     *
     * Begin Decimal Insert
     *
     *
     * */
    public String insertDot(String expression) {

        if (expression.isEmpty() || expression.charAt(expression.length() - 1) == '/' || expression.charAt(expression.length() - 1) == '*' || expression.charAt(expression.length() - 1) == '-' || expression.charAt(expression.length() - 1) == '+' || expression.charAt(expression.length() - 1) == '%') {
            evalExpression += "0.";
            return expression + "0.";
        }

        for (int i = expression.length() - 1; i >= 0; i--) {
            if (expression.charAt(i) == '.')
                return expression;
            else if (expression.charAt(i) == '/' || expression.charAt(i) == '*' || expression.charAt(i) == '+' || expression.charAt(i) == '%' || expression.charAt(i) == '-')
                break;
        }
        evalExpression += ".";
        return expression + ".";
    }
    /*
     *
     *
     * Begin Decimal Insert
     *
     *
     * */

    /*
     *
     *
     * Begin Find if  a given string is number(decimal/scientific included)
     *
     *
     * */
    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
    /*
     *
     *
     * End Find if a given string is number(decimal/scientific included)
     *
     *
     * */


    /*
     *
     *
     * Begin Insert Brackets
     *
     *
     * */
    public String insertOpenBracket(String expression) {
        openBracket++;
        if (expression.isEmpty()) {
            evalExpression += "(";
            return expression + "(";
        } else if ((Character.isDigit(expression.charAt(expression.length() - 1)) || expression.charAt(expression.length() - 1) == 'π'
                || expression.charAt(expression.length() - 1) == 'e' || expression.charAt(expression.length() - 1) == '!' || expression.charAt(expression.length() - 1) == ')')) {
            evalExpression += "*(";
            return expression + "(";
        }
        evalExpression += "(";
        return expression + "(";
    }

    public String insertCloseBracket(String expression) {
        if ((openBracket == 0 && !expression.isEmpty()) || (!expression.isEmpty() && (expression.charAt(expression.length() - 1) == '(' || expression.charAt(expression.length() - 1) == '/' || expression.charAt(expression.length() - 1) == '*'
                || expression.charAt(expression.length() - 1) == '-' || expression.charAt(expression.length() - 1) == '+'
                || expression.charAt(expression.length() - 1) == '%'|| expression.charAt(expression.length() - 1) == '^')) ) {
            return expression;
        }
        openBracket--;
        evalExpression += ")";
        return expression + ")";

    }
    /*
     *
     *
     * Begin Insert Brackets
     *
     *
     * */



    /*
     *
     *
     * Begin                    T R I G O N O M E T R I C    F U N C T I O N S
     *
     *
     * */


    public String insertTrigono(String expression,String trigono){
        openBracket++;
        if (!expression.isEmpty()   &&   (Character.isDigit(expression.charAt(expression.length() - 1)) || expression.charAt(expression.length() - 1) == 'π'
                || expression.charAt(expression.length() - 1) == 'e' || expression.charAt(expression.length() - 1) == '!'
                || expression.charAt(expression.length() - 1) == ')')){
            evalExpression+="*"+trigono+"(";
            return expression+trigono+"(";
        }
        evalExpression += trigono+"(";
        return expression +trigono+"(";
    }
    /*
     *
     *
     * END                   T R I G O N O M E T R I C    F U N C T I O N S
     *
     *
     * */




    /*
     *
     *
     * Begin                    L O G A R A T H I M I C   F U N C T I O N S
     *
     *
     * */

    public String insertLog(String expression,String mode){
        openBracket++;
        if (!expression.isEmpty()   &&   (Character.isDigit(expression.charAt(expression.length() - 1)) || expression.charAt(expression.length() - 1) == 'π'
                || expression.charAt(expression.length() - 1) == 'e' || expression.charAt(expression.length() - 1) == '!'
                || expression.charAt(expression.length() - 1) == ')')){
            evalExpression+="*"+mode+"(";
            return expression+mode+"(";
        }
        evalExpression += mode+"(";
        return expression +mode+"(";
    }


    /*
     *
     *
     * END                   L O G A R A T H I M I C   F U N C T I O N S
     *
     *
     * */


    /*
     *
     *
     * Begin                   S Q U A R E - R O O T    F U N C T I O N
     *
     *
     * */

    public String insertSqrt(String expression) {
        openBracket++;
        if (!expression.isEmpty()   &&   (Character.isDigit(expression.charAt(expression.length() - 1)) || expression.charAt(expression.length() - 1) == 'π'
                || expression.charAt(expression.length() - 1) == 'e' || expression.charAt(expression.length() - 1) == '!'
                || expression.charAt(expression.length() - 1) == ')')){
            evalExpression+="*sqrt(";
            return expression+"*√(";
        }
        evalExpression += "sqrt(";
        return expression +"√(";
    }
    /*
     *
     *
     * END                  S Q U A R E - R O O T    F U N C T I O N
     *
     *
     * */






    /*
     *
     *
     *Begin Pop the last character
     *
     * */
    public String pop(String expression) {
        if (evalExpression.isEmpty())
        {
            return expression;
        }


        else if (evalExpression.length() > 1 && evalExpression.charAt(evalExpression.length() - 2) == '%')
        {
            evalExpression = evalExpression.substring(0, evalExpression.length() - 2);
            expression = expression.substring(0, expression.length() - 1);
        }

//      POP closeBracket
        else if (evalExpression.charAt(evalExpression.length() - 1) == ')')
        {
            openBracket++;
            evalExpression = evalExpression.substring(0, evalExpression.length() - 1);
            expression = expression.substring(0, expression.length() - 1);
        }
        //      POP Trigonometric functions
        else if(evalExpression.charAt(evalExpression.length() - 1) == '('
                && ((evalExpression.charAt(evalExpression.length() - 2) == 'n' && evalExpression.charAt(evalExpression.length() - 3 )== 'i') )
                || (evalExpression.charAt(evalExpression.length() - 2) == 's' && evalExpression.charAt(evalExpression.length() - 3 )== 'o' )
                || (evalExpression.charAt(evalExpression.length() - 2) == 'n' && evalExpression.charAt(evalExpression.length() - 3 )== 'a'))
        {
            openBracket--;
            evalExpression = evalExpression.substring(0, evalExpression.length() - 4);
            expression = expression.substring(0, expression.length() - 4);
        }

//      POP ln
        else if(evalExpression.charAt(evalExpression.length() - 1) == '(' && (evalExpression.charAt(evalExpression.length() - 3) == 'l'
                && evalExpression.charAt(evalExpression.length() - 2) == 'n'))
        {
            openBracket--;
            evalExpression = evalExpression.substring(0, evalExpression.length() - 3);
            expression = expression.substring(0, expression.length() - 3);
        }

//        POP Square Root
        else if(evalExpression.charAt(evalExpression.length() - 1) == '(' && (evalExpression.charAt(evalExpression.length() - 5) == 's'
                && evalExpression.charAt(evalExpression.length() - 2) == 't'))
        {
            openBracket--;
            evalExpression = evalExpression.substring(0, evalExpression.length() - 5);
            expression = expression.substring(0, expression.length() - 2);
        }

//      POP log10
        else if(evalExpression.charAt(evalExpression.length() - 1) == '(' && evalExpression.charAt(evalExpression.length() - 6) == 'l'
                    && evalExpression.charAt(evalExpression.length()-5) == 'o')
        {
            openBracket--;
            evalExpression = evalExpression.substring(0, evalExpression.length() - 6);
            expression = expression.substring(0, expression.length() - 6);
        }




        else if (evalExpression.charAt(evalExpression.length() - 1) == '(')
        {
            openBracket--;
            evalExpression = evalExpression.substring(0, evalExpression.length() - 1);
            expression = expression.substring(0, expression.length() - 1);
        }


        else
        {
            evalExpression = evalExpression.substring(0, evalExpression.length() - 1);
            expression = expression.substring(0, expression.length() - 1);
        }
        return expression;
    }

    /*
    *
    *
    * Begin Set Calculator Mode
    *
    * */

    public void setCalcMode(String mode){
        if(mode.equals("DEG")){
            mXparser.setDegreesMode();
        }
        else if(mode.equals("RAD")){
            mXparser.setRadiansMode();
        }
    }


    /*
     *
     *
     * Begin Set Calculator Mode
     *
     * */



    /*
     *
     *
     *Begin Pop the last character
     *
     *
     * */


    /*
     *
     *
     *Begin Execution and Evaluation of expression
     *
     *
     * */
    public String evaluateExpression() {

        char[] repeat = new char[openBracket];
        Arrays.fill(repeat, ')');
        evalExpression += new String(repeat);
        openBracket = 0;
        Expression e = new Expression(evalExpression);
        double res = e.calculate();
        if (Double.isNaN(res)) {
            return "Invalid Expression";
        } else if (Double.isInfinite(res)) {
            return "Infinity";
        } else if (res > 1E12) {
            evalExpression = Double.toString(res);
            return evalExpression;
        } else if (res == Math.round(res)) {
            evalExpression = BigDecimal.valueOf(Math.round(res)).toPlainString();
            return evalExpression;
        }
        evalExpression = BigDecimal.valueOf(res).toPlainString();
        if (evalExpression.length() - evalExpression.indexOf('.') - 1 <= 7) {
            return evalExpression;
        }
        evalExpression = BigDecimal.valueOf(res).setScale(8, RoundingMode.HALF_UP).stripTrailingZeros().toPlainString();
        return evalExpression;
    }


    /*
     *
     *
     *End Execution and Evaluation of expression
     *
     *
     * */


}
