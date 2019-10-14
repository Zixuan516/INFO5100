package assignment5.Q4;

public class TestQ4 {
    public static void main(String[] args) {
        try {
            throw new MyIndexOutOfBoundException(0, 9, 10);
        } catch (MyIndexOutOfBoundException e) {
            System.out.println(e.toString());
        }
    }
}
