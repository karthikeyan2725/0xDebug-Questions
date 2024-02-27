import java.util.Arrays;
class HackerRank{
    static int[] reverse(int[] items){
        int reversed[] = items.clone();
        int size = items.length; 
        int temp;
        for(int i = 0; i < size / 2; i++){
            temp = reversed[i];
            reversed[i] = reversed[size-1-i];
            reversed[size-1-i] = temp;
        }
        return reversed;
    }
    
    static int[] remove_zeros(int[] items){
        int reversed[] = reverse(items);
        int first = 0;
        for(int item: reverse(items)){
            if(item == 0){
                first += 1;
            }
            else{
                break;
            }
        }
        return Arrays.copyOfRange(reversed,first,reversed.length);
    }
    
    static int[] add(int[] poly1, int[] poly2){
        int size1 = poly1.length;
        int size2 = poly2.length;
        int resultSize = Math.max(size1, size2);
        
        int result[] = new int[resultSize];
        for(int i = 0; i < resultSize; i++){
            if(i<size1){
                result[i] += poly1[i];
            }
            if(i<size2){
                result[i] += poly2[i];
            }
        }
        return result;
    }
    
    static int[][][] split(int[] poly1, int[] poly2){
        int size1 = poly1.length;
        int size2 = poly2.length;
        int mid = Math.max(size1,size2) / 2;
        
        return new int[][][] {
            {   Arrays.copyOfRange(poly1,0,mid),
                Arrays.copyOfRange(poly1,mid,size1)
            },
            {   Arrays.copyOfRange(poly2,0,mid),
                Arrays.copyOfRange(poly2,mid,size2)
            }};
    }
    
    static int[] increase_exponent(int[] poly, int n){
        int polySize = poly.length;
        int maxSize =  polySize + n;
        int result[] = new int[maxSize];
        for(int i = n; i < maxSize;i++){
            result[i] = poly[i-n];
        }
        return result;
    }
    
    static int[] subract(int[] poly1, int[] poly2){
        int negPoly2[] = poly2.clone();
        for(int i = 0; i<negPoly2.length; i++){
            negPoly2[i] = -negPoly2[i];
        }
        return add(poly1,negPoly2);
    }
    
    static int[] multiply_polynomial(int[] poly1, int[] poly2, int m, int n){
        int result[];
        if(m==0 || n ==0){
            return new int[]{};
        }
        
        if(m==1){
            if(poly1[0] == 0){
                return new int[]{0};
            }
            else{
                result = poly2.clone();
                for(int i = 0; i<result.length;i++){
                    result[i] = poly1[0] * poly2[i];
                }
                return result;
            }
        }
        
        if(n==1){
            if(poly2[0] == 0){
                return new int[]{0};
            }
            else{
                result = poly1.clone();
                for(int i = 0; i<result.length;i++){
                    result[i] = poly2[0] * poly1[i];
                }
                return result;
            }
        }
        n = Math.max(m,n);
        
        int splitted[][][] = split(poly1,poly2);
        int A[][] = splitted[0];
        int B[][] = splitted[1];
        
        int add_A[] = add(A[0],A[1]);
        int add_B[] = add(B[0],B[1]);
        int Y[] = multiply_polynomial(add_A,add_B,add_A.length,add_B.length);
        int U[] = multiply_polynomial(A[0],B[0],A[0].length,B[0].length);
        int Z[] = multiply_polynomial(A[1],B[1],A[1].length,B[1].length);
        
        Y = increase_exponent(subract(Y,add(U,Z)),n/2);
        Z = increase_exponent(Z,n);
        
        result = add(Y,add(U,Z));
        result = remove_zeros(result);
        return result;
    }
    
    
    
    
    
    // public static void main(String args[]){
    //     int a[] = {1,2};
    //     for(int num: multiply_polynomial(a,a,a.length,a.length)){
    //         System.out.println(num+",");
    //     }
    // }
    public static void main(String args[]){
        int a[] = {1,2};
        for(int num: reverse(a)){
            System.out.println(num+",");
        }
    }
}