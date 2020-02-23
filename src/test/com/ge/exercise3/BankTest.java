package com.ge.exercise3;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class BankTest {

    Bank bank;

    @Before
    public void setUp() {
        bank = new Bank();
    }

    @Test
    public void addAccountTest() {
        Account account = new Account("001");
        bank.addAccount(account);
        assertEquals(1, bank.numAccounts());
    }

    @Test
    public void getAccountTest() {
        Account account = new Account("002", "Checking", 100.0f);
        bank.addAccount(account);
        assertEquals(account, bank.getAccount("002"));
    }

    @Test
    public void depositToAccountTest() {
        Account account = new Account("003", "Checking", 100.0f);
        bank.addAccount(account);
        bank.depositToAccount("003", 100.0f);
        assertEquals(200.0f, account.getBalance(), 0.01);
    }

    @Test
    public void withdrawFromAccountTest() {
        Account account = new Account("004", "Checking", 100.0f);
        bank.addAccount(account);
        bank.withdrawFromAccount("004", 100.0f);
        assertEquals(0.0f, account.getBalance(), 0.01);
    }
    
    @Test
    public void withdrawFromCheckingAccountFailedTest() {
        Account account = new Account("005", "Checking", 200.0f);
        bank.addAccount(account);
        bank.withdrawFromAccount("005", 150.0f);
        assertEquals(200.0f, account.getBalance(), 0.01);
    }
    
    @Test
    public void withdrawFromSavingsAccountFailedsTest() {
        Account account = new Account("006", "Savings", 100.0f);
        bank.addAccount(account);
        bank.withdrawFromAccount("006", 150.0f);
        assertEquals(100.0f, account.getBalance(), 0.01);
    }
    
    @Test
    public void getCurrentHoldingsTest() {
    	Account account1 = new Account("007", "Savings", 100.0f);
    	Account account2 = new Account("008", "Savings", 200.0f);
    	Account account3 = new Account("009", "Savings", 300.0f);
    	
    	bank.addAccount(account1);
    	bank.addAccount(account2);
    	bank.addAccount(account3);
    	
    	assertEquals(600.0f,bank.getCurrentHoldings(),0.01);
    }
    
    @Test
    public void projectProfitOrLossForProfitTest() {
    	Map<String,Account> accountMap = bank.getAccountMap();
    	accountMap.clear(); // Clearing already created accounts only for testing purpose
    	
    	Account account1 = new Account("0010", "Savings", 100.0f);
    	Account account2 = new Account("0011", "Savings", 200.0f);
    	
    	account2.setMonthlyFee(2.0f);
    	
    	bank.addAccount(account1);
    	bank.addAccount(account2);
    	
    	assertEquals("Profit", bank.projectProfitOrLoss());
    }
    
    
    @Test
    public void projectProfitOrLossForLosssTest() {
    	Map<String,Account> accountMap = bank.getAccountMap();
    	accountMap.clear(); // Clearing already created accounts only for testing purpose
    	
    	Account account1 = new Account("0012", "Savings", 100.0f);
    	Account account2 = new Account("0013", "Savings", 200.0f);
    	
    	account1.setMonthlyFee(2.0f);
    	account2.setMonthlyFee(2.0f);
    	
    	bank.addAccount(account1);
    	bank.addAccount(account2);
    	
    	assertEquals("Loss", bank.projectProfitOrLoss());
    }
}