#include<bits/stdc++.h>
using namespace std;
int cal(int arr[],int i){
    if(i==0){
        return 0;
    }
    if(i==1){
        return abs(arr[i]-arr[i-1]);
    }
    int w1=abs(arr[i]-arr[i-1])+cal(arr,i-1);
    int w2=abs(arr[i]-arr[i-2])+cal(arr,i-2);
    return min(w1,w2);
}
int cal_memo(int arr[],int  dp[],int i){
    if(i==0){
        return 0;
    }
    if(i==1){
        return abs(arr[i]-arr[i-1]);
    }
    if(dp[i]!=-1){
        return dp[i];
    }
    int w1=abs(arr[i]-arr[i-1])+cal_memo(arr,dp,i-1);
    int w2=abs(arr[i]-arr[i-2])+cal_memo(arr,dp,i-2);
    return dp[i]=min(w1,w2);

}
int cal_tab(int arr[],int n){
    int dp[n];
    dp[0]=0;
    dp[1]=abs(arr[1]-arr[0]);
    for(int i=2;i<n;i++){
       int w1=abs(arr[i]-arr[i-1])+dp[i-1];
       int w2=abs(arr[i]-arr[i-2])+dp[i-2];
       dp[i]=min(w1,w2);
    }
return dp[n-1];

}
int cal_o(int arr[],int n){
    if(n==0){
        return 0;
    }
    if(n==1){
        return abs(arr[0]-arr[1]);
    }
    int p1=0;
    int p2=abs(arr[0]-arr[1]);
    for(int i=2;i<n;i++){
        int curr=min(abs(arr[i]-arr[i-1])+p1,abs(arr[i]-arr[i-2])+p2);
        p2=p1;
        p1=curr;
    }
    return p2;

}
int main(){
    int n;
    cin>>n;
    int arr[n];
    for(int i=0;i<n;i++){
        cin>>arr[i];

    }
    int dp[n+1];
    for(int i=0;i<n;i++){
        dp[i]=-1;
    }
    cout<<cal(arr,n-1)<<endl;
    cout<<cal_memo(arr,dp,n-1)<<endl;
    cout<<cal_tab(arr,n)<<endl;
    cout<<cal_o(arr,n);

}