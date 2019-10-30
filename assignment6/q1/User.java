package assignment6.q1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class User {
    private String name;
    private int age;
    private String address;
    private String phoneNumber;
    private String bankAccountNumber;
    private String password;
    private double availableBalance;
    private Queue<Transaction> transaction;

    public User(String bankAccountNumber, String password) {
        this.bankAccountNumber = bankAccountNumber;
        this.password = password;
        transaction = new LinkedList<>();
    }

    public void transactionDisplay(){
        ArrayList<Transaction> list = new ArrayList<>(transaction);
        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.println(list.get(i).toString());
        }
    }

    public Queue<Transaction> getTransaction() {
        return transaction;
    }

    public void setTransaction(Queue<Transaction> transaction) {
        this.transaction = transaction;
    }

    public double getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(double availableBalance) {
        this.availableBalance = availableBalance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
