import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Optional<Person> p = Person.createPerson(10);
        Map<String, Integer> m = new HashMap<>();
        m.put("Joseph", 33);
        Optional<Integer> age = Optional.ofNullable(m.get("Youssef"));
        p.get().tell();
    }
}
