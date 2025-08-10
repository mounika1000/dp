import java.util.*;
public class stocks_3 {
    public static int cal(int idx,int buy,int cap,int p[]){
        if(idx==p.length){
            return 0;
        }
        if(cap==0){
            return 0;
        }
        if(buy==1){
            return Math.max(-p[idx]+cal(idx+1,0,cap,p),cal(idx+1,1,cap,p));
        }
        return Math.max(p[idx]+cal(idx+1,1,cap-1,p),cal(idx+1,0,cap,p));
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int p[]=new int[n];
        for(int i=0;i<n;i++){
            p[i]=sc.nextInt();
        }
        System.out.println(cal(0,1,2,p));
    }
    
}
