package com.example.scientific_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import org.mariuszgromada.math.mxparser.*;

public class MainActivity extends AppCompatActivity {
    private EditText display;
    private TextView previousCalculation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        previousCalculation = findViewById(R.id.previousCalculationView);
        display = findViewById(R.id.displayEditText);

        display.setShowSoftInputOnFocus(false);
    }
    private void updateText(String strToAdd) {
        String oldStr = display.getText().toString();
        int cursorPos = display.getSelectionStart();
        String leftStr = oldStr.substring(0,cursorPos);
        String rightStr = oldStr.substring(cursorPos);
        display.setText(String.format("%s%s%s", leftStr, strToAdd, rightStr));
        display.setSelection(cursorPos + strToAdd.length());
    }

    public void zeroButtonPush (View view)
    {
        updateText(getResources().getString(R.string.zeroText));
    }
    public void oneButtonPush (View view)
    {
        updateText(getResources().getString(R.string.oneText));
    }
    public void twoButtonPush (View view)
    {
        updateText(getResources().getString(R.string.twoText));
    }
    public void threeButtonPush (View view)
    {
        updateText(getResources().getString(R.string.threeText));
    }
    public void fourButtonPush (View view)
    {
        updateText(getResources().getString(R.string.fourText));
    }
    public void fiveButtonPush (View view)
    {
        updateText(getResources().getString(R.string.fiveText));
    }
    public void sixButtonPush (View view)
    {
        updateText(getResources().getString(R.string.sixText));
    }
    public void sevenButtonPush (View view)
    {
        updateText(getResources().getString(R.string.sevenText));
    }
    public void eightButtonPush (View view)
    {
        updateText(getResources().getString(R.string.eightText));
    }
    public void nineButtonPush (View view)
    {
        updateText(getResources().getString(R.string.nineText));
    }
    public void addButtonPush (View view)
    {
        updateText(getResources().getString(R.string.addText));
    }
    public void subButtonPush (View view)
    {
        updateText(getResources().getString(R.string.subtractText));
    }
    public void multiplyButtonPush (View view)
    {
        updateText(getResources().getString(R.string.multiplyText));
    }
    public void divideButtonPush (View view)
    {
        updateText(getResources().getString(R.string.divideText));
    }
    public void clearButtonPush (View view)
    {
        display.setText("");
        previousCalculation.setText("");
    }
    public void openBracketsButtonPush (View view)
    {
        updateText(getResources().getString(R.string.parenthesesOpenText));
    }
    public void closeBracketsButtonPush (View view)
    {
        updateText(getResources().getString(R.string.parenthesesCloseText));
    }
    public void equalsButtonPush (View view)
    {

        String userExpression = display.getText().toString();
        previousCalculation.setText(userExpression);
        userExpression = userExpression.replaceAll(getResources().getString(R.string.divideText),"/");
        userExpression = userExpression.replaceAll(getResources().getString(R.string.multiplyText),"*");
        Expression exp = new Expression(userExpression);
        String result = String.valueOf(exp.calculate());

        display.setText(result);
        display.setSelection(result.length());
    }
    public void backspaceButtonPush (View view)
    {
        int cursorPos = display.getSelectionStart();
        int textLength = display.getText().length();
        if(cursorPos!=0 && textLength!=0)
        {
            SpannableStringBuilder selection =(SpannableStringBuilder) display.getText();
            selection.replace(cursorPos-1, cursorPos, "");
            display.setText(selection);
            display.setSelection(cursorPos-1);
        }
    }
    public void decimalButtonPush (View view)
    {
        updateText(getResources().getString(R.string.decimalText));
    }

    public void trigSinButtonPush(View view){
        updateText("sin(");
    }
    public void trigCosButtonPush(View view){
        updateText("cos(");
    }
    public void trigTanButtonPush(View view){
        updateText("tan(");
    }
    public void trigArcSinButtonPush(View view){
        updateText("arcsin(");
    }
    public void trigArcCosButtonPush(View view){
        updateText("arccos(");
    }
    public void trigArcTanButtonPush(View view){
        updateText("arctan(");
    }
    public void logButtonPush(View view){
        updateText("log(");
    }
    public void naturalLogButtonPush(View view){
        updateText("ln(");
    }
    public void squaredRootButtonPush(View view){
        updateText("sqrt(");
    }
    public void eButtonPush(View view){
        updateText("e");
    }
    public void piButtonPush(View view){
        updateText("pi");
    }
    public void absoluteValueSinButtonPush(View view){
        updateText("abs(");
    }
    public void isPrimeButtonPush(View view){
        updateText("ispr(");
    }
    public void valueSquaredButtonPush(View view){
        updateText("^(2)");
    }
    public void valuePowerYButtonPush(View view){
        updateText("^(");
    }
}