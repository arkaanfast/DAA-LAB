
public class Subset {
	static int a[] = new int[10];
	static int w[] = {1, 2, 5, 6, 8};
	static int count = 0, d = 9;
	public static void main(String args[]) {
		int sum = 0;
		int n = 5;
		int i;
		System.out.println("the set of numbers is:");
		System.out.println(" { ");
		for(i = 0;i < n - 1;i++) {
			System.out.print(w[i] + ",");
		}
		System.out.print(w[i] + " }");
		System.out.println();
		for(i = 0;i < n;i++)
			sum += w[i];
		if(sum < d)
			System.out.println("no solution");
		else
			sumsubset(0, 0, sum);
	}
	public static void sumsubset(int sum, int index, int remainingsum) {
		int i;
		a[index] = 1;
		if(sum + w[index] == d) {
			System.out.println("soloution " + (++count));
			for(i = 0;i <= index;i++) {
				if(a[i] == 1)
					System.out.print(w[i] + " ");
		}
			System.out.println();
		}
		else if(sum + w[index] + w[index + 1] <= d)
			sumsubset(sum + w[index], index + 1, remainingsum - w[index]);
		if((sum + remainingsum - w[index] >= d) && (sum + w[index + 1] <= d)) {
			a[index] = 0;
			sumsubset(sum, index + 1, remainingsum - w[index]);
	}
}
}