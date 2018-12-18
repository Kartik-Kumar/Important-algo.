import java.util.Scanner;

public class Subset {
	static int[] el;
	static int[] subset;
	static int n,sum,total;
	
	public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter the number of elements in the set:");
	n=sc.nextInt();
	el=new int[n+1];
	subset=new int[n+1];
	System.out.println("Enter the elements in the set:");
	for(int i=1; i<=n; i++)
	{
		el[i]=sc.nextInt();
		total +=el[i];
	}
	System.out.println("Enter sum:");
	sum=sc.nextInt();
	java.util.Arrays.sort(el);
	if(total<sum)
		System.out.println("Solution not possible");
	else {
		System.out.println("Subsets are:");
		Sumsubset(0,1,total);
		}
	
	sc.close();
	}

	static void Sumsubset(int x,int i, int total){
		int j;
		subset[i]=1;
		if(x+el[i]==sum)
		{
			System.out.print("\n{");
			for(j=1; j<=i; j++)
				if(subset[j]==1)
					System.out.print(el[j]+" ");
			System.out.println("}");
		}
		else if((x+el[i]+el[i+1])<=sum)
		{
			Sumsubset(x+el[i],i+1,total-el[i]);
		}
			if((x+total-el[i]>=sum && (x+ el[i+1])<=sum))
			{
				subset[i]=0;
				Sumsubset(x,i+1,total-el[i]);
			}
	}
}
	


