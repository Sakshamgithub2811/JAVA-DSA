/**
 * ============================================================================
 *                    BASIC MATH: DIGIT MANIPULATION IN JAVA
 * ============================================================================
 * 
 * In DSA, almost every math-based problem (Reverse Integer, Palindrome Number,
 * Count Digits, Armstrong Number) relies on 3 FUNDAMENTAL OPERATIONS:
 * 
 * 1. GET LAST DIGIT:
 *    - Formula:   lastDigit = n % 10;
 *    - Mechanism: The modulo operator (%) returns the remainder after division by 10.
 *    - Example:   4567 % 10  ==>  7
 * 
 * 2. DELETE / REMOVE LAST DIGIT:
 *    - Formula:   n = n / 10;
 *    - Mechanism: Integer division truncates the decimal part, effectively dropping the last digit.
 *    - Example:   4567 / 10  ==>  456
 * 
 * 3. ADD / APPEND A DIGIT TO THE END:
 *    - Formula:   n = (n * 10) + newDigit;
 *    - Mechanism: Multiplying by 10 shifts existing digits one position to the left (creating a trailing 0),
 *                 then adding the new digit places it at the end.
 *    - Example:   (456 * 10) + 7  ==>  4560 + 7  ==>  4567
 * 
 * 4. UNIVERSAL DIGIT EXTRACTION LOOP:
 *    - To process every digit of a number from right to left:
 * 
 *        while (n > 0) {
 *            int digit = n % 10;   // 1. Extract digit
 *            // ... process digit ...
 *            n = n / 10;           // 2. Remove digit
 *        }
 * 
 * ============================================================================
 */

public class basic {

    public static void main(String[] args) {

        System.out.println("=== 1. THE 3 CORE DIGIT OPERATIONS ===");
        int num = 789;

        // Operation 1: GET last digit
        int lastDigit = num % 10;
        System.out.println("Original number:       " + num);
        System.out.println("1. Get last digit:     " + lastDigit); // 9

        // Operation 2: DELETE last digit
        num = num / 10;
        System.out.println("2. After deleting digit:" + num);      // 78

        // Operation 3: ADD a digit to the end (e.g., append 5)
        int newDigit = 5;
        num = (num * 10) + newDigit;
        System.out.println("3. After adding 5 to end:" + num);     // 785


        System.out.println("\n=== 2. EXTRACT & PRINT ALL DIGITS (RIGHT TO LEFT) ===");
        int n1 = 4567;
        System.out.print("Digits of " + n1 + " from right to left: ");
        int temp1 = n1;
        while (temp1 > 0) {
            int digit = temp1 % 10;
            System.out.print(digit + " ");
            temp1 = temp1 / 10;
        }
        System.out.println(); // Output: 7 6 5 4


        System.out.println("\n=== 3. COUNT NUMBER OF DIGITS ===");
        int n2 = 98765;
        int count = 0;
        int temp2 = n2;
        while (temp2 > 0) {
            count++;
            temp2 = temp2 / 10;
        }
        System.out.println("Total digits in " + n2 + ": " + count); // 5


        System.out.println("\n=== 4. REVERSE A NUMBER (LEETCODE 7 PATTERN) ===");
        int n3 = 12345;
        int reversed = 0;
        int temp3 = n3;
        while (temp3 > 0) {
            int digit = temp3 % 10;
            reversed = (reversed * 10) + digit; // Shift left and append
            temp3 = temp3 / 10;
        }
        System.out.println("Original number: " + n3);
        System.out.println("Reversed number: " + reversed); // 54321


        System.out.println("\n=== 5. CHECK PALINDROME NUMBER (LEETCODE 9 PATTERN) ===");
        int n4 = 1221;
        int revCheck = 0;
        int temp4 = n4;
        while (temp4 > 0) {
            int digit = temp4 % 10;
            revCheck = (revCheck * 10) + digit;
            temp4 = temp4 / 10;
        }
        boolean isPalindrome = (n4 == revCheck);
        System.out.println("Is " + n4 + " a Palindrome? " + isPalindrome); // true
    }
}


/*
--- MATH ROADMAP / TO-DO TOPICS ---
1. prime number 
2. sum of digits
3. gcd of a number
4. lcm of a number
5. armstrong number
6. find divisior and check perfect number
7. print all prime 1 to n 
*/ 
