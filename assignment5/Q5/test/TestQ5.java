package assignment5.Q5.test;

import assignment5.Q5.cat.Cat;
import assignment5.Q5.dog.Dog;

public class TestQ5 {
    public static void main(String[] args) {
        Cat cat = new Cat("cat", "catOwner", "red", "long");
        Dog dog = new Dog("dog", "dogOwner", "black", "small");
        cat.setSex(2);
        dog.setSex(2);
        System.out.println(cat.toString());
        System.out.println(dog.toString());
    }
}
