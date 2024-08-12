package com.mycompany.payroll;

import java.util.ArrayList;
import java.util.List;

/**
 * Singleton class to manage payroll operations.
 * 
 * Applied Singleton Pattern to ensure a single instance of PayrollManager.
 * 
 * Author: Vrajl
 */
public class PayrollManager {

    private static PayrollManager instance;
    private List<Employee> employees;

    private PayrollManager() {
        employees = new ArrayList<>();
    }

    public static PayrollManager getInstance() {
        if (instance == null) {
            instance = new PayrollManager();
        }
        return instance;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void displayPays() {
        double totalPaid = 0;
        for (Employee emp : employees) {
            System.out.println(emp.printStatement());
            totalPaid += emp.calculatePay();
        }
        System.out.printf("The total amount to be paid to all employees is $%.2f\n", totalPaid);
    }
}
