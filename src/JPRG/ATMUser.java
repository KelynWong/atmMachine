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
public class ATMUser {

    public static void main(String[] args) {
        ATM atm1 = new ATM();
        atm1.createAccounts();
        atm1.enterAccountNo();
    }
}
