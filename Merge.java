import java.util.Random;
import java.util.Scanner;

public class Merge {
	private static int c[];
	public static void sort(int a[]) {
				c = new int[a.length];
				if(a == null || a.length == 0)
			return;
		else
			mergesort(a, 0, a.length - 1);
	}
	public static void mergesort(int a[], int low, int high) {
		if(low < high) {
			int mid = (low + high)/2;
			mergesort(a, low, mid);
			mergesort(a, mid + 1, high);
			mergearray(a, low, mid, high);
		}
	}
	public static void mergearray(int a[], int low, int mid, int high) {
		int i = low, j = mid + 1, k = low;
		while(i <= mid && j <= high) {
		if(a[i] < a[j])
			c[k++] = a[i++];
		else
			c[k++] = a[j++];
	}
		while(i <= mid)
			c[k++] = a[i++];
		while(j <= high)
			c[k++] = a[j++];
		for(i = low;i <= high;i++)
			a[i] = c[i];
  }
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n, a[];
		System.out.println("enter the size of the array");
		n = in.nextInt();
		a = new int[n];
		Random random = new Random();
		System.out.println("the randomly generated array is ");
		for(int i = 0;i < n;i++) {
			a[i] = Math.abs(random.nextInt(20));
			System.out.print(a[i] + " ");
		}
		System.out.println();
		long startTime = System.nanoTime();
		sort(a);
		long stopTime = System.nanoTime();
		long elapsedTime = stopTime - startTime;
		System.out.println("the sorted array is ");
		for(int i = 0;i < n;i++)
			System.out.print(a[i] + " ");
		System.out.println();
		System.out.println("the total time take " + elapsedTime);
			
	}
}
