package interviewAsked.kartezya;
/*
Welcome to JDoodle!

You can execute code here in 88 languages. Right now you’re in the Java IDE.

  1. Click the orange Execute button ▶ to execute the sample code below and see how it works.

  2. Want help writing or debugging code? Type a query into JDroid on the right hand side ---------------->

  3.Try the menu buttons on the left. Save your file, share code with friends and open saved projects.

Want to change languages? Try the search bar up the top.
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class MyClass {
    public static class Person implements Comparable<Person>{
        private String name;
        private int age;
        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
        
        public int compareTo(Person p) {
            return this.age - p.age;
        }
        
    }
    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        list.add(new Person("A", 12));
        list.add(new Person("B", 15));
        list.add(new Person("C", 13));
        Collections.sort(list); // Time complexity: O(n log n)
        
        for (Person person : list) {
            System.out.println(person.name + " " + person.age);
        }
        
    }

}