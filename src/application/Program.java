package application;

import entities.Employee;
import entities.OutsourcedEmployee;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        ArrayList<Employee> list = new ArrayList<>();

        System.out.print("Enter the number of employees: ");
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("Employee #" + (i+1) + " data:");
            System.out.print("Outsorced (y/n)? ");
            char ch = scanner.next().charAt(0);
            System.out.print("Name: ");
            scanner.nextLine();
            String name = scanner.nextLine();
            System.out.print("Hours: ");
            int hours = scanner.nextInt();
            System.out.print("Value per hour: ");
            double valuePerHour = scanner.nextDouble();
            if (ch == 'y'){
                System.out.println("Aditional charge: ");
                double additionalCharge = scanner.nextDouble();
                list.add(new OutsourcedEmployee(name,hours,valuePerHour,additionalCharge));
            }//não precisa criar uma variável antes para depois instanciar, pode fazer direto no .add
            else {
                list.add(new Employee(name, hours, valuePerHour));
            }//não precisa criar uma variável antes para depois instanciar, pode fazer direto no .add
        }

        System.out.println("\nPAYMENTS:");
        for (Employee emp : list){
            System.out.println(emp.getName() + " - $ "+ String.format("%.2f", emp.payment()));
        }
    }
}
