#include<bits/stdc++.h>
using namespace std;
int cal(int n){
    if(n==0 ){
        return 1;
    }
    if(n<0){
        return 0;
    }
   
    return cal(n-1)+cal(n-2);
}

int main(){
    int n;
    cin>>n;
    cout<<cal(n);

}