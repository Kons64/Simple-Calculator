package edu.msu.huangm18.SimpleCalculator;

import android.os.Bundle;

public class Calculator {

    /**
     * The number displayed on the screen
     */
    private String display = "0";

    /**
     * The base number
     */
    private float secondNumber = 0f;

    private float stack = 0f;

    private String lastInput = "0";

    private boolean started = false;

    private String lastOperation = "";

    /**
     * The operation
     */
    private String operation = "";

    public void addToInput(String character) {
        if (lastInput.equals("0")) {
            if (character.equals(".")) {
                lastInput += character;
            } else {
                lastInput = character;
            }
        } else {
            if (character.equals(".")) {
                if (!lastInput.contains(".")) {
                    lastInput += character;
                }
            } else {
                lastInput += character;
            }
        }
    }

    public void operatorCalled(String operation) {
        if (!lastInput.equals("")) {
            secondNumber = Float.parseFloat(lastInput);
            lastInput = "";
            if (!this.operation.equals("")) {
                calculate();
            } else {
                if (!started) {
                    started = true;
                    stack = secondNumber;
                    lastOperation = operation;
                }
            }
            if (!operation.equals("=")) {
                this.operation = operation;
            }
        } else {
            if (!operation.equals("=")) {
                this.operation = operation;
            } else {
                this.operation = lastOperation;
                calculate();
            }
        }

    }

    public void calculate() {
        switch (operation) {
            case "+":
                stack += secondNumber;
                display = String.valueOf(stack);
                break;
            case "-":
                stack -= secondNumber;
                display = String.valueOf(stack);
                break;
            case "*":
                stack *= secondNumber;
                display = String.valueOf(stack);
                break;
            case "/":
                if (secondNumber == 0) {
                    display = "Error";
                } else {
                    stack /= secondNumber;
                    display = String.valueOf(stack);
                }
                break;
        }
        lastOperation = operation;
        operation = "";
    }

    public void clear() {
        display = "0";
        stack = 0;
        lastInput = "";
    }

    public boolean isError() {
        return display.equals("Error");
    }

    public String getDisplay() {
        if (!lastInput.equals("")) {
            display = lastInput;
        }
        return this.display;
    }

    public void negate() {
        this.lastInput = String.valueOf(-Float.parseFloat(lastInput));
    }

    /**
     * Save the calculator to a bundle
     * @param bundle The bundle we save to
     */
    public void saveInstanceState(Bundle bundle) {

        bundle.putString("DISPLAY", this.display);
        bundle.putFloat("SECONDNUMBER", this.secondNumber);
        bundle.putFloat("STACK", this.stack);
        bundle.putString("LASTINPUT", this.lastInput);
        bundle.putBoolean("STARTED", this.started);
        bundle.putString("LASTOPERATION", this.lastOperation);
        bundle.putString("OPERATION", this.operation);
    }

    /**
     * Read the puzzle from a bundle
     * @param bundle The bundle we save to
     */
    public void loadInstanceState(Bundle bundle) {
        this.display = bundle.getString("DISPLAY");
        this.secondNumber = bundle.getFloat("SECONDNUMBER");
        this.stack = bundle.getFloat("STACK");
        this.lastInput = bundle.getString("LASTINPUT");
        this.started = bundle.getBoolean("STARTED");
        this.lastOperation = bundle.getString("LASTOPERATION");
        this.operation = bundle.getString("OPERATION");
    }

}
