package assignment5.Q3;

public class FullTime extends Employee {
    private static final int WORKING_HOURS = 8;

    public FullTime(String name, int paymentPerHour) {
        super(name, paymentPerHour);
    }

    public int calculateSalary() {
        return WORKING_HOURS * getPaymentPerHour();
    }
}
