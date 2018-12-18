import java.util.Random;
import java.util.Scanner;


public class MergeSort {

	
	public static void main(String[] args) {
		int n,i,max=5000;
		
		Scanner sc=new Scanner(System.in);
		Random ranNum=new Random();
		System.out.println("Enter the number of numbers to be sorted:");
		n=sc.nextInt();
		float a[]=new float[n];
		
		for(i=0; i<n; i++){
			a[i]=ranNum.nextInt(max);
		}
		
		long start=System.currentTimeMillis();
		
		MSort.partitionArray(a, 0, n-1);
		
		long end=System.currentTimeMillis();
		System.out.println("Sorted Array:");
		for(i=0; i<n; i++)
			System.out.println(a[i]);
		System.out.println("\nTime taken:"+(end-start));
		sc.close();
	}

}

class MSort{
	static void partitionArray(float a[],int first,int last){
		int mid;
		if(first<last)
		{
			mid=(first+last)/2;
			partitionArray(a,first,mid);
			partitionArray(a,mid+1,last);
			MergeArray(a,first,mid,last);
		}
	}
	static void MergeArray(float a[],int first,int mid,int last){
		int i,j,k;
		int l1=mid-first+1;
		int l2=last-mid;
		int[] left=new int[l1];
		int [] right=new int[l2];
		for(i=0; i<l1;i++)
			left[i]=(int)a[first+1];
		for(j=0;j<l2;j++)
			right[j]=(int)a[mid+1+j];
		i=j=0;
		k=first;
		while(i<l1 && j<l2)
		{
			if(left[i]<=right[j])
				a[k++]=left[i++];
			else
				a[k++]=right[j++];
		}
		while(i<l1)
			a[k++]=left[i++];
		while(j<l2)
			a[k++]=right[j++];
		
	}
}
