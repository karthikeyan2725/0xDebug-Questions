### Question 5:
Select the Logical Error in the following Code Snippet for the function `multiplyMatrices`

```c
void multiplyMatrices(int A[ROWS_A][COLS_A], int B[ROWS_B][COLS_B], int result[ROWS_A][COLS_B]) {
    for (int i = 0; i < ROWS_A; i++) {
        for (int j = 0; j < COLS_B; j++) {
            result[i][j] = 0;
            for (int k = 0; k < COLS_A; k++) {
                result[i][j] += A[i][k] * B[j][k]; 
            }
        }
    }
}
```

1. There is No Error
2. Array A is accessed wrongly
3. Array B is accessed wrongly
4. Array result is accessed wrongly

`Ans`: 3. B must be accessed as B[k][j]

### Question 6:
Find the Output of the following code
```c
#include <stdio.h>

int main() 
{
    int a = -1, b = -a;
    int x, y;

    x = (a > 0) && (b < 0) || (a < 0) && (b > 0);
    y = (a <= 0) || (b >= 0) && (a >= 0) || (b <= 0);

    printf("%d\n", x == y);

    return 0;
}
```

a) 0 
b) 1 
c) Compiler Error
d) Undefined Behavior

`Ans`: 1
### Question 7:
The following Code snippet for the function `hasCycle`, uses hare-tortoise algorithm for detecting cycle in linked list. Read through the code carefully and select the option that is suitable.
```c
int hasCycle(struct Node* head) {
    struct Node* tortoise = head;
    struct Node* hare = head;
    while (hare != NULL) {
        tortoise = tortoise->next;
        hare = hare->next->next;

        if (tortoise == hare) {
            return 1;  // Cycle detected
        }
    }
    return 0;  // No cycle
}
```

1. The hare should move one step at a time instead of two.
2. The hare's initialization should be struct Node* hare = head->next.
3. The while must be improved by adding some condition.
4. There is no issue in the code; it will execute successfully.

`Ans`: 3. hare->next != NULL must also be checked in while loop

