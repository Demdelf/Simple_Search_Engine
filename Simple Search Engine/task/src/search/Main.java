package search;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        String fileName = "";

        for (int i = 0; i < args.length; i++){
            if (args[i].equals("--data")){
                fileName = args[i + 1];
                break;
            }
        }
        Scanner fileScanner = new Scanner(new File(/*"D:\\my\\JAVA\\WebTree\\Simple Search Engine" +
                "\\Simple Search Engine\\task\\src\\search\\" + */fileName));


        Scanner scanner = new Scanner(System.in);

        List<Person> persons = new ArrayList<>();

        /*System.out.println("Enter the number of people:");
        int personsNumber = scanner.nextInt();
        scanner.nextLine();*/

        //System.out.println("Enter all people:");
        //for (int i = 0; i < personsNumber; i++){
        while (fileScanner.hasNext()){
            List<String> list = new ArrayList<>();
            list.addAll(Arrays.asList(fileScanner.nextLine().split(" ")));
            if (list.size() == 2){
                persons.add(new Person(list.get(0), list.get(1)));
            }else if (list.size() == 3) persons.add(new Person(list.get(0), list.get(1), list.get(2)));
            else if (list.size() == 1) persons.add(new Person(list.get(0), ""));

        }
        fileScanner.close();

        Map<String, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < persons.size(); i++){
            for (String s: persons.get(i).getStrings()
            ) {
                if (map.containsKey(s)){
                    map.get(s).add(i);
                }else {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    map.put(s, list);
                }
            }
        }


        int menuNumber = 10;
        while (menuNumber != 0){

            System.out.println("=== Menu ===\n" +
                    "1. Find a person\n" +
                    "2. Print all people\n" +
                    "0. Exit");
            menuNumber = scanner.nextInt();
            scanner.nextLine();
            System.out.println();
            switch (menuNumber){
                case 1 :

                    System.out.println("Select a matching strategy: ALL, ANY, NONE");
                    SearchStrategy searchStrategy = null;
                    switch (scanner.nextLine()){
                        case "ALL":
                            searchStrategy = new AllSearchStrategy();
                            break;
                        case "ANY":
                            searchStrategy = new AnySearchStrategy();
                            break;
                        case "NONE":
                            searchStrategy = new NoneSearchStrategy();
                            break;

                    }
                    System.out.println();
                    System.out.println("Enter a name or email to search all suitable people.");

                    searchStrategy.findPerson(scanner, persons, map);
                    break;
                case 2 :
                    System.out.println("=== List of people ===");
                    persons.forEach(p -> System.out.println(p.getData()));
                    break;
                case 0 :
                    System.out.println("Bye!");
                    break;
                default:
                    System.out.println("Incorrect option! Try again.");
                    break;
            }
            System.out.println();
        }




        /*int searchesNumber = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < searchesNumber; i++){
            String search = scanner.nextLine();
            findPerson(scanner, persons);

        }*/

    }

    public static void findPerson(Scanner scanner, List<Person> persons, Map<String, List<Integer>> map){
        String search = scanner.nextLine();
        if (map.containsKey(search)){
            for (Integer i: map.get(search)
            ) {
                System.out.println(persons.get(i).getData());
            }
        }else System.out.println("No matching people found.");

        /*boolean flag = false;
        for (Person p: persons
        ) {
            if (p.getData().toLowerCase().contains(search.toLowerCase())){
                flag = true;
                System.out.println(p.getData());
            }
        }
        if (!flag) System.out.println("No matching people found.");*/
    }

}
