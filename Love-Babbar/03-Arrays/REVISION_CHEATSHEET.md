# ⚡ Arrays Quick Revision Cheatsheet (FAANG Interview Ready)

> **Purpose:** Har question ko 60 seconds me revise karne ke liye single-page quick reference. Code dobara type karne ki zaroorat nahi hai—sirf **Core Invariant, Pointer Movement aur Edge Cases** dimaag me taaza karo!

---

## 🚦 Revision Priority Buckets (Spaced Repetition)

* 🟢 **Bucket 1 (Muscle Memory - Mahine me 1 baar):**
  * `LC 167` (Two Sum II - Sorted), `LC 344` (Reverse String), `LC 283` (Move Zeroes), `LC 121` (Best Time to Buy/Sell Stock), `LC 75` (Sort Colors / DNF)
* 🟡 **Bucket 2 (Edge Case Care - 15 Din me 1 baar):**
  * `LC 125` (Valid Palindrome), `LC 26` (Remove Duplicates), `LC 977` (Squares of Sorted Array), `LC 724` (Pivot Index), `LC 268` (Missing Number)
* 🔴 **Bucket 3 (Interview Gold - Har hafte 1 baar pen-paper trace):**
  * `LC 15` (3Sum Duplicate Bypass), `LC 53` (Kadane's Subarray), `LC 11` (Container With Most Water), `LC 56` (Merge Intervals), `LC 48` (Rotate Image 90°), `LC 42` (Trapping Rain Water), `LC 31` (Next Permutation)

---

## 🛠️ The 4 Golden Rules of Arrays (Always Remember)

1. **Rule 1 (The Sorting Prerequisite Rule):**
   * Two Pointers moving inward (`left = 0`, `right = n - 1`) **TABHI KAAM KARTA HAI JAB ARRAY SORTED HO!**
   * Agar array unsorted hai (jaise LC 1), toh Two Pointers kabhi mat lagana—wahan **HashMap** ($\mathcal{O}(N)$) ya **Brute Force** ($\mathcal{O}(N^2)$) chalega.

2. **Rule 2 (Java Memory vs Interview Output Rule):**
   * Java me array hamesha **0-indexed (`0` se `length - 1`)** hota hai.
   * Agar question 1-based indexing maange (jaise LC 167), toh pointer hamesha `0` aur `n - 1` se hi shuru karo, aur **sirf return karte waqt `+ 1` add karo** (`return new int[]{left + 1, right + 1};`).

3. **Rule 3 (In-Place Reader-Writer Rule):**
   * Jab bhi array se elements hatane ya filter karne ho $\mathcal{O}(1)$ space me (jaise Move Zeroes, Remove Duplicates):
   * `writer` pointer ko pichhe rakho, aur `reader` pointer ko daudao. Condition match hone par `nums[writer] = nums[reader]` karke `writer++` karo.

4. **Rule 4 (Matrix 90° Rotation Formula):**
   * Clockwise $90^\circ$ Rotate = **Transpose (Swap `matrix[i][j]` with `matrix[j][i]`) $\rightarrow$ Reverse Each Row**.

---

## 📑 Master Array Questions (1-Minute Flashcards)

---

### 1️⃣ LeetCode 167: Two Sum II - Input Array Is Sorted
* **Pattern:** Opposite-Direction Two Pointers (Convergent)
* **The "Aha!" Invariant:**
  ```java
  int left = 0, right = numbers.length - 1;

  while (left < right) {
      int sum = numbers[left] + numbers[right];

      if (sum == target) {
          return new int[]{left + 1, right + 1}; // 1-based indexing!
      } else if (sum < target) {
          left++;  // Sum chhota hai -> bada number lene ke liye rightwards badho
      } else {
          right--; // Sum bada hai -> chhota number lene ke liye leftwards badho
      }
  }
  return new int[]{-1, -1};
  ```
* **Visual:**
  ```text
  Sorted:  [ 2,    7,    11,   15 ], target = 9
             ↑                  ↑
           left (0)            right (3)  ==> sum = 2 + 15 = 17 (> 9) -> right--

           [ 2,    7,    11,   15 ]
             ↑           ↑
           left (0)     right (2)         ==> sum = 2 + 11 = 13 (> 9) -> right--

           [ 2,    7,    11,   15 ]
             ↑     ↑
           left   right                   ==> sum = 2 + 7 = 9 (== target) -> RETURN [1, 2]!
  ```
* **Interview Trap:** 
  1. Adding indices instead of values (`left + right` instead of `numbers[left] + numbers[right]`).
  2. Forgetting 1-based indexing in return (`{left + 1, right + 1}`).
  3. Inverting the condition (`sum < target` me `right--` kar dena).
* **Complexity:** $\mathcal{O}(N)$ Time, $\mathcal{O}(1)$ Space.

---

### 2️⃣ LeetCode 26: Remove Duplicates from Sorted Array
* **Pattern:** Same-Direction Two Pointers (Reader & Writer / Officer-CM)
* **The "Aha!" Invariant:**
  ```java
  int officer = 0; // Writer pointer (Last settled unique element)

  for (int cm = 1; cm < nums.length; cm++) { // Reader pointer (Scouting forward)
      if (nums[cm] != nums[officer]) {
          officer++;
          nums[officer] = nums[cm]; // Naye unique bande ko line me aage bithao
      }
  }
  return officer + 1; // Total unique elements count
  ```
* **Visual:**
  ```text
  Initial:   [ 1,   1,   2 ]
               ↑    ↑
            officer cm   ==> nums[cm] == nums[officer] (duplicate, cm++ aage badha)

  Next:      [ 1,   1,   2 ]
               ↑         ↑
            officer      cm   ==> nums[cm] != nums[officer] (unique mila!)
                              officer++ karke nums[officer] = nums[cm] likha

  Result:    [ 1,   2,   2 ], return officer + 1 = 2 elements!
  ```
* **Interview Trap:** 
  1. Extra `count` variable rakhna (jabki `officer + 1` hi exact count hota hai).
  2. Modifying `cm` manually inside `while` loop with `continue` (error-prone; `for` loop is cleaner).
  3. Forgetting that question requires **In-Place $\mathcal{O}(1)$ space** modification of `nums`.
* **Complexity:** $\mathcal{O}(N)$ Time, $\mathcal{O}(1)$ Space.

---

### 3️⃣ LeetCode 977: Squares of a Sorted Array
* **Pattern:** Opposite-Direction Two Pointers (Backward Fill from End)
* **The "Aha!" Invariant:**
  ```java
  int left = 0, right = nums.length - 1;
  int k = nums.length - 1; // Sabse bada number aakhri index par bithaenge
  int[] res = new int[nums.length];

  while (left <= right) {
      int leftSq = nums[left] * nums[left];
      int rightSq = nums[right] * nums[right];

      if (leftSq > rightSq) {
          res[k] = leftSq;
          left++;
      } else {
          res[k] = rightSq;
          right--;
      }
      k--;
  }
  return res;
  ```
* **Visual:**
  ```text
  nums = [ -4,   -1,    0,    3,   10 ]
            ↑                        ↑
          left (0)                 right (4)
          leftSq = 16              rightSq = 100

  res:  [  _ ,   _ ,   _ ,   _ ,  100 ]  (res[4] = 100, right--)
  ```
* **Interview Trap:** 
  1. Chhote se bada bharne ke chakkar me alag-alag ArrayLists me split karke merge karna (extra space aur code complex ho jata hai).
  2. Direct square karke `Arrays.sort()` chala dena ($\mathcal{O}(N \log N)$), jabki two-pointer se $\mathcal{O}(N)$ single pass me ho jata hai.
* **Complexity:** $\mathcal{O}(N)$ Time, $\mathcal{O}(1)$ Auxiliary Space (excluding returned array).

---
