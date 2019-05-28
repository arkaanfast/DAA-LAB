import java.util.Random;
import java.util.Scanner;

public class Quick {
	public static void sort(int a[]) {
		quicksort(a, 0, a.length - 1);
	}
	public static void quicksort(int a[], int low, int high) {
		int j;
		if(low <= high) {
			j = partition(a, low, high);
			quicksort(a, low, j-1);
			quicksort(a, j+1, high);
		}
	}
	public static int partition(int a[], int low, int high) {
		int i = low + 1;
		int j = high;
		int pivot = a[low];
		while(true) {
			while(i < j && pivot > a[i])
				i++;
			while(pivot < a[j])
				j--;
			if(i < j) {
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
			}
			else {
				int temp = a[low];
				a[low] = a[j];
				a[j] = temp;
				return j;
			}
		}
	}
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n;
		System.out.println("enter the size of the array");
		n = in.nextInt();
		int a[] = new int[n];
		Random random = new Random();
		System.out.println("the randomly generated array is");
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
	}
}
