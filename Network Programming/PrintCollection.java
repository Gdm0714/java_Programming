import java.util.*;

public class PrintCollection{
    public static void main(String [] args){
        HashMap<String, Object> person = new HashMap<>();
        HashMap<String, HashMap<String, Object>> persons = new HashMap<>();

        person.put("name", "이순신");
        person.put("address", "여수시");
        person.put("age", 20);
        persons.add(new HashMap<>(person));
        person.clear();

        person.put("name", "이방원");
        person.put("address", "한양시");
        person.put("age", 30);
        persons.add(new HashMap<>(person));
        person.clear();

        person.put("name", "미도");
        person.put("address", "서울시");
        person.put("age", 42);
        persons.add(new HashMap<>(person));

        Set<String> keySet = persons.keySet();
        System.out.println(keySet.size());

        String [] keys = keySet.toArray(new String[0]);
        System.out.println(keys.length);
        
    }
}