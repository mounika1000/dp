import java.util.*;
public class unique_path_obstacle {
    public static int grid_ways(int a[][],int i,int j){
        if(i>=0 && j>=0 && a[i][j]==-1){
            return 0;
        }
        if(i==0 && j==0){
            return 1;
        }
        if(i<0 || j<0){
            return 0;
        }
        return grid_ways(a, i-1, j)+grid_ways(a,i,j-1);

    }
    public static int grid_ways_memo(int a[][],int i,int j,int dp[][]){
        if(i>=0 && j>=0 && a[i][j]==-1){
            return 0;
        }
        if(i<0 || j<0){
            return 0;
        }
        if(i==0 && j==0){
            return 1;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        return dp[i][j]=grid_ways_memo(a,i-1,j,dp)+grid_ways_memo(a,i,j-1,dp);

    }
    public static int grid_ways_tab(int m,int n,int a[][]){
        int dp[][]=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(a[i][j]==-1){
                    dp[i][j]=0;
                    continue;
                }
if(i==0 && j==0){
    dp[i][j]=1;
}else{
    int l=0,r=0;
       if(i>0)   l=dp[i-1][j];
    if(j>0)  r=dp[i][j-1];
    dp[i][j]=l+r;

}

            }
        
        }
        return dp[m-1][n-1];
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
        int a[][]=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                a[i][j]=sc.nextInt();

            }
        }
        int dp[][]=new int[m][n];
        for(int row[]:dp){
            Arrays.fill(row,-1);

        }
        System.out.println(grid_ways(a, m-1, n-1));
        System.out.println(grid_ways_memo(a,m-1,n-1,dp));
        System.out.println(grid_ways_tab( m, n,a));
    }
    
}
