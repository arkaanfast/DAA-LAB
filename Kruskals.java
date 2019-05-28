import java.util.Scanner;

public class Kruskals {
	public int c[][] = new int[10][10];
	public int parent[] = new int[10];
	public int mincost = 0;
	public void calc(int n) {
		int i, j, mini = 1, minj = 1, a = 1, b = 1, edges = 1;
		int min;
		parent[mini] = 0; parent[minj] = 0;
		while(edges < n) {
			for(i = 1, min = 999;i <= n; i++)
				for(j = 1;j <= n;j++)
					if(this.c[i][j] < min) {
						min = this.c[i][j];
						mini = a = i;
						minj = b = j;
					}
			while(parent[mini]!= 0)						
				mini = parent[mini];
			while(parent[minj]!= 0)	
				minj = parent[minj];
			if(mini != minj) {
				System.out.println("from node " + a + " to node " + b + " the mincost:-" + min);
				edges += 1;
				this.mincost += min;
				this.parent[minj] = mini;
			}
			this.c[a][b] = this.c[b][a] = 999;
		}
		System.out.println("the minimum cost is " + this.mincost);
	}
	public static void main(String args[]) {
		int nodes;
		Scanner in = new Scanner(System.in);
		System.out.println("enter the number of nodes");
		nodes = in.nextInt();
		Kruskals k = new Kruskals();
		System.out.println("Enter the cose matrix");
		for(int i = 1;i <= nodes;i++)
			for(int j = 1;j <= nodes;j++) {
				k.c[i][j] = in.nextInt();
				if(k.c[i][j] == 0)
					k.c[i][j] = 999;
			}
		k.calc(nodes);
	}
}
