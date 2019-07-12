#include <vector>
#include <unordered_set>

using namespace std;

/* Time complexity is O(n). */
int sockMerchant(int n, vector<int> ar)
{
    int pairs = 0;

    unordered_set<int> colors;

    // Add the first color.
    colors.insert(ar.at(0));

    for (int i = 1; i < n; i++)
    {
        // Time complexity of find is O(1).
        if (colors.find(ar.at(i)) == colors.end())
        {
            // Time complexity of insert is O(1).
            colors.insert(ar.at(i));
        }
        else
        {
            pairs++;

            // Time complexity of erase is O(1).
            colors.erase(ar.at(i));
        }
    }

    return pairs;
}