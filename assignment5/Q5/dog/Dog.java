package assignment5.Q5.dog;

import assignment5.Q5.boardable.Boardable;
import assignment5.Q5.helpers.DateValidator;
import assignment5.Q5.pet.Pet;

public class Dog extends Pet implements Boardable {
    private String size;
    private long boardStart, boardEnd;

    public Dog(String name, String ownerName, String color, String size) {
        super(name, ownerName, color);
        this.size = size;
    }

    public String getSize() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DOG:").append('\n')
                .append(getPetName()).append(" owned by ").append(getOwnerName()).append('\n')
                .append("Color: ").append(getColor()).append('\n')
                .append("Sex: ").append(getSex()).append('\n')
                .append("Size: ").append(getSize());
        return sb.toString();
    }

    @Override
    public void setBoardStart(int month, int day, int year) {
        DateValidator.validateDate(month, day, year);
        boardStart = year * 10000 + month * 100 + day;
    }

    @Override
    public void setBoardEnd(int month, int day, int year) {
        DateValidator.validateDate(month, day, year);
        boardEnd = year * 10000 + month * 100 + day;
    }

    @Override
    public boolean boarding(int month, int day, int year) {
        DateValidator.validateDate(month, day, year);
        return (year * 10000 + month * 100 + day >= boardStart && year * 10000 + month * 100 + day <= boardEnd);
    }
}
