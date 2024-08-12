package com.mycompany.payroll;

/**
 * Factory class to create different types of employees.
 * 
 * Applied Factory Pattern to encapsulate employee creation logic.
 * 
 * Author: Vrajl
 */
public class EmployeeFactory {

    public static Employee createEmployee(String type, String name, double hours, double wage) {
        switch (type.toLowerCase()) {
            case "fulltime" -> {
                return new FullTimeEmployee(name, hours, wage);
            }
            case "parttime" -> {
                return new PartTimeEmployee(name, hours, wage);
            }
            case "manager" -> {
                return new Manager(name, hours, wage);
            }
            default -> throw new IllegalArgumentException("Invalid employee type");
        }
    }
}
