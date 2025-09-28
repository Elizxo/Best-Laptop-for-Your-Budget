import java.util.*;

class Laptop {
    String name;
    double price;
    int batteryLife; // Gaming mins it lasted based on Jareds Tech

    Laptop(String name, double price, int batteryLife) {
        this.name = name;
        this.price = price;
        this.batteryLife = batteryLife;
    }
}

public class LaptopForBudget {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Laptop list 
        // List is not completed
        // Unavaible is not shown to the user but is in the list (-1)
        List<Laptop> laptops = Arrays.asList(
                new Laptop("ASUS Vivobook Pro 16X OLED (Ryzen 9 5900HX/3050 Ti 50W) 96Wh", 1449.99, 176),
                new Laptop("Lenovo Legion 5 (2025) - (AMD Ryzen AI 7 350/5070 8GB 115W) 80Wh", 1117.74, 174),
                new Laptop("Acer Triton 14 (2025) - (Intel Core Ultra 9 288V/5070 8GB 97-110W) 76Wh", 1949.99, 172),
                new Laptop("Alienware 16 Aurora (2025) - (Intel Core 7 240H/5060 8GB 80W) 96Wh", 1249.99, 172),
                new Laptop("ASUS Zenbook 14 OLED (2024) - (Intel Ultra 9 185H/Intel Arc Graphics) 75Wh", 1299.99, 168),
                new Laptop("Lenovo Legion Slim 7i (2023) - (i9-13900H/4070 90-140W) 99.9Wh", -1, 162),
                new Laptop("Gigabyte Aero X16 (2025) - (AMD Ryzen AI 7 350/5070 8GB 75-85W) 76Wh", 1299.99, 157),
                new Laptop("Alienware 16X Aurora (2025) - (Intel Core Ultra 9 275HX/5070 8GB 100-115W) 96Wh", 1999.99, 148),
                new Laptop("Razer Blade 14 (2025) - (AMD Ryzen AI 9 365/5070 8GB 113-125W) 72Wh", 1699.99, 146),
                new Laptop("MSI Creator 15 (i7-10875H/2060 80W) 99.9Wh", -1, 146),
                new Laptop("Acer Swift 3 (Ryzen 7 4700U/Radeon Graphics) 48Wh", 700.00, 145),
                new Laptop("Lenovo LOQ 16 (2023) (i7-13700H/4060 8GB 98-115W) 80Wh", -1, 144),
                new Laptop("ASUS TUF A14 (2024) - (Ryzen AI 9 HX 370/4060 8GB 86-100W) 73Wh", 999.00, 144),
                new Laptop("ASUS Zephyrus G16 (2025) - (Intel Core Ultra 9 285H/5070 Ti 12GB 105-125W) 90Wh", 2629.99, 143),
                new Laptop("Lenovo Legion 5 (Ryzen 7 4800H/1660 Ti 80W) 80Wh", 994.00, 140),
                new Laptop("MSI Vector 16 HX (2025) - (Intel Core Ultra 9 275HX/5070 Ti 12GB 120-140W) 90Wh", 1499.99, 139),
                new Laptop("ASUS Zephyrus G16 (2024) - (Intel Ultra 9 185H/4070 8GB 95-115W) 90Wh", 1899.99, 139), // fixed price
                new Laptop("Alienware m15 R5 (2021) - (Ryzen 9 5900HX/3070 110-125W) 86Wh", -1, 139),
                new Laptop("Alienware m16 R2 (2024) - (Intel Ultra 9 185H/4070 8GB 100-140W) 90Wh", 1899.99, 138),
                new Laptop("Lenovo Legion 5 (2021) - (Ryzen 7 5800H/3060 115-130W) 80Wh", 900.00, 136),
                new Laptop("Lenovo Legion 5i (2025) - (Intel Core Ultra 7 255HX/5070 8GB 115W) 80Wh", 1249.99, 136),
                new Laptop("Lenovo Legion Slim 5i (2023) - (i7-13700H/4060 8GB 103-140W) 80Wh", -1, 136)
        );

        while (true) {
            System.out.println("\n--- Laptop Menu ---");
            System.out.println("1. Enter budget");
            System.out.println("2. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.print("Enter your budget: $");
                double budget = scanner.nextDouble();

                System.out.println("\nPrice Budget: $" + budget);
                System.out.println("Laptops under your budget:\n");

                // Laptop Fliter with price <= budget and price != -1
                List<Laptop> filtered = new ArrayList<>();
                for (Laptop l : laptops) {
                    if (l.price != -1 && l.price <= budget) {
                        filtered.add(l);
                    }
                }
          
                // Sort by battery life (descending)
                filtered.sort((a, b) -> b.batteryLife - a.batteryLife);

                if (filtered.isEmpty()) {
                    System.out.println("No laptops found under this budget.");
                } else {
                    for (Laptop l : filtered) {
                        System.out.printf("%s | $%.2f | Battery: %d mins%n", l.name, l.price, l.batteryLife);
                    }
                }
            } else if (choice == 2) {
                System.out.println("Exiting... Goodbye!");
                break;
            } else {
                System.out.println("Invalid option. Try again.");
            }
        }

        scanner.close(); // Still needs error handling 
    }
}
