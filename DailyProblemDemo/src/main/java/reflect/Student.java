package reflect;

/**
 * @author: pinnuli
 * @date: 2019-01-21
 */

public class Student {

    private String name;

    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private void speck(String name) {
        System.out.println("I am " + name);
    }

    @Override
    public String toString() {
        return "name: " + name + "age: " + age;
    }
}
