# 🧠 Daily DSA Spaced-Repetition Revision Cheatsheet
> **The Golden Rule:** Har subah code dobara type nahi karna hai! Sirf **10-15 minute** pen-paper par **Pointer Movement aur Dry Run** trace karna hai.

---

## ⏰ Notifications Kaise Milenge? (3 Best Options)

| Option | Kha Notification Milega? | Setup Kaise Hoga? |
| :--- | :--- | :--- |
| **Option 1 (Recommended on PC)** | **Windows Desktop Banner / Toast Pop-up** | Windows Task Scheduler se roz subah aapki screen par pop-up aayega. |
| **Option 2 (Mobile Phone)** | **Google Calendar / Phone Reminder** | Roz subah 10:00 AM ka recurring alarm with topic name. |
| **Option 3 (Inside Antigravity)** | **Agent Recurring Chat Alert** | Antigravity me `/schedule` command se automated prompt trigger. |

---

## 📈 Spaced Repetition Formula (1 - 3 - 7 - 15 - 30 Rule)
Kisi bhi question ko bhoolne se bachane ka scientific formula:
* **Day 1 (Solve Day):** Question solve karo aur Flashcard banao.
* **Day 2 (Next Day - 2 mins):** Invariant & Edge Cases dimaag me revise karo.
* **Day 4 (After 3 Days - 5 mins):** Pen-paper par 1 dry run trace karo.
* **Day 8 (After 7 Days - 5 mins):** Code ki structure dimaag me visualize karo.
* **Day 15 & 30 (After 15/30 Days):** Muscle memory permanent ho jaati hai!

---

## 🗓️ 10-Day Daily Revision Schedule (15 Minutes Daily)

Har subah bas yeh 2-3 specific flashcards khol kar dekho:

### 🔹 Day 1 (Kal Subah)
* 📖 **Topic:** Two Pointers In-Place Basics
* 🎯 **Revise Flashcards:**
  - `LC 167` (Two Sum II - Sorted Array: `sum < target -> left++`, `sum > target -> right--`)
  - `LC 283` (Move Zeroes: single pass swap with non-zero)
  - `LC 344` (Reverse String: `left < right`, char swap)
* ⏱️ **Time:** 10 Minutes (Link: [03-Arrays/REVISION_CHEATSHEET.md](file:///e:/java%20Dsa/Love-Babbar/03-Arrays/REVISION_CHEATSHEET.md))

### 🔹 Day 2
* 📖 **Topic:** Reader-Writer Filtering & Digit Maths
* 🎯 **Revise Flashcards:**
  - `LC 26` (Remove Duplicates: `officer = 0`, `nums[cm] != nums[officer]`)
  - `LC 27` (Remove Element: overwrite filter)
  - `Basic Maths` (`% 10` extract, `/ 10` discard, `* 10 + d` append)
* ⏱️ **Time:** 10 Minutes

### 🔹 Day 3
* 📖 **Topic:** Backward Fill & Palindrome Logic
* 🎯 **Revise Flashcards:**
  - `LC 977` (Squares of Sorted Array: `res[k]` backward fill from end)
  - `LC 125` (Valid Palindrome: `Character.isLetterOrDigit` skip pointers)
  - `LC 206` (Linked List: Reverse LL with 3 pointers `prev, curr, forward`)
* ⏱️ **Time:** 12 Minutes (Link: [07-LinkedList/REVISION_CHEATSHEET.md](file:///e:/java%20Dsa/Love-Babbar/07-LinkedList/REVISION_CHEATSHEET.md))

### 🔹 Day 4
* 📖 **Topic:** Linked List Tortoise-Hare & Cycles
* 🎯 **Revise Flashcards:**
  - `LC 876` (Middle of LL: `slow` 1 step, `fast` 2 steps)
  - `LC 141` & `LC 142` (Cycle Detection & Starting Node)
  - `LC 234` (Palindrome LL: Middle find karo -> Half reverse karo -> Compare)
* ⏱️ **Time:** 15 Minutes

### 🔹 Day 5
* 📖 **Topic:** Dutch National Flag & 3 Pointers
* 🎯 **Revise Flashcards:**
  - `LC 75` (Sort Colors: `low, mid, high` 3-way partition)
  - `LC 15` (3Sum: Sort -> Fix `i` -> Two Pointers with duplicate bypass)
* ⏱️ **Time:** 15 Minutes

### 🔹 Day 6
* 📖 **Topic:** Container & Rain Water Invariants
* 🎯 **Revise Flashcards:**
  - `LC 11` (Container With Most Water: chhoti height wale pointer ko andar badhao)
  - `LC 42` (Trapping Rain Water: `leftMax` aur `rightMax` boundary concept)
* ⏱️ **Time:** 15 Minutes

### 🔹 Day 7 (Cumulative Review)
* 📖 **Topic:** Full Week Flashcard Blitz
* 🎯 **Action:** Saare 6 Arrays Flashcards + 5 Core LL Flashcards ke invariants 1 minute per card scan karo (Total 12 mins).

---

## ⚡ 60-Second Flash Formulas (Instant Cheat)

```text
1. TWO SUM SORTED:
   sum < target -> left++   |   sum > target -> right--

2. READER-WRITER IN-PLACE:
   LC 26 (Dupes):   nums[cm] != nums[officer] -> officer++, nums[officer] = nums[cm] (return officer + 1)
   LC 27 (Remove):  nums[reader] != val       -> nums[writer++] = nums[reader]       (return writer)
   LC 283 (Zeroes): nums[reader] != 0         -> swap(nums[writer++], nums[reader])

3. BACKWARD FILL (LC 977):
   Filling from k = n - 1 down to 0 avoids overwriting smallest elements!

4. LINKED LIST REVERSAL:
   forward = curr.next; curr.next = prev; prev = curr; curr = forward;

5. FAST-SLOW MIDDLE:
   while (fast != null && fast.next != null) { slow = slow.next; fast = fast.next.next; }
```
