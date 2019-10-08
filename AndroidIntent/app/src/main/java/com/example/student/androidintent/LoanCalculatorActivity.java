package com.example.student.androidintent;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class LoanCalculatorActivity extends Activity {

    private double mLoanAmount = 100000,
                   mAnnualInterestRateInPercent = 5.0;
    private long   mLoanPeriodInMonths = 360; // 30 years
    private String mCurrencySymbol = "$";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loan_payment);
        setInputsFromExtras();
        setInputsFromUri();
        calculateAndSetOutputValues();
    }

    private void calculateAndSetOutputValues() {
        PaymentInfo paymentInfo =
                new PaymentInfo(mLoanAmount, mAnnualInterestRateInPercent, mLoanPeriodInMonths, mCurrencySymbol);
        TextView loanAmountDisplay = findViewById(R.id.loan_amount);
        loanAmountDisplay.setText(paymentInfo.getmLoanAmount());
        TextView interestRateDisplay = findViewById(R.id.interest_rate);
        interestRateDisplay.setText(Double.toString(paymentInfo.getmAnnualInterestRateInPercent()));
        TextView loanPeriodDisplay = findViewById(R.id.tv_loan);
        loanPeriodDisplay.setText(paymentInfo.getmMonthlyPayment());
        TextView monthlyPaymentDisplay = findViewById(R.id.monthly_payment);
        monthlyPaymentDisplay.setText(paymentInfo.getFormattedMonthlyPayment());
        TextView totalPaymentsDisplay = findViewById(R.id.total_payments);
        totalPaymentsDisplay.setText(paymentInfo.getFormattedTotalPayments());
    }

}