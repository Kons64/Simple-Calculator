package edu.msu.huangm18.SimpleCalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Calculator calculator;

    private TextView display;

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_main);
        calculator = new Calculator();
        if(bundle != null) {
            calculator.loadInstanceState(bundle);    // We have saved state
        }
        display=findViewById(R.id.displayTextView);
        updateUI();
    }

    @Override
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        calculator.saveInstanceState(bundle);
    }

    @Override
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        calculator.loadInstanceState(bundle);
    }

    public void onClear(View view) {
        if (!calculator.isError()) {
            if (calculator.getDisplay().equals("0")) {
                calculator = new Calculator();
            } else {
                calculator.clear();
            }
            updateUI();
        }
    }

    public void onZero(View view) {
        if (!calculator.isError()) {
            calculator.addToInput("0");
            updateUI();
        }
    }

    public void onOne(View view) {
        if (!calculator.isError()) {
            calculator.addToInput("1");
            updateUI();
        }
    }

    public void onTwo(View view) {
        if (!calculator.isError()) {
            calculator.addToInput("2");
            updateUI();
        }
    }

    public void onThree(View view) {
        if (!calculator.isError()) {
            calculator.addToInput("3");
            updateUI();
        }
    }

    public void onFour(View view) {
        if (!calculator.isError()) {
            calculator.addToInput("4");
            updateUI();
        }
    }

    public void onFive(View view) {
        if (!calculator.isError()) {
            calculator.addToInput("5");
            updateUI();
        }
    }

    public void onSix(View view) {
        if (!calculator.isError()) {
            calculator.addToInput("6");
            updateUI();
        }
    }

    public void onSeven(View view) {
        if (!calculator.isError()) {
            calculator.addToInput("7");
            updateUI();
        }
    }

    public void onEight(View view) {
        if (!calculator.isError()) {
            calculator.addToInput("8");
            updateUI();
        }
    }

    public void onNine(View view) {
        if (!calculator.isError()) {
            calculator.addToInput("9");
            updateUI();
        }
    }

    public void onDecimalPoint(View view) {
        if (!calculator.isError()) {
            calculator.addToInput(".");
            updateUI();
        }
    }

    public void onPlus(View view) {
        if (!calculator.isError()) {
            calculator.operatorCalled("+");
            updateUI();
        }
    }

    public void onMinus(View view) {
        if (!calculator.isError()) {
            calculator.operatorCalled("-");
            updateUI();
        }
    }

    public void onMultiply(View view) {
        if (!calculator.isError()) {
            calculator.operatorCalled("*");
            updateUI();
        }
    }

    public void onDivision(View view) {
        if (!calculator.isError()) {
            calculator.operatorCalled("/");
            updateUI();
        }
    }

    public void onEqual(View view) {
        if (!calculator.isError()) {
            calculator.operatorCalled("=");
            updateUI();
        }
    }

    public void onNegate(View view) {
        if (!calculator.isError()) {
            calculator.negate();
            updateUI();
        }
    }

    /**
     * output clean numbers if removing decimal point is necessary
     * @param input The input string
     */
    public String decimalRemover(String input) {
        if (!input.endsWith(".")) {
            if (input.equals("Error")) {
                return input;
            }
            float x = Float.parseFloat(input);
            int y = (int)x;
            if (x == y) {
                return String.valueOf(y);
            }
        }
        return input;
    }

    /**
     * The clear button
     */
    private Button getCButton() {
        return (Button)findViewById(R.id.CButton);
    }

    /**
     * Update the UI for every pressed button
     */
    private void updateUI() {
        String calculatorDisplay = decimalRemover(calculator.getDisplay());
        display.setText(calculatorDisplay);
        if (calculatorDisplay.equals("0")) {
            getCButton().setText(R.string.AC_button);
        } else {
            getCButton().setText(R.string.C_button);
        }

    }
}