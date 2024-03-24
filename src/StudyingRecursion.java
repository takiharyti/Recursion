/*
Author: Tenny Akihary
Class: *** ***
Project: StudyingRecursion
Purpose: Different functions and methods using recursion and exceptions.
 */
package studyingrecursion;

public class StudyingRecursion {
    public static void main(String[] args) {
        tr(6, 6);
    }
    
    //Factorial n! = n*(n-1)*(n-2)*---*2*1
    static int factRecursive(int n){
        //Base case
        if(n == 1)
            return 1;
        return n*factRecursive(n-1);
    }
    
    //Checking if n is a 2's power (2*2*2*2)
    static boolean i2pr(int n){
        if(n == 1)
            return true;
        return (n%2 == 0) && i2pr(n/2);
    }
    
    //Reversing a string
    static String rsr(String s){
        //Base Case
        if(s.length() == 1)
            return s;
        return s.charAt(s.length()-1) + rsr(s.substring(0, s.length()-1));
    }
    
    //GCD using Euclid's method
    //Iterative way
    static int gcdi(int n1, int n2){
        while(n2>0){
            int r = n1%n2;
            n1 = n2;
            n2 = r;
        }
        return n1;
    }
    
    //Recursive way
    static int gcdr(int n1, int n2){
        //Base case
        if(n2 == 0)
            return n1;
        return gcdr(n2, n1%n2);
    }
    
    //Decimal to binary
    static String dtbr(int n){
        if(n == 0)
            return "";
        return(dtbr(n/2) + n%2);
    }
    
    //Binary to Decimal
    static int btdr(String b){
        int n = b.length();
        if(n == 0)
            return 0;
        return(btdr(b.substring(0,n-1))*2+(b.charAt(n-1)-'0'));
    }
    
    //Printing a Triangle
    static void tr(int size, int n){
        if(n > 0){
            tr(size, n-1);
            for (int i = 0; i < size-n; i++) {
                System.out.print(" ");
            }
            for (int i = 1; i <= 2*n-1; i++) {
                System.out.print(n);
            }
            System.out.println();
        }
    }
    
}

class Recursion{
    private int[] a;
    
    //Constructor
    public Recursion(int[] array){
        a = array;
    }
    
    //Print array forward
    //N in these methods will be the number of elements to affect
    public void printF(int n){
        if(n > 0){
            printF(n-1);
            System.out.print(a[n-1]);
        }
    }
    
    //Print array backward
    public void printB(int n){
        if(n > 0){
            System.out.print(a[n-1]);
            printB(n-1);
        }
    }
    
    //Largest element
    public int maxA(int n){
        if(n == 1)
            return a[0];
        return Math.max(maxA(n-1), a[n-1]);
    }
    
    //Smallest element
    public int minA(int n){
        if(n == 1)
            return a[0];
        return Math.min(minA(n-1), a[n-1]);
    }
    
    //Reversing an array
    public void reverseA(int l, int r){
        if(l < r){
            int t = a[l];
            a[l] = a[r];
            a[r] = t;
            reverseA(l+1, r-1);
        }
    }
    
    //Mode of the int array - int that appears most often
    int mode(int n){
        if(n == 1)
            return a[0];
        int m = mode(n-1);
        int c1 = 0, c2 = 1;
        for (int i = 0; i < n-1; i++) {
            if(a[i] == m)
                c1++;
            else if(a[i] == a[n-1])
                c2++;
        }
        if(c1 > c2)
            return m;
        return a[n-1];
    }
    
    //Gridpath (Method Overloading)
    static void gridPath(int n, int m){
        gridPath(n, m, "");
    }
    
    static void gridPath(int n, int m, String s){
        if(n == 0){
            if(m == 0)
                System.out.println(s);
            else
                gridPath(n, m-1, s+"R");
        } else {
            if(m == 0)
                gridPath(n-1, m, s+"U");
            else{
                gridPath(n-1, m, s+"U");
                gridPath(n, m-1, s+"R");
            }
        }
    }
    
    //Bubble Sort v1
    public void bubble(int n){
        if(n > 1){
            for (int i = 0; i <= n-1; i++) {
                if(a[i] > a[i+1]){
                    int t = a[i];
                    a[i] = a[i+1];
                    a[i+1] = t;
                }
                bubble(n-1);
            }
        }
    }
    
    //Insertion sort
    public void insertion(int n){
        if(n > 1){
            insertion(n-1);
            int t = a[n-1];
            int i;
            for(i = n-2; i >= 0; i--){
                if(a[i] > t)
                    a[i+1] = a[i];
                else
                    break;
            }
            a[i+1] = t;
        }
    }
}
