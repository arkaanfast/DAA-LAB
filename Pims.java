import java.util.Scanner;

public class Pims {
	public int visited[] = new int[10];
	public int cost[][] = new int[10][10];
	public int mincost = 0;
	public void calc(int n) {
		int i, j, mini = 1, minj = 1, edges = 1, a = 1, b = 1;
		int min;
		while(edges < n) {
			for(i = 1, min = 999;i <= n;i++)
				for(j = 1;j <= n;j++)
					if(this.cost[i][j] < min)
						if(this.visited[i] != 0) {
							min = this.cost[i][j];
							mini = a = i;
							minj = b = j;
						}
			if(this.visited[mini] == 0 || this.visited[minj] == 0) {
				System.out.println(" from node " + a + " to node " + b + " the min cost " + min);
				this.mincost += min;
				edges += 1;
				this.visited[b] = 1;
			}
			this.cost[a][b] = this.cost[b][a] = 999;
		}
		System.out.println("the mincost is " + this.mincost);
	}
	public static void main(String args[]) {
		Pims p = new Pims();
		Scanner in = new Scanner(System.in);
		System.out.println("enter the number of nodes");
		int nodes = in.nextInt();
		System.out.println("enter the cost matrix");
		for(int i = 1;i <= nodes;i++)
			for(int j = 1;j <= nodes;j++) {
				p.cost[i][j] = in.nextInt();
				if(p.cost[i][j] == 0)
					p.cost[i][j] = 999;
			}
		p.visited[1] = 1;
		p.calc(nodes);	
	}
}
