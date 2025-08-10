import java.util.*;

public class stocks_1 {
    public static int cal(int p[]){
        int min=p[0],profit=0;
        for(int i=1;i<p.length;i++){
            int cost=p[i]-min;
            profit=Math.max(profit,cost);
            min=Math.min(min,p[i]);
        }
        return profit;

    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int p[]=new int[n];
        for(int i=0;i<n;i++){
            p[i]=sc.nextInt();
        }
        System.out.println(cal(p));
        
    }
    
}
