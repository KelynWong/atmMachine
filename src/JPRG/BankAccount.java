/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPRG;

/**
 *
 * @author kelyn
 */
public class BankAccount {

    private String accountNo;
    private double balance;
    private String password;

    public BankAccount(String accountNo, String password, double balance) {
        this.accountNo = accountNo;
        this.password = password;
        this.balance = balance;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return this.balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void withdraw(double balance) {
        this.balance = balance;
    }
}
