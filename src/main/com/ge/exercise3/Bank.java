package com.ge.exercise3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class Bank {

    private static final Logger logger = LogManager.getLogger(Bank.class);
    private Map<String, Account> accountMap;

    public Bank() {
        accountMap = new HashMap<>();
    }

    public Map<String, Account> getAccountMap() {
		return accountMap;
	}

	public Account getAccount(String accountNumber) {
        return accountMap.get(accountNumber);
    }

    public void addAccount(Account account) {
        accountMap.put(account.getAccountNumber(), account);
    }

    public void depositToAccount(String accountNumber, float amount) {
        getAccount(accountNumber).deposit(amount);
    }

    public void withdrawFromAccount(String accountNumber, float amount) {
    	Account account = getAccount(accountNumber);
    	
    	if(account.getAccountType().equals("Checking")) {
    		if(amount <= 100f) {
    			account.withdraw(amount);
    		}
    		else {
    			logger.error("Cannot Withdraw as Amount exceeds 100$");
    		}
    	} else if(account.getAccountType().equals("Savings")) {
    		if(amount <= account.getBalance()) {
    			account.withdraw(amount);
    		} else {
    			logger.error("Cannot Withdraw as Amount exceeds Available Balance");
    		}
    	}
    }

    public int numAccounts() {
        return accountMap.size();
    }
    
    public double getCurrentHoldings() {
    	double sum = 0;
    	
    	for(Map.Entry<String, Account> entry : accountMap.entrySet()) {
    		sum += entry.getValue().getBalance();
    	}
    	
		return sum;
    }
    
    public String projectProfitOrLoss() {
    	double feesCollected = 0.0f;
    	double interestPaid = 0.0f;
    	
    	for(Map.Entry<String, Account> entry : accountMap.entrySet()) {
    		feesCollected += entry.getValue().getMonthlyFee();
    		interestPaid += (entry.getValue().getMonthlyInterestRate() * entry.getValue().getBalance());
    	}
    	
    	if(interestPaid > feesCollected)
    			return "Profit";
    	else if(interestPaid < feesCollected)
    		return "Loss";
    	else
    		return "Neither Profit Nor Loss";
    }
}
