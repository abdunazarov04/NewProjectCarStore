import org.been.Car;
import org.been.User;
import org.db.CarDatabase;
import org.db.UserDatabase;

import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static User user;

    private static User currentUser;
    private static UserDatabase userDatabase = new UserDatabase();//TODO: HashMap ga o'zgatring!
    private static CarDatabase carDatabase = new CarDatabase();

    public static void main(String[] args) {


        boolean isRunning = true;
        while (isRunning) {
            System.out.println("Welcome to the Car Store!");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");//TODO: optimal string format kerak
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 ->
                    registerUser();
                case 2 ->
                    loginUser();
                case 3 -> {
                    isRunning = false;
                }
                default ->
                    System.out.println("Invalid choice. Please enter a valid option.");//TODO: optimal switch !! to'gorladim
            }
        }
    }

    private static void registerUser() {
        System.out.println("Welcome to register page!");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        int userId = userDatabase.getUserList().size() + 1;

        User newUser = new User(userId, username, password);
        userDatabase.addUser(newUser);

        System.out.println("User registered successfully!");
    }

    private static void loginUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        for (User user : userDatabase.getUserList()) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                currentUser = user;
                System.out.println("Login successful!");
                showMenu(scanner);
                return;
            } else {
                System.out.println("Invalid username or password!");
            }
        }
        System.out.println("You are not registered please register!");
        registerUser();
    }

    private static void showMenu(Scanner scanner) {
        boolean isLoggedIn = true;
        while (isLoggedIn) {
            System.out.println("\nCar Store Menu:");
            System.out.println("1. Add Car");
            System.out.println("2. My Cars");
            System.out.println("3. Sell My Car");
            System.out.println("4. Buy a Car");
            System.out.println("5. Balance");
            System.out.println("6. Log out");
            System.out.print("Choose an option: ");//TODO: optimal string format kerak
            int choice = scanner.nextInt();

            switch (choice) {
                case 1->
                    addCar();
                case 2 ->
                    showUserCars();
                case 3 ->
                    sellCar();
                case 4 ->
                    buyCar();
                case 5 ->
                    System.out.println("Your Balance is: " + currentUser.getBalance());
                case 6 -> {
                    currentUser = null;
                    isLoggedIn = false;
                }
                default ->
                    System.out.println("Invalid choice. Please enter a valid option.");


            }
        }
    }

    private static void addCar() {
        Scanner scanner = new Scanner(System.in);
        if (currentUser == null) {
            System.out.println("Please log in first.");
            return;
        }

        System.out.print("Enter car name: ");
        String name = scanner.nextLine();
        System.out.print("Enter car color: ");
        String color = scanner.nextLine();
        System.out.print("Enter car price: ");
        int price = scanner.nextInt();

        int carId = carDatabase.getCarList(currentUser.getId()).size() + 1;
        Car newCar = new Car(carId, name, color, currentUser.getId(), price);
        carDatabase.addCar(newCar);

        System.out.println("Car added successfully!");
    }

    private static void showUserCars() {
        if (currentUser == null) {
            System.out.println("Please log in first.");
            return;
        }

        List<Car> userCars = carDatabase.getCarsByUserId(currentUser.getId());

        if (userCars.isEmpty()) {
            System.out.println("You don't have any cars.");
        } else {
            System.out.println("Your cars:");
            for (Car car : userCars) {
                String inStore = car.isInStore() ? "In Store" : "In Garage";
                System.out.println("Car ID: " + car.getId() + ", Name: " + car.getName() + ", Color: " + car.getColor()
                        + ", Status: " + inStore + "car price: " + car.getPrice());//TODO: bu formatda yozish xato to'girliman o'zim
            }
        }
    }


    private static void sellCar() {
      /*  showUserCars();
        System.out.print("Which car to sell enter car id: ");
        int sellId = scanner.nextInt();

        List<Car> userCars = carDatabase.getCarsByUserId(currentUser.getId());

        for (Car car : userCars) {
            if (car != null && car.getId() == sellId) {
                if (user != null) {
                    user.setBalance(user.getBalance() + car.getPrice());
                    System.out.println("Car is sold.");
                }
            } else {
                System.out.println("User object is null. Unable to sell the car.");
            }
            return;
        }
        System.out.println("Car is not found.");*///TODO: Ishlamadi hozir usitda ishlavomma
    }



    private static void buyCar() {
        // Mashina sotib olish logikasi
    }
}
