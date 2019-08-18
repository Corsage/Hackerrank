#include <bits/stdc++.h>

/*
Node is defined as 

class Node {
    public:
        int data;
        Node *left;
        Node *right;
        Node(int d) {
            data = d;
            left = NULL;
            right = NULL;
        }
};

*/

/*
Initial Logic:
When we want to insert into a tree, starting from root:
1) If the data is smaller -> go left.
2) If the data is larger -> go right.

If the left/right node is null, we insert.
*/

/*
Time complexity: Average is O(log n), however O(n) worst case -- degenerate tree.
*/
Node *insert(Node *root, int data) {
    // If tree is empty.
    if (root == NULL)
    {
        Node *node = new Node(data);
        root = node;
    }
    else if (data > root->data)
    {
       if (root->right != NULL) 
       {
           insert(root->right, data)
       }
       else
       {
            Node *node = new Node(data);
           root->right = node;
       }
    }
    else
    {
        if (root->left != NULL)
        {
            insert(root->left, data)
        }
        else
        {
            Node *node = new Node(data);
            root->left = node;
        }
    }

    return root;
}