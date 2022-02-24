package labs.lab3;

import org.junit.jupiter.api.*;

import java.io.*;


import static labs.lab3.Main.*;
import static org.junit.jupiter.api.Assertions.*;


class Lab3Test {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void before() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void after() {
        System.out.flush();
        System.setOut(originalOut);
    }

    @Test
    public void problem1() {
        assertEquals(2, problem1_maxBlock("hoopla"));
        assertEquals(3, problem1_maxBlock("abbCCCddBBBxx"));
        assertEquals(0, problem1_maxBlock(""));
    }

    @Test
    public void problem2() {
        assertEquals("ab", Main.problem2_sameEnds("abXYab"));
        assertEquals("x", Main.problem2_sameEnds("xx"));
        assertEquals("x", Main.problem2_sameEnds("xxx"));
        assertEquals("", Main.problem2_sameEnds("Robert"));
        assertEquals("", Main.problem2_sameEnds("Robertr"));
    }

    @Test
    public void problem3() {
        assertTrue(problem3_rHappy("xxrrxx"));
        assertFalse(problem3_rHappy("xxrxx"));
        assertFalse(problem3_rHappy("xxrryyrxx"));
        assertTrue(problem3_rHappy("1234"));
        assertTrue(problem3_rHappy(""));
    }

    @Test
    public void problem4() {
        DataSet data = new DataSet();
        data.add(40);
        data.add(12.5);
        data.add(-280.887);
        data.add(9);

        assertEquals(-219.387, data.getSum());
        assertEquals(-54.84675, data.getAverage());
        assertEquals(-280.887, data.getSmallest());
        assertEquals(40, data.getLargest());
        assertEquals(320.887, data.getRange());
        assertEquals(4, data.getCount());
        assertEquals(-280.887, data.getSmallest());
        assertEquals(-280.887, data.getSmallest());

        data.add(10);
        assertEquals(-209.387, data.getSum());
        assertEquals(5, data.getCount());
    }

    @Test
    public void problem5() {
        PrimeGenerator generator = new PrimeGenerator();
        int[] primes = new int[] {2,3,5,7,11,13,17,19};
        for (int prime : primes) {
            assertEquals(prime, generator.nextPrime());
        }
    }

    @Test
    public void problem6() {
        assertArrayEquals(new int[]{1, 2}, problem6_post3(new int[]{2, 3, 1, 2}));
        assertArrayEquals(new int[]{2}, problem6_post3(new int[]{3, 1, 3, 2}));
        assertArrayEquals(new int[]{1, 2, 4}, problem6_post3(new int[]{3, 3, 1, 2, 4}));
        assertArrayEquals(new int[]{}, problem6_post3(new int[]{1, 3, 3}));
    }

    @Test
    public void problem7() {
        assertEquals(2, problem7_countClumps(new int[]{1, 2, 2, 3, 4, 4}));
        assertEquals(2, problem7_countClumps(new int[]{1, 1, 2, 1, 1}));
        assertEquals(1, problem7_countClumps(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1}));
        assertEquals(0, problem7_countClumps(new int[]{}));
    }

    @Test
    public void problem8() {
        double[] arr1 = new double[]{3.2, 4.5, 8.0, 9.34, 10.0, 0.75};
        ExperimentData data1 = new ExperimentData(arr1);

        assertSame(arr1, data1.getValues());
        assertArrayEquals(arr1, data1.getValues()); // returns [3.2, 4.5, 8.0, 9.34, 10.0, 0.75]
        data1.smooth();

        assertSame(arr1, data1.getValues());
        assertArrayEquals(new double[]{3.85, 5.233333333333333, 7.28, 9.113333333333333, 6.696666666666666, 5.375},
                data1.getValues());

        double[] arr2 = new double[]{3, 6.2};
        ExperimentData data2 = new ExperimentData(arr2);
        assertSame(arr2, data2.getValues());
        data2.smooth();
        assertSame(arr2, data2.getValues());
        assertArrayEquals(new double[]{4.6, 4.6}, data2.getValues());
    }

    @Test
    public void problem9() {
        SeatingChart chart = new SeatingChart();
        String seating = "40 50 50 50 40" + System.lineSeparator() +
                "30 40 40 40 30" + System.lineSeparator() +
                "20 30 30 30 20" + System.lineSeparator() +
                "10 20 20 20 10" + System.lineSeparator() +
                "10 10 10 10 10" + System.lineSeparator();
        assertEquals(seating, chart.getSeatingChart());

        chart.sellSeatByNumber('D', 5);
        chart.sellSeatByNumber('B', 2);
        chart.sellSeatByNumber('b', 3);
        chart.sellSeatByPrice(10);
        chart.sellSeatByPrice(10);
        chart.sellSeatByPrice(30);
        chart.getSeatingChart();
        seating = "40 50 50 50 40" + System.lineSeparator() +
                " 0  0 40 40 30" + System.lineSeparator() +
                "20 30 30 30 20" + System.lineSeparator() +
                " 0 20 20 20  0" + System.lineSeparator() +
                " 0 10 10 10 10" + System.lineSeparator();
        assertEquals(seating, chart.getSeatingChart());
    }

    @Test
    public void problem10() {
        Sequence firstSequence = new Sequence();
        firstSequence.add(1);
        firstSequence.add(4);
        firstSequence.add(9);
        firstSequence.add(16);

        Sequence secondSequence = new Sequence();
        secondSequence.add(9);
        secondSequence.add(7);
        secondSequence.add(4);
        secondSequence.add(9);
        secondSequence.add(11);

        Sequence appendedSequence = firstSequence.append(secondSequence);
        assertEquals("[1, 4, 9, 16, 9, 7, 4, 9, 11]", appendedSequence.toString());
        assertEquals("[1, 4, 9, 16]", firstSequence.toString());
        assertEquals("[9, 7, 4, 9, 11]", secondSequence.toString());

        Sequence mergedSequence = firstSequence.merge(secondSequence);
        assertEquals("[1, 9, 4, 7, 9, 4, 16, 9, 11]", mergedSequence.toString());
        assertEquals("[1, 4, 9, 16]", firstSequence.toString());
        assertEquals("[9, 7, 4, 9, 11]", secondSequence.toString());
    }

}