#include<bits/stdc++.h>
using namespace std;
int cal_memo(int arr[],int i,int k,int dp[]){
    if(i==0){
        return 0;
    }
    if(dp[i]!=-1){
        return dp[i];
    }
    int min_e=INT_MAX;
    for(int j=1;j<=k;j++){
        if(i-j>=0){
        int ans=abs(arr[i]-arr[j])+cal_memo(arr,i-j,k,dp);
        min_e=min(ans,min_e);
        }
    }
   return  dp[i]=min_e;

}
int cal(int arr[],int n,int k){
    int dp[n];
    dp[0]=0;
    for(int i=1;i<n;i++){
        int min_ene=INT_MAX;
    for(int j=1;j<=k;j++){
        if(i-j>=0){
            int ans=abs(arr[i]-arr[i-j])+dp[i-j];
            min_ene=min(min_ene,ans);
        }

    }
    dp[i]=min_ene;
}
return dp[n-1];
}
int main(){
    int n;
    cin>>n;
    int arr[n];
    for(int i=0;i<n;i++){
        cin>>arr[i];
    }
    int k;
    cin>>k;
    cout<<cal(arr,n,k);
    
}