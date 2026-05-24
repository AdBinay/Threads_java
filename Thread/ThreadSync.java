// ThreadSync.java - Demonstrates Thread Synchronization using PrintOdd and PrintEven threads

public class ThreadSync {

    static int number = 1;       // Shared variable: both threads use this counter
    static final int MAX = 100;   // Maximum number to print (stop after reaching this)
    static final Object lock = new Object(); // Shared lock object used for synchronization

    // ─────────────────────────────────────────────
    // Thread 1: Prints ODD numbers (1, 3, 5, ...)
    // ─────────────────────────────────────────────
    static class PrintOdd implements Runnable {

        @Override
        public void run() { // run() is called when the thread starts
            while (number <= MAX) { // Keep looping until we exceed MAX

                synchronized (lock) { // Acquire the lock — only one thread enters at a time

                    // Check if current number is ODD (remainder when divided by 2 is not 0)
                    if (number % 2 != 0) {
                        System.out.println("ODD  Thread → " + number); // Print the odd number
                        number++; // Increment the shared counter
                        lock.notify(); // Wake up the other thread (PrintEven) that is waiting
                    } else {
                        // Current number is even — not our turn, so wait
                        try {
                            lock.wait(); // Release the lock and wait until notified
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt(); // Restore interrupted status
                        }
                    }
                } // Lock is released here (end of synchronized block)

                // Pause for 500ms to slow down output and make the alternation visible
                try {
                    Thread.sleep(500); // sleep() pauses this thread (does NOT release the lock)
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt(); // Restore interrupted status if woken early
                }
            }
        }
    }

    // ─────────────────────────────────────────────
    // Thread 2: Prints EVEN numbers (2, 4, 6, ...)
    // ─────────────────────────────────────────────
    static class PrintEven implements Runnable {

        @Override
        public void run() { // run() is called when the thread starts
            while (number <= MAX) { // Keep looping until we exceed MAX

                synchronized (lock) { // Acquire the lock — only one thread enters at a time

                    // Check if current number is EVEN (remainder when divided by 2 is 0)
                    if (number % 2 == 0) {
                        System.out.println("EVEN Thread → " + number); // Print the even number
                        number++; // Increment the shared counter
                        lock.notify(); // Wake up the other thread (PrintOdd) that is waiting
                    } else {
                        // Current number is odd — not our turn, so wait
                        try {
                            lock.wait(); // Release the lock and wait until notified
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt(); // Restore interrupted status
                        }
                    }
                } // Lock is released here (end of synchronized block)

                // Pause for 500ms to slow down output and make the alternation visible
                try {
                    Thread.sleep(500); // sleep() pauses this thread (does NOT release the lock)
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt(); // Restore interrupted status if woken early
                }
            }
        }
    }

    // ─────────────────────────────────────────────
    // Main method — entry point of the program
    // ─────────────────────────────────────────────
    public static void main(String[] args) throws InterruptedException {

        // Create Runnable instances for each thread task
        PrintOdd oddTask  = new PrintOdd();  // Task that handles odd numbers
        PrintEven evenTask = new PrintEven(); // Task that handles even numbers

        // Wrap each Runnable in a Thread object so they can run concurrently
        Thread oddThread  = new Thread(oddTask,  "ODD-Thread");  // Named "ODD-Thread"
        Thread evenThread = new Thread(evenTask, "EVEN-Thread"); // Named "EVEN-Thread"

        System.out.println("=== Thread Synchronization Demo ===");
        System.out.println("Printing numbers 1 to " + MAX + " alternately\n");

        oddThread.start();  // Start the ODD thread — calls oddTask.run() in a new thread
        evenThread.start(); // Start the EVEN thread — calls evenTask.run() in a new thread

        // Main thread waits for both child threads to finish before continuing
        oddThread.join();  // Block main thread until oddThread finishes
        evenThread.join(); // Block main thread until evenThread finishes

        System.out.println("\n=== Done! Both threads finished. ===");
    }
}