🧠 When to Use
Use sliding window when:

* You are dealing with subarrays or substrings.
* You need continuous ranges.
* The problem asks for maximum/minimum/valid length or count in a dynamic window.

This avoids O(n²) brute force by dynamically expanding and shrinking the window in O(n).

🧩 Sliding Window Types

| Type          | When to Use                                | Example Problem                   |
|---------------|--------------------------------------------|-----------------------------------|
| Fixed-size    | Window length is constant                  | Maximum sum of size K             |
| Variable-size | Window length changes with conditions      | Longest substring without repeats |
| Two-pointer   | Window changes based on left/right indices | Subarray product less than K      |
