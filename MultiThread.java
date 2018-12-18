import java.util.*;

public class MultiThread {

	public static void main(String[] args) {
		RandomNum rm=new RandomNum();
		rm.start();
		Square sq=new Square();
		sq.start();
		Cube c=new Cube();
		c.start();
		

	}

}

class RandomNum extends Thread
{
	int res;
	static int n;
	public synchronized int GenerateRandomNum()
	{
		Random r=new Random();
		n= r.nextInt(100);
		return n;
		
	}
	
	public void run()
	{
		int i=0;
		while(i<10)
		{
			try{
				res=GenerateRandomNum();
				System.out.println("Random Number Generator:"+res);
				Thread.sleep(1000); //Makes the thread sleep for one second
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
			i++;
		}
	}
}

class Square extends Thread{
	
	public void ComputeSquare(int s){
		int res=s*s;
		System.out.println("Square is:"+res);
	}
	public void run()
	{
		int i=0;
		while(i<10){
			try{
				ComputeSquare(RandomNum.n);
				Thread.sleep(1000);
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
			i++;
		}
	}
}
class Cube extends Thread{
	
	public void ComputeSquare(int s){
		int res=s*s*s;
		System.out.println("Cube is:"+res);
	}
	public void run()
	{
		int i=0;
		while(i<10){
			try{
				ComputeSquare(RandomNum.n);
				Thread.sleep(1000);
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
			i++;
		}
	}
}