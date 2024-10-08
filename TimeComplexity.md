## Commmon Looping Time Complexity

# 1) O(1): 

Time complexity of a function (or set of statements) is considered as O(1) if it doesn't contain loop, recursion, and call to any other non-constant time function. 
 

   // set of non-recursive and non-loop statements

For example, swap() function has O(1) time complexity. 
A loop or recursion that runs a constant number of times is also considered as O(1). For example, the following loop is O(1). 
 

   // Here c is a constant   
   for (int i = 1; i <= c; i++) {  
        // some O(1) expressions
   }

# 2) O(n): 

Time Complexity of a loop is considered as O(n) if the loop variables are incremented/decremented by a constant amount. For recursive call in recursive function, the time complexity is considered as O(n). For example following functions have O(n) time complexity. 
 

   // Here c is a positive integer constant   
   for (int i = 1; i <= n; i += c) {  
        // some O(1) expressions
   }

   for (int i = n; i > 0; i -= c) {
        // some O(1) expressions
   }
 

//Recursive function
void recurse(n)
{
    if(n==0)
        return;
    else{
        // some O(1) expressions
    }
    recurse(n-1);
}

# 3) O(nc): 

Time complexity of nested loops is equal to the number of times the innermost statement is executed. For example, the following sample loops have O(n2) time complexity 
 

  
   for (int i = 1; i <=n; i += c) {
       for (int j = 1; j <=n; j += c) {
          // some O(1) expressions
       }
   }

   for (int i = n; i > 0; i -= c) {
       for (int j = i+1; j <=n; j += c) {
          // some O(1) expressions
   }

For example, Selection sort and Insertion Sort have O(n2) time complexity. 


# 4) O(Logn) 

Time Complexity of a loop is considered as O(Logn) if the loop variables are divided/multiplied by a constant amount. 
 

   for (int i = 1; i <=n; i *= c) {
       // some O(1) expressions
   }
   for (int i = n; i > 0; i /= c) {
       // some O(1) expressions
   }

For example, Binary Search(refer iterative implementation) has O(Logn) time complexity. Let us see mathematically how it is O(Log n). The series that we get in the first loop is 1, c, c2, c3, ... ck. If we put k equals to Logcn, we get cLogcn which is n. 


# 5) O(LogLogn) 

Time Complexity of a loop is considered as O(LogLogn) if the loop variables are reduced/increased exponentially by a constant amount. 
 

   // Here c is a constant greater than 1   
   for (int i = 2; i <=n; i = pow(i, c)) { 
       // some O(1) expressions
   }
   //Here fun is sqrt or cuberoot or any other constant root
   for (int i = n; i > 1; i = fun(i)) { 
       // some O(1) expressions
   }

# Common Algorithm Time complexity

|Algorithm	     | Best Case|	Average Case	|Worst Case|
|---|---|---|---|
|Selection Sort	 |O(n^2)   	|O(n^2)	|O(n^2)|
|Bubble Sort	     | O(n)	  |  O(n^2)|	O(n^2)|
|Insertion Sort	 | O(n)	  | O(n^2)	  |O(n^2)|
|Tree Sort	      | O(nlogn)	|O(nlogn)	|O(n^2)|
|Radix Sort	    |  O(dn)	   | O(dn)	|  O(dn)|
|Merge Sort	    |O(nlogn)	|O(nlogn)	|O(nlogn)|
|Heap Sort	     | O(nlogn)	|O(nlogn)	|O(nlogn)|
|Quick Sort	   | O(nlogn)	|O(nlogn)|	O(n^2)|
|Bucket Sort	   |  O(n+k)	|   O(n+k)	|  O(n^2)|
|Counting Sort	  | O(n+k)	  | O(n+k)	 | O(n+k)|
 

## Analysis of Recursion

Many algorithms are recursive. When we analyze them, we get a recurrence relation for time complexity. We get running time on an input of size n as a function of n and the running time on inputs of smaller sizes. For example in Merge Sort, to sort a given array, we divide it into two halves and recursively repeat the process for the two halves. Finally, we merge the results. Time complexity of Merge Sort can be written as T(n) = 2T(n/2) + cn. There are many other algorithms like Binary Search, Tower of Hanoi, etc. 

There are mainly three ways of solving recurrences:

# Substitution Method:
We make a guess for the solution and then we use mathematical induction to prove the guess is correct or incorrect. 

For example consider the recurrence T(n) = 2T(n/2) + n

We guess the solution as T(n) = O(nLogn). Now we use induction to prove our guess.

We need to prove that T(n) <= cnLogn. We can assume that it is true for values smaller than n.

T(n) = 2T(n/2) + n
     <= 2c(n/2Log(n/2)) + n
       =  cnLogn - cnLog2 + n
       =  cnLogn - cn + n
    <= cnLogn

# Recurrence Tree Method:
In this method, we draw a recurrence tree and calculate the time taken by every level of the tree. Finally, we sum the work done at all levels. To draw the recurrence tree, we start from the given recurrence and keep drawing till we find a pattern among levels. The pattern is typically arithmetic or geometric series. 
 

For example, consider the recurrence relation 

T(n) = T(n/4) + T(n/2) + cn2

            cn2
            /      \
  T(n/4)     T(n/2)

If we further break down the expression T(n/4) and T(n/2), 
we get the following recursion tree.

                    cn2
              /             \      
    c(n2)/16          c(n2)/4
   /         \            /         \
T(n/16)  T(n/8)  T(n/8)    T(n/4) 

Breaking down further gives us following

                       cn2 
                /                \     
       c(n2)/16              c(n2)/4
    /          \                 /          \
c(n2)/256  c(n2)/64  c(n2)/64   c(n2)/16
 /    \            /    \      /    \        /    \  

To know the value of T(n), we need to calculate the sum of tree 
nodes level by level. If we sum the above tree level by level, 

we get the following series T(n)  = c(n^2 + 5(n^2)/16 + 25(n^2)/256) + ....
The above series is a geometrical progression with a ratio of 5/16.

To get an upper bound, we can sum the infinite series. We get the sum as (n2)/(1 - 5/16) which is O(n2)

# Master Method:
Master Method is a direct way to get the solution. The master method works only for the following type of recurrences or for recurrences that can be transformed into the following type. 
 

T(n) = aT(n/b) + f(n) where a >= 1 and b > 1


There are the following three cases: 

If f(n) = O(nc) where c < Logba then T(n) = Θ(nLogba) 
If f(n) = Θ(nc) where c = Logba then T(n) = Θ(ncLog n) 
If f(n) = Ω(nc) where c > Logba then T(n) = Θ(f(n)) 
How does this work? 
The master method is mainly derived from the recurrence tree method. If we draw the recurrence tree of T(n) = aT(n/b) + f(n), we can see that the work done at the root is f(n), and work done at all leaves is Θ(nc) where c is Logba. And the height of the recurrence tree is Logbn 
 

Master Theorem


In the recurrence tree method, we calculate the total work done. If the work done at leaves is polynomially more, then leaves are the dominant part, and our result becomes the work done at leaves (Case 1). If work done at leaves and root is asymptotically the same, then our result becomes height multiplied by work done at any level (Case 2). If work done at the root is asymptotically more, then our result becomes work done at the root (Case 3). 

Examples of some standard algorithms whose time complexity can be evaluated using the Master Method 

Merge Sort: T(n) = 2T(n/2) + Θ(n). It falls in case 2 as c is 1 and Logba] is also 1. So the solution is Θ(n Logn) 
Binary Search: T(n) = T(n/2) + Θ(1). It also falls in case 2 as c is 0 and Logba is also 0. So the solution is Θ(Logn) 
Notes: 

It is not necessary that a recurrence of the form T(n) = aT(n/b) + f(n) can be solved using Master Theorem. The given three cases have some gaps between them. For example, the recurrence T(n) = 2T(n/2) + n/Logn cannot be solved using master method. 
Case 2 can be extended for f(n) = Θ(ncLogkn) 
If f(n) = Θ(ncLogkn) for some constant k >= 0 and c = Logba, then T(n) = Θ(ncLogk+1n) 
