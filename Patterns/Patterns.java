/*

Patterns

Steps
=====
1) Identify the no of rows
2) Indentify the number of columns and map the columns to the row using some equation
3) Print in the inner loop

*/


import java.io.*;
import java.util.*;


public class Patterns{
    
    /*
     *  *  *
     *  *  *
     *  *  *
     */
    public static void pattern1(int n){
        
        for(int i=0;i<n;i++){
            for(int j =0;j<n;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    
    
     /*
     *  
     *  *  
     *  *  *
     */
    public static void pattern2(int n){
        
        for(int i=1;i<=n;i++){
            for(int j =1;j<=i;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    
     /*
     1  
     1  2  
     1  2  3
     
     1 -> 1
     2 -> 1, 2
     3 -> 1, 2, 3
     */
    public static void pattern3(int n){
        
        for(int i=1;i<=n;i++){
            for(int j =1;j<=i;j++){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
    
    
     /*
     *  *  *  
     *  *  
     *
     
     n = 3
     1 -> 1,2, 3   => 3 -1 (current row no) +1
     2 -> 1, 2     => 3 -2 (current row no) +1
     3 -> 1        => 3-3 (current row no) +1
     
     */
    public static void pattern4(int n){
        
        for(int i=1;i<=n;i++){
            for(int j =1;j<=n-i+1;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    
    
     /*
     1  2  3  
     1  2  
     1
     
     n = 3
     1 -> 1,2, 3   => 3 -1 (current row no) +1
     2 -> 1, 2     => 3 -2 (current row no) +1
     3 -> 1        => 3-3 (current row no) +1
     
     */
    public static void pattern5(int n){
        
        for(int i=1;i<=n;i++){
            for(int j =1;j<=n-i+1;j++){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
    
    
     
     /*
           *
        *  *   *
     *  *  *   *  *
    
    
    n = 3
       [ space , star , space]
    0  [2 , 1,  2]
    1  [1 , 3,  1] 
    2  [0,  5 , 0]
    
     n-i-1 , 2i+1 , n-i-1  
     
     */
    public static void pattern6(int n){
        
        for(int i=0;i<n;i++){
            //Spaces
            for(int j =0;j<n-i-1;j++){
                System.out.print(" ");
            }
            
            //Stars
            for(int j=0;j<2*i+1;j++){
                System.out.print("*");
            }
            
            //Spaces
            for(int j =0;j<n-i-1;j++){
                System.out.print(" ");
            }
            System.out.println();
        }
    }
    
    
      /*
       
     *  *  *   *  *
        *  *   *
           *
           
    n = 3
       [ space , star , space]
    0  [0 , 5,  0]
    1  [1 , 3,  1] 
    2  [2,  1 , 2]
    
      same as i , 2n - 2i+1 , same as i 
     
     */
    public static void pattern7(int n){
        
        for(int i=0;i<n;i++){
            //Spaces
            for(int j =0;j<i;j++){
                System.out.print(" ");
            }
            
            //Stars
            for(int j=0;j<2*n - (2*i+1);j++){
                System.out.print("*");
            }
            
            //Spaces
            for(int j =0;j<i;j++){
                System.out.print(" ");
            }
            System.out.println();
        }
    }
    
    
     /*
           *
        *  *   *
     *  *  *   *  *
     *  *  *   *  *
        *  *   *
           *
     n = 3
       [ space , star , space]
    0  [2 , 1,  2]
    1  [1 , 3,  1] 
    2  [0,  5 , 0]
    
     n-i-1 , 2i+1 , n-i-1  
     
     [ space , star , space]
    0  [0 , 5,  0]
    1  [1 , 3,  1] 
    2  [2,  1 , 2]
    
      same as i , 2n - 2i+1 , same as i 
    
    */
     public static void pattern8(int n){
         
         pattern6(n);
         pattern7(n);
         
     }
     
     
     /*

    *
    *   *
    *   *  *
    *   *   
    *
    
    n = 3 
    
    row = 2*n -1 = 5
    
    1 -> 1
    2 -> 2
    3 -> 3
    4 -> 2    (2*n -i)
    5 -> 1
    
    */
     public static void pattern9(int n){
        
        for(int i=1; i < (2*n-1) ;i++){
            int stars = i;
            if( i > n)
                stars = 2*n -i;
            for(int j =1;j<stars;j++){
                System.out.print("*");
             }
            System.out.println();
        }
           
        
    }
    /*
    
    1
    0 1
    1 0 1
    0 1 0 1
    
    
    */
    
    public static void pattern10(int n){
        int start = 1;
        for(int i = 0; i< n ;i ++){
          if( i %2 == 0)
             start = 1;
          else
             start = 0;
        
          for(int j = 0; j<=i;j++){
              System.out.print(start);
              start = 1- start; //flipping of numbers
          }
          System.out.println();
        }
           
        
    }
    
     /*
    
    1         1
    1 2     2 1
    1 2 3 3 2 1
    
    n = 3, row =3
    
      [num , space , num]
    0 [ 1, 4 ,1]
    1 [2 ,2, 2]
    2 [3, 0, 3]
    
     [right angle Triangle, 2*n-2, left angled triangle]
    */
    
    public static void pattern11(int n){
        
        int space = 2*n-2;
        for(int i = 1; i<= n ;i ++){
          
          //For rigt angled triangle
          for(int j = 1; j<=i;j++){
              System.out.print(j);
          }
          
          //For space
          for(int j = 1; j<=space;j++){
              System.out.print(" ");
          }
          
          //For rigt angled triangle
         for(int j = i; j>= 1;j--)
              System.out.print(j);
          
          System.out.println();
          space -=2;
        }
           
        
    }
    
    
    /*
    
    1
    2 3
    4 5 6
    
    */
    
     public static void pattern12(int n){
         int num = 1;
         for(int i = 1;i<= n;i++){
             for(int j =1;j<=i;j++){
                 System.out.print(num +" ");
                 num +=1;
             }
             System.out.println();
         }
     }
    
    
     /*
    
    A
    A B
    A B C
    
    */
    
     public static void pattern13(int n){
         for(int i = 0;i< n;i++){
             for(char j ='A';j< 'A'+i;j++){
                 System.out.print(j +" ");
             }
             System.out.println();
         }
     }
    
    
     /*
 
    A B C
    A B
    A
    
    */
    
     public static void pattern14(int n){
         for(int i = 0;i< n;i++){
             for(char j ='A';j< 'A'+(n-i-1);j++){
                 System.out.print(j +" ");
             }
             System.out.println();
         }
     }
     
    /*
 
    A 
    B B
    C C  C
    
    */
    
     public static void pattern15(int n){
         char alpha = 'A';
         for(int i = 0;i< n;i++){
             for(int j = 0;j<= i;j++){
                 System.out.print(alpha);
             }
             System.out.println();
             alpha += 1;
         }
     }
     
     
     /*
          A
        A B A
     A  B C B A
     
     n=3
     
      [ space, characters, Space]
     0 [2 , 1 , 2]
     1 [1 , 3,  1]
     2 [0,  5,  0]
     
     [n-i-1 , 2i+1, n-i-1]
     
     */
     public static void pattern16(int n){
         for(int i = 0;i< n;i++){
             //space
             for(int j = 0;j< n-i-1;j++){
                 System.out.print(" ");
             }
             
             
             //Characters
             char chara = 'A';
             int breakpointOfSymmetry = (2*i+1)/2;
             for(int j = 0;j< 2*i+1;j++){
                 System.out.print(chara);
                 if(j>= breakpointOfSymmetry)
                  chara--;
                 else
                  chara++;
                 
             }
             
             
             //space
             for(int j = 0;j< n-i-1;j++){
                 System.out.print(" ");
             }
             System.out.println();
         }
     }
     
     
     /*
     
     E
     D E
     C D E
     
     n = 3
     
      E , E-1 = D, E-2 = C
     
     */
     
      public static void pattern17(int n){
         for(int i = 0;i<n;i++){
             for(char ch = (char) ('E' - i) ;ch <= 'E';ch++){
                 System.out.print(ch);
             }
             System.out.println();
         }
      }
      
      /*
      
        * * * * * *
        * *     * *
        *         *
        *         *
        * *     * *
        * * * * * *
        
        first symmetry
        ------------------
        n = 3
      
        [ stars , space, stars]
       1 [  3 , 0 , 3]
       2 [  2,  2,  2]
       3 [  1,  4,  1]
        
        [n-i+1 , increment by 2, n-i+1]
        
        
        second symmetry
        ---------------
        n = 3
        
        
        [ stars , space, stars]
       1 [  1 , 4 , 1]
       2 [  2,  2,  2]
       3 [  3,  0,  3]
        
        [i , decrement by 2 ( 2n-2) , i]
          
      
      
      */
       public static void pattern18(int n){
         
         //Top symmetry
         int space = 0;
         for(int i = 1;i<=n;i++){
             
             
             //stars
             for(int j = 1; j <= n-i+1;j++){
                 System.out.print("*");
             }
             
             
             //space
             for(int j = 0;j<space;j++){
                 System.out.print(" ");
             }
             
             
             //stars
             for(int j = 1; j <= n-i+1;j++){
                 System.out.print("*");
             }
             System.out.println();
             space+=2;
         }
         
         //Bottom symmetry
         space = 2*n -2;
         for(int i = 1;i<=n;i++){
             
             
             //stars
             for(int j = 1; j <= i;j++){
                 System.out.print("*");
             }
             
             
             //space
             for(int j = 0;j<space;j++){
                 System.out.print(" ");
             }
             
             
             //stars
             for(int j = 1; j <= i;j++){
                 System.out.print("*");
             }
             System.out.println();
             space-=2;
         }
         
      }
      
      /*
      
      *         *
      * *     * *
      * * * * * *
      * *     * *
      *         *
      
      n = 3
      
      rows = 2*n-1
      
      [ stars, space, stars]
       1 [ 1, 4, 1]
       2 [ 2, 2, 2]
       3 [ 3, 0, 3]
       4 [ 2, 2, 2]
       5 [ 1, 4, 1]
       
       
      */
       public static void pattern19(int n){
         
         int stars = 0;
         int space = 2*n-2;
         for(int i = 1;i<=2*n-1;i++){
             
             if(i>n)
                stars = 2*n-i;
             else
                stars = i;
             //stars
             for(int j = 1; j <= stars;j++){
                 System.out.print("*");
             }
             
             
             //space
             
             for(int j = 1;j<=space;j++){
                 System.out.print(" ");
             }
             
             
             //stars
             for(int j = 1; j <= stars;j++){
                 System.out.print("*");
             }
             System.out.println();
             if(i >= n)
              space+=2;
             else
              space-=2;
         }
       }
       
       /*
       
       * * * 
       *   *
       * * *
       
       Stars only in the border , so i =0, j=0, i=n-1, j=n-1
       
       */
         public static void pattern20(int n){
         
           for(int i =0;i<n;i++){
               for(int j=0;j<n;j++){
                   if(i==0 || j ==0 || i == n-1 || j== n-1){
                       System.out.print("*");
                   }else{
                        System.out.print(" ");
                   }
               }
               System.out.println();
           }
         }
    
    public static void main(String[] args){
        int n = 3;
        
       /* pattern1(n);
        
        pattern2(n);
        
        pattern3(n);
        
        pattern4(n);
        
        pattern5(n); 
        
        pattern6(n);
        
        pattern7(n);
        
        pattern8(n);
         
        pattern9(n);
        
        pattern10(5);
        
        pattern12(5);
        
        pattern13(5);
        
        pattern14(5);
        
        pattern15(5);
        
        pattern16(5);
         
        pattern17(3);
         
        pattern18(3);
        
        pattern19(3);
        
        
        */
        pattern20(3);
        
    }
}
