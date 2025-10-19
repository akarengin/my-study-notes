🔍 Core Idea

Divide and conquer approach

Repeatedly halve the search space

Time Complexity: O(log n) for sorted data

🧠 Key Binary Search Variants

| Pattern                        | Use Case                                    | Notes                                         |
|--------------------------------|---------------------------------------------|-----------------------------------------------|
| Standard Binary Search         | Find element in sorted array                | Classic implementation                        |
| Lower Bound (First Occurrence) | First position of target or insertion index | Prefer when duplicates exist                  |
| Upper Bound (Last Occurrence)  | Last position of target                     | Useful for range problems                     |
| Binary Search on Answer        | Search in solution space                    | Use when elements are not directly searchable |

🧮 Lower Bound vs Upper Bound

| Term            | Definition                                                                                | Goal                                                          | Common Usage                                   |
|-----------------|-------------------------------------------------------------------------------------------|---------------------------------------------------------------|------------------------------------------------|
| **Lower Bound** | The **first position** where a target could be inserted without violating the sort order. | Find the **first occurrence** or **insert index** of a target | `Arrays.binarySearch()`, insert in sorted list |
| **Upper Bound** | The **first position greater than** the target (i.e., one past the last occurrence).      | Find the **last occurrence** + 1                              | Count range or duplicates                      |
