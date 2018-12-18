import java.util.Scanner;
import java.util.StringTokenizer;


public class Cust {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Ener name & date:");
		String name=sc.next();
		String date=sc.next();
		Customer c=new Customer();
		c.custdetails(name,date);
		sc.close();
	}

}

class Customer{
	String temp;
	int dd,mm,yyyy;
	void custdetails(String name,String date){
		StringTokenizer token=new StringTokenizer(date,",/");
		temp=token.nextToken();
		dd=Integer.parseInt(temp);
		temp=token.nextToken();
		mm=Integer.parseInt(temp);
		temp=token.nextToken();
		yyyy=Integer.parseInt(temp);
		System.out.println(name+","+dd+","+mm+","+yyyy);
	}
}