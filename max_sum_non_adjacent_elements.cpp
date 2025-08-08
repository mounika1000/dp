#include<bits/stdc++.h>
using namespace std;
int cal(int idx,int arr[]){
    if(idx==0){
        return arr[idx];
    }
    if(idx<0){
        return 0;

    }
    int p=cal(idx-2,arr)+arr[idx];
    int np=cal(idx-1,arr);
    return max(p,np);
}
int cal_memo(int idx,int arr[],int dp[]){
    if(idx<0){
        return 0;
    }
    if(idx==0){
        return 0;
    }
    if(dp[idx]!=-1){
        return dp[idx];
    }
    int p=cal_memo(idx-2,arr,dp)+arr[idx];
    int np=cal_memo(idx-1,arr,dp);
    return dp[idx]=max(p,np);
}
int main(){
    int n;
    cin>>n;
    int arr[n];
    for(int i=0;i<n;i++){
        cin>>arr[i];
    }
    int dp[n];
    for(int i=0;i<n;i++){
        dp[i]=-1;
    }
    cout<<cal(n-1,arr)<<endl;
    cout<<cal_memo()
}