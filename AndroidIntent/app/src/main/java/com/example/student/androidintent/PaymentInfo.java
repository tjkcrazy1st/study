package com.example.student.androidintent;
    public class PaymentInfo {
        private final double mLoanAmount, mAnnualInterestRateInPercent,
                mMonthlyPayment, mTotalPayments;
        private final long mLoanPeriodInMonths;
        private final String mCurrencySymbol;
        public PaymentInfo(double loanAmount, double annualInterestRateInPercent,
                           long loanPeriodInMonths, String currencySymbol) {
            mLoanAmount = loanAmount;
            mAnnualInterestRateInPercent = annualInterestRateInPercent;
            mLoanPeriodInMonths = loanPeriodInMonths;
            mCurrencySymbol = currencySymbol;
            mMonthlyPayment = LoanUtils.monthlyPayment(loanAmount,
                    annualInterestRateInPercent,
                    loanPeriodInMonths);
            mTotalPayments = mMonthlyPayment * mLoanPeriodInMonths;
        }

        public double getmLoanAmount() {
            return mLoanAmount;
        }

        public double getmAnnualInterestRateInPercent() {
            return mAnnualInterestRateInPercent;
        }

        public double getmMonthlyPayment() {
            return mMonthlyPayment;
        }

        public double getmTotalPayments() {
            return mTotalPayments;
        }

        public long getmLoanPeriodInMonths() {
            return mLoanPeriodInMonths;
        }

        public String getmCurrencySymbol() {
            return mCurrencySymbol;
        }
    }

