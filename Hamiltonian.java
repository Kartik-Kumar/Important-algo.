import java.util.Scanner;

public class Hamiltonian {

	static int n;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number of vertices:");
		n=sc.nextInt();
		int graph[][]=new int[n][n];
		System.out.println("Enter the adjacency matrix of graph:");
		for(int i=0; i<n; i++)
			for(int j=0; j<n; j++)
				graph[i][j]=sc.nextInt();
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++)
				System.out.print(graph[i][j]+"\t");
			System.out.println();
		}
			hamCycle(graph);
		sc.close();
	}
	
	static void printSolution(int path[]){
		System.out.println("Solution Exists");
		System.out.println("Following is one Hamiltonian Cycle:");
		for(int i=0; i<n; i++)
			System.out.print(path[i]+1+"---->");
		System.out.println(path[0]+1);
	}
	
	static boolean isSafe(int v, int graph[][], int path[],int pos)
	{
		if(graph[path[pos-1]][v]==0)
			return false;
		for(int i=0; i<pos; i++)
			if(path[i]==v)
				return false;
		return true;
	}
	
	static boolean hamCycleUtil(int graph[][],int path[],int pos)
	{
		if(pos==n)
		{
			if(graph[path[pos-1]][path[0]]==1)
				return true;
			else return false;
		}
		for(int v=1; v<n; v++)
		{
			if(isSafe(v,graph,path,pos))
			{
				path[pos]=v;
				if(hamCycleUtil(graph,path,pos+1)==true)
					return true;
				path[pos]=-1;
			}
		}
		return false;
	}
	
	static boolean hamCycle(int graph[][])
	{
		int path[]=new int[n+1];
		for(int i=0; i<n; i++)
			path[i]=-1;
		path[0]=0;
		if(hamCycleUtil(graph,path,1)==false)
		{
			System.out.println("Solution does not exist");
			return false;
		}
		
		printSolution(path);
		return true;
	}

}

