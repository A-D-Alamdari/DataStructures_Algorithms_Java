package DataStructures_Udemy.BigO;

public class BigO {
    /***
     * This function has Big-O as N -> O(N)
     * @param n Input
     */
    public static void printItems1(int n) {     // O(N)
        for (int i = 0; i< n; i++) {            // N        times executed
            System.out.println(i);
        }
    }

    /***
     * This function has Big-O as N^2 -> O(N^2)
     * @param n Input
     */
    public static void printItems2(int n) {     // O(N^2)
        for (int i = 0; i < n; i++) {           // N        times executed
            for (int j = 0; j < n; j++) {       // N * N    times executed
                System.out.println(i * j);
            }
        }
    }

    /***
     * This function has Big-O as N^3 -> O(N^3)
     * @param n Input
     */
    public static void printItems3(int n) {     // O(N^3)
        for (int i = 0; i < n; i++) {           // N            times executed
            for (int j = 0; j < n; j++) {       // N * N        times executed
                for (int k =0; k < n; k++) {    // N * N * N    times executed
                    System.out.println(i + j + k);
                }
            }
        }
    }


    /***
     * This function has Big-O as N^2 -> O(N^2)
     * @param n Input
     */
    public static void printItems4(int n) {     // O(N^2)   // The first for loop dominates the second one
        // First for-loop
        for (int i = 0; i < n; i++) {           // N        times executed
            for (int j = 0; j < n; j++) {       // N * N    times executed
                System.out.println(i * j);
            }
        }
        // Second for-loop
        for (int k =0; k < n; k++) {            // N        times executed
            System.out.println(k);
        }
    }

    public static void main(String[] args) {
        printItems1(10);
    }
}
