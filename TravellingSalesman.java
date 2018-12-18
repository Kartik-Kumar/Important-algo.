import java.util.Scanner;


public class TravellingSalesman {

	
	public static void main(String[] args) {
		int i,j;
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number of vertices:");
		int n=sc.nextInt();
		int path[]=new int[n+1];
		if(n==1){
			System.out.println("Only one city present");
			sc.close();
			return;
		}
		
		int[][] cost=new int[n+1][n+1];
		System.out.println("Enter the cost matrix:");
		for(i=1; i<=n; i++)
			for(j=1; j<=n; j++)
			{
				cost[i][j]=sc.nextInt();
				if(cost[i][j]==0 && !(i==j))
					cost[i][j]=999;
			}
		
		for(i=1;i<=n;i++){
			path[i]=i;
		}
		int mincost=Tsmp.Mincost(n, cost, path, 1);
		System.out.println("Minimum cost path is:");
		for(i=1; i<=n; i++)
			System.out.print(path[i] +"---->");
		System.out.println("1");
		System.out.println("Min cost is:"+mincost);
		sc.close();
		
	}

}

class Tsmp{
	static int Mincost(int n, int[][] cost,int[] path,int start){
		int[] minpath=new int[n+1];
		int[] temp=new int[n+1];
		int mincost=999,curcost,i,j,k;
		if(start==n-1)
		{
			return(cost[path[n-1]][path[n]]+cost[path[n]][1]);
		}
		for(i=start+1; i<=n; i++)
		{
			for(j=1; j<=n; j++){
				temp[j]=path[j];
			}
			temp[start+1]=path[i];
			temp[i]=path[start+1];
			if((cost[path[start]][path[i]]+(curcost=Mincost(n,cost,temp,start+1)))< mincost){
					mincost=cost[path[start]][path[i]]+curcost;
			for(k=1; k<=n; k++)
				minpath[k]=temp[k];
			}
	
		}
		
		for(i=1; i<=n;i++)
			path[i]=minpath[i];
		return mincost;
	}
}