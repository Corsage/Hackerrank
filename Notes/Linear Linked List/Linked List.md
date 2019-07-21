# Linked List

This data structure uses linked storage, an alternative to sequential storage. Linked lists rely heavily on pointers and dynamically allocated memory. There are a wide variety of implementations as this is a very general and well known data structure.

A linked list contains many operations, however this will cover the following:

| Method        | Description                                 |
| ------------- | ------------------------------------------- |
| `insert`      | Adds a new element to the end of the list.  |
| `remove`      | Removes the specified element from the list.|
| `get`         | Get the element associated to an index.     |
| `size`        | Returns the current size of the stack.      |
| `is_empty`    | Returns true if the stack is empty.         |

## Time Complexity

For all **standard operations** (insert, remove, and get) the worst-case runtime is **O(n)**. The implementation of this data structure below showcases that these operations transverse the list. However, in this implementation we did not add a tail pointer. If we did, then the runtime for insertions would become O(1).

The **copy constructor and assignment operator** are **O(n)** -- where n is the number of elements on the stack. This is because each element must be copied (copying one element takes constant time). 

The **destructor** when a linked list is used (this implementation uses linked list) results in **O(n)** runtime. This is because we must transverse thru the remaining elements and free them one-by-one.

| Method        | Time Complexity |
| ------------- | --------------- |
| `insert`      | O(1)            |
| `remove`      | O(n)            |
| `get`         | O(n)            |
| `size`        | O(1)            |
| `is_empty`    | O(1)            |

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

class LinkedList
{
private:
    int _size;
    Node *head;
public:
    LinkedList();
    ~LinkedList();
    
    // Standard operations.
    void insert(int data);
    void remove(int index);
    
    int get(int index);
    
    int size();
    
    bool is_empty();
    
    // Helper function.
    void print();
};

LinkedList::LinkedList()
{
    this->_size = 0;
    this->head = NULL;
}

int LinkedList::size()
{
    return this->_size;
}

bool LinkedList::is_empty()
{
    return this->_size == 0;
}

void LinkedList::insert(int data)
{
    Node *node = new Node;
    node->data = data;
    node->next = NULL;
    
    if (this->is_empty())
    {
        this->head = node;
    }
    else
    {
        Node *head = this->head;
    
        // Transverse thru list.
        while (head->next != NULL)
        {
            head = head->next;
        }
    
        head->next = node;
    }
    
    this->_size++;
}

void LinkedList::remove(int index)
{
    if (index >= _size)
    {
        throw "Index is greater than size.";
    }
    
    Node *head = this->head;
    Node *prev = NULL;
    
    // Transverse list till we reach the index.
    for (int i = 0; i < _size; i++)
    {
        if (i == index)
        {
            Node* next = head->next;
            prev->next = next;
    
            delete head;
            this->_size--;
            break;
        }
    
        prev = head;
        head = head->next;
    }
}

int LinkedList::get(int index)
{
    if (index >= _size)
    {
        throw "Index is greater than size.";
    }
    
    Node *node = this->head;
    
    // Transverse list till we reach the index.
    for (int i = 0; i < _size; i++)
    {
        if (i == index)
        {
            return node->data;
        }
        node = node->next;
    }
}

void LinkedList::print()
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