/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPRG;

import javax.swing.JOptionPane;

/**
 *
 * @author kelyn
 */
public class ATM {

    private int select1 = 0;
    private int select2 = 0;
    BankAccount[] accounts = new BankAccount[3];

    public void createAccounts() {
        accounts[0] = new BankAccount("123", "abc", 1000.0);
        accounts[1] = new BankAccount("321", "cba", 5000.0);
        accounts[2] = new BankAccount("456", "def", 3000.0);
    }

    public void enterAccountNo() {
        String accountInput;
        accountInput = JOptionPane.showInputDialog(null,
                "Please enter your account number: ",
                "ATM",
                JOptionPane.QUESTION_MESSAGE);
        for (int i = 0; i < accounts.length; i++) {
            if (accountInput.equals(accounts[i].getAccountNo())) {
                select1 = i;
                enterPassword();
            }
        }

        JOptionPane.showMessageDialog(null,
                "Invalid account number! Please reenter.",
                "Error",
                JOptionPane.ERROR_MESSAGE);
        enterAccountNo();
    }

    public void enterPassword() {
        String passwordInput;
        passwordInput = JOptionPane.showInputDialog(null,
                "Please enter your password: ",
                "ATM",
                JOptionPane.QUESTION_MESSAGE);
        for (int i = 0; i < accounts.length; i++) {
            if (passwordInput.equals(accounts[i].getPassword())) {
                enterOptions();
            }
        }

        JOptionPane.showMessageDialog(null,
                "Invalid password! Please reenter",
                "Error",
                JOptionPane.ERROR_MESSAGE);
        enterPassword();
    }

    public void enterOptions() {
        String input = JOptionPane.showInputDialog(null,
                "Enter your option:\n\n1. Check the balance\n2. Withdraw\n3. Deposit\n4. Transfer funds\n5. Switch accounts\n6. Change password\n7. Exit",
                "ATM",
                JOptionPane.QUESTION_MESSAGE);
        int optionsInput = Integer.parseInt(input);

        switch (optionsInput) {
            case 1:
                checkBalance();
                return;
            case 2:
                enterWithdraw();
                return;
            case 3:
                enterDeposit();
                return;
            case 4:
                transferFunds();
                return;
            case 5:
                switchAccounts();
                return;
            case 6:
                enterNewPassword();
            case 7:
                JOptionPane.showMessageDialog(null,
                        "Thank you for banking with us!",
                        "Message",
                        JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            default:
                JOptionPane.showMessageDialog(null,
                        "Invalid option! Please enter in the range from 1 to 5.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                enterOptions();
        }
    }

    public void checkBalance() {
        JOptionPane.showMessageDialog(null,
                "Balance: " + accounts[select1].getBalance(),
                "Message",
                JOptionPane.INFORMATION_MESSAGE);
        enterOptions();
    }

    public void enterWithdraw() {
        String input = JOptionPane.showInputDialog(null,
                "Please enter the amount to withdraw: ",
                "ATM",
                JOptionPane.QUESTION_MESSAGE);
        double withdrawInput = Double.parseDouble(input);
        for (int i = 0; i < accounts.length; i++) {
            if (withdrawInput <= 0 || withdrawInput > accounts[select1].getBalance()) {
                JOptionPane.showMessageDialog(null,
                        "Invalid amount! The amount to withdraw must be greater than 0 and less than $" + accounts[select1].getBalance(),
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                enterWithdraw();
            } else {
                accounts[select1].withdraw(accounts[select1].getBalance() - withdrawInput);
                JOptionPane.showMessageDialog(null,
                        "New balance: $" + accounts[select1].getBalance(),
                        "Message",
                        JOptionPane.INFORMATION_MESSAGE);
                enterOptions();
            }
        }
    }

    public void enterDeposit() {
        String input = JOptionPane.showInputDialog(null,
                "Please enter the amount to be deposit: ",
                "ATM",
                JOptionPane.QUESTION_MESSAGE);
        double depositInput = Double.parseDouble(input);
        for (int i = 0; i < accounts.length; i++) {
            if (depositInput <= 0) {
                JOptionPane.showMessageDialog(null,
                        "Invalid amount! The amount to deposit must be greater than 0",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                enterDeposit();
            } else {
                accounts[select1].withdraw(accounts[select1].getBalance() + depositInput);
                JOptionPane.showMessageDialog(null,
                        "New balance: $" + accounts[select1].getBalance(),
                        "Message",
                        JOptionPane.INFORMATION_MESSAGE);
                enterOptions();
            }

        }
    }

    public void enterNewPassword() {
        String input1 = JOptionPane.showInputDialog(null,
                "Please enter current password: ",
                "ATM",
                JOptionPane.QUESTION_MESSAGE);
        if (!input1.equals(accounts[select1].getPassword())) {
            JOptionPane.showMessageDialog(null,
                    "Password does not match",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            enterNewPassword();
        }
        String input2 = JOptionPane.showInputDialog(null,
                "Please enter new password: ",
                "ATM",
                JOptionPane.QUESTION_MESSAGE);
        String input3 = JOptionPane.showInputDialog(null,
                "Please reenter the new password: ",
                "ATM",
                JOptionPane.QUESTION_MESSAGE);
        if (!input2.equals(input3)) {
            JOptionPane.showMessageDialog(null,
                    "Password does not match",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            enterNewPassword();
        } else {
            accounts[select1].setPassword(input3);
            JOptionPane.showMessageDialog(null,
                    "Password changed.",
                    "ATM",
                    JOptionPane.INFORMATION_MESSAGE);
            enterOptions();
        }
    }

    public void switchAccounts() {
        enterAccountNo();
    }

    public void transferFunds() {
        String accountInput = JOptionPane.showInputDialog(null,
                "Enter accountNo to tranfer funds to: ",
                "ATM",
                JOptionPane.QUESTION_MESSAGE);
        for (int i = 0; i < accounts.length; i++) {
            if (accountInput.equals(accounts[i].getAccountNo())) {
                select2 = i;
                calculateFunds();
            }
        }

        JOptionPane.showMessageDialog(null,
                "Invalid account number! Please reenter.",
                "Error",
                JOptionPane.ERROR_MESSAGE);
        transferFunds();
    }

    public void calculateFunds() {
        String input = JOptionPane.showInputDialog(null,
                "Enter amount to transfer: ",
                "ATM",
                JOptionPane.QUESTION_MESSAGE);
        double transferAmount = Double.parseDouble(input);

        for (int i = 0; i < accounts.length; i++) {
            if (transferAmount <= 0 || transferAmount > accounts[select1].getBalance()) {
                JOptionPane.showMessageDialog(null,
                        "Invalid amount! The amount to withdraw must be greater than 0 and less than $" + accounts[select1].getBalance(),
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                calculateFunds();
            } else {
                accounts[select1].setBalance(accounts[select1].getBalance() - transferAmount);
                accounts[select2].setBalance(accounts[select2].getBalance() + transferAmount);

                JOptionPane.showMessageDialog(null,
                        "Transfer successful.",
                        "Transfer funds",
                        JOptionPane.INFORMATION_MESSAGE);

                JOptionPane.showMessageDialog(null,
                        "Your new balance is " + accounts[select1].getBalance(),
                        "New balance",
                        JOptionPane.INFORMATION_MESSAGE);
                enterOptions();
            }
        }
    }
}
