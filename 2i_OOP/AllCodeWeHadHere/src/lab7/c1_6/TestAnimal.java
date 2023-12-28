package lab7.c1_6;

public class TestAnimal {
    public static void main(String[] args) {
        // Using the subclasses
        Cat cat1 = new Cat("Meo");
        cat1.greets();
        Dog dog1 = new Dog("Gau");
        dog1.greets();
        BigDog bigDog1 = new BigDog("GauGau");
        bigDog1.greets(dog1);

        // Using Polymorphism
        Animal animal1 = new Cat("Meo");
        animal1.greets();
        Animal animal2 = new Dog("Gau");
        animal2.greets();
        Animal animal3 = new BigDog("GauGau");
        animal3.greets();

        // Downcast
        Dog dog2 = (Dog)animal2;
        BigDog bigDog2 = (BigDog)animal3;
        Dog dog3 = (Dog)animal3;
        dog2.greets(dog3);
        dog3.greets(dog2);
        dog2.greets(bigDog2);
        bigDog2.greets(dog2);
        bigDog2.greets(bigDog1);
    }

}
