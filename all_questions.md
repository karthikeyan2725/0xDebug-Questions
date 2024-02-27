> 🤖 : The answers to question with this emoji is only known to those who are *well versed* in C.
> `-` : avoid selecting these questions if possible 
## Bugs specific to Language (5):
### Question 1 🤖: 

Go through the following code, and Choose the option.
```c
#include <stdio.h>

void print_all_elements(int arr[]){
    int n = sizeof(arr) / sizeof(int);
    printf("{");
    for(int i = 0; i<n-1; i++){
        printf("%d,",arr[i]);
    }
    printf("%d}",arr[n-1]);
}

int main() {
    int num_list[] = {1,2,3,4,5};
    print_all_elements(num_list);
}
```
`The given code Outputs`:
1. {1,2,3,4,5,21039,42057}
2. {1,2,3,4}
3. Compilation Error: sizeof not found
4. {1,2}

`Output`: {1,2}

`Bug`: In the function call, the size of array pointer (8 Bytes) is used instead of size of actual array (20 Bytes), and since the array size is divided by the size of int type(4), only 2 elements are printed.

`Debug`: The size of the integer array must be passed from outside 

```c
    #include <stdio.h>

    void print_array(int arr[],int n){
        printf("{");
        for(int i = 0;i<n-1;i++){
            printf("%d,",arr[i]);
        }
        printf("%d}",arr[n-1]);
    }

    int main() {
        int num_list[] = {1,2,3,4,5};
        int n = sizeof(num_list) / sizeof(int);
        print_array(num_list,n);
    }
```
`output`: {1,2,3,4,5}

###  Question 2  🤖:
```c
#include<stdio.h>
void _start(){}
void main(){
    int a[] = {21,1,76};
    printf("%d",a);
}
```
`What may be output of the code`:
1. The Code prints 21
2. Prints the base address of array a
3. Compilation Error
4. Segmentation Fault

`Bug`: _start() function is an initialization function that executes before main(), behind the scenes. It is already declared, so you get a compilation error .

### Question 3 - Sneaky Fork 🤖:
```c
#include<stdio.h>
#include<unistd.h>
void main(){
    printf("ThisIsCryptera");
    fork();
    fork();
}
```
`options`:
1. prints ThisIsCryptera
2. prints ThisIsCrypteraThisIsCryptera
3. prints ThisIsCrypteraThisIsCrypteraThisIsCrypteraThisIsCryptera

`Bug`:
printf string is buffered until `\n` is encountered. So, upon fork, another buffer containing ThisIsCryptera is created. Hence the string will be printed *four* times.
### Question 4 🤖:

```c
    #include<stdio.h>
    #define MAIN void main() CODE
    #define CODE {printf("This is main\n");}
    MAIN
```
`options`:
1. Compilation error: CODE undeclared
2. Compilation error: undefined reference to main
3. Prints "This is main"
4. [choice 4]

`ans`: There is no bug, because the order of execution of the preprocessors does not matter. Hence 3 is the correct answer.

### Question 5 🤖:
```c
    void main(){
        int a = 0;
        if(a=++a){
            printf("If with %d",a);
        }else{
            printf("Else with %d",a);
        }
    }
```
`options`:
1. If With 0
2. If WIth 1
3. Else with 0
4. Else with 1

`Ans`: **If with 1**. In the expression, `a = ++a` the value that is assigned to `a` will be returned. since a is incremented to `1`, `if(1)` will be executed.


## Debugging for All languages(15):

### Question 1:
Consider the following function function `Search` that takes an  array `a`, the starting index `start`, the `last` index, and a integer `item` to search.

 This function was written to find the index of the `item` in the array. 
 
 But `Search` is not able to produce the correct output.

```c
int Search(int a[], int start, int last, int item){
    int mid;
    if(last >= start){
        mid = (start + last)/2;
        if(a[mid] == item){
            return mid;
        }
        else if(a[mid] < item){
            return Search(a,start,mid+1,item);
        }
        else{
            return Search(a,mid-1,last,item);
        }
    }
    return -1;
}
```

select all the lines needs to be changed to get a correct output for this search function?

1. line 9
2. line 2
3. line 12
4. line 5

`Answer`: 1 and 3

#### Correct code:
```c
int Search(int a[], int start, int last, int item){
    int mid;
    if(a[mid] == item){
        return mid;
    }
    else if(a[mid] < item){
        return Search(a,mid+1,last,item); 
    }
    else{
        return Search(a,start,mid-1,item); 
    }
    return -1;
}
```
### Question 2:
The following code snippet to Check whether a given year is leap year or not.
`For example: `
If the user enters the year 2020 , then the output will be **2020 is a Leap Year**.
If the user enters the year 2023 , then the output will be **2023 is not a Leap Year**.

```c
#include<stdio.h>
int main ()
{
    int year;
    scanf("%d",&year);

    if(year % 200 == 0)
    printf("%d is a Leap Year",year);

    else if(year % 4 == 0 && year % 200 != 0)
    printf("%d is a Leap Year",year);

    else
    printf("%d is not a Leap Year",year);

    return 0;
}
```
Find out line containing the logical error and select the option that must be replaced with that line

1. if (year % 400 == 0)
2. else if (year % 200 == 0 && year % 4 == 0)
3. if (year % 4 == 0)
4. if (year % 100 == 0)

`Ans`: 1

### Question 3:
The following code snippet To Find out the Sum of Digits of a Number.

```c
    1 #include<stdio.h>
    2 int main ()
    3 {
    4    int num, sum = 0;
    5    printf("Enter a number: ");
    6    scanf("%d",&num);
    7    while(num!=0){
    8       sum =+ num % 10;
    9       num = num % 10;
    10   }
    11   printf("Sum: %d",sum);
    12   return 0;
    13 }
```

For example: 

    Enter a number:
    223153
    Output:
    Sum: 16

The code snippet fails to give the desired results for some test cases due to logical errors. Your task is to select all of the following changes that needs to be done to the code to get the expected output.

 Note: `Only select them if those changes are necessary`

1. Replace line 8 with sum = sum + num % 10;
2. Replace line 8 with sum = sum + num;
3. Replace line 9 with num = num / 10;
4. No Changes has to be done

`Ans`: 1 and 3. Line 8 has a syntactical error, with `=+` instead of `+=`, and in line 9, `%` is replaced by `/` (wrong logic).

#### Corrected Code:
```c
int main ()
{
    int num, sum = 0;
    printf("Enter a number: ");
    scanf("%d",&num);
    while(num!=0){
        sum = sum + num % 10; <---
        num = num / 10; <---
    }
    printf("Sum: %d",sum);
    return 0;
}
```
### Question 4:
The below question is to check, can we able to reach the last element of the array by starting from 0th index of the array. 

The index has to be incremented by value in that index position. N is the length of the array. 

`arr_step_count` array contains values (step count) ranging from 0 <= step_count <= ∞

```c
    #include<stdio.h>
    #include<stdlib.h>
    void main(){
        int N, *arr_step_count,current_index = 0;
        scanf("%d",&N);
        arr_step_count = (int*)calloc(N,sizeof(int));
        
        for(int i = 0;i<N;i++){
            scanf("%d",arr_step_count+i);
        }
        while(current_index < N-1){
            current_index += arr_step_count[current_index];
        }
        
        if (current_index == N-1){
            printf("True");
        }
        else{
            printf("False %d",current_index);
        }
        
    }
```
Is there any possibilities for infinite loop?
1. Yes
2. No

`Ans`: 1. The code produces infinite loop if array[current_index] is 0.

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

### Question 8:

```c
int fibonacci(int n){
    if(n<=1){
        return n;
    }
    else{
        return fibonacci(n-1) + fibonacci(n-2);
    }
}

void main(){
    printf("%d",fibonacci(3));
}
```

1.	Code logic is deviated due to the line number 2 “if (n<=1)”
2.	Code does not stop resulting in infinite loop
3.	Code does not have any errors
4.	Code shows an error in concatenation 

`Ans`: 3. Code does not have any errors

### Question 9:

```c
int finding_palindrome(int num){
    int temp = num;
    int result = 0;
    while(num>0){
        int rem = num % 10;
        result = result + 10 * num;
        num /= 10;
    }
    return (result == temp)? 1 : 0;
}

void main(){
    printf("%d",finding_palindrome(1001));
}
```
To make the above code work properly, how many changes has to be made.
1. No error
2. Three
3. Two
4. One

`Ans`: 2

### Question 10:
Graph
```c

void DFS(int start) {
    int visited[MAX_VERTICES] = {0};
    int stack[MAX_VERTICES];
    int top = -1;
    stack[++top] = start;

    while (top != -1) {
        int current = stack[top--];
        if (!visited[current]) {
            printf("%d ", current);
            visited[current] = 1;
        }
        for (int neighbor = 0; neighbor < V; ++neighbor) {
            if (adj[current][neighbor] && !visited[neighbor]) {
                stack[++top] = neighbor;
            }
        }
    }
}
```
What change would transform Depth-First Search (DFS) into Breadth-First Search (BFS)?

1. Replace the stack with a queue.
2. Change stack push to stack insert.
3. Modify the DFS function to use recursion instead of a stack.
4. Add an additional check to ensure the visited nodes are explored in a specific order.

### Question 11:
Read through the following code for Linked List reversal with the following functions.
```c
void reverseLinkedList(struct Node** head) {
    struct Node* prev = NULL;
    struct Node* current = *head;
    struct Node* next = NULL;

    while (current != NULL) {
        current->next = prev;
        current = next;
        next = current->next;
        prev = current;
    }
    *head = prev;
}
```

What must be the **order** of the lines inside the while loop must follow, to reverse the linked list.
1. 8,7,10,9
2. 9,7,10,8
3. 7,10,9,8
4. 9,7,8,10

`ans`: 2

    next = current->next; 9
    current->next = prev; 7
    prev = current; 10
    current = next; 8
### Question 12:
Go through the following code for binary search
```c
int binarySearch(int arr[], int low, int high, int target) {
    while (low <= high) {
        int mid = low + (high - low) / 2;
        if (arr[mid] == target)
            return mid;
        else if (arr[mid] < target)
            low = mid + 1;
        else
            high = mid - 1;
    }
    return -1; 
} 
```
1. Change while `(low <= high)` to while `(low < high)`.
2. Change `int mid = low + (high - low) / 2;` to `int mid = low + (high - low + 1) / 2;`.
3. Change if `(arr[mid] < target)` to if `(arr[mid] <= target)`.
4. Change `return -1;` to `return low`;.

### Question 13:
In the following function `invalid` Checks if a given string has balanced parentheses, curly braces, and square brackets.

`initialize`: Initializes a custom stack.
`push`: Pushes a character onto the stack.
`pop`: Pops the top character from the stack.
`isEmpty`: Checks if the stack is empty.
```c
bool isValid(char* s) {
    Stack stack;
    initialize(&stack);

    for (int i = 0; s[i] != '\0'; i++) {
        char c = s[i];
        if (c == '(' || c == '{' || c == '[') {
            push(&stack, c);
        } else {
            if (isEmpty(&stack) || pop(&stack) != c) {
                return false;
            }
        }
    }
    return isEmpty(&stack);
}
```
 Choose the suitable option
1. Incorrect condition in the first if block
2. Incorrect condition in the second if block
3. Incorrect condition in the last else if block 
4. No Error

`Ans`: 3
### Question 14:
```c
int main() {
    int temp = 40;
    
    if (temp == 30 && temp / 0 == 4) {
        printf("1\n");
    } else {
        printf("2\n");
    }

    return 0;
}
```
1) 2 
2) 1 
3) Runtime Exception of java.lang.ArithimeticException 
4) Compliation error due to divisibility by 0

`Ans`: option 1.
### Question 15:

```c
int* twoSum(int* nums, int numsSize, int target) {
    for (int i = 0; i < numsSize; i++) {
        for (int j = i + 1; j < numsSize; j++) {
            if (nums[i] + nums[j] == target) {
                int* result = (int*)malloc(2 * sizeof(int));
                result[0] = i;
                result[1] = j;
                return result;
            }
        }
    }
    return NULL;
}
```
Choose the correct option 
1. The condition in the first for loop
2. The condition in the second for loop
3. ArrayIndexOutOfBoundsException in the inner loop condition 
4. No error introduced
`Ans`: 3

### Resources:
1. https://www.geeksforgeeks.org/common-memory-pointer-related-bug-in-c-programs/ - `s1`

2. https://prepinsta.com/cognizant/code-debugging/ - `c1,c2,c3`

3. Ariharan - `c4,c8,c9`

4. karthikeyan P - `c5,c6,c7`
