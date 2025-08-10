import java.util.*;

public class stocks_2 {
    public static int cal(int idx,int buy,int p[]){
        if(idx==p.length){
            return 0;
        }
        int profit=0;
        if(buy==1){
            int pi=-p[idx]+cal(idx+1,0,p);
            int np=cal(idx+1,1,p);
            profit= Math.max(pi,np);

        }
        else{
            int s=p[idx]+cal(idx+1,1,p);
            int ns=cal(idx+1,0,p);
            profit= Math.max(s,ns);
        }
        return profit;
        
    }
    public static int cal_memo(int idx,int buy,int p[],int dp[][]){
        if(idx==p.length){
            return 0;
        }
        if(dp[idx][buy]!=-1){
            return dp[idx][buy];
        }
        int profit=0;
        if(buy==1){
            int pi=-p[idx]+cal_memo(idx+1,0,p,dp);
            int np=cal_memo(idx+1,1,p,dp);
            profit=Math.max(np,pi);

        }else{
            int s=+p[idx]+cal_memo(idx+1,1,p,dp);
            int ns=cal_memo(idx+1,0,p,dp);
            profit=Math.max(ns,s);

        }
        return dp[idx][buy]=profit;

    }
    public static int cal_tab(int p[]){
        int n=p.length;
        int dp[][]=new int[n+1][2];
         dp[n][0]=0;dp[n][1]=0;
        for(int i=n-1;i>=0;i--){
            for(int buy=0;buy<=1;buy++){
                int profit=0;
                if(buy==1){
                    int pi=-p[i]+dp[i+1][0];
                    int np=dp[i+1][1];
                    profit=Math.max(pi,np);

                }else{
                    int s=+p[i]+dp[i+1][1];
                    int ns=dp[i+1][0];
                    profit=Math.max(ns,s);

                }
                dp[i][buy]=profit;
            }
           
        }
         return dp[0][1];
    }
    public static int cal_op(int p[]){
        int n=p.length;
        int nb=0,ns=0;
        for(int i=n-1;i>=0;i--){
            int cb=Math.max(-p[i]+ns,nb);
            int cs=Math.max(p[i]+nb,ns);
            nb=cb;
            ns=cs;
        }
        return nb;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int p[]=new int[n];
        for(int i=0;i<n;i++){
            p[i]=sc.nextInt();
        }
        int dp[][]=new int[n][2];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        System.out.println(cal(0,1,p));
        System.out.println(cal_memo(0,1,p,dp));
        System.out.println(cal_tab(p));
        System.out.println(cal_op(p));
    }
	
}
