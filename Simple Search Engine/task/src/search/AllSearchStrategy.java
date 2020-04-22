package search;

import java.util.*;

public class AllSearchStrategy implements SearchStrategy {
    @Override
    public void findPerson(Scanner scanner, List<Person> persons, Map<String, List<Integer>> map) {
        String[] search = scanner.nextLine().split("\\s");
        System.out.println();
        Set<Person> set = new HashSet<>();
        boolean flag = false;
        for (Person p: persons
             ) {
            if (containAll(search, p)){
                set.add(p);
                flag = true;
            }
        }
        if (!flag) System.out.println("No matching people found.");
        else {
            System.out.printf("%d persons found:", set.size());
            System.out.println();
            set.forEach(p -> System.out.println(p.getData()));
        }
    }

    private boolean containAll(String[] search, Person person){
        boolean flag = true;
        for (String s: search
        ) {
            if (!person.getData().toLowerCase().contains(s.toLowerCase())){
                flag = false;
                break;
            }
        }
        return flag;
    }
}
