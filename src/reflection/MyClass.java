package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class MyClass {
	
	public static void main(String[] args) {
		System.out.println("Test");
		
		try {
			Class c = Class.forName("java.util.Random");
			//wont load with just 'Random' as it needs the entire path.
			//also cannot import Random and expect it to work.
			System.out.println(c);//WHAT CLASSES ARE THERE
			Method[] m = c.getMethods();
			System.out.println(m);//WHAT METHODS ARE INVOLVED?
			//you have to be able to decode this, as 'm' is an array of methods.
			//prints [Ljava.lang.reflect.Method;@45ee12a7 
			//'Ljava' says it's a class.
			//so let's iterate using an enhanced for loop.
			for (Method meth:m){
				System.out.println(meth.toString());
				//iterate over the array and list the methods.
				//tells us all the methods it will respond to, not only the methods in Random.
				//all the methods associated with Random and then it gets inherited, this is how 'autocomplete' works.
				//Auto-complete uses reflection.
				
			
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.err.println("It's all gone wrong.");
			e.printStackTrace();
		} 
		//complaining because there is no class "", forName throws 
		//classNotFoundException, so it needs to be caught/dealt with.
		//Here we have surrounded by try/catch block.
		//Someone designed Exception classes wrong in Java. 
	
	
	System.out.println("Enter the name of the Class that you want to use Reflection on, You must type 'reflection.NAMEOFCLASS'.");
	Scanner in = new Scanner(System.in);
	String nameOfClass = in.next();
	
	System.out.println("Reflecting...");
	
	try {
		Class<?> theUserClass = Class.forName("reflection."+nameOfClass);
		//<?> is a raw type so if you don't put it, it will complain a little, but still compile!
		//not good to leave it out.
		
		//so we have a class - lets create an instance of it.
		
		Object obj = theUserClass.newInstance();
		//this throws an IllegalAccessException and InstantiationExceptions!
		//should create a newInstance of the class.
		//throws Instantiation Exception if there is no nullary constructor (we overloaded it!).		
		System.out.println(obj);
		
		System.out.println(theUserClass);
		Method[] theUserMethods = theUserClass.getMethods();
		Method[] theUserMethods2 = theUserClass.getDeclaredMethods();
		for (Method meth:theUserMethods){
			System.out.println(meth.toString());

		}
		
		try {
			Constructor<?> obj1 = theUserClass.getConstructor(String.class,String.class);
			Object p;
			try {
				p = obj1.newInstance("Esha", "111");
				System.out.println(p);
				
				Class<? extends Object> c = p.getClass();
				
				Method m = c.getMethod("setName", new Class[]{String.class});//setName is a method we want to invoke, and String.class is the Parameter that it takes in.
				m.invoke(p, new Object[]{"ohmygod"}); //m  is the method we want to invoke on object p. OhmyGod is the name we want to set. New Object because we don't know what parameters it takes in.
				System.out.println(p);
				
				
				
			} catch (IllegalArgumentException | InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.err.println("It's all gone wrong.");
	}
	
	
	
	}
	}
