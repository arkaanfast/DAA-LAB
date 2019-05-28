import java.util.Scanner;

public class Dijkstra {
	public int distance[] = new int[10];
	public int cost[][] = new int[10][10];
	public void calc(int n, int s) {
		int flag[] = new int[10];
		int i, minpos = 1, c, k, min;
		for(i = 1;i <= n;i++) {
			flag[i] = 0;
			this.distance[i] = this.cost[s][i];
		}
		c = 2;
		while(c <= n) {
			min = 99;
			for(k = 1;k <= n;k++)
				if(this.distance[k] < min && flag[i] != 1) {
					min = this.distance[k];
					minpos = k;
				}
			flag[minpos] = 1;
			c++;
			for(k = 1;k <= n;k++) {
				if(this.distance[minpos] + this.cost[minpos][k] < this.distance[k] && flag[k]!= 1)
					this.distance[k] = this.distance[minpos] + this.cost[minpos][k];
			}
		}
	}
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		Dijkstra d = new Dijkstra();
		int nodes, s;
		System.out.println("enter the number of nodes");
		nodes = in.nextInt();
		System.out.println("enter the source");
		s = in.nextInt();
		System.out.println("enter the cost matrix");
		for(int i = 1;i <= nodes;i++)
			for(int j = 1;j <= nodes;j++) {
				d.cost[i][j] = in.nextInt();
				if(d.cost[i][j] == 0)
					d.cost[i][j] = 999;
			}
			d.calc(nodes, s);
			System.out.println("The min distance of the nodes from the source is");
			for(int i = 1;i <= nodes;i++) {
				if(i != s)
					System.out.println("from source " + s + " to the node " + i + " the distance is " + d.distance[i]);
			}
	}
}
