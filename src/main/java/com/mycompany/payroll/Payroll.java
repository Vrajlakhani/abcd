package com.mycompany.payroll;

import java.util.Scanner;

/**
 * A class that models the Payroll Application.
 * We are modeling this as an Object so we must think of
 * what would represent both the state and the behaviour of 
 * the Payroll class.
 * 
 * Applied Factory Pattern for creating employees and
 * Single Responsibility Principle by separating payroll management.
 * 
 * Author: Vrajl
 */
public class Payroll {

    private PayrollManager payrollManager;

    public Payroll() {
        payrollManager = PayrollManager.getInstance();
    }

    /**
     * A main method where we create an instance of the payroll
     * and then call the private run method on it.
     * We also catch our Exceptions here from the Employee class.
     */
    public static void main(String[] args) {
        try {
            Payroll app = new Payroll();
            app.run();
        } catch (NumberFormatException e) {
            System.out.println("A number format is incorrect " + e.getMessage()
                    + " Please ensure hours and wage are entered as numbers and not words");
        } catch (Exception e) {
            System.out.println("An exception was caught while trying to process employees: " + e.getMessage());
        }
    }

    /**
     * A private run method that prompts the user for input and
     * adds each Employee to the array.
     * Finally, we call the print method to print out the payroll
     * for each employee and the total.
     */
    private void run() {
        Scanner sc = new Scanner(System.in);
        boolean shouldContinue = true;
        System.out.println("Welcome to the Payroll Application.");

        while (shouldContinue) {
            Employee emp = createEmployee(sc);
            payrollManager.addEmployee(emp);

            System.out.println("Would you like to enter another employee (yes or no)?");
            String yesOrNo = sc.nextLine();
            shouldContinue = yesOrNo.equalsIgnoreCase("yes");
        }

        payrollManager.displayPays();
    }

    /**
     * A method to create an employee based on user input.
     * 
     * Applied Factory Pattern by using EmployeeFactory to create employees.
     * @param sc the Scanner object for user input
     * @return the created Employee object
     */
    private Employee createEmployee(Scanner sc) {
        System.out.println("Please enter the Employee's name: ");
        String name = sc.nextLine();
        System.out.println("Please enter the Employee's number of hours worked as a number: ");
        double numHours = Double.parseDouble(sc.nextLine());
        System.out.println("Please enter the Employee's hourly wage: ");
        double wage = Double.parseDouble(sc.nextLine());

        System.out.println("Do you want to create a manager? Type yes or no");
        String manager = sc.nextLine();
        if (manager.equalsIgnoreCase("yes")) {
            System.out.println("Please enter a bonus for the manager");
            double bonus = Double.parseDouble(sc.nextLine());
            Manager man = (Manager) EmployeeFactory.createEmployee("manager", name, numHours, wage);
            man.setBonus(bonus);
            return man;
        } else {
            System.out.println("Do you want to create a part-time Employee? Type yes or no");
            String partTime = sc.nextLine();
            if (partTime.equalsIgnoreCase("yes")) {
                return EmployeeFactory.createEmployee("parttime", name, numHours, wage);
            } else {
                return EmployeeFactory.createEmployee("fulltime", name, numHours, wage);
            }
        }
    }
}
