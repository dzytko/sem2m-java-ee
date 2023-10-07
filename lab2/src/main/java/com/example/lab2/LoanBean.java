package com.example.lab2;


import java.io.Serializable;

public class LoanBean implements Serializable {
    private double amount;
    private double yearlyInterestRate;
    private int numberOfInstallments;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getYearlyInterestRate() {
        return yearlyInterestRate;
    }

    public void setYearlyInterestRate(double yearlyInterestRate) {
        this.yearlyInterestRate = yearlyInterestRate;
    }

    public int getNumberOfInstallments() {
        return numberOfInstallments;
    }

    public void setNumberOfInstallments(int numberOfInstallments) {
        this.numberOfInstallments = numberOfInstallments;
    }

    public double getInstallment() {
        double monthlyInterestRate = yearlyInterestRate / 1200;
        return (amount * monthlyInterestRate) / (1 - Math.pow(1 + monthlyInterestRate, -numberOfInstallments));
    }
}
