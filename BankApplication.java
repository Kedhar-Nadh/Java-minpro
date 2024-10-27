package MiniProj;

import java.util.*;

public class BankApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Create an array to store up to 5 accounts
        Account[] accounts = new Account[5];
        int accountCount = 0;

        // Simple menu loop for banking operations
        while (true) {
            System.out.println("\n1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Display Account Info");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    if (accountCount < accounts.length) {
                        System.out.print("Enter account number: ");
                        String accNumber = scanner.nextLine();
                        System.out.print("Enter account holder name: ");
                        String accHolder = scanner.nextLine();
                        System.out.print("Enter initial balance: ");
                        double balance = scanner.nextDouble();
                        
                        accounts[accountCount] = new Account(accNumber, accHolder, balance);
                        accountCount++;
                        System.out.println("Account created successfully!");
                    } else {
                        System.out.println("Cannot create more accounts. Limit reached.");
                    }
                    break;
                
                case 2:
                    System.out.print("Enter account number for deposit: ");
                    String depositAccNum = scanner.nextLine();
                    Account depositAccount = findAccount(accounts, depositAccNum);
                    if (depositAccount != null) {
                        System.out.print("Enter amount to deposit: ");
                        double amount = scanner.nextDouble();
                        depositAccount.deposit(amount);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;
                
                case 3:
                    System.out.print("Enter account number for withdrawal: ");
                    String withdrawAccNum = scanner.nextLine();
                    Account withdrawAccount = findAccount(accounts, withdrawAccNum);
                    if (withdrawAccount != null) {
                        System.out.print("Enter amount to withdraw: ");
                        double amount = scanner.nextDouble();
                        withdrawAccount.withdraw(amount);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;
                
                case 4:
                    System.out.print("Enter account number to display info: ");
                    String displayAccNum = scanner.nextLine();
                    Account displayAccount = findAccount(accounts, displayAccNum);
                    if (displayAccount != null) {
                        displayAccount.displayAccountInfo();
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;
                
                case 5:
                    System.out.println("Exiting application.");
                    scanner.close();
                    return;
                
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    // Helper method to find an account by account number
    public static Account findAccount(Account[] accounts, String accountNumber) {
        for (Account acc : accounts) {
            if (acc != null && acc.getAccountNumber().equals(accountNumber)) {
                return acc;
            }
        }
        return null;
    }
}