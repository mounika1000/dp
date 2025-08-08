#include<bits/stdc++.h>
using namespace std;
int fibo(int n){
    if(n==1 || n==0){
        return n;
    }
    return fibo(n-1)+fibo(n-2);
}
int fibo_memo(int n,int dp[]){
    if(n==0 || n==1){
        return n;
    }
    if(dp[n]!=-1){
        return dp[n];
    }
    return dp[n]=fibo_memo(n-1,dp)+fibo_memo(n-2,dp);
}
int fibo_tab(int n){
    int dp[n+1];
    dp[0]=0;
    dp[1]=1;
    for(int i=2;i<n+1;i++){
        dp[i]=dp[i-1]+dp[i-2];
    }
    return dp[n];
}
int fibo_o(int n){
    if(n==0 || n==1){
        return n;
    }
    int p1=1;
    int p2=0;
  
    for(int i=2;i<n+1;i++){
  int curr=p1+p2;
  p2=p1;
  p1=curr;
        
    }
    return p1;
}
int main(){
    int n;
    cin>>n;
    int dp[n+1];
    for(int i=0;i<n+1;i++){
        dp[i]=-1;
    }
    cout<<fibo(n);
    cout<<fibo_memo(n,dp);
    cout<<fibo_tab(n);
    cout<<fibo_o(n);
    
    
}