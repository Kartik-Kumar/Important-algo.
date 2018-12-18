import java.util.*;

public class ClassDetails {
	
	static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) {
		int n,i,c;
		
		System.out.println("1.Teaching details\n2.Technical details\n3.Contract details\nEnter your choice:");
		c=sc.nextInt();
		System.out.println("Enter the number of Staff:");
		n=sc.nextInt();
		switch(c){
		
		case 1:	System.out.println("Enter staff details:");
				Teaching[] t=new Teaching[n];
				for(i=0;i<n;i++)
					t[i]=new Teaching();
				for(i=0; i<n; i++)
				{
					read(t[i]);
					read1(t[i]);
			
				}
				for(i=0; i<n; i++){
					display(t[i]);
					System.out.println("Publications"+t[i].publications);
					System.out.println("Domain"+t[i].domain);
				}
				break;
		case 2:	System.out.println("Enter staff details:");
				Technical[] tc=new Technical[n];
					for(i=0;i<n;i++)
						tc[i]=new Technical();
					for(i=0; i<n; i++)
					{
						read(tc[i]);
						read2(tc[i]);
					}
					for(i=0; i<n; i++){
					display(tc[i]);
					System.out.println("Skills:"+tc[i].skills);
					}
					break;	
		case 3:	System.out.println("Enter staff details:");
				Contract[] con=new Contract[n];
					for(i=0;i<n;i++)
							con[i]=new Contract();
				for(i=0; i<n; i++)
					{
						read(con[i]);
						read3(con[i]);
					}
				for(i=0; i<n; i++){
					display(con[i]);
					System.out.println("Period:"+con[i].period);
				}
				break;
		default: break;
		}
	}
	static void display(Staff t){
		System.out.println("Name:"+t.name);
		System.out.println("Staff ID:"+t.staffid);
		System.out.println("Phone Number:"+t.ph);
		System.out.println("Salary:"+t.salary);
		
	}
	static void read(Staff t)
	{
		System.out.println("Enter name,Staff id,Phone Number,Salary:");
		t.name=sc.next();
		t.staffid=sc.next();
		t.ph=sc.nextLong();
		t.salary=sc.nextLong();
		
		
	}
	static void read1(Teaching t){
		System.out.println("Enter Domain and Publications:");
		t.domain=sc.next();
		t.publications=sc.next();
	}
	static void read2(Technical tc)
	{
		System.out.println("Enter Skills:");
		tc.skills=sc.next();
		
	}
	static void read3(Contract c)
	{
		System.out.println("Enter Period:");
		c.period=sc.nextInt();
		
	}
}

class Staff{
	String staffid,name;
	long ph,salary;
	
}

class Teaching extends Staff{
	String domain,publications;

}
class Technical extends Staff{
	String skills;
}
class Contract extends Staff{
	int period;
}