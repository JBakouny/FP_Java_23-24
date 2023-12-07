package lb.esib.variance;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Person {
    Person get() {return null;} //covariance on return type
    void fail() throws Exception {

    }
}

class Joe extends Person {
    JoeJr get() {
        return null;
    }
    void fail() throws IOException {

    }
}

class JoeImpl extends Joe {
    public JoeJr get() { return null;} // overridden
    public void fail() throws IOException {} // overridden
}

class JoeJr extends Joe {}


public class Variance {
    public static void main(String[] args) {
        // Type hierarchy: Person :> Joe :> JoeJr
//        List<Person> p = new ArrayList<Joe>(); // COMPILE ERROR (a bit counterintuitive, but remember List<Person> is invariant)
//        List<Joe> j = new ArrayList<Person>(); // COMPILE ERROR

        // Type hierarchy: Person :> Joe :> JoeJr
        List<Person> p = new ArrayList<>();
        p.add(new Person()); // ok
        p.add(new Joe()); // ok
        p.add(new JoeJr()); // ok

        // Type hierarchy: Person :> Joe :> JoeJr
//        List<Joe> joes = new ArrayList<>();
//        Joe j = joes.get(0); // ok
//        Person p = joes.get(0); // ok


        //Covriance
        // Type hierarchy: Person :> Joe :> JoeJr
        List<? extends Joe> superJoe = new ArrayList<Joe>(); // ok
        List<? extends Joe> superJoeJr = new ArrayList<JoeJr>(); // ok
//        List<? extends Joe> = new ArrayList<Person>(); // COMPILE ERROR

        // Type hierarchy: Person :> Joe :> JoeJr
//        List<? extends Joe> joes = new ArrayList<>();
//        Joe j = joes.get(0); // ok
//        Person p = joes.get(0); // ok
//        JoeJr jr = joes.get(0); // compile error (you don't know what subtype of Joe is in the list)


//        // Type hierarchy: Person > Joe > JoeJr
//        List<? extends Joe> joes = new ArrayList<>();
//        joes.add(new Joe());  // compile error (you don't know what subtype of Joe is in the list)
//        joes.add(new JoeJr()); // compile error (ditto)
//        joes.add(new Person()); // compile error (intuitive)
//        joes.add(new Object()); // compile error (intuitive)


        // Type hierarchy: Person > Joe > JoeJr
//        List<? super Joe> joes = new ArrayList<Joe>();  // ok
//        List<? super Joe> joes = new ArrayList<Person>(); // ok
//        List<? super Joe> joes = new ArrayList<JoeJr>(); // COMPILE ERROR

        // Type hierarchy: Person > Joe > JoeJr
//        List<? super Joe> joes = new ArrayList<>();
//        Joe j = joes.get(0); // compile error (could be Object or Person)
//        Person p = joes.get(0); // compile error (ditto)
//        Object o = joes.get(0); // allowed because everything IS-A Object in Java

        // Type hierarchy: Person > Joe > JoeJr
//        List<? super Joe> joes = new ArrayList<>();
//        joes.add(new JoeJr()); // allowed

//        // Type hierarchy: Person > Joe > JoeJr
//        List<? super Joe> joes = new ArrayList<>();
//        joes.add(new Person()); // compile error (again, could be a list of Object or Person or Joe)
//        joes.add(new Object()); // compile error (ditto)

        // Type hierarchy: Person > Joe > JoeJr

// Invariance
//        Function<Person, Joe> personToJoe = null;
//        Function<Joe, JoeJr> joeToJoeJr = null;
//        personToJoe = joeToJoeJr; // COMPILE ERROR (personToJoe is invariant)

// Covariance
//        Function<? extends Person, ? extends Joe> personToJoe = null; // covariant
//        Function<Joe, JoeJr> joeToJoeJr = null;
//        personToJoe = joeToJoeJr;  // ok

// Contravariance
//        Function<? super Joe, ? super JoeJr> joeToJoeJr = null; // contravariant
//        Function<? super Person, ? super Joe> personToJoe = null;
//        joeToJoeJr = personToJoe; // ok
        System.out.println("Hello world!");
    }
}