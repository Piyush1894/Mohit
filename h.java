import java.util.*;

class Person implements Comparable<Person> {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Person person) {
        // Compare based on age
        return Integer.compare(this.age, person.age);
    }

    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Alice", 25));
        personList.add(new Person("Bob", 30));
        personList.add(new Person("Charlie", 20));

        // Using compareTo for natural ordering based on age
        Collections.sort(personList);
        System.out.println("Sorted by age (natural order):");
        for (Person person : personList) {
            System.out.println(person.getName() + " - " + person.getAge() + " years old");
        }

        // Using compare for custom ordering based on name
        Comparator<Person> nameComparator = new Comparator<Person>() {
            @Override
            public int compare(Person person1, Person person2) {
                return person1.getName().compareTo(person2.getName());
            }
        };

        // Sorting by name using compare
        Collections.sort(personList, nameComparator);
        System.out.println("\nSorted by name:");
        for (Person person : personList) {
            System.out.println(person.getName() + " - " + person.getAge() + " years old");
        }
    }
}
