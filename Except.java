import java.util.*;

public class Except {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		int a,b,r;

		System.out.println("Enter two numbers:");
		a=sc.nextInt();
		b=sc.nextInt();
		try{
			r=a/b;
			System.out.println("Result is:"+r);
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		sc.close();
		
	}

}
