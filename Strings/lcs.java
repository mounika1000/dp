package Strings;
import java.util.*;

public class lcs {
    public static int cal(int i,int j,String s1,String s2){
        if(i==0 || j==0){
            return 0;
        }
        if(s1.charAt(i-1)==s2.charAt(j-1)){
            return 1+cal(i-1,j-1,s1,s2);
        }
        int ans1=cal(i-1,j,s1,s2);
        int ans2=cal(i,j-1,s1,s2);
        return Math.max(ans1,ans2);
    }
    public static int cal_memo(int i,int j,String s1,String s2,int dp[][]){
        if(i==0 || j==0){
            return 0;
        }
        
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(s1.charAt(i-1)==s2.charAt(j-1)){
            return 1+cal_memo(i-1,j-1,s1,s2,dp);
        }
        return dp[i][j]=Math.max(cal_memo(i-1,j,s1,s2,dp),cal_memo(i,j-1,s1,s2,dp));
    }
    public static int cal_tab(String s1,String s2){
        int n=s1.length();
        int m=s2.length();

        int dp[][]=new int[n+1][m+1];
        for(int i=0;i<n+1;i++){
            dp[i][0]=0;
        }
        for(int j=0;j<m+1;j++){
            dp[0][j]=0;
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];

                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s1=sc.next();
       String s2=sc.next();
       int i=s1.length();
       int j=s2.length();
       int dp[][]=new int[i+1][j+1];
       for(int row[]:dp){
        Arrays.fill(row,-1);
       }
       System.out.println(cal(i,j,s1,s2));
       System.out.println(cal_memo(i,j,s1,s2,dp));
       System.out.println(cal_tab(s1,s2));


    }
    
}
