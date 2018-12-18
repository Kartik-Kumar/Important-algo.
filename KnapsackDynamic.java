import java.util.Scanner;


public class KnapsackDynamic 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		int n,m;
		System.out.println("Enter the number Objects");
		n=sc.nextInt();
		System.out.println("Enter the maximum Capacity of the Knapsack:");
		m=sc.nextInt();
		int p[]=new int[n+1];
		int  w[]=new int[n+1];
		for(int i=1; i<=n; i++)
		{
			System.out.println("Enter object "+(i)+"'s Profit and Weight:");
			p[i]=sc.nextInt();
			w[i]=sc.nextInt();
		}

		int v[][]=new int[n+1][m+1];
		Dynamic.solve(v,w,p,n,m);
		int i,j;
		for(i=0; i<=n; i++){
			for(j=0; j<=m; j++)
			{
				System.out.print(v[i][j]+"\t");
			}
			System.out.println();
		}
		
		Dynamic.Display(n,w,v,m);
		sc.close();
	}

}

class Dynamic{
	public static void solve(int v[][],int[] w,int [] p, int n ,int m){
		int i,j;
		for(i=0; i<=n; i++)
		{
			for( j=0; j<=m; j++)
			{
				if(i==0 || j==0)
					v[i][j]=0;
				
				else if(j<w[i])
					v[i][j]=v[i-1][j];
				
				else 
					v[i][j]=max(v[i-1][j],v[i-1][j-w[i]]+p[i]);
			}
		
		}
		
			
		}
		
	
	static int max(int a,int b)
	{
		if(a>b)
			return a;
		else 
			return b;
	
	}
	static void Display(int n,int w[],int v[][],int c)
	{
		int []k=new int[n+1];
		int i,j;
		for(i=n, j=c; (i!=0 && j!=0); i--)
		{
			if(v[i][j]!=v[i-1][j])
			{
				k[i]=1;
				j=j-w[i];
			}
		}
		for(i=1;i<=n;i++){
			System.out.println(i+"-"+k[i]);
			}
		System.out.println("Max Profit:"+v[n][c]);
		}
}