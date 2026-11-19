/**
 * ============================================================================
 *                          WHAT IS AN ARRAY IN JAVA? (DSA GUIDE)
 * ============================================================================
 * 
 * 1. DEFINITION:
 *    - An Array is a LINEAR data structure that stores a collection of elements 
 *      of the SAME DATA TYPE (homogeneous) in CONTIGUOUS (adjacent) memory locations.
 * 
 * 2. CORE PROPERTIES:
 *    - Fixed Size: Once created, the size of an array cannot be modified.
 *    - 0-Indexed: The first element is stored at index 0, and the last at (length - 1).
 *    - Homogeneous: Can only hold elements of one type (e.g., all int, all String).
 *    - Contiguous Memory: Elements are stored in consecutive memory bytes in RAM.
 * 
 * 3. WHY IS ARRAY ACCESS O(1) TIME? (Random Access Formula):
 *    - Because elements are stored contiguously, the CPU does NOT traverse from element 0.
 *    - Instead, it calculates the exact memory address in 1 CPU cycle using the formula:
 * 
 *         Address of Index (i) = Base_Address + (i * size_of(data_type))
 * 
 *      Example (int array = 4 bytes per element, Base Address = 1000):
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
 * 5. JVM MEMORY ARCHITECTURE (STACK VS HEAP):
 *    - Stack Memory: Holds the reference variable (e.g., 'arr').
 *    - Heap Memory:  Holds the actual array object with elements (e.g., '[10, 20, 30]').
 *    - When you write: int[] arr = new int[3];
 *        Stack: [ arr ]  --------points to------->  Heap: [ 0 | 0 | 0 ]
 * 
 * 6. 2D ARRAYS IN JAVA (ARRAY OF ARRAYS):
 *    - In Java, a 2D array is NOT a flat continuous matrix in memory.
 *    - It is an "Array of References", where each element of the outer array 
 *      points to an independent 1D array on the Heap.
 *    - This unique structure allows JAGGED (RAGGED) ARRAYS:
 *      rows can have completely different column lengths!
 * 
 * 7. ADVANTAGES:
 *    - Fast O(1) random access using index.
 *    - Cache-friendly (Spatial Locality): Contiguous memory allows the CPU to pre-fetch 
 *      nearby elements into L1/L2 cache, making loops faster.
 * 
 * 8. DISADVANTAGES:
 *    - Fixed size (wasted memory if overestimated; overflow if underestimated).
 *    - Expensive insertions and deletions (requires O(N) element shifting).
 *    - Requires a contiguous block of memory (allocation fails if memory is fragmented).
 * ============================================================================
 */

import java.util.Arrays;
import java.util.Scanner;

public class Basic {

    // Helper method to demonstrate Pass-By-Value of Object Reference
    public static void modifyArray(int[] temp) {
        temp[0] = 999; // Mutating here will reflect in the caller's array!
    }

    public static void main(String[] args) {

        // =========================================================
        // 1. ARRAY DECLARATION & INITIALIZATION (3 COMMON WAYS)
        // =========================================================

        // Way A: Allocate memory first, assign values later (initialized to 0)
        int[] arr1 = new int[5];
        arr1[0] = 10;
        arr1[1] = 20;
        arr1[2] = 30;
        arr1[3] = 40;
        arr1[4] = 50;

        // Way B: Direct initialization with values (size is inferred automatically)
        int[] arr2 = { 100, 200, 300, 400, 500 };

        // Way C: Anonymous array syntax using 'new int[]' (useful for function arguments)
        int[] arr3 = new int[] { 5, 15, 25, 35 };

        System.out.println("arr1 length: " + arr1.length);
        System.out.println("arr2 length: " + arr2.length);
        System.out.println("arr3 length: " + arr3.length);


        // =========================================================
        // 2. O(1) RANDOM ACCESS & UPDATE
        // =========================================================
        System.out.println("\nElement at index 2: " + arr1[2]); // 30
        arr1[2] = 777; // O(1) in-place update
        System.out.println("After update: " + arr1[2]);       // 777


        // =========================================================
        // 3. ARRAY TRAVERSAL (2 STYLES)
        // =========================================================

        // Style 1: Standard For-Loop (Used when the index 'i' is required)
        System.out.print("\nStandard for loop: ");
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + " ");
        }
        System.out.println();

        // Style 2: Enhanced For-Each Loop (Used when only values are needed; cleaner syntax)
        System.out.print("Enhanced for-each loop: ");
        for (int val : arr2) {
            System.out.print(val + " ");
        }
        System.out.println();


        // =========================================================
        // 4. DEFAULT VALUES IN JAVA ARRAYS
        // =========================================================
        // Newly allocated arrays are automatically initialized with default values:
        // int / long / byte / short -> 0
        // float / double            -> 0.0
        // boolean                   -> false
        // char                      -> '\u0000' (null character)
        // Object / String           -> null
        boolean[] boolArr = new boolean[2];
        String[] strArr = new String[2];
        System.out.println("\nDefault boolean: " + boolArr[0]); // false
        System.out.println("Default String:  " + strArr[0]);  // null


        // =========================================================
        // 5. PASS-BY-VALUE OF OBJECT REFERENCE (MUTATION IN METHODS)
        // =========================================================
        int[] original = { 1, 2, 3 };
        System.out.println("\nBefore method call: " + original[0]);
        modifyArray(original);
        System.out.println("After method call (modified in-place): " + original[0]); // 999


        // =========================================================
        // 6. SHALLOW COPY VS DEEP COPY (.clone())
        // =========================================================
        int[] a = { 10, 20, 30 };

        // Shallow Copy: Both references point to the exact same memory location on the heap
        int[] shallowCopy = a;
        shallowCopy[0] = 555;
        System.out.println("\nOriginal 'a[0]' after shallow copy change: " + a[0]); // 555 (Changed!)

        // Deep Copy: A completely independent new array is created in heap memory
        int[] deepCopy = a.clone();
        deepCopy[0] = 1111;
        System.out.println("Original 'a[0]' after deep copy change:    " + a[0]); // 555 (Unaffected!)


        // =========================================================
        // 7. ESSENTIAL java.util.Arrays UTILITY METHODS
        // =========================================================
        int[] numbers = { 50, 10, 40, 20, 30 };

        // 1. Arrays.toString() -> Prints elements cleanly without manual loops
        System.out.println("\nBefore sort: " + Arrays.toString(numbers));

        // 2. Arrays.sort() -> Dual-Pivot Quicksort running in O(N log N)
        Arrays.sort(numbers);
        System.out.println("After sort:  " + Arrays.toString(numbers));

        // 3. Arrays.binarySearch() -> Fast O(log N) search on sorted arrays
        int foundIdx = Arrays.binarySearch(numbers, 40);
        System.out.println("Index of 40 in sorted array: " + foundIdx);

        // 4. Arrays.fill() -> Fills every cell with a specified value (essential for DP)
        int[] dp = new int[5];
        Arrays.fill(dp, -1);
        System.out.println("DP table filled with -1: " + Arrays.toString(dp));

        // 5. Arrays.equals() -> Compares content equality rather than reference identity
        int[] list1 = { 1, 2, 3 };
        int[] list2 = { 1, 2, 3 };
        System.out.println("Reference comparison (list1 == list2): " + (list1 == list2));             // false
        System.out.println("Content comparison   (Arrays.equals):  " + Arrays.equals(list1, list2));  // true


        // =========================================================
        // 8. 2D ARRAYS (MATRICES) & JAGGED ARRAYS
        // =========================================================
        System.out.println("\n=== 8. 2D ARRAYS (MATRICES) & JAGGED ARRAYS ===");

        // Declaration & Direct Initialization (2 Rows x 3 Columns)
        int[][] matrix = {
            { 1, 2, 3 },
            { 4, 5, 6 }
        };

        // Dimensions of 2D Array
        int rows = matrix.length;       // Number of rows (2)
        int cols = matrix[0].length;    // Number of columns in row 0 (3)
        System.out.println("Matrix dimensions: " + rows + " rows x " + cols + " columns");

        // Traversal Way 1: Standard Nested For-Loop
        System.out.println("Matrix elements (Row-by-Row):");
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                System.out.print(matrix[r][c] + " ");
            }
            System.out.println();
        }

        // Traversal Way 2: Arrays.deepToString() -> 1-Line print for Multi-Dimensional Arrays!
        System.out.println("Using Arrays.deepToString(): " + Arrays.deepToString(matrix));

        // JAGGED (RAGGED) ARRAY: Rows with different number of columns!
        // In Java, int[][] is an "Array of Arrays", so each row can have a unique size:
        System.out.println("\n--- Jagged Array Example ---");
        int[][] jagged = new int[3][];
        jagged[0] = new int[] { 10, 20 };           // Row 0 has 2 columns
        jagged[1] = new int[] { 30, 40, 50, 60 };   // Row 1 has 4 columns
        jagged[2] = new int[] { 70 };               // Row 2 has 1 column

        for (int r = 0; r < jagged.length; r++) {
            System.out.print("Row " + r + " (len=" + jagged[r].length + "): ");
            for (int c = 0; c < jagged[r].length; c++) {
                System.out.print(jagged[r][c] + " ");
            }
            System.out.println();
        }


        // =========================================================
        // 9. TAKING USER INPUT VIA SCANNER CLASS
        // =========================================================
        System.out.println("\n=== 9. USER INPUT VIA SCANNER CLASS ===");
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] userArray = new int[n];
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            userArray[i] = sc.nextInt();
        }

        System.out.println("Array entered by user: " + Arrays.toString(userArray));
        sc.close();
    }
}
