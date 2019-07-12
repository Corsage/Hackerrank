# Data Structures

This note will **not** cover implementations of various data structures. Instead, it will be a brief overview of the advantages and disadvantages of each commonly used data structure, and provide a basis of when to use each.

## List

## Set

A collection that contains no duplicate elements.

#### HashSet

| Methods       | Time Complexity |
| ------------- | --------------- |
| add           | O(1)            |
| remove        | O(1)            |
| contains      | O(1)            |

## Queue

#### PriorityQueue

| Methods            | Time Complexity |
| ------------------ | --------------- |
| offer              | O(log n)        |
| poll               | O(log n)        |
| remove `from head` | O(log n)        |
| add                | O(log n)        |
| remove             | O(n)            |
| contains           | O(n)            |
| peek               | O(1)            |
| element            | O(1)            |
| size               | O(1)            |

## Map