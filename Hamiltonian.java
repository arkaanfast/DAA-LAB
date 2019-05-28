import java.util.Scanner;

public class Hamiltonian {
	static int vertex[] = new int[25];
	public static void main(String args[]) {
		int i, j, v1, v2, edges, n;
		int g[][] = new int[25][25];
		Scanner in = new Scanner(System.in);
		System.out.println("enter the number of cities");
		n = in.nextInt();
		for(i = 1;i <= n;i++)
			for(j = 1;j <= n;j++) {
				vertex[i] = 0;
				g[i][j] = 0;
				
			}
		vertex[1] = 1;
		System.out.println("enter the number of edges");
		edges = in.nextInt();
		System.out.println("enter the edges");
		for(i = 0;i < edges;i++) {
			v1 = in.nextInt();
			v2 = in.nextInt();
			g[v1][v2] = 1;
			g[v2][v1] = 1;
		}
		System.out.println(" the path is ");
		h_cycle(g, n, 2);
	}
	public static void h_cycle(int g[][], int n, int k) {
		while(true) {
			nextvertex(g, n, k);
			if(vertex[k] == 0)
				return;
			if(k == n) {
				for(int i = 1;i <= n;i++)
					System.out.print(vertex[i] + " --> " );
				System.out.print(" " + vertex[1]);
				System.out.println();
			}
			else
				h_cycle(g, n, k + 1);
		}
	}
	public static void nextvertex(int g[][], int n, int k) {
		int i;
		while(true) {
		vertex[k] = (vertex[k] + 1)%(n + 1);
		if(vertex[k] == 0)
			return;
		if(g[vertex[k - 1]][vertex[k]] != 0) {
			for(i = 1;i <= k;i++)
				if(vertex[i] == vertex[k])
					break;
			if(i == k) {
				if((k < n) || (k == n) && (g[vertex[n]][vertex[1]] != 0))
					return;
			}
		}
	}
  }
}
