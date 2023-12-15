/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication9;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class UserAccount {
    private String username;
    private String password;

    public UserAccount(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }
}

public class UserAccountSystem { // This is for creation an account 
    private Map<String, UserAccount> users;
    private UserAccount currentUser;
    private Scanner scanner;

    public UserAccountSystem() {
        users = new HashMap<>();
        scanner = new Scanner(System.in);
    }

    public void createUser() {
        System.out.println("Enter username:");
        String username = scanner.nextLine();
        
        if (users.containsKey(username)) {
            System.out.println("Username already exists. Please choose a different username.");
            return;
        }

        System.out.println("Enter password:");
        String password = scanner.nextLine();

        UserAccount newUser = new UserAccount(username, password);
        users.put(username, newUser);
        System.out.println("User account created successfully!");
    }

    public void login() {
        System.out.println("Enter username:");
        String username = scanner.nextLine();

        if (!users.containsKey(username)) {
            System.out.println("User does not exist. Please create an account.");
            return;
        }

        System.out.println("Enter password:");
        String password = scanner.nextLine();

        UserAccount user = users.get(username);

        if (user.checkPassword(password)) {
            currentUser = user;
            System.out.println("Login successful!");
        } else {
            System.out.println("Invalid password. Please try again.");
        }
    }

    public void logout() {
        if (currentUser == null) {
            System.out.println("No user is currently logged in.");
        } else {
            System.out.println(currentUser.getUsername() + " has been logged out.");
            currentUser = null;
        }
    }
public class JavaApplication9 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        UserAccountSystem accountSystem = new UserAccountSystem();
        Scanner scanner = new Scanner(System.in);

        boolean running = true;
        while (running) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Create User Account");
            System.out.println("2. Login");
            System.out.println("3. Logout");
            System.out.println("4. Exit");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    accountSystem.createUser();
                    break;
                case 2:
                    accountSystem.login();
                    break;
                case 3:
                    accountSystem.logout();
                    break;
                case 4:
                    running = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option not existing. Please select a valid option.");
                   /** when the user choose invalid option*/
            }
        }

        scanner.close();
    }
}
          }
    

