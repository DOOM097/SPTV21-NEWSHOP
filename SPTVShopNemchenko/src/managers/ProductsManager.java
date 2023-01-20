package managers;

import entity.Product;
import java.util.Arrays;
import java.util.Scanner;


public class ProductsManager {
    private Scanner scanner;

    public ProductsManager() {
        scanner = new Scanner(System.in);
    }
    
    public Product createProduct(){
        Product product = new Product();
        System.out.println("Input product title: ");
        product.setTitle(scanner.nextLine());
        
        System.out.println("Input product price per item: ");
        product.setPrice(scanner.nextDouble()); //scanner.nextLine();
        
        System.out.println("Input products quantity: ");
        product.setQuantity(scanner.nextInt()); scanner.nextLine();
        return product;
    }
    
    public void productsLis(Product[] products){
        for (int i = 0; i < products.length; i++) {
            System.out.printf("%d. Title: %s; Price: %.2f; Quantity: %d%n", i+1, products[i].getTitle(), products[i].getPrice(), products[i].getQuantity());
        }
    }
    
    public Product[] editProduct(Product[] products){
        this.productsLis(products);
        System.out.print("Choose product number to edit: ");
        int prodNrToEdit = scanner.nextInt()-1; scanner.nextLine();
        System.out.printf("Edit title '%s'? Choose option: (y / n) ", products[prodNrToEdit].getTitle());
            String task = scanner.nextLine();
            switch (task.toLowerCase()){
                case "y":
                    System.out.print("Input new title: ");
                    products[prodNrToEdit].setTitle(scanner.nextLine());
                break;
            }
            System.out.printf("Edit price '%.2f'? Choose option: (y / n) ", products[prodNrToEdit].getPrice());
            task = scanner.nextLine();
            switch (task.toLowerCase()){
                case "y":
                    System.out.print("Input new price: ");
                    products[prodNrToEdit].setPrice(scanner.nextDouble()); scanner.nextLine();
                break;
            }
            System.out.printf("Edit quantity '%d'? Choose option: (y / n) ", products[prodNrToEdit].getQuantity());
            task = scanner.nextLine();
            switch (task.toLowerCase()){
                case "y":
                    System.out.print("Input new quantity: ");
                    products[prodNrToEdit].setQuantity(scanner.nextInt()); scanner.nextLine();
                break;
            }
        return products;
    }
    
    
    
    
    
}
