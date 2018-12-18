import java.util.Scanner;


public class Floyds {

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
		Floyd.minpath(cost,n);
		sc.close();
		
	}
}

class Floyd{
	static void minpath(int [][]cost,int n){
		for(int k=1;k<=n;k++){
			for(int i=1;i<=n;i++){
				for(int j=1;j<=n;j++){
					cost[i][j]=Math.min(cost[i][j], (cost[i][k]+cost[k][j]));
			}
		}
	}

	for(int i=1;i<=n; i++){
		for(int j=1;j<=n;j++)
			System.out.print(cost[i][j]+" ");
		System.out.println();
		}
	}
}