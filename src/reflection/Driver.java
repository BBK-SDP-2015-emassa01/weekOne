package reflection;

public class Driver {

	public static void main(String[] args) {
		
		// YOUR CODE GOES HERE
		Storage<BankAccount> aStorage = new Storage<>();
		Storage<String> sStorage = new Storage<>();
		
	//Reasons for Generics: no casting, hold any type and 'has a' type of relationshop
	//Stronger type checking at compile time
	//Paramerterisable 
	
		Class baCls = BankAccount.class;
		try {
		Object myAccount = baCls.newInstance();
		aStorage.setValue(myAccount);
		// Deposit
		myAccount.deposit(15);
		}
		catch ( InstantiationException e ) {
		// ...
		}
		catch ( IllegalAccessException e ) {
		
		
		
	}

}
