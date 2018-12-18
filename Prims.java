import java.util.Scanner;


public class Prims {
	
		public static void main(String[] args) {
			int i,j;
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter the nember of vertices:");
			int n=sc.nextInt();
			int[][] cost=new int[n+1][n+1];
			System.out.println("Enter the cost matrix:");
			for(i=1; i<=n; i++)
				for(j=1; j<=n; j++)
				{
					cost[i][j]=sc.nextInt();
					if(cost[i][j]==0 && !(i==j))
						cost[i][j]=999;
				}
			Prim.mincst(cost,n);
			sc.close();
		}

	}

class Prim{
	static void mincst(int [][]cost,int n){
		int i=0,j=0,min=0,mincost=0,u=0,v=0;
		int[] visited=new int [n+1];
		visited[1]=1;
		int ne=1;
		while(ne<n){
			for(i=1,min=999; i<=n; i++)
			{
				for(j=1;j<=n;j++)
					if(cost[i][j]<min)
					{
						if(visited[i]==1){
					
						min=cost[i][j];
						u=i;
						v=j;
						}
					}
			}
	
	if(visited[u]==0 || visited[v]==0)
	{
		System.out.printf("\nEdge(%d,%d)----->%d",u,v,min);
		ne++;
		mincost+=min;
		visited[v]=1;
	}
	cost[u][v]=cost[v][u]=999;
	}
	System.out.println("\n"+mincost);
	}
}
