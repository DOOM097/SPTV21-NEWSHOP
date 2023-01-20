package SPTV21shopNemchenko;

import entity.Customer;
import entity.Product;
import entity.Order;
import java.awt.print.Book;
import java.util.Scanner;
import java.util.Arrays;
import managers.CustomerManager;
import managers.ProductsManager;
import managers.OrderManager;


public class App {
    private final Scanner scanner;
    private final CustomerManager customerManager;
    private Customer[] customers;
    
    private final ProductsManager productsManager;
    private Product[] products;
    
    private final OrderManager ordersManager;
    private Order[] orders;

    public App() {
        scanner = new Scanner(System.in);
        customerManager = new CustomerManager();
        customers = new Customer[0];
        
        productsManager = new ProductsManager();
        products  = new Product[0];
        
        ordersManager = new OrderManager();
        orders = new Order[0];
        
        testAddCustomer();
        testAddProduct();
        
    }
    
    public void run(){
        String splitter = "\n------------------------------------------------------------------------------";
        Scanner scanner = new Scanner(System.in);
        boolean repeat = true;
        
        do{
            System.out.println("\t\t\t\tApp options:");
            System.out.println("0 - Quit");
            System.out.println("1 - Add product\t\t|\t2 - Edit product\t|\t3 - Products list" );
            System.out.println("4 - Add customer\t|\t5 - Edit customer\t|\t6 - Customers list");
            System.out.println("7 - Place order\t\t|\t8 - Orders list");
            System.out.print("Choose options number: ");
            int option = scanner.nextInt();
            System.out.println("\n");
            switch (option){
                case 0:
                   repeat = false;
                   break;
                case 1:
                    System.out.println("1 - Add product");
                    addProduct(productsManager.createProduct());
                    
                    System.out.println(splitter);
                   break;
                case 2:
                    System.out.println("2 - Edit product");
                    products = productsManager.editProduct(products);
                    
                    System.out.println(splitter);
                    break;
                case 3:
                    System.out.println("3 - Products list");
                    productsManager.productsLis(products);
                    
                    System.out.println(splitter);
                    break;
                case 4:
                    System.out.println("4 - Add customer");
                    addCustomer(customerManager.createCustomer());
                    
                    System.out.println(splitter);
                    break;
                case 5:
                    System.out.println("5 - Edit customer");
                    customers = customerManager.editCustomer(customers);
                    
                    System.out.println(splitter);
                    break;
                case 6:
                    System.out.println("6 - Customers list");
                    customerManager.customersList(customers);
                    
                    System.out.println(splitter);
                    break;
                case 7:
                    System.out.println("7 - Place order");
                    addOrder(ordersManager.placeOrder(customers, products));
                    
                    System.out.println(splitter);
                    break;
                case 8:
                    System.out.println("8 - Orders list");
                    ordersManager.ordersList(orders);
                    
                    System.out.println(splitter);
                    break;
                    
                default:
                    System.out.println("There is no function with such number\nChoose function number from the list!\n---------------------------------------------------------------------------");
            }
            
            
        }while(repeat);
        System.out.println("Good bye!");
        
        
        
    }   // run ends
    
    public void addCustomer(Customer customer){
        customers = Arrays.copyOf(customers, customers.length+1);
        customers[customers.length-1] = customer;
    }
    
    public void addProduct(Product product){
        products = Arrays.copyOf(products, products.length+1);
        products[products.length-1] = product;
    }
    
    public void addOrder(Order order){
        orders = Arrays.copyOf(orders, orders.length+1);
        orders[orders.length-1] = order;
    }
    
    
    
    
    
    // to add customer automatically
    private void testAddCustomer(){
        Customer customer = new Customer("Tolik", "Pruzhinkin", "55123123");
        this.customers = Arrays.copyOf(this.customers, this.customers.length+1);
        this.customers[this.customers.length-1] = customer;
        
        Customer customer1 = new Customer("Vasily", "Pupkin", "587896321");
        this.customers = Arrays.copyOf(this.customers, this.customers.length+1);
        this.customers[this.customers.length-1] = customer1;
    }
    
    // to add product automatically
    private void testAddProduct(){
        Product product = new Product("Bread", 5.0, 23);
        this.products = Arrays.copyOf(this.products, this.products.length+1);
        this.products[this.products.length-1] = product;
        
        Product product1 = new Product("Milk", 1.86, 36);
        this.products = Arrays.copyOf(this.products, this.products.length+1);
        this.products[this.products.length-1] = product1;
        
    }
    
    
}   // public class App ENDS
