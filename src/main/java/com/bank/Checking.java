package com.bank;

import com.bank.Account;

public class Checking extends Account {

    public void compute(){
        while (period != 0) {
            int fee = 5;
            double interest = rate*.01;
            double interestGained = interest*balance;
            balance = interestGained + balance - fee;
            period --;
        }
    }
}

