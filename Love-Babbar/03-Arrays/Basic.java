/**
 * ============================================================================
 *                          WHAT IS AN ARRAY IN JAVA? (DSA GUIDE)
 * ============================================================================
 * 
 * 1. DEFINITION:
 *    - An Array is a LINEAR data structure that stores a collection of elements 
 *      of the SAME DATA TYPE (homogeneous) in CONTIGUOUS (side-by-side) memory locations.
 * 
 * 2. CORE PROPERTIES:
 *    - Fixed Size: Once created, an array's size cannot be increased or decreased.
 *    - 0-Indexed: The first element is stored at index 0, and the last element at index (length - 1).
 *    - Homogeneous: Can only hold elements of one type (e.g., all int, all String, etc.).
 *    - Contiguous Memory: Elements are stored in consecutive bytes in RAM.
 * 
 * 3. WHY IS ARRAY ACCESS O(1) TIME? (Random Access Formula):
 *    - Because elements are contiguous, the CPU does NOT traverse from element 0.
 *    - Instead, it calculates the exact memory address in 1 CPU cycle using the formula:
 * 
 *         Address of Index (i) = Base_Address + (i * size_of(data_type))
 * 
 *      Example (int array, 4 bytes each, Base Address = 1000):
 *        Index 0: 1000 + (0 * 4) = Address 1000
 *        Index 1: 1000 + (1 * 4) = Address 1004
 *        Index 2: 1000 + (2 * 4) = Address 1008
 *        Index 3: 1000 + (3 * 4) = Address 1012
 * 
 * 4. TIME & SPACE COMPLEXITY:
 *    +-----------------------------+--------------------+
 *    | Operation                   | Time Complexity    |
 *    +-----------------------------+--------------------+
 *    | Access by Index: arr[i]     | O(1) - Constant    |
 *    | Update by Index: arr[i] = v | O(1) - Constant    |
 *    | Linear Search               | O(N)               |
 *    | Binary Search (if sorted)   | O(log N)           |
 *    | Insertion at End (if space) | O(1)               |
 *    | Insertion / Deletion (Mid)  | O(N) (shifting)    |
 *    +-----------------------------+--------------------+
 *    | Space Complexity            | O(N)               |
 *    +-----------------------------+--------------------+
 * 
 * 5. ADVANTAGES:
 *    - Super fast O(1) random access using index.
 *    - Cache-friendly (Cache Locality): Contiguous memory means the CPU pre-fetches 
 *      nearby elements into L1/L2 cache, making loops extremely fast.
 * 
 * 6. DISADVANTAGES:
 *    - Fixed size (memory waste if overestimated, overflow if underestimated).
 *    - Insertion & Deletion is expensive (requires O(N) shifting of elements).
 *    - Must allocate contiguous memory (if 1GB RAM is fragmented, allocation fails).
 * ============================================================================
 */

public class Basic {
    public static void main(String[] args) {

        System.out.println("=== 1. ARRAY DECLARATION & INITIALIZATION WAYS ===");

        // Method A: Declare & Allocate memory first, then assign values later
        int[] arr1 = new int[5]; // size = 5, default values are all 0
        arr1[0] = 10;
        arr1[1] = 20;
        arr1[2] = 30;
        arr1[3] = 40;
        arr1[4] = 50;

        // Method B: Declare & Initialize directly with values (Size is inferred automatically)
        int[] arr2 = { 100, 200, 300, 400, 500 };

        // Method C: Using 'new int[]' syntax (often used when passing arrays to functions)
        int[] arr3 = new int[] { 5, 15, 25, 35 };

        System.out.println("arr1 length: " + arr1.length);
        System.out.println("arr2 length: " + arr2.length);
        System.out.println("arr3 length: " + arr3.length);


        System.out.println("\n=== 2. O(1) RANDOM ACCESS & UPDATE ===");
        System.out.println("Element at index 2 in arr1: " + arr1[2]); // 30
        arr1[2] = 999; // O(1) update
        System.out.println("After update, arr1[2]: " + arr1[2]); // 999


        System.out.println("\n=== 3. ARRAY TRAVERSAL (2 Common Ways) ===");

        // Way 1: Standard For-Loop (Use when index 'i' is needed)
        System.out.print("Standard for loop: ");
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + " ");
        }
        System.out.println();

        // Way 2: Enhanced For-Each Loop (Use when you only need values, cleaner syntax)
        System.out.print("Enhanced for-each loop: ");
        for (int val : arr2) {
            System.out.print(val + " ");
        }
        System.out.println();


        System.out.println("\n=== 4. DEFAULT VALUES IN JAVA ARRAYS ===");
        // Java automatically fills newly allocated arrays with default values:
        // int / byte / short / long -> 0
        // float / double            -> 0.0
        // boolean                   -> false
        // char                      -> '\u0000' (null character)
        // Object / String           -> null
        boolean[] boolArr = new boolean[3];
        String[] strArr = new String[3];
        System.out.println("Default boolean value: " + boolArr[0]); // false
        System.out.println("Default String value: " + strArr[0]);   // null
    }
}
