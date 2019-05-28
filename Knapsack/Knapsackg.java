import java.util.Scanner;

public class Knapsackg {
	public static void knapsack(int n, float cap, float w[], float p[]) {
		float x[] = new float[10];
		int i, c, tp = 0;
		c = (int)cap;
		for(i = 0;i < n;i++)
			x[i] = (float)0.0;
		for(i = 0;i < n;i++) {
			if(w[i] > c)
				break;
			else {
				x[i] = (float)1.0;
				tp += p[i];
				c = (int)(c - w[i]);
			}
		}
	    if(i < n) {
	    	x[i] = c/w[i];
	    	tp += x[i] * p[i];
	    }
	    System.out.println("the resultant vector is");
	    for(i = 0;i < n;i++)
	    	System.out.print(x[i] + " ");
	    System.out.println("the total profit " + tp);
	}
	public static void main(String args[]) {
		float p[] = new float[10];
		float w[] = new float[10];
		float ratio[] = new float[10];
		int i, n, cap;
		Scanner in = new Scanner(System.in);
		System.out.println("enter the number of items");
		n = in.nextInt();
		System.out.println("enter the capacity of knapsack");
		cap = in.nextInt();
		System.out.println("enter the weights and profits");
		for(i = 0;i < n;i++) {
			w[i] = in.nextFloat();
			p[i] = in.nextFloat();
		}
		for(i = 0;i < n;i++)
			ratio[i] = p[i]/w[i];
		for(i = 0;i < n;i++)
			for(int j = i + 1;j < n;j++) {
				if(ratio[i] < ratio[j]) {
					float temp = ratio[i];
					ratio[i] = ratio[j];
					ratio[j] = temp;
					
					temp = w[i];
					w[i] = w[j];
					w[j] = temp;
					
				    temp = p[i];
					p[i] = p[j];
					p[j] = temp;
				}
					
				
			}
		knapsack(n, cap, w, p);
	}
}
