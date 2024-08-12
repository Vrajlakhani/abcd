package com.mycompany.payroll;

/**
 * A class that represents part-time employees.
 * 
 * Part-time employees get an extra 10% of their wage to put towards benefits.
 * 
 * Author: Vrajl
 */
public class PartTimeEmployee extends Employee {

    public PartTimeEmployee(String givenName, double givenHours, double givenWage) {
        super(givenName, givenWage, givenHours);
    }

    @Override
    public double calculatePay() {
        double basePay = getHours() * getWage();
        double extra = basePay * 0.1;
        return basePay + extra;
    }
}
