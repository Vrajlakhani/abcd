package com.mycompany.payroll;

/**
 * A class representing full-time employees.
 * 
 * Applied Inheritance and Polymorphism by extending Employee.
 * 
 * Author: Vrajl
 */
public class FullTimeEmployee extends Employee {

    public FullTimeEmployee(String givenName, double givenHours, double givenWage) {
        super(givenName, givenWage, givenHours);
    }

    @Override
    public double calculatePay() {
        return getHours() * getWage();
    }
}
