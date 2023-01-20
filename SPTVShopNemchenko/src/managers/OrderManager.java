package managers;

import entity.Customer;
import entity.Order;
import entity.Product;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Scanner;


public class OrderManager {
    private final Scanner scanner;
    private final CustomerManager customerManager;
    private final ProductsManager productsManager;
    

    public OrderManager() {
        scanner = new Scanner(System.in);
        customerManager = new CustomerManager();
        productsManager = new ProductsManager();
    }
    
    public Order placeOrder(Customer[] customers, Product[] products){
        Order order = new Order();
        customerManager.customersList(customers);
        System.out.print("Choose customer number: ");
        int customerNr = scanner.nextInt(); scanner.nextLine();
        
        productsManager.productsLis(products);
        System.out.print("Choose product number: ");
        int productNr = scanner.nextInt(); scanner.nextLine();
        
        Boolean itemQty = true;
        do {
            System.out.print("How many pieces would you like: ");
            int productQty = scanner.nextInt(); scanner.nextLine();
            if (productQty > products[productNr-1].getQuantity()) {
                System.out.println("Not enough pruducts in store.");
            }else{
                order.setCustomer(customers[customerNr-1]);
                order.setProduct(products[productNr-1]);
                order.getProduct().setQuantity(productQty);
                order.setOrderDate(new GregorianCalendar().getTime());
                int remainQty = order.getProduct().getQuantity()- productQty;
                // change products quantity in store;
                itemQty = false;
            }
        } while (itemQty);
        return order;
    }
    
    public void ordersList(Order[] orders){
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy, hh:mm");
        for (int i = 0; i < orders.length; i++) {
            Order order = orders[i];
            System.out.printf("%d. %s - %d; Price per item: %.2f; Customer: %s %s; Order date: %s", i+1,
                    order.getProduct().getTitle(),
                    order.getProduct().getQuantity(),
                    order.getProduct().getPrice(),
                    order.getCustomer().getName(),
                    order.getCustomer().getLastName(),
                    sdf.format(order.getOrderDate())
                    );
//            System.out.println((i+1) + ". Product: " + order.getProduct() + "; Customer: " + order.getCustomer() + "; Order date: " + sdf.format(order.getOrderDate()));
        }
    }
    
    
    
    
    
}   // public class OrderManager
