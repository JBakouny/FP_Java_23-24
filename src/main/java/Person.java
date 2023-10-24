import lb.esib.Singer;

import java.util.Optional;

public class Person {
    public void tell() {
        System.out.println("Bonjour");
    }
    static Optional<Person> createPerson(int age) {
        if (age < 18)
            return Optional.empty();
        return Optional.of(new Person(age));
    }

    public Person(int age) {
        this.age = age;
    }

    private int age;
}


