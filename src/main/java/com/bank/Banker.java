package com.bank;

import javax.swing.*;
import java.util.ArrayList;

public class Banker {

    public static final String CHECKING = "Checking";
    public static final String SAVINGS = "Savings";
    public static final String CERTIFICATE_OF_DEPOSIT = "Certificate of Deposit";

    private static ArrayList<Account> allAccounts = new ArrayList<>();
    public static void main(String[] args) {
        System.out.println("Welcome to ROME bank.");
        promptUser();
        displayBalance();
    }



    public static void promptUser() {
        int goAgain = JOptionPane.NO_OPTION;
        do {
            String[] accountOptions = {CHECKING, SAVINGS, CERTIFICATE_OF_DEPOSIT};
            Object accountType = JOptionPane.showInputDialog(null, "Select an account type", "Select Account type", JOptionPane.QUESTION_MESSAGE, null, accountOptions, CHECKING);

            Account account = createAccount(accountType);

            String startingBalance = JOptionPane.showInputDialog("Enter your starting balance.");
            double balance = Double.parseDouble(startingBalance);
            account.setBalance(balance);

            String startingRate = JOptionPane.showInputDialog("Enter your starting rate.");
            int rate = Integer.parseInt(startingRate);
            account.setRate(rate);

            String startingPeriod = JOptionPane.showInputDialog("Enter the number of periods.");
            int period = Integer.parseInt(startingPeriod);
            account.setPeriod(period);

            if (accountType.toString().equals(CERTIFICATE_OF_DEPOSIT)){
                String inputMaturity = JOptionPane.showInputDialog("Enter amount of Terms:");
                int term = Integer.parseInt(inputMaturity);
            }
            allAccounts.add(account);

            goAgain = JOptionPane.showConfirmDialog(null, "Would you like to create another account?", "Create another account?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);


        }
        while (goAgain == JOptionPane.YES_OPTION);
    }

    /**
     * Method to create and return a subclass of type com.bank.Account
     *
     * @param selectedAccount A string representing the account type we want to create.
     * @return the created account
     */

    public static Account createAccount(final Object selectedAccount)
    {
        Account account = new Account();
        if (selectedAccount.toString().equals(CHECKING))
        {
            account = new Checking();
        }
        else if (selectedAccount.toString().equals(SAVINGS))
        {
            account = new Savings();
        }
        else if (selectedAccount.toString().equals(CERTIFICATE_OF_DEPOSIT))
        {
            account = new CertificateOfDeposit();
        }
        return account;

    }


    public static void displayBalance()
    {
        for (Account account : allAccounts)
        {
            account.compute();
            JOptionPane.showMessageDialog(null, "Account balance: " + account.getBalance());
        }


    }
}
