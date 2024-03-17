import java.util.ArrayList;
import java.util.Scanner;

class Store {
    String name, email, phoneNumber, product;
    int amount;

    Store(String name, String email, String phoneNumber, String product, int amount) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.product = product;
        this.amount = amount;
    }
}

public class Main {
    public static void main(String[] args) {
        String[] watchBrands = {"Rolex", "Casio", "Seiko", "Omega"};
        ArrayList<Store> customers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        String[][] brandMapping = {
                {"Watch1", "Rolex"},
                {"Watch2", "Armani"},
                {"Watch3", "Gucci"},
                {"Watch4", "Omega"}
        };

        for (int i = 0; i < 3; i++) {
            System.out.println("Введите ФИО:");
            String name = scanner.nextLine();
            System.out.println("Введите email:");
            String email = scanner.nextLine();
            System.out.println("Введите номер телефона:");
            String phoneNumber = scanner.nextLine();

            System.out.println("Список доступных товаров:");
            for (int j = 0; j < brandMapping.length; j++) {
                System.out.println((j + 1) + ". " + brandMapping[j][0] + " - " + brandMapping[j][1]);
            }

            System.out.println("Выберите товар (введите номер):");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice >= 1 && choice <= brandMapping.length) {
                String product = brandMapping[choice - 1][0];
                System.out.println("Введите количество:");
                int amount = scanner.nextInt();
                scanner.nextLine();
                customers.add(new Store(name, email, phoneNumber, product, amount));
                System.out.println("Заказ добавлен.");
            } else {
                System.out.println("Неверный выбор.");
            }
        }

        System.out.println("\nИнформация о заказах:");
        for (Store customer : customers) {
            System.out.println("Заказчик: " + customer.name);
            System.out.println("Email: " + customer.email);
            System.out.println("Номер телефона: " + customer.phoneNumber);
            System.out.println("Товар: " + customer.product + " - " + getBrandName(brandMapping, customer.product));
            System.out.println("Кол-во: " + customer.amount);
            System.out.println();
        }
    }

    private static String getBrandName(String[][] brandMapping, String product) {
        for (String[] mapping : brandMapping) {
            if (mapping[0].equals(product)) {
                return mapping[1];
            }
        }
        return null;
    }
}
