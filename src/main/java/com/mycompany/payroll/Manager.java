package com.mycompany.payroll;

/**
 * A class that represents managers.
 * 
 * Managers have a bonus in addition to their regular pay.
 * 
 * Author: Vrajl
 */
public class Manager extends Employee {

    private double bonus;

    public Manager(String givenName, double givenHours, double givenWage) {
        super(givenName, givenWage, givenHours);
        this.bonus = 0;
    }

    public void setBonus(double bonusAmount) {
        this.bonus = bonusAmount;
    }

    public double getBonus() {
        return this.bonus;
    }

    @Override
    public double calculatePay() {
        return getWage() * getHours() + bonus;
    }
}
