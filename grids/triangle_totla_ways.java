import java.util.*;
public class triangle_totla_ways {
    public static int cal(List<List<Integer>>list,int i,int j){
        if(i==list.size()-1){
            return list.get(i).get(j);
        }
        int d=cal(list,i+1,j);
        int dg=cal(list,i+1,j+1);
       
        return list.get(i).get(j)+Math.min(d,dg);

    }
    

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        List<List<Integer>>triangle=new ArrayList<>();
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            List<Integer>r=new ArrayList<>();
            for(int j=0;j<=i;j++){
                r.add(sc.nextInt());
            }
            triangle.add(r);
        }

        System.out.println(cal(triangle,0,0));

       

    }
    
}
