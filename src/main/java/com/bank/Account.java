package com.bank;

public class Account {
    protected double balance;
    protected int rate;
    protected int period;

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public double getBalance() {return balance;}

    public int getRate() {
        return rate;
    }

    public int getPeriod() {
        return period;
    }

    public void compute(){
        while(period != 0){
            double interest = rate*.01;
            double interestGained = interest*balance;
            balance = interestGained + balance;
            period --;
        }

    }
}
