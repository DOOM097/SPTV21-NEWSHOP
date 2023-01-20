package managers;

import entity.Customer;
import java.util.Arrays;
import java.util.Scanner;

public class CustomerManager {
    private final Scanner scanner;
    private Customer[] customers;
    
    

    public CustomerManager() {
        scanner = new Scanner(System.in);
    }
    
    public Customer createCustomer(){
        Customer customer = new Customer();
        System.out.println("Input customer's name");
        customer.setName(scanner.nextLine());
        System.out.println("Input customer's last name");
        customer.setLastName(scanner.nextLine());
        System.out.println("Input customer's phone");
        customer.setPhone(scanner.nextLine());
        return customer;
        
    }
    
    public void customersList(Customer customers[]){
        for (int i = 0; i < customers.length; i++) {
            System.out.printf("%d. %s %s, phone: %s%n", i+1, customers[i].getName(), customers[i].getLastName(), customers[i].getPhone());
        }
    }
    
    public Customer[] editCustomer(Customer[] customers){
        this.customersList(customers);
        System.out.print("Choose customer number to edit: ");
        int custNrToEdit = scanner.nextInt()-1; scanner.nextLine();
        
//        Customer editCustomer = customers[custNrToEdit];
//        Customer changedCustomer = new Customer();
//        Boolean finish = true;
//        editLoop: do {
//            System.out.println("What do you like to edit?\nN - edit name\t L - edit last name\tP - edit phone \tS - Save changes and quit");
//            String whatToEdit = scanner.nextLine();
//            switch(whatToEdit.toUpperCase()){
//                case "N":
//                    System.out.print("Old name: " + editCustomer.getName() + "\tNew name: ");
//                    changedCustomer.setName(scanner.nextLine());
//                    changedCustomer.setLastName(editCustomer.getLastName());
//                    changedCustomer.setPhone(editCustomer.getPhone());
//                break;
//                case "L":
//                    System.out.print("Old lastname: " + editCustomer.getLastName() + "\tNew lastname: ");
//                    changedCustomer.setLastName(scanner.nextLine());
//                    changedCustomer.setName(editCustomer.getName());
//                    changedCustomer.setPhone(editCustomer.getPhone());
//                break;
//                case "P":
//                    System.out.print("Old phone: " + editCustomer.getPhone() + "\tNew phone: ");
//                    changedCustomer.setPhone(scanner.nextLine());
//                    changedCustomer.setName(editCustomer.getName());
//                    changedCustomer.setLastName(editCustomer.getLastName());
//                break;
//                case "S":
//                    break editLoop;
//            }
//            Arrays.asList(customers).replaceAll(n->n.equals(editCustomer) ? changedCustomer : n);
//        } while (finish);
        
//            teacher's method
        System.out.printf("Edit name '%s'? Choose option: (y / n) ", customers[custNrToEdit].getName());
        String task = scanner.nextLine();
        switch (task.toLowerCase()){
            case "y":
                System.out.print("Input new name: ");
                customers[custNrToEdit].setName(scanner.nextLine());
            break;
        }
        System.out.printf("Edit lastname '%s'? Choose option: (y / n) ", customers[custNrToEdit].getLastName());
        task = scanner.nextLine();
        switch (task.toLowerCase()){
            case "y":
                System.out.print("Input new lastname: ");
                customers[custNrToEdit].setLastName(scanner.nextLine());
            break;
        }
        System.out.printf("Edit phone '%s'? Choose option: (y / n) ", customers[custNrToEdit].getPhone());
        task = scanner.nextLine();
        switch (task.toLowerCase()){
            case "y":
                System.out.print("Input new phone: ");
                customers[custNrToEdit].setPhone(scanner.nextLine());
            break;
        }
        
        return customers;
        
    }
    
    
    
    
    
    
}   // public class CustomerManager ENDS
