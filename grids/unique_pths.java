import java.util.*;
public class unique_pths{
    public static int cal_memo(int m,int n,int dp[][]){
        if(n==0 || m==0){
            return 1;
        }
        if(m<0 || n<0){
            return 0;
        }
        if(dp[m][n]!=-1){
            return dp[m][n];
        }
        int l=cal_memo(m-1, n, dp);
        int r=cal_memo(m,n-1,dp);
        return dp[m][n]=l+r;
}
    public static int cal(int m,int n){
        if(m==0 && n==0){
            return 1;
        }
        if(m<0 || n<0){
            return 0;
        }
        int l=cal(m-1,n);
        int r=cal(m,n-1);
        return l+r;

    }
    public static int cal_tab(int n,int m){
        int dp[][]=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<m;j++){
                if(i==0 && j==0){
                    dp[i][j]=1;
                }else{
                    int l=0,r=0;
                    if(i>0){
                        l=dp[i-1][j];
                    }
                    if(j>0){
                        r=dp[i][j-1];
                    }
                    dp[i][j]=l+r;
                }
                
            }
        }
        return dp[n-1][m-1];
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
        int dp[][]=new int[m][n];
    for(int row[]:dp){
        Arrays.fill(row,-1);
    }
        System.out.println(cal(m-1,n-1));
          System.out.println(cal_memo(m-1,n-1,dp));
                  System.out.println(cal_tab(m,n));

    }
}