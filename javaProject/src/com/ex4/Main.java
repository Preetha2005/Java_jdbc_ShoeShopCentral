package com.ex4;
import com.preetha_shoeshop.*;
import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Inventory in = new Inventory();
        System.out.println("Welcome to ShoeShop Central!!!");
        shoeshop s = new shoeshop();
        
        Login l = new Login();
        user u = null;
        boolean isAuthenticated = false;
        
        // Authentication loop: keep asking for username and password until correct
        while (!isAuthenticated) {
            System.out.println("Username:");
            String lname = sc.next() + sc.nextLine();
            System.out.println("Password:");
            String password = sc.next() + sc.nextLine();
            
            u = new user(lname, password);
            
            try {
                if (l.admin(u)) {
                    isAuthenticated = true;  // Set flag to true on successful login
                } else {
                    throw new InvalidPassword();
                }
            } catch (InvalidPassword e) {
                System.out.println("Invalid password. Please try again.");
            }
        }

        // Main menu after successful login
        String choice;
        do {
            System.out.println("1. Add 2. Update 3. Search 4. Remove 5. Show 6. Logout");
            System.out.println("Enter option:");
            int op = sc.nextInt();
            switch (op) {
                case 1:
                    // Add new shoe entry
                    System.out.println("Enter the name:");
                    s.setname(sc.next() + sc.nextLine());
                    System.out.println("Enter the size:");
                    s.setsize(sc.nextDouble());
                    System.out.println("Enter the color:");
                    s.setcolor(sc.next() + sc.nextLine());
                    System.out.println("Enter the type:");
                    s.settype(sc.next() + sc.nextLine());
                    in.addP(s);
                    break;
                case 2:
                    // Update shoe details
                    System.out.println("Enter the name whose details to be updated:");
                    String name = sc.next() + sc.nextLine();
                    System.out.println("Enter the color:");
                    String color = sc.next() + sc.nextLine();
                    s.setname(name);
                    s.setcolor(color);
                    in.update(s);
                    break;
                case 3:
                    // Search for shoe by ID
                    System.out.println("Enter the ID to search:");
                    String ids = sc.next() + sc.nextLine();
                    s = in.search(ids);
                    System.out.println(s);
                    break;
                case 4:
                    // Remove shoe entry by ID
                    System.out.println("Enter the id to be deleted:");
                    String idr = sc.next() + sc.nextLine();
                    in.Remove(idr);
                    break;
                case 5:
                    // Show all shoes
                    in.show();
                    break;
                case 6:
                    // Logout
                    in.logout();
                    break;
                default:
                    System.out.println("Invalid option.");
            }
            System.out.println("Enter 'yes' to continue or 'No' to stop:");
            choice = sc.next() + sc.nextLine();
        } while (!choice.equalsIgnoreCase("No"));  // Proper string comparison
    }
}
