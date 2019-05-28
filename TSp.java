import java.util.Scanner;

public class TSp {
	static int cost = 0;
	public static void main(String args[]) {
		int visited[] = new int[10];
		int a[][] = new int[10][10];
		int i, j, n;
		Scanner in = new Scanner(System.in);
		System.out.println("enter the number of cities");
		n = in.nextInt();
		System.out.println("enter the cost matrix");
		for(i = 1;i <=n;i++) {
			for(j = 1;j <= n;j++) {
					a[i][j] = in.nextInt();
				}
			visited[i] = 0;
		}
		mincost(a, n, visited, 1);
		display();
	}
	public static void mincost(int a[][], int n, int v[], int city) {
		int i, cityno;
		v[city] = 1;
		System.out.print((city) + " --> ");
		cityno = least(a, v, n, city);
		if(cityno == 999) {
			cityno = 1;
			System.out.print(" " + cityno);
			System.out.println();
			cost += a[city][cityno];
			return;
		}
		mincost(a, n, v, cityno);
	}
	public static int least(int a[][], int v[], int n ,int c) {
		int i, min = 999, mincode = 999, newmin = 0;
		for(i = 1;i <= n;i++) {
			if((a[c][i] != 0) && (v[i] == 0))
				if(a[c][i] < min) {
					min = a[i][1] + a[c][i];
					newmin = a[c][i];
					mincode = i;
				}
		}
		if(mincode != 999)
			cost += newmin;
		return mincode;
	}
	public static void display() {
		System.out.println("the total cost is" + cost);
	}
}
