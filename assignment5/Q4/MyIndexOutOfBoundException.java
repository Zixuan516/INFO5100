package assignment5.Q4;

public class MyIndexOutOfBoundException extends RuntimeException {
    private int lowerBound;
    private int upperBound;
    private int index;

    public MyIndexOutOfBoundException(int lowerBound, int upperBound, int index) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        this.index = index;
    }

    public String toString(){
        return String.format("Error Message: Index: %d, but Lower bound: %d, Upper bound: %d", index, lowerBound, upperBound);
    }




}
