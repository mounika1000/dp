import java.util.*;

public class minimum_path_sum {
    public static int cal(int mat[][], int i, int j) {
        if (i == 0 && j == 0) {
            return 1;
        }
        if (i < 0 || j < 0) {
            return 0;
        }
        int l = cal(mat, i - 1, j);
        int r = cal(mat, i, j - 1);
        return l + r;

    }

    public static int min_sum(int mat[][], int i, int j) {
        if (i == 0 && j == 0) {
            return  mat[i][j];

        }
        if (i < 0 || j < 0) {
            return Integer.MAX_VALUE;
        }

       
        int l = min_sum(mat, i - 1, j);
        int r = min_sum(mat, i, j - 1);
        return mat[i][j]+Math.min(l, r);
    }

    public static int min_sum_memo(int mat[][], int i, int j, int dp[][]) {
        if (i == 0 && j == 0) {
            return  mat[i][j];
        }
        if (i < 0 || j < 0) {
            return Integer.MAX_VALUE;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
      
        int l = min_sum_memo(mat, i - 1, j, dp);
        int r = min_sum_memo(mat, i, j - 1, dp);
        return dp[i][j] = mat[i][j]+Math.min(l, r);

    }

    public static int tab(int mat[][], int n, int m) {
        int dp[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = mat[0][0];
                }else {
                int l =Integer.MAX_VALUE,r=Integer.MAX_VALUE;
                if (i > 0)
                    l = dp[i - 1][j] ;
                if (j > 0)
                    r = dp[i][j - 1] ;
                dp[i][j] = mat[i][j]+Math.min(l, r);
                }

            }

        }
        return dp[n - 1][m - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int mat[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mat[i][j] = sc.nextInt();
            }
        }
        int dp[][] = new int[n][m];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }
        System.out.println(cal(mat, n - 1, m - 1));

        System.out.println(min_sum(mat, n - 1, m - 1));
        System.out.println(min_sum_memo(mat, n - 1, m - 1, dp));
        System.out.println(tab(mat,n,m));
    }

}
