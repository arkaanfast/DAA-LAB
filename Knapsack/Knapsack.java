import java.util.Scanner;

public class Knapsack {
	public static int max(int a, int b) {
		return a>b?a:b;
	}
	public static void main(String args[]) {
		int p[] = new int[10];
		int w[] = new int[10];
		int cap, n, i, j;
		int v[][] = new int[10][10];
		Scanner in = new Scanner(System.in);
		System.out.println("enter the number of items");
		n = in.nextInt();
		System.out.println("enter the capacity");	
		cap = in.nextInt();
		System.out.println("enter the weights and profits");
		for(i = 1;i <= n;i++) {
			w[i] = in.nextInt();
			p[i] = in.nextInt();
		}
		for(i = 0;i < n;i++)
			v[i][0] = 0;
		for(i = 1;i <= n;i++)
			for(j = 1;j <= cap;j++) {
				if(w[i] > j)
					v[i][j] = v[i-1][j];
				else
					v[i][j] = max(v[i-1][j], v[i-1][j-w[i]] + p[i]);
			}
	  System.out.println("the matrix is");
	  for(i = 0;i <= n;i++) {
		  for(j = 0;j <= cap;j++) {
			  System.out.print(v[i][j] + " ");
		  }
	  System.out.println("\n");
	  }
	  System.out.println("the maximum profit is " + v[n][cap]);
	  j = cap;
	  System.out.println("the optimal subset { ");
	  for(i = n;i >= 1;i--) {
		  if(v[i][j] != v[i-1][j]) {
			  System.out.println("item " + i);
			  j = j - w[i];
		  }
	  }
	  System.out.println(" }");
	}
}
