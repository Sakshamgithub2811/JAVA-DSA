# ⚡ Linked List Quick Revision Cheatsheet (FAANG Interview Ready)

> **Purpose:** Har question ko 60 seconds me revise karne ke liye single-page quick reference. Code dobara type karne ki zaroorat nahi hai—sirf **Core Invariant, Pointer Movement aur Edge Cases** dimaag me taaza karo!

---

## 🚦 Revision Priority Buckets (Spaced Repetition)

* 🟢 **Bucket 1 (Muscle Memory - Mahine me 1 baar):**
  * `LC 206` (Reverse), `LC 876` (Middle), `LC 141` (Cycle I), `LC 237` (Delete Node without Head)
* 🟡 **Bucket 2 (Edge Case Care - 15 Din me 1 baar):**
  * `LC 2095` (Delete Middle), `LC 203` (Remove Elements with Val), `LC 83` (Duplicates I), `LC 19` (Remove Nth)
* 🔴 **Bucket 3 (Interview Gold - Har hafte 1 baar pen-paper trace):**
  * `LC 142` (Cycle Entry Math Proof), `LC 234` (Palindrome Combo), `LC 82` (Duplicates II - Anchor & Scout), `LC 92` (Sublist Cut & Reverse)

---

## 📑 14 LeetCode Master Questions (1-Minute Flashcards)

---

### 1️⃣ LeetCode 206: Reverse Linked List
* **Pattern:** In-Place Pointer Rewiring (3-Pointers)
* **The "Aha!" Invariant:**
  ```java
  forward = curr.next;  // 1. Backup lo taaki aage ki list na khoye
  curr.next = prev;     // 2. Arrow ko peechhe ghuma do
  prev = curr;          // 3. prev ko aage khiskao
  curr = forward;       // 4. curr ko aage khiskao
  ```
* **Visual:**
  ```text
  null <- [ 1 ] <- [ 2 ] <- [ 3 ]    curr = null
                            ^
                           prev (Naya Head!)
  ```
* **Interview Trap:** Loop khatam hone ke baad `curr` nahi, **`return prev;`** karte hain (kyunki `curr` null ban chuka hota hai).
* **Complexity:** $\mathcal{O}(N)$ Time, $\mathcal{O}(1)$ Space.

---

### 2️⃣ LeetCode 876: Middle of the Linked List
* **Pattern:** Slow & Fast Pointer (Tortoise & Hare)
* **The "Aha!" Invariant:**
  * `slow` moves by 1 step (`slow = slow.next`)
  * `fast` moves by 2 steps (`fast = fast.next.next`)
  * Loop condition: `while (fast != null && fast.next != null)`
* **Visual:**
  * **Odd length `[1, 2, 3]`:** Fast stops at node 3 (`fast.next == null`). Slow is at `2` (exact middle).
  * **Even length `[1, 2, 3, 4]`:** Fast steps into `null`. Slow is at `3` (second middle, as LeetCode requires).
* **Interview Trap:** Agar `head == null || head.next == null` par `return null` likh diya toh single node `[1]` fail ho jayega! Single node ka middle wahi khud hota hai.
* **Complexity:** $\mathcal{O}(N)$ Time, $\mathcal{O}(1)$ Space.

---

### 3️⃣ LeetCode 2095: Delete the Middle Node
* **Pattern:** Slow-Fast Pointer + Prev Tracker
* **The "Aha!" Invariant:**
  * Middle dabba delete karne ke liye uske theek 1 kadam pehle (`prev`) khada hona padega.
  * Har loop iteration me: `prev = slow; slow = slow.next; fast = fast.next.next;`
  * Bypass: `prev.next = slow.next;`
* **Interview Trap:** Single node list `[ 1 ]` me middle delete karne ke baad list khali ho jati hai!
  ```java
  if (head == null || head.next == null) return null;
  ```
* **Complexity:** $\mathcal{O}(N)$ Time, $\mathcal{O}(1)$ Space.

---

### 4️⃣ LeetCode 141: Linked List Cycle I (Detection)
* **Pattern:** Floyd's Cycle-Finding Algorithm
* **The "Aha!" Invariant:**
  * Relative speed between Fast and Slow is $2 - 1 = 1$. Har step me doori 1 kam hoti hai.
  * Agar cycle hai, toh `slow == fast` collision guaranteed hai!
  * Agar cycle nahi hai, toh `fast` ya `fast.next` hit karega `null`.
* **Interview Trap:** Order of checks matters:
  * ✅ `while (fast != null && fast.next != null)`
  * ❌ `while (fast.next != null && fast != null)` $\rightarrow$ Fast null hone par crash ho jayega!
* **Complexity:** $\mathcal{O}(N)$ Time, $\mathcal{O}(1)$ Space.

---

### 5️⃣ LeetCode 142: Linked List Cycle II (Entry Point)
* **Pattern:** Floyd's Math Proof ($L_1 = n \cdot C - L_2$)
* **The "Aha!" Invariant:**
  1. Pehle `slow == fast` se collision point (meeting point) dhoondo.
  2. Jaise hi mile: `slow = head;` par reset karo.
  3. Ab dono ko **1-1 kadam** chalao: `while (slow != fast) { slow = slow.next; fast = fast.next; }`
  4. Jis node par dobara milenge, wahi cycle ka **Starting Node** hai!
* **Proof Summary:** Shuruat se cycle tak ki doori ($L_1$) meeting point se cycle ke start tak ki bachi hui doori ke barabar hoti hai!
* **Complexity:** $\mathcal{O}(N)$ Time, $\mathcal{O}(1)$ Space.

---

### 6️⃣ LeetCode 19: Remove Nth Node From End of List
* **Pattern:** Two Pointers with Fixed Gap $N$
* **The "Aha!" Invariant:**
  1. `dummy.next = head` banao (in case first node delete karna ho).
  2. `fast` ko pehle $N$ kadam aage dauda do.
  3. Ab `slow` (dummy par) aur `fast` dono ko saath-saath 1-1 kadam chalao jab tak `fast.next != null`.
  4. Ab `slow` theek target node ke 1 kadam pehle khada hoga!
  5. Bypass: `slow.next = slow.next.next;`
* **Interview Trap:** Agar $N = \text{length of list}$ (pehla node delete karna hai), bina dummy node ke code crash ho jayega. Dummy node simplifies everything!
* **Complexity:** $\mathcal{O}(N)$ Time (Single Pass!), $\mathcal{O}(1)$ Space.

---

### 7️⃣ LeetCode 234: Palindrome Linked List
* **Pattern:** Middle (LC 876) + In-Place Reversal (LC 206) Combo
* **The "Aha!" Invariant:**
  1. **Step 1:** Slow-Fast se First Middle dhoondo (`while (fast.next != null && fast.next.next != null)`).
  2. **Step 2:** Second half ko reverse karo: `secondHalf = reverse(mid.next)`.
  3. **Step 3:** Do pointers chalao: `p1 = head` aur `p2 = secondHalf`.
  4. **Step 4:** Compare values: `while (p2 != null) { if (p1.val != p2.val) return false; p1 = p1.next; p2 = p2.next; }`
* **Interview Trap:** Even list me slow ko hamesha **First Middle** par rokna chahiye, taaki `mid.next` se second half perfectly barabar split ho sake.
* **Complexity:** $\mathcal{O}(N)$ Time, $\mathcal{O}(1)$ Space.

---

### 8️⃣ LeetCode 237: Delete Node in a Linked List (Without Head)
* **Pattern:** Identity Theft / Next Value Copy
* **The "Aha!" Invariant:**
  ```java
  node.val = node.next.val;     // Agle node ki aatma chura li
  node.next = node.next.next;   // Agle node ko line se hata diya
  ```
* **Interview Trap:** Yeh trick **Aakhri Node (Tail)** par fail ho jayegi kyunki `node.next` null hoga aur NPE crash hoga! (Question me explicitly guarantee hoti hai ki node tail nahi hoga).
* **Complexity:** $\mathcal{O}(1)$ Time, $\mathcal{O}(1)$ Space.

---

### 9️⃣ LeetCode 203: Remove Linked List Elements with Value `val`
* **Pattern:** Sentinel / Dummy Node Pattern
* **The "Aha!" Invariant:**
  ```java
  ListNode dummy = new ListNode(-1, head);
  ListNode curr = dummy;
  while (curr.next != null) {
      if (curr.next.val == val) {
          curr.next = curr.next.next; // Bypass! Yahan curr ko aage mat badhana!
      } else {
          curr = curr.next;           // Sirf safe dabba hone par hi aage badho!
      }
  }
  return dummy.next;
  ```
* **Interview Trap:** Lagaatar duplicate values (`7 -> 7 -> 7`): agar bypass karte waqt `curr = curr.next` kar diya, toh beech ka `7` delete hone se bach jayega!
* **Complexity:** $\mathcal{O}(N)$ Time, $\mathcal{O}(1)$ Space.

---

### 🔟 LeetCode 83: Remove Duplicates from Sorted List I (Keep 1 Copy)
* **Pattern:** Single Pointer Look-Ahead & In-Place Bypass
* **The "Aha!" Invariant:**
  ```java
  ListNode curr = head;
  while (curr != null && curr.next != null) {
      if (curr.val == curr.next.val) {
          curr.next = curr.next.next; // Duplicate bypass, curr wahin khada rahega!
      } else {
          curr = curr.next;           // Value alag aayi tabhi aage badho
      }
  }
  return head;
  ```
* **Difference from LC 82:** Isme 1 copy bacha kar rakhni hoti hai, isiliye `prev` ki zaroorat nahi padti, `curr` khud bacha rehta hai.
* **Complexity:** $\mathcal{O}(N)$ Time, $\mathcal{O}(1)$ Space.

---

### 1️⃣1️⃣ LeetCode 82: Remove Duplicates from Sorted List II (Delete ALL Copies)
* **Pattern:** Anchor (`prev`) & Scout (`curr`) Cluster Skipping
* **The "Aha!" Invariant:**
  ```java
  ListNode dummy = new ListNode(-1, head);
  ListNode prev = dummy; // Anchor (Last confirmed safe node)
  ListNode curr = head;  // Scout (Duplicate cluster dhoondne wala)

  while (curr != null) {
      if (curr.next != null && curr.val == curr.next.val) {
          // Aakhri duplicate tak bhagao
          while (curr.next != null && curr.val == curr.next.val) {
              curr = curr.next;
          }
          prev.next = curr.next; // Saare duplicate ek jhatke me bypass!
      } else {
          prev = curr;           // Safe dabba mila, anchor ko aage badhao!
      }
      curr = curr.next;          // Agle node ki jaanch
  }
  return dummy.next;
  ```
* **Interview Trap:** `else` block me `prev = curr.next` likhne ki galti mat karna! `curr` khud safe hai, isiliye `prev = curr;` hoga.
* **Complexity:** $\mathcal{O}(N)$ Time, $\mathcal{O}(1)$ Space.

---

### 1️⃣2️⃣ LeetCode 328: Odd Even Linked List
* **Pattern:** Two-Track Pointer Weaving (Odd track & Even track)
* **The "Aha!" Invariant:**
  ```java
  ListNode odd = head;
  ListNode even = head.next;
  ListNode evenHead = even; // Golden Backup!

  while (even != null && even.next != null) {
      odd.next = even.next;
      odd = odd.next;
      even.next = odd.next;
      even = even.next;
  }
  odd.next = evenHead; // Junction Connection!
  return head;
  ```
* **Visual:**
  ```text
  odd:  [ 1 ] --------> [ 3 ] --------> [ 5 ]
                                          |
  even: [ 2 ] --------> [ 4 ] <----------- (odd.next = evenHead)
  ```
* **Interview Trap:** Loop condition me `even != null && even.next != null` check karte hain kyunki `even` hamesha `odd` se 1 kadam aage chalta hai. Agar `even` null ya last dabba hua, toh rasta finish!
* **Complexity:** $\mathcal{O}(N)$ Time, $\mathcal{O}(1)$ Space.

---

### 1️⃣3️⃣ LeetCode 160: Intersection of Two Linked Lists
* **Pattern:** Difference of Lengths (Race Handicap) OR Track-Switching
* **The "Aha!" Invariant:**
  ```java
  int diff = Math.abs(lenA - lenB);
  // Lambi list ko pehle diff kadam daudao taaki dono barabar doori par aa jayein
  if (lenA > lenB) {
      for (int i = 1; i <= diff; i++) currA = currA.next;
  } else {
      for (int i = 1; i <= diff; i++) currB = currB.next;
  }
  // Ab dono ko saath-saath tab tak daudao jab tak dono takra na jayein
  while (currA != currB) {
      currA = currA.next;
      currB = currB.next;
  }
  return currA; // Match mil gaya! (Ya null agar intersect nahi hua)
  ```
* **Interview Trap:** `currA == currB` check karte hain (memory reference match), `currA.val == currB.val` nahi! Do alag-alag nodes me same value ho sakti hai, intersection ka matlab physically same dabba hota hai.
* **Complexity:** $\mathcal{O}(M + N)$ Time, $\mathcal{O}(1)$ Space.

---

### 1️⃣4️⃣ LeetCode 92: Reverse Linked List II (Sublist Reversal)
* **Pattern:** Cut ✂️ $\rightarrow$ Reverse 🔄 $\rightarrow$ Re-hook 🔗 (Dummy Node Strategy)
* **The "Aha!" Invariant:**
  ```java
  // 1. dummy (pos 0) se seedha counting karke pahucho:
  // leftPre -> left - 1 steps; rightEnd -> right steps
  for (int i = 0; i < left - 1; i++) leftPre = leftPre.next;
  for (int i = 0; i < right; i++) rightEnd = rightEnd.next;

  // 2. Cut: subHead aur rightPost save karo, fir cut karo
  ListNode subHead = leftPre.next, rightPost = rightEnd.next;
  rightEnd.next = null; // Cut done!

  // 3. Reverse: standard LC 206 helper function
  ListNode newHead = reverse(subHead);

  // 4. Re-hook: vaapas list me jod do
  leftPre.next = newHead;
  subHead.next = rightPost; // purana subHead ab reversed sublist ki tail hai!
  ```
* **Visual:**
  ```text
  leftPre -> [2 -> 3 -> 4] -> rightPost
                 ↓ (Reverse)
  leftPre -> [4 -> 3 -> 2] -> rightPost
  ```
* **Interview Trap:** Agar `left = 1` ho, toh `head` badal jata hai! Isliye `dummy` banana mandatory hai taaki `leftPre` safely `dummy` par khada ho sake.
* **Complexity:** $\mathcal{O}(N)$ Time, $\mathcal{O}(1)$ Space.

---

## 🛠️ The 3 Golden Rules of Linked List (Always Remember)

1. **Rule 1 (Delete Rule):** Agar kisi dabbe ko delete karna hai, toh aapko hamesha uske **theek 1 kadam pehle (`prev`)** khada hona padega!
2. **Rule 2 (Dummy Node Rule):** Jab bhi **Head delete ho sakta ho** ya **Head badal sakta ho**, bina soche `dummy = new ListNode(-1, head)` bana lo! Saare edge cases khatam ho jayenge.
3. **Rule 3 (Consecutive Duplicates Rule):** Jab bhi bypass (`curr.next = curr.next.next`) karo, pointer ko wahin roko, `curr = curr.next` **sirf `else` me** badhao!

