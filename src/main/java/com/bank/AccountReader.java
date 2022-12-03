package com.bank;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountReader {

    private static Map<String, Account> allAccounts = new HashMap<>();

    public static void main(String[] args){
        createAccount();
        //
    }

    public static void createAccount(){
        Path accountFilePath = Paths.get("accounts.txt");
        try{
            List<String> accountLines = Files.readAllLines(accountFilePath);
            for (String accountDetail: accountLines)
            {
                String[] accountArray = accountDetail.split(", ");
                if (accountArray.length <= 5)
                {
                    String accountType = accountArray[0];
                    if (accountType.equals("CertificateOfDeposit"))
                    {
                        String accountTerm = accountArray[1];
                        String accountRate = accountArray[2];
                        String accountBalance = accountArray[3];
                        String accountPeriods = accountArray[4];
                    }
                    else
                    {
                        String accountRate = accountArray[1];
                        String accountBalance = accountArray[2];
                        String accountPeriods = accountArray[3];

                    }

                }
            }
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
