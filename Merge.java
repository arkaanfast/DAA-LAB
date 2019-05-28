import java.util.Random;
import java.util.Scanner;

public class Merge {
	private static int c[]; //Creating a temporary array
	public static void sort(int a[]) {
				c = new int[a.length];
				if(a == null || a.length == 0)
			return;
		else
			mergesort(a, 0, a.length - 1); //calling the method mergesort
	}
	public static void mergesort(int a[], int low, int high) {
		if(low < high) {                       // if low is less than or equal to the length of the array
			int mid = (low + high)/2;
			mergesort(a, low, mid);        //recrsive call by passing one half of the array
			mergesort(a, mid + 1, high);   //recursive call by passing the other half
			mergearray(a, low, mid, high); //calling method to merge the halfs
		}
	}
	public static void mergearray(int a[], int low, int mid, int high) {
		int i = low, j = mid + 1, k = low;
		while(i <= mid && j <= high) {          // will execute untill this condition
		if(a[i] < a[j])
			c[k++] = a[i++];
		else
			c[k++] = a[j++];
	}
		while(i <= mid)                          // to put all the remaining elements
			c[k++] = a[i++];
		while(j <= high)
			c[k++] = a[j++];
		for(i = low;i <= high;i++)               // transfering the elements from the temporary array to the original array
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
