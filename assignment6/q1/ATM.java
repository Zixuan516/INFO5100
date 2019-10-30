package assignment6.q1;

import java.util.*;

public class ATM {
    private double availableAmountInMachine;
    private double transactionFee;
    private Map<String, User> userData;

    public ATM(int availableAmountInMachine, double transactionFee) {
        this.availableAmountInMachine = availableAmountInMachine;
        this.transactionFee = transactionFee;
        this.userData = new HashMap<>();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("are you a NEW USER or CURRENT USER ?");
        String userInfo = scanner.nextLine();
        if (userInfo.equals("NEW USER")) {
            createAccount();
        }
        System.out.println("if you want to login please type in \"login\", if you want to reset your password please type in \"reset\" ");
        String loginOrReset = scanner.nextLine();
        String bankAccount;
        if (loginOrReset.equals("login")) {
            bankAccount = login();
        } else if (loginOrReset.equals("reset")) {
            resetPassword();
            bankAccount = login();
        } else {
            throw new IllegalArgumentException("Invalid option: " + loginOrReset + ". Valid options are \"login\" and \"reset\"");
        }

        startSession(bankAccount);
    }

    private void createAccount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("please enter a bankAccountNumber for your new account");
        String bankAccountNumber = scanner.nextLine();
        while (userData.containsKey(bankAccountNumber)) {
            System.out.println("this bankAccountNumber has been used, please enter a unique bankAccountNumber");
            bankAccountNumber = scanner.nextLine();
        }
        System.out.println("please enter a password for your new account");
        String password = scanner.nextLine();
        User user = new User(bankAccountNumber, password);
        System.out.println("please input your name");
        user.setName(scanner.nextLine());
        System.out.println("please input your age");
        user.setAge(Integer.parseInt(scanner.nextLine()));
        System.out.println("please input your address");
        user.setAddress(scanner.nextLine());
        System.out.println("please input your phone number");
        user.setPhoneNumber(scanner.nextLine());
        userData.put(bankAccountNumber, user);
        System.out.println("created new account successfully, please login");
    }

    private String login() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("please enter your bankAccountNumber");
        String bankAccountNumber = scanner.nextLine();
        System.out.println("please enter your password");
        String password = scanner.nextLine();
        while (!(userData.containsKey(bankAccountNumber) && userData.get(bankAccountNumber).getPassword().equals(password))) {
            System.out.println("the account or the password is wrong, please try again");

            System.out.println("please enter your bankAccountNumber");
            bankAccountNumber = scanner.nextLine();
            System.out.println("please enter your password");
            password = scanner.nextLine();
        }
        System.out.println("login successfully, welcome!");
        return bankAccountNumber;
    }

    private void resetPassword() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("please enter your bankAccountNumber");
        Scanner bankAccountNumber = new Scanner(System.in);

        System.out.println("please enter your name");
        String name = scanner.nextLine();
        System.out.println("please enter your age");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("please enter your phoneNumber");
        String phoneNumber = scanner.nextLine();
        if (userData.containsKey(bankAccountNumber) && name.equals(userData.get(bankAccountNumber).getName()) && age == (userData.get(bankAccountNumber).getAge()) && phoneNumber.equals(userData.get(bankAccountNumber).getPhoneNumber())) {
            System.out.println("please enter your new password");
            String password = scanner.nextLine();
            userData.get(bankAccountNumber).setPassword(password);
            System.out.println("reset password successfully, please login");
        }
    }

    private void startSession(String bankAccountNumber) {
        while (true) {
            System.out.println("Please select what you'd like to do:\n" +
                    "1. get available balance\n" +
                    "2. withdrawal\n" +
                    "3. deposit\n" +
                    "4. get recent transactions\n" +
                    "5. change password\n" +
                    "6. exit");
            Scanner scanner = new Scanner(System.in);
            String option = scanner.nextLine();

            switch (option) {
                case "1":
                    double availableBalance = userData.get(bankAccountNumber).getAvailableBalance();
                    System.out.println(String.format("Available balance for %s: %.3f", bankAccountNumber, availableBalance));
                    break;
                case "2":
                    System.out.println("Please input amount of money you want to withdraw");
                    Double amount = Double.valueOf(scanner.nextLine());
                    withDrawal(bankAccountNumber, amount);
                    break;
                case "3":
                    System.out.println("Please input amount of money you'll deposit");
                    amount = Double.valueOf(scanner.nextLine());
                    deposit(bankAccountNumber, amount);
                    break;
                case "4":
                    recentTransactions(bankAccountNumber);
                    break;
                case "5":
                    changePassword(bankAccountNumber);
                    break;
                case "6":
                    exit();
                    break;
                default:
                    System.out.println("Invalid option " + option + ". Must be 1-6");
            }
        }
    }

    private void withDrawal(String bankAccountNumber, double amount) {
        User user = userData.get(bankAccountNumber);
        if(amount + transactionFee > user.getAvailableBalance()){
            System.out.println("the withdrawal amount should be smaller than your available balance");
            return;
        }
        if(amount > availableAmountInMachine){
            System.out.println("sorry, the available amount in machine is not enough");
            return;
        }
        Transaction transaction = new Transaction("withDrawal", amount);
        user.setAvailableBalance(user.getAvailableBalance() - amount - transactionFee);
        availableAmountInMachine = availableAmountInMachine - amount;
        if(user.getTransaction().size() == 10){
            user.getTransaction().poll();
        }
        user.getTransaction().add(transaction);

        System.out.println(String.format("your withdrawal with %.3f has finished! Your balance is: %.3f", amount, user.getAvailableBalance()));
    }

    private void deposit(String bankAccountNumber, double amount){
        User user = userData.get(bankAccountNumber);
        Transaction transaction = new Transaction("deposit", amount);
        user.setAvailableBalance(user.getAvailableBalance() + amount - transactionFee);
        availableAmountInMachine = availableAmountInMachine + amount;
        if(user.getTransaction().size() == 10){
            user.getTransaction().poll();
        }
        user.getTransaction().add(transaction);

        System.out.println(String.format("your deposit with %.3f has finished! Your balance is: %.3f", amount, user.getAvailableBalance()));
    }

    private void recentTransactions(String bankAccountNumber){
        userData.get(bankAccountNumber).transactionDisplay();
    }

    private void changePassword(String bankAccountNumber){
        Scanner scanner = new Scanner(System.in);

        System.out.println("please enter your new password");
        String password = scanner.nextLine();
        userData.get(bankAccountNumber).setPassword(password);
        System.out.println("change password successfully");
    }

    private void exit(){
        System.exit(0);
    }

}

