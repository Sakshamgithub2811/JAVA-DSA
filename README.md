# Java DSA Practice Tracker 🚀

Dono courses (**Padho with Pratyush** & **Love Babbar**) ki DSA practice ke liye structured repository.

---

## 📁 Folder Structure

```text
java Dsa/
├── Padho-With-Pratyush/
│   ├── 01-Basics/
│   ├── 02-Patterns/
│   ├── 03-Arrays/
│   ├── 04-Searching-Sorting/
│   ├── 05-Strings/
│   ├── 06-Recursion/
│   ├── 07-LinkedList/
│   ├── 08-Stacks-Queues/
│   ├── 09-BinaryTrees/
│   ├── 10-BST/
│   ├── 11-Heaps/
│   ├── 12-Graphs/
│   └── 13-DP/
│
├── Love-Babbar/
│   ├── 01-Basics/
│   ├── 02-Patterns/
│   ├── 03-Arrays/
│   ├── 04-Searching-Sorting/
│   ├── 05-Strings/
│   ├── 06-Recursion-Backtracking/
│   ├── 07-LinkedList/
│   ├── 08-Stacks/
│   ├── 09-Queues/
│   ├── 10-BinaryTrees/
│   ├── 11-BST/
│   ├── 12-Heaps/
│   ├── 13-HashMaps-Tries/
│   ├── 14-DP/
│   └── 15-Graphs/
│
└── .gitignore
```

---

## 💡 Best Practices

### 1. File Naming Format
File ka naam clear aur descriptive rakhein taaki baad me dhoondna aasan ho:
- `Lec01_PrintCounting.java` (Lecture code ke liye)
- `LC_0206_ReverseLinkedList.java` (LeetCode problem ke liye)
- `GFG_DetectLoop.java` (GeeksForGeeks problem ke liye)

### 2. Code Template (Comments)
Har problem ke top pe problem description aur time/space complexity zaroor mention karein:

```java
/**
 * Problem: Reverse a Linked List
 * Platform: LeetCode #206
 * Course Reference: Love Babbar Day 44 / Padho with Pratyush Lec 8
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
```

### 3. How to Run Single Java Files
Terminal me kisi bhi file ko bina package issues ke direct run karne ke liye:
```bash
# Compile
javac Padho-With-Pratyush/07-LinkedList/LinkedList.java

# Run
java -cp Padho-With-Pratyush/07-LinkedList LinkedList
```
*(Ya VS Code ke direct **Run** / **Play** button se run karein)*
