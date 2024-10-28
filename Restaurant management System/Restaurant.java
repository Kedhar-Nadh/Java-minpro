package Project;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Restaurant {
    static HashMap<Integer, Item> items;
    Cart cart;
    Scanner sc;

    public Restaurant() {
        items = new HashMap<>();
        cart = new Cart();
        sc = new Scanner(System.in);
        initializeItems(); // Populate initial items
    }

    void initializeItems() {
        items.put(1, new Item(1, "Chicken Biryani", "Biryani", 150));
        items.put(2, new Item(2, "Veg Biryani", "Biryani", 130));
        items.put(3, new Item(3, "Mango Juice", "Drinks", 50));
        items.put(4, new Item(4, "Lemonade", "Drinks", 30));
        items.put(5, new Item(5, "Spring Rolls", "Starters", 70));
    }

    static void menu() {
        System.out.println("****** Welcome To Restaurant Management System ***** "
                + "\n0. Menu" + "\n1. Add Item to Cart" + "\n2. Show Cart" + "\n3. Remove Item from Cart"
                + "\n4. View All Items" + "\n5. Print Total Bill" + "\n6. Exit ");
    }

    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();
        while (true) {
            menu();
            int choice = restaurant.sc.nextInt();

            switch (choice) {
                case 0:
                    restaurant.displayItems();
                    break;
                case 1:
                    System.out.println("Enter Item ID to add to cart:");
                    int itemId = restaurant.sc.nextInt();
                    Item item = items.get(itemId);
                    if (item != null) {
                        restaurant.cart.addItem(item);
                    } else {
                        System.out.println("Item not found.");
                    }
                    break;
                case 2:
                    restaurant.cart.showItems();
                    break;
                case 3:
                    System.out.println("Enter Item ID to remove from cart:");
                    int removeId = restaurant.sc.nextInt();
                    restaurant.cart.removeItem(removeId);
                    break;
                case 4:
                    restaurant.displayItems();
                    break;
                case 5:
                    double totalBill = restaurant.cart.calculateTotal();
                    System.out.println("Total Bill: $" + totalBill);
                    System.out.println("Thanks! Visit Again");
                    break;
                case 6:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    void displayItems() {
        System.out.println("Available Items:");
        for (Map.Entry<Integer, Item> entry : items.entrySet()) {
            Item item = entry.getValue();
            System.out.println(item.id + " --- " + item.name + " --- $" + item.price + " --- " + item.category);
        }
    }
}