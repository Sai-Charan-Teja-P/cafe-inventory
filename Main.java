package cafe_inventory;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // reading input: provided for you
        Product[] products = new Product[10]; // an array with room for 10 products
        int count = 0; // how many products are stored so far
        int choice;
        do {
            System.out.println("\n--- Campus Cafe Inventory ---");
            System.out.println("1. Add product");
            System.out.println("2. Display all products");
            System.out.println("3. Total stock value");
            System.out.println("4. Average price");
            System.out.println("5. Restock a product");
            System.out.println("6. Duplicate a product");
            System.out.println("0. Exit");
            System.out.print("Choose: ");
            choice = sc.nextInt();
            sc.nextLine(); // clears the leftover newline after nextInt()
            if (choice < 0 || choice > 6) {
                System.out.println("Invalid choice, try again.");
            }
            switch (choice) {
                case 1:
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Price: ");
                    double price = sc.nextDouble();
                    System.out.print("Quantity: ");
                    int quantity = sc.nextInt();
                    sc.nextLine();
                    // TODO: if the array is full (count is 10), print a message
                    if (count == 10) {
                        System.out.println("You can add max 10 products..!");
                    }
                    // TODO: else if price <= 0 or quantity < 0, print an error message
                    if (price <= 0 || quantity < 0) {
                        System.out.println(
                                "Price should be greater than 0 and Quantity should not be a negative number..!");
                    }
                    // TODO: otherwise create the Product with the parameterized
                    // constructor, store it at products[count] and increase count
                    Product p = new Product(name, price, quantity);
                    products[count] = p;
                    count++;
                    break;
                case 2:
                    // TODO: if count is 0 print a message, otherwise loop from 0 to
                    // count - 1 and call display() on each product
                    // (print the number i + 1 before each one)
                    if (count > 0) {
                        for (int i = 0; i < count; i++) {
                            Product pr = products[i];
                            System.out.print(i + 1);
                            pr.display();
                        }
                    }
                    break;
                case 3:
                    // TODO: loop over the stored products, add up stockValue()
                    // and print the total (message if count is 0)
                    double stockValue = 0.0;
                    if (count > 0) {
                        for (int i = 0; i < count; i++) {
                            Product pr = products[i];
                            stockValue += pr.stockValue();
                        }
                        System.out.print("Total Stock Value :: " + stockValue);
                    } else {
                        System.out.print("No Stock..!");
                    }

                    break;
                case 4:
                    // TODO: calculate the average price as a double and print it
                    // also print it rounded down using an explicit cast
                    double avg = 0.0;
                    if (count > 0) {
                        for (int i = 0; i < count; i++) {
                            Product pr = products[i];
                            avg += pr.stockValue();
                        }
                        avg = avg / count;
                    }
                    System.out.print("Avg :: " + avg + " " + (int) avg);
                    break;
                case 5:
                    System.out.print("Product number: ");
                    int num = sc.nextInt();
                    System.out.print("Quantity to add: ");
                    int extra = sc.nextInt();
                    sc.nextLine();
                    // TODO: check num is between 1 and count and extra is above 0,
                    // otherwise print an error; then add extra to the quantity
                    // of products[num - 1]
                    if ((num > 0 && num < count) && extra > 0) {
                        Product p1 = products[num - 1];
                        p1.quantity += extra;
                    }
                    break;
                case 6:
                    System.out.print("Product number: ");
                    int n = sc.nextInt();
                    sc.nextLine();
                    // TODO: check n is between 1 and count (and the array is not full)
                    if ((n > 0 && n < count) && count < 10) {
                        Product p1 = products[n - 1];
                        Product copy = new Product(p1);
                        products[count] = copy;
                        count++;
                    }
                    // TODO: create a copy of products[n - 1] with the copy constructor,
                    // add " (copy)" to the copy's name, store it at
                    // products[count] and increase count
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    break;
            }
        } while (choice != 0);
        System.out.println("Products created in total: " + Product.totalProducts);
    }
}
