import java.util.*;

public class matrix_min_sum {
    public static int cal(int a[][],int i,int j){
         if(j<0 ||j>=a[i].length){
            return Integer.MAX_VALUE;
        }
        if(i==0){
            return a[i][j];
        }
       
        int u=cal(a,i-1,j);
        int ld=cal(a,i-1,j-1);
        int rd=cal(a,i-1,j+1);
        return Math.min(u,Math.min(ld,rd))+a[i][j];

    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[][]=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                a[i][j]=sc.nextInt();
            }
        }
       int min=Integer.MAX_VALUE;
       for(int j=0;j<n;j++){
        min=Math.min(min,cal(a,n-1,j));
       }
System.out.println(min);
        
    }
    
}
