# Stack

A stack is an ordered collection of elements for which insertions and removals can only be done from one end (the top). This is a linear data structure usually described as FIFO (first in first out).

A stack contains a limted set of operations:

| Method        | Description                                 |
| ------------- | ------------------------------------------- |
| `push`        | Adds a new element on the top of the stack. |
| `pop`         | Removes the top element from the stack.     |
| `size`        | Returns the current size of the stack.      |
| `is_empty`    | Returns true if the stack is empty.         |


## Time Complexity

For all **standard operations** (push, pop, and size) the worst-case runtime is **O(1)**. The implementation of this data structure below showcases that these operations take constant time.

| Method        | Time Complexity |
| ------------- | --------------- |
| `push`        | O(1)            |
| `pop`         | O(1)            |
| `size`        | O(1)            |
| `is_empty`    | O(1)            |

The **copy constructor and assignment operator** are **O(n)** -- where n is the number of elements on the stack. This is because each element must be copied (copying one element takes constant time). 

The **destructor** when a linked list is used (this implementation uses linked list) results in **O(n)** runtime. This is because we must transverse thru the remaining elements and free them one-by-one.

## Implementation

Recall we define a **node** as the following:

```cpp
typedef struct Node
{
    int data;
    struct Node *next;
} Node;
```

This implementation of Stack uses a **linked list**.

```cpp
#include <iostream>

class Stack
{
private:
    int _size;
    Node *head;
public:
    Stack();
    ~Stack();

    // Standard operations.
    void push(int data);
    void pop();
    
    bool is_empty();
    int size();
    
    // Helper function.
    void print();
};

Stack::Stack()
{
    this->size = 0;
    this->head = NULL;
}

Stack::~Stack()
{
    std::cout << "Calling destructor." << std::endl;
    Node *head = this->head;

    while (head != NULL)
    {
        std::cout << "Deleting node with value: " << head->data << std::endl;
        delete head;
        head = head->next;
    }
}

int Stack::size()
{
    return this->_size;
}

bool Stack::is_empty()
{
    return this->_size == 0;
}

void Stack::push(int data)
{
    Node *node = new Node;
    node->data = data;
    node->next = head;

    this->head = node;
    this->_size++;
}

void Stack::pop()
{
    if (this->is_empty())
    {
        throw "The list contains no elements.";
    }

    Node *node = this->head;  
    this->head = this->head->next;

    delete node;
    this->_size--;
}

void Stack::print()
{
    if (this->is_empty())
    {
        std::cout << "The list contains no elements." << std::endl;
        return;
    }

    Node *head = this->head;

    for (int i = 0; i < this->_size; i++)
    {
        std::cout << "Node " << i << ": " << head->data << std::endl;
        head = head->next;
    }
}
```

Example usage of this implementation:

```cpp
int main() {
    // Allocate memory for the stack.
    Stack *stack = new Stack();

    stack->push(4);
    stack->push(5);
    stack->push(2);

    stack->print();

    stack->pop();

    delete stack;
    return 0;
}
```

This will give the following output:
```
Node 0: 2
Node 1: 5
Node 2: 4
Calling destructor.
Deleting node with value: 5
Deleting node with value: 4
```