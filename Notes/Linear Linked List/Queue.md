# Queue

A queue is an ordered collection of elements for whcih we can only insert an element at the back or remove an element from the front. This is a linear data structure usually described as FIFO ( first in first out).

Since this data structure requires us to insert and remove on opposite ends, it is best implemented with a **doubly linked list**. A queue contains a limited set of operations:

| Method        | Description                                    |
| ------------- | ---------------------------------------------- |
| `push`        | Adds a new element to the end of the queue.    |
| `pop`         | Removes the element at the front of the queue. |
| `size`        | Returns the current size of the queue.         |
| `is_empty`    | Returns true if the queue is empty.            |

## Time Complexity

For all **standard operations** (push, pop, and size) the worst-case runtime is **O(1)**. The implementation of this data structure below showcases that these operations take constant time. In this case, the `pop` operation is constant time because we use a doubly linked list and a tail pointer.

| Method        | Time Complexity |
| ------------- | --------------- |
| `push`        | O(1)            |
| `pop`         | O(1)            |
| `size`        | O(1)            |
| `is_empty`    | O(1)            |

The **copy constructor and assignment operator** are **O(n)** -- where n is the number of element in the queue. This is because each element must be copied (copying one element takes constant time). 

The **destructor** when a linked list is used (this implementation uses linked list) results in **O(n)** runtime. This is because we must transverse thru the remaining elements and free them one-by-one.

## Implementation

Recall we define a **node** as the following:

```cpp
typedef struct Node
{
    int data;
    struct Node *prev;
    struct Node *next;
} Node;
```

This implementation of Queue uses a **doubly linked list**.

```cpp
#include <iostream>

class Queue
{
private:
    int _size;
    Node *head;
    Node *tail;
public:
    Queue();
    ~Queue();
    
    // Standard operations.
    void push(int data);
    void pop();
    
    bool is_empty();
    int size();
    
    // Helper function.
    void print();
};

Queue::Queue()
{
    this->_size = 0;
    this->head = NULL;
    this->tail = NULL;
}

Queue::~Queue()
{
    std::cout << "Calling destructor." << std::endl;
    Node *node = this->head;
    
    while (node != NULL)
    {
        std::cout << "Deleting node with value: " << node->data << std::endl;
        delete node;
        node = node->next;
    }
}

bool Queue::is_empty()
{
    return this->_size == 0;
}

int Queue::size()
{
    return this->_size;
}

void Queue::push(int data)
{
    Node *node = new Node;
    node->data = data;
    
    node->prev = NULL;
    node->next = this->head;
    
    if (this->head != NULL)
    {
        this->head->prev = node;
    }
    
    this->head = node;
    
    if (this->tail == NULL)
    {
        this->tail = node;
    }
    
    this->_size++;
}

void Queue::pop()
{
    if (this->is_empty())
    {
        throw "The list contains no elements.";
    }
    
    Node *node = this->tail;
    
    this->tail = this->tail->prev;
    this->tail->next = NULL;
    
    delete node;
    this->_size--;
}

void Queue::print()
{
    if (this->is_empty())
    {
        std::cout << "The list contains no elements." << std::endl;
        return;
    }
    
    Node *node = this->head;
    
    for (int i = 0; i < this->_size; i++)
    {
        std::cout << "Node " << i << ": " << node->data << std::endl;
        node = node->next;
    }
}
```

Example usage of this implementation:

```cpp
int main() {
    Queue *q = new Queue();
    q->push(4);
    q->push(2);
    q->push(3);
    q->push(9);
    q->push(7);
    
    q->print();
    
    q->pop();
    q->push(5);
    q->pop();
    
    std::cout << "The size of the current queue is: " << q->size() << std::endl;
    
    q->print();
    
    delete q;
    return 0;
}
```

This will give the following output:
```
Node 0: 7
Node 1: 9
Node 2: 3
Node 3: 2
Node 4: 4
The size of the current queue is: 4
Node 0: 5
Node 1: 7
Node 2: 9
Node 3: 3
Calling destructor.
Deleting node with value: 5
Deleting node with value: 7
Deleting node with value: 9
Deleting node with value: 3
```