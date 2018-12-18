import java.util.Scanner;
public class Dijkstra {	
	public static void main(String[] args) {
		int i,j,src;
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
		System.out.println("Enter source node:");
		src=sc.nextInt();
		int[] dest=new int[n+1];
		for(i=1; i<=n; i++)
			dest[i]=cost[src][i];
		
		Dijk.Sp(n,src,cost,dest);
		sc.close();
	}
}
class Dijk{
	static void Sp(int n, int src, int cost[][],int dest[]){
		int[] reach=new int[n+1],path=new int[n+1];
		int i,j,c,min,u=0;
		for(i=1; i<=n; i++)
			path[i]=src;
		c=1;
		while(c<n){
			min=999;
			for(i=1; i<=n; i++)
				if(dest[i]<min && reach[i]==0)
				{
					min=dest[i];
					u=i;
				}
			reach[u]=1;
			c++;
		
		for(i=1; i<=n; i++)
		{
			if(dest[u]+cost[u][i]<dest[i]&&reach[i]==0)
			{
				dest[i]=dest[u]+cost[u][i];
				path[i]=u;
			}
		}
	}
		for(i=1; i<=n; i++)
		{
			if(i!=src){
				System.out.println("Shortest distance from "+src+" to "+i+" is "+dest[i]);
				if(dest[i]<999){
					System.out.print("Path:"+i);
					j=i;
					while(j!=src){
						j=path[j];
						System.out.print("<--"+j);
					}
					System.out.println();
				}
			}
		}
		System.out.println("If 999 node is not reachable.");
		
	}

}