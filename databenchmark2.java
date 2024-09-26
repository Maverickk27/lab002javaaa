import java.util.*;

public class DataStructuresBenchmark {

    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 100000, 1000000};

        for (int size : sizes) {
            System.out.println("\n===== Benchmark for size: " + size + " =====");
            benchmarkArray(size);
            benchmarkArrayList(size);
            benchmarkLinkedList(size);
            benchmarkHashSet(size);
        }
    }

    // Common method to measure time for operations
    public static long measureTime(Runnable operation) {
        long startTime = System.nanoTime();
        operation.run();
        return System.nanoTime() - startTime;
    }

    // Benchmark for Array (using ArrayList as we can't dynamically resize a primitive array)
    public static void benchmarkArray(int size) {
        ArrayList<Integer> array = new ArrayList<>(size);

        System.out.println("Array (ArrayList) - Insert Tail Time: " +
                measureTime(() -> {
                    for (int i = 0; i < size; i++) array.add(i);
                }) + " ns");

        System.out.println("Array (ArrayList) - Read by Index Time: " +
                measureTime(() -> {
                    for (int i = 0; i < size; i++) array.get(i);
                }) + " ns");

        System.out.println("Array (ArrayList) - Read by Value Time: " +
                measureTime(() -> {
                    for (int i = 0; i < size; i++) array.contains(i);
                }) + " ns");

        System.out.println("Array (ArrayList) - Insert Head Time: " +
                measureTime(() -> array.add(0, -1)) + " ns");

        System.out.println("Array (ArrayList) - Insert Mid Time: " +
                measureTime(() -> array.add(size / 2, -1)) + " ns");

        System.out.println("Array (ArrayList) - Delete Head Time: " +
                measureTime(() -> array.remove(0)) + " ns");

        System.out.println("Array (ArrayList) - Delete Mid Time: " +
                measureTime(() -> array.remove(size / 2)) + " ns");

        System.out.println("Array (ArrayList) - Delete Tail Time: " +
                measureTime(() -> array.remove(array.size() - 1)) + " ns");
    }

    // Benchmark for ArrayList
    public static void benchmarkArrayList(int size) {
        ArrayList<Integer> arrayList = new ArrayList<>(size);

        System.out.println("ArrayList - Insert Tail Time: " +
                measureTime(() -> {
                    for (int i = 0; i < size; i++) arrayList.add(i);
                }) + " ns");

        System.out.println("ArrayList - Read by Index Time: " +
                measureTime(() -> {
                    for (int i = 0; i < size; i++) arrayList.get(i);
                }) + " ns");

        System.out.println("ArrayList - Read by Value Time: " +
                measureTime(() -> {
                    for (int i = 0; i < size; i++) arrayList.contains(i);
                }) + " ns");

        System.out.println("ArrayList - Insert Head Time: " +
                measureTime(() -> arrayList.add(0, -1)) + " ns");

        System.out.println("ArrayList - Insert Mid Time: " +
                measureTime(() -> arrayList.add(size / 2, -1)) + " ns");

        System.out.println("ArrayList - Delete Head Time: " +
                measureTime(() -> arrayList.remove(0)) + " ns");

        System.out.println("ArrayList - Delete Mid Time: " +
                measureTime(() -> arrayList.remove(size / 2)) + " ns");

        System.out.println("ArrayList - Delete Tail Time: " +
                measureTime(() -> arrayList.remove(arrayList.size() - 1)) + " ns");
    }

    // Benchmark for LinkedList
    public static void benchmarkLinkedList(int size) {
        LinkedList<Integer> linkedList = new LinkedList<>();

        System.out.println("LinkedList - Insert Tail Time: " +
                measureTime(() -> {
                    for (int i = 0; i < size; i++) linkedList.add(i);
                }) + " ns");

        System.out.println("LinkedList - Read by Index Time: " +
                measureTime(() -> {
                    for (int i = 0; i < size; i++) linkedList.get(i);
                }) + " ns");

        System.out.println("LinkedList - Read by Value Time: " +
                measureTime(() -> {
                    for (int i = 0; i < size; i++) linkedList.contains(i);
                }) + " ns");

        System.out.println("LinkedList - Insert Head Time: " +
                measureTime(() -> linkedList.addFirst(-1)) + " ns");

        System.out.println("LinkedList - Insert Mid Time: " +
                measureTime(() -> linkedList.add(size / 2, -1)) + " ns");

        System.out.println("LinkedList - Delete Head Time: " +
                measureTime(() -> linkedList.removeFirst()) + " ns");

        System.out.println("LinkedList - Delete Mid Time: " +
                measureTime(() -> linkedList.remove(size / 2)) + " ns");

        System.out.println("LinkedList - Delete Tail Time: " +
                measureTime(() -> linkedList.removeLast()) + " ns");
    }

    // Benchmark for HashSet
    public static void benchmarkHashSet(int size) {
        HashSet<Integer> hashSet = new HashSet<>();

        System.out.println("HashSet - Insert Time: " +
                measureTime(() -> {
                    for (int i = 0; i < size; i++) hashSet.add(i);
                }) + " ns");

        System.out.println("HashSet - Read by Value Time: " +
                measureTime(() -> {
                    for (int i = 0; i < size; i++) hashSet.contains(i);
                }) + " ns");

        System.out.println("HashSet - Delete Time: " +
                measureTime(() -> {
                    for (int i = 0; i < size; i++) hashSet.remove(i);
                }) + " ns");
    }
}
