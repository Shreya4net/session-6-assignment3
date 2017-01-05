package thread;

public class Onlinebanking extends Thread {
Synchro s;
Onlinebanking(Synchro s)
{
this.s=s;
}
public void run()
{
	s.dposit(600);
}
}
class Banking extends Thread{
	Synchro s;
	Onlinebanking m;
	Banking(Synchro s,Onlinebanking m){
 this.s=s;
 this.m=m;
	}
	public void run()
	{
s.withdraw(500);
}
}

class Synchro
{
	int bal=500;
	synchronized void dposit(int amt)
{
		int temp=bal;
		temp=temp+bal;
		temp=temp+amt;
		try {Thread.sleep(500);}
		catch(Exception e){}
		bal=temp;
		System.out.println("Account Balance="+bal);
}
	synchronized void withdraw(int amount) {
		int temp=bal;
		temp=temp-bal;
		temp=amount-temp;
		try{Thread.sleep(500);}
		
		catch(Exception e){}
		bal=temp;
		System.out.println("Account Balance="+bal);
	}
	public static void main(String[] args)
	{
		Synchro s=new Synchro();
		Onlinebanking m=new Onlinebanking(s);
		m.start();
		Banking m1=new Banking(s,m);
		m1.start();
		
		
		}
}