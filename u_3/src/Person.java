public class Person implements Comparable<Person> {
    private String name;
    private int age;
    private String email;

    public Person(String name, int age, String email) {
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public int compareTo(Person otherPerson) {
        return this.email.compareTo(otherPerson.email);
    }

    @Override
    public String toString() {
        return "name: " + getName() + ", age: " + getAge() + ", email: " + getEmail();
    }

}