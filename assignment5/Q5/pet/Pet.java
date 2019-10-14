package assignment5.Q5.pet;

import assignment5.Q5.helpers.SexType;

import static assignment5.Q5.helpers.SexType.FEMALE;
import static assignment5.Q5.helpers.SexType.MALE;
import static assignment5.Q5.helpers.SexType.SPAYED;
import static assignment5.Q5.helpers.SexType.NEUTERED;

public class Pet {
    private String name;
    private String ownerName;
    private String color;
    protected SexType sexType;

    public Pet(String name, String ownerName, String color) {
        this.name = name;
        this.ownerName = ownerName;
        this.color = color;
    }

    public String getPetName() {
        return name;
    }

    public String getOwnerName() {
        return  ownerName;
    }

    public String getColor() {
        return color;
    }

    public void setSex(int sexId) {
        if (sexId == 0) {
            sexType = MALE;
        } else if (sexId == 1) {
            sexType = FEMALE;
        } else if (sexId == 2) {
            sexType = SPAYED;
        } else if (sexId == 3) {
            sexType = NEUTERED;
        } else {
            throw new IllegalArgumentException(String.format("sexId %d is not valid id. Valid id is 0-3.", sexId));
        }
    }

    public String getSex() {
        return sexType.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getPetName()).append("owned by ").append(getOwnerName())
                .append("\n")
                .append("Color: ").append(getColor())
                .append('\n')
                .append("Sex: ").append(getSex());
        return sb.toString();
    }

}

