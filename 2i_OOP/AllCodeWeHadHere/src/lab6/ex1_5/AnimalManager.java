package lab6.ex1_5;

public class AnimalManager {
    public static void main(String[] args) {
        Cat cat = new Cat("Doraemon");
        Dog dog = new Dog("Shiba");

        //Test toString()
        System.out.println(cat);
        System.out.println("Greets of the cat: ");
        cat.greets();

        System.out.println(dog);
        System.out.println("Greets of the dog: ");
        dog.greets();

        Dog anotherDog = new Dog("Unknown");
        System.out.println("When a unknown dog meet Shiba, Shiba will: ");
        dog.greets(anotherDog);
    }
}
