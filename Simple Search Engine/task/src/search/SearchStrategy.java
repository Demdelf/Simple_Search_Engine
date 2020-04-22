package search;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public interface SearchStrategy {
    void findPerson(Scanner scanner, List<Person> persons, Map<String, List<Integer>> map);
}
