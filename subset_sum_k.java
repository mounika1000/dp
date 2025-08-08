import java.util.*;
public class subset_sum_k{
    public static boolean cal(int arr[],int idx,int k){
        if(k==0){
            return true;
        }
        if(idx==0){
            return arr[idx]==k;
        }
        boolean np=cal(arr,idx-1,k);
        boolean p=false;
        if(arr[idx]<=k){
            p=cal(arr,idx-1,k-arr[idx]);
        }
        return p||np;
    }
    public static boolean cal_memo(int idx,int k,int arr[],Boolean dp[][]){
        if(k==0){
            return true;
        }
        if(idx==0){
            return arr[0]==k;
        }
        if(dp[idx][k]!=null){
            return dp[idx][k];
        }
        boolean np=cal_memo(idx-1,k,arr,dp);
        boolean p=false;
        if(arr[idx]<=k){
            p=cal_memo(idx-1,k-arr[idx],arr,dp);
        }
        return dp[idx][k]=np||p;
    }
    public static boolean cal_tab(int k,int arr[]){
        int n=arr.length;
        boolean dp[][]=new boolean[n][k+1];
        for(int j=0;j<n;j++){
            dp[j][0]=true;
        }
        if(arr[0]<=k)
        dp[0][arr[0]]=true;
        for(int i=1;i<n;i++){
            for(int j=1;j<k+1;j++){
                boolean np=dp[i-1][j];
                boolean p=false;
                if(arr[i]<=j){
                    p=dp[i-1][j-arr[i]];
                }
                dp[i][j]=np||p;
            }
        }
        return dp[n-1][k];

    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int k=sc.nextInt();
        Boolean dp[][]=new Boolean[n+1][k+1];
        System.out.println(cal(arr,n-1,k));
        System.out.println(cal_memo(n-1,k,arr,dp));
        System.out.println(cal_tab(k,arr));

    }
}