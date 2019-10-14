package assignment5.Q3;

public class TestQ3 {
    public static void main(String[] args) {
        Contractor lucy = new Contractor("lucy", 2, 7);
        FullTime sam = new FullTime("sam", 3);
        System.out.println(lucy.calculateSalary());
        System.out.println(sam.calculateSalary());
    }
}
