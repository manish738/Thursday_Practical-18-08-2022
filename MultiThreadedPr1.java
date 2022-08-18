/*Write a Java program that implements a multi-thread application that has three threads. 
First thread generates random integer every 1 second and if the value is even, 
second thread computes the square of the number and prints.
 If the value is odd, the third thread will print the value of cube of the number.*/

import java.util.Random;
class square extends Thread
{
	int x;
	square(int n)
	{
		x=n;
	}
	public void run()
	{
		System.out.println("Random Number : "+x);
		System.out.println("The Thread :  "+x+"  Even and square of the number :"+(x*x));
		System.out.println("--------------------------------------------------------");	
	}
}
class cube extends Thread
{
	int x;
	cube(int n)
	{
		x=n;
	}
	public void run()
	{
		System.out.println("Random Number : "+x);
		System.out.println("The Thread  : "+x+"  Old and cube of the number :"+(x*x*x));
		System.out.println("--------------------------------------------------------");
	}
}
 
class RandomV extends Thread
{
	public void run()
	{ 
	Random r=new Random();
		for(int i=0;i<5;i++)
		{
			int n=r.nextInt(100);
			if(n%2==0)
			{
				square s=new square(n);
				s.start();
			}
			else
			{
				cube c=new cube(n);
				c.start();	
			}
			try	
			{
				Thread.sleep(1000);
			}
			 catch (InterruptedException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

public class MultiThreadedPr1 extends Thread 
{
	public static void main(String[] args)
	{
		RandomV r1=new RandomV();
		r1.start();
	}
}