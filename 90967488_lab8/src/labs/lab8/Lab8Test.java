package labs.lab8;

import org.junit.jupiter.api.*;

import java.awt.*;
import java.util.ArrayList;

import static labs.lab8.Main.*;
import static org.junit.jupiter.api.Assertions.*;

public class Lab8Test {

    @Test
    public void problem1() {
        Pair<String, Integer> p = new Pair<>("Lucky Number", 13);
        Pair<Integer, String> q = problem1_swap(p);
        assertEquals(13, q.getFirst());
        assertEquals("Lucky Number", q.getSecond());

        Pair<Double, Boolean> r = new Pair<>(8.5, false);
        Pair<Boolean, Double> s = problem1_swap(r);
        assertFalse(s.getFirst());
        assertEquals(8.5, s.getSecond());
    }

    @Test
    public void problem2() {
        String[] words = {"Mary", "had", "a", "little", "lamb"};
        // (using Lambda expression here for brevity in this example; Lambda expressions will be covered in week 10):
        assertEquals("little", Measurer.max(words, s -> s.length()));

        // this example uses java.awt.Rectangle:
        Rectangle[] rects = {
                new Rectangle(1, 2, 10, 20),
                new Rectangle(5, 15, 17, 23),
                new Rectangle(9, 15, 25, 22),
                new Rectangle(12, 8, 18, 23)};
        // (using Lambda expression here for brevity in this example; Lambda expressions will be covered in week 10):
        Rectangle rectangle = Measurer.max(rects, r -> r.getWidth() * r.getHeight());
        assertEquals(rects[2], rectangle);
    }

    @Test
    public void problem3() {
        ArrayList<Person> a = new ArrayList<>();
        ArrayList<Student> b = new ArrayList<>();
        a.add(new Person("Fred"));
        a.add(new Person("Sally"));
        b.add(new Student("Bob", "Bioinformatics"));
        b.add(new Student("Rubia", "Computer Science"));
        problem3_append(a, b);

        // a now contains Fred, Sally, Bob, Rubia
        assertTrue(a.containsAll(b));
    }

    @Test
    public void problem4() {
        ArrayList<String> a = new ArrayList<>();
        a.add("apple");
        a.add("orange");
        a.add("pear");
        a.add("banana");
        ArrayList<String> b = problem4_reverse(a);
        assertEquals("apple", b.get(3));
        assertEquals("orange", b.get(2));
        assertEquals("pear", b.get(1));
        assertEquals("banana", b.get(0));

// a now contains: apple, orange, pear, banana
// b now contains banana, pear, orange, apple
        ArrayList<Integer> c = new ArrayList<>();
        c.add(1);
        c.add(2);
        c.add(3);
        c.add(4);
        ArrayList<Integer> d = problem4_reverse(c);
// c now contains: 1, 2, 3, 4
// d now contains: 4, 3, 2, 1
        assertEquals(3, d.get(1));
    }

    @Test
    public void problem5() {
        Integer[] nums = { 10, 100, 50, 15, 8, 99 };
        Pair<Integer, Integer> mm = problem5_minmax(nums);
        assertEquals(8, mm.getFirst());
        assertEquals(100, mm.getSecond());

        String[] strs = { "Java", "C++", "Python", "JavaScript", "Lua" };
        Pair<String, String> mm2 = problem5_minmax(strs);
        assertEquals("C++", mm2.getFirst());
        assertEquals("Python", mm2.getSecond());
    }
}
