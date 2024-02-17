### Question 1: 
Go through the following code, and Choose the option.

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

`The given code Outputs`:
1. {1,2,3,4,5,21039,42057}
2. {1,2,3,4}
3. Compilation Error: sizeof not found
4. {1,2}

`Output`: {1,2}

`Bug`: In the above code, the size of array pointer(8) is used instead of size of actual array, and since the array size is divided by the size of int type(4), only 2 elements are printed.

`Debug`: The size of the integer array must be passed from outside 

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
`output`: {1,2,3,4,5}

### Question 2 

    #include<stdio.h>
    void _start(){}
    void main(){
        int a[] = {21,1,76};
        printf("%d",a);
    }

`What may be output of the code`:
1. The Code prints 21
2. Prints the base address of array a
3. Compilation Error
4. Segmentation Fault

`Bug`: _start() function is an initialization function that executes before main(). It is already declared, so you get an compilation error.

### Question 3 - Sneaky Fork
    #include<stdio.h>
    #include<unistd>
    void main(){
        printf("ThisIsCryptera");
        fork();
    }
`options`:
1. prints ThisIsCryptera
2. prints ThisIsCrypteraThisIsCryptera

`Bug`:
printf string is buffered until \n is encountered. So, upon fork, 2 of 
### Question 4 :

    #include<stdio.h>
    #define MAIN void main() CODE
    #define CODE {printf("This is main\n");}
    MAIN

`options`:
1. Compilation error: CODE undeclared
2. Compilation error: undefined reference to main
3. Prints This is main
4. 
`bug`: There is no bug, because the order of execution of the preprocessors does not matter.

### Question 5:
    void main(){
        int a = 0;
        if(a=++a){
            printf("If with %d",a);
        }else{
            printf("Else with %d",a);
        }
    }

`options`:
1. If With 0
2. If WIth 1
3. Else with 0
4. Else with 1

`Ans`: If with 1
### Resources:
1. https://www.geeksforgeeks.org/common-memory-pointer-related-bug-in-c-programs/ - `1`