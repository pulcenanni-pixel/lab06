package it.unibo.collections;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;

import java.util.concurrent.TimeUnit;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {

    private static final int ADD_ELEMS = 100_000;
    private static final int READ_TIMES = 1_000;


    private UseListsAndMaps() {
    }

    /**
     * Program entry point.
     */
    public static void main() {
        int i;
        long time;
        long millis;
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
        List<Integer> integerArrayList = new ArrayList<>();
        for (i = 1000; i < 2000; i++){
            integerArrayList.add(i);
        }
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        List<Integer> integerLinkedList = new LinkedList<>();
        integerLinkedList.addAll(integerArrayList);
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        int temp = integerArrayList.get(0);
        integerArrayList.set(0, integerArrayList.get(integerArrayList.size()-1));
        integerArrayList.set(integerArrayList.size()-1, temp);
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        int counter = 0;
        for (int num : integerArrayList){
            counter++;
            IO.print(num + "\t");
            if (counter % 20 == 0){
                IO.print("\n");
            }
        }
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        time = System.nanoTime();

        for (i = 0; i < ADD_ELEMS; i++) {
            integerArrayList.addFirst(i);
        }
        
        time = System.nanoTime() - time;
        millis = TimeUnit.NANOSECONDS.toMillis(time);
        IO.println(
            "Adding "
                + ADD_ELEMS
                + " ints to the beginning of the ArrayList took "
                + time
                + "ns ("
                + millis
                + "ms)"
        );


        time = System.nanoTime();    

        for (i = 0; i < ADD_ELEMS; i++) {
            integerLinkedList.addFirst(i);
        }
        
        time = System.nanoTime() - time;
        millis = TimeUnit.NANOSECONDS.toMillis(time);
        IO.println(
            "Adding "
                + ADD_ELEMS
                + " ints to the beginning of the LinkedList took "
                + time
                + "ns ("
                + millis
                + "ms)"
        );
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
        time = System.nanoTime();

        for (i = 0; i < READ_TIMES; i++) {
            integerArrayList.get(integerArrayList.size()/2);
        }
        
        time = System.nanoTime() - time;
        millis = TimeUnit.NANOSECONDS.toMillis(time);
        IO.println(
            "Reading "
                + READ_TIMES
                + " times an element in the middle of ArrayList took "
                + time
                + "ns ("
                + millis
                + "ms)"
        );


        time = System.nanoTime();    

        for (i = 0; i < READ_TIMES; i++) {
            integerLinkedList.get(integerLinkedList.size()/2);
        }
        
        time = System.nanoTime() - time;
        millis = TimeUnit.NANOSECONDS.toMillis(time);
        IO.println(
            "Reading "
                + READ_TIMES
                + " times an element in the middle of LinkedList took "
                + time
                + "ns ("
                + millis
                + "ms)"
        );
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */
        Map<String, Long> continents = new HashMap<>();
        continents.put("Africa", 1_110_635_000L);
        continents.put("Americas", 972_005_000L);
        continents.put("Antarctica", 0L);
        continents.put("Asia", 4_298_723_000L);
        continents.put("Europe", 742_452_000L);
        continents.put("Oceania", 38_304_000L);
        /*
         * 8) Compute the population of the world
         */
        long totPopulation = 0L;
        for (String key : continents.keySet()){
            totPopulation+=continents.get(key);
        }
        IO.println("The world population is currently " + totPopulation + " people");
    }
}
