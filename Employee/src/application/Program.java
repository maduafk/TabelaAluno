package application;

import java.util.Locale;
import java.util.Scanner;
import entities.Employee;

public class Program {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Locale.setDefault(Locale.US);

    Employee emp = new Employee();

    System.out.println("Name: ");
    emp.name = sc.nextLine();
    System.out.println("Gross salary: ");
    emp.grossSalary = sc.nextDouble();
    System.out.println("Tax: ");
    emp.tax = sc.nextDouble();

    System.out.println("Employee: " + emp);
    System.out.println("Which percentage to increase salary?" );
    double percentage = sc.nextDouble();
    emp.increaseSalary(percentage);

    System.out.println("Updated data: " + emp);

    sc.close();
    }
}