import java.util.*;
public class KnapSack {

	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n,m;
		System.out.println("Enter the number Objects");
		n=sc.nextInt();
		System.out.println("Enter the maximum Capacity of the Knapsack:");
		m=sc.nextInt();
		float  p[]=new float[n];
		float w[]=new float[n];
		for(int i=0; i<n; i++)
		{
			System.out.println("Enter object "+(i+1)+"'s Profit and Weight:");
			p[i]=sc.nextFloat();
			w[i]=sc.nextFloat();
		}
		
		float temp,temp1;
		for(int i=0; i<n; i++){
			
			for(int j=0; j<n-1; j++){
				
				if((p[j]/w[j])<(p[j+1]/w[j+1]))
				{
					temp=w[j]; temp1=p[j];
					w[j]=w[j+1]; p[j]=p[j+1];
					w[j+1]=temp; p[j+1]=temp1;
					
				}
			
			}
		}
		 
		Greedy.GreedyDo(n,m,w,p);
		sc.close();
		
	}

}

class Greedy{
	static public void GreedyDo(int n,int m,float w[],float p[]){
		double x[]=new double[n];
		int i;
		double res=0,u=m;
		for(i=0; i<n; i++)
			x[i]=0;
		
		for(i=0; i<n; i++)
		{
			if(w[i]>u)
				break;
			x[i]=1.0f;
			u=u-w[i];
		}
		if(i<=n)
			x[i]=(u/w[i]);
					
		
	for(int j=0; j<=i; j++)
		res=res+(x[j]*p[j]);
	System.out.print(res);
	}
}