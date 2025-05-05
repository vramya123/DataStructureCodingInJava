public class Solution {
    public static List<Integer> spiralOrder(int[][] matrix) {
        
        List<Integer> res = new ArrayList<Integer>();
        int minrow = 0;
        int maxrow = matrix.length-1;
        int mincol = 0;
        int maxcol = matrix[0].length-1;
        
        while(minrow<=maxrow && mincol<= maxcol){
            
            //first row constant and col varies
            
            for(int i = mincol;i<=maxcol;i++){
                res.add(matrix[minrow][i]);
            }
            
            minrow++;
            
            //maxcol is constant and row varies
            
            for(int i=minrow;i<=maxrow;i++){
                res.add(matrix[i][maxcol]);
            }
            
            maxcol--;
            if(minrow<=maxrow){
            //maxrow is fixed,col varies
            for(int i=maxcol;i>=mincol;i--){
                res.add(matrix[maxrow][i]);
            }
            }
            
            maxrow--;
            
            if(mincol<=maxcol){
            //mincol is fixed and row varies
            for(int i=maxrow;i>=minrow;i--){
                res.add(matrix[i][mincol]);
            }
            }
            mincol++;
            
        }
        
        return res;
        
    }
    
    public static void main(String[] args){
        /*Scanner sc = new Scanner(System.in);
        System.out.println("enter the number of row");
        int m  = sc.nextInt();
        System.out.println("enter the number of cols");
        int n = sc.nextInt();
        int[][] a = new int[m][n];
        for(int i=0;i<m;i++)
         for(int j=0;j<n;j++)
           a[i][j]=sc.nextInt();*/
        
        int[][] a= {{1,2,3},{4,5,6},{7,8,9}};
        
        //Output: [1,2,3,6,9,8,7,4,5]
        
        List<Integer> res = spiralOrder(a);
        
        res.forEach(System.out::print);
        
        
    }
}
