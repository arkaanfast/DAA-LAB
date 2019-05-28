import java.util.Scanner;

public class Floyd {
	public static int min(int a, int b) {
		return a < b?a:b;
	}
	public static void floyd(int d[][], int n) {
		int i, j , k;
		for(k = 1;k <= n;k++) {
			for(i = 1;i <=n;i++) {
				for(j = 1;j <= n;j++) {
					d[i][j] = min(d[i][j], d[i][k] + d[k][j]);
					
				}
			}
		}
		for(i = 1;i <=n;i++) {
			for(j = 1;j <= n;j++)
				System.out.print(d[i][j] + " ");
			System.out.println();
	}
}
	public static void main(String args[]) {
		int w[][] = new int[10][10];
		int n, i, j;
		System.out.println("enter the number of nodes");
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		System.out.println("enter the cost matrix");
		for(i = 1;i <= n;i++)
			for(j = 1;j <= n;j++)
				w[i][j] = in.nextInt();
		System.out.println(" all shortest pair");
		floyd(w, n);
	}
}