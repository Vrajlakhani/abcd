
package com.mycompany.payroll;

/**
 * An abstract class that represents Employee Objects.
 * Employees have a name, a number of hours, and an hourlyWage.
 * 
 * Applied DRY principle by providing common methods for subclasses.
 * 
 * Author: Vrajl
 */
public abstract class Employee {

    private String name;
    private double numHours;
    private double hourlyWage;

    public Employee(String givenName, double givenWage, double givenHours) {
        this.name = givenName;
        this.hourlyWage = givenWage;
        this.numHours = givenHours;
    }

    public void setName(String newName) {
        name = newName;
    }

    public String getName() {
        return name;
    }

    public void setHours(double hoursWorked) {
        numHours = hoursWorked;
    }

    public double getHours() {
        return numHours;
    }

    public void setWage(double workingWage) {
        hourlyWage = workingWage;
    }

    public double getWage() {
        return hourlyWage;
    }

    /**
     * Abstract method to calculate the pay for an employee.
     * Applied the Open/Closed Principle by making this method abstract to be implemented by subclasses.
     * @return the total pay
     */
    public abstract double calculatePay();

    /**
     * Method to return a formatted pay statement.
     * Applied DRY principle by consolidating print statement logic.
     * @return the pay statement
     */
    public String printStatement() {
        return getClass().getSimpleName() + ": " + getName() + " is owed: $" + calculatePay() + "\n**************************************************************";
    }
}
