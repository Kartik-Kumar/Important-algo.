import java.util.*;
public class Kruskals {

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
		Krus.mincst(cost,n);
		sc.close();
	}

}

class Krus{
	static void mincst(int [][]cost,int n){
		int i=0,j=0,min=0,mincost=0,u=0,v=0,a=0,b=0;
		int[] parent=new int [n+1];
		int ne=1;
		while(ne<n){
			for(i=1,min=999; i<=n; i++)
			{
				for(j=1;j<=n;j++)
					if(cost[i][j]<min)
					{
						min=cost[i][j];
						a=u=i;
						b=v=j;
					}
			}
		
	
	u=find(u,parent);
	v=find(v,parent);
	if(union(u,v,parent)==1)
	{
		System.out.printf("\nEdge(%d,%d)----->%d",a,b,min);
		ne++;
		mincost+=min;
		}
	cost[a][b]=cost[b][a]=999;
		}
	System.out.println("\n"+mincost);
	}
	static int find(int i,int parent[])
	{
		while(parent[i]==1)
			i=parent[i];
		return i;
	}
	static int union(int i,int j,int parent[])
	{
		if(i!=j)
		{
			parent[j]=i;
			return 1;
		}
		return 0;
	}
}
