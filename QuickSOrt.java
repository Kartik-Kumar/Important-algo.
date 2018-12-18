import java.util.*;
public class QuickSOrt {

	public static void main(String[] args) {
		int n,i,min=5000,max=5000;
		
		Scanner sc=new Scanner(System.in);
		Random ranNum=new Random();
		System.out.println("Enter the number of numbers to be sorted:");
		n=sc.nextInt();
		int a[]=new int[n];
		
		for(i=0; i<n; i++){
			a[i]=min+ranNum.nextInt(max);
		}
		
		long start=System.currentTimeMillis();
		
		Sort.sortArray(a, 0, n-1);
		
		long end=System.currentTimeMillis();
		System.out.println("Sorted Array:");
		for(i=0; i<n; i++)
			System.out.println(a[i]);
		System.out.println("\nTime taken:"+(end-start));
		sc.close();
	}

}


class Sort {

	 static void sortArray(int[] a,int first,int last)
	{
		int j;
		if(first<last)
		{
			j=partitionArray(a,first,last);
			sortArray(a,first,j-1);
			sortArray(a,j+1,last);
		}
		
	}
	
	 static int partitionArray(int[] a,int first,int last)
	{
		int pivot,i,j,temp;
		pivot=a[first];
		i=first+1;
		j=last;
		while(true)
		{
				while(a[i]<=pivot && i<last)
					i++;
				while(a[j]>=pivot && j>first)
					j--;
				if(i<j)
				{
					temp=a[j];
					a[j]=a[i];
					a[i]=temp;
				}
				else 
				{
					temp=a[first];
					a[first]=a[j];
					a[j]=temp;
					return j;
				}
		}		
	}
	
}