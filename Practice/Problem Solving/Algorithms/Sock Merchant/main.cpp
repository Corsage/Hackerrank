#include <vector>

using namespace std;

int sockMerchant(int n, vector<int> ar)
{
    int count = 0;

    int* arr = (int*) calloc(n, sizeof(int));

    arr[0] = ar.at(0);

    for (int i = 1; i < n; i++)
    {
        for (int j = 0; j < i; j++)
        {
            // Found a match.
            if (ar.at(i) == arr[j])
            {
                arr[j] = 0;
                count++;
                break;
            }
            else if (j == (i - 1))
            {
                arr[i] = ar.at(i);
            }
        }
    }

    return count;
}