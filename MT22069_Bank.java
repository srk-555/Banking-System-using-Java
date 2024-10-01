import java.util.Date;
import java.util.Random;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
public class MT22069_Bank {
	private String name;
	private String accNo;
	private String dob;
	private String gender;
	private String accType;
	 // all three indices represent services for priority queue, personal manager and cash delhivery at home
	public boolean priority_queue = false;
	public boolean password_manager = false;
	public boolean cash_delhivery = false;
	private long balance;
	Date accCreated;
	Date baseForInterest = new Date(); 
	
	// Assuming interest rate is applied yearly as NOT explicitly mentioned in the question
	
	
	
	public static String getRandomNumberString() {
	    // It will generate 6 digit random Number.
	    // from 0 to 999999
	    Random rnd = new Random();
	    int number = rnd.nextInt(999999);

	    // this will convert any number sequence into 6 character.
	    return String.format("%06d", number);
	}
	Scanner sc = new Scanner(System.in);
	
	 public boolean search(String ac_no) { 
		    
		   //System.out.println("received - "+ac_no);
		   //System.out.println("Actual - "+accNo);

	        if(accNo.equals(ac_no)){  
	        	//System.out.println("checked");
	            return true; 
	        }  
	        return (false);  
	    }  
	
	public void openAccount(int i) {
		accCreated = new Date();
		baseForInterest = accCreated;
		System.out.println("-------------------------------------------\n");
		System.out.println("Enter your name - ");
		name = sc.nextLine();
	

		accNo = getRandomNumberString();

		
		System.out.println("Enter DOB (dd/mm/yyyy)- ");
		dob = sc.nextLine();
			
		System.out.println("Enter Gender - ");
		gender = sc.nextLine();
		
		System.out.println("Enter Account Type (Savings/Current/FixedDeposit/NewType) - ");
		
		accType = sc.next();
		if(accType.toLowerCase().equals("newtype")) {
			System.out.println("Enter new account type - ");
			String newType = sc.next();
			accType = newType;
		}
		
		balance = 0;
		if(accType.toLowerCase().equals("fixeddeposit")) {
			System.out.println("Enter Initial Deposit for your FD - ");
			long initialDeposit = sc.nextLong();
			balance = initialDeposit;
		}
		System.out.println("\nPlease Note your Account No - "+ accNo);
		System.out.println("Initial Balance - "+balance);
		
	}
	
	public String getInterest(int end) {
		int start = (int)accCreated.getYear();
		System.out.println("Your account was created in year - " + start+1900);
		if (end < start) {
			
			return "Bad Input!";
		}
		double result = 0.0;
		int diff = end - (start+1900);
		if (accType.toLowerCase().equals("newtype")) {
			return "Interest rates only for savings, current and fixed deposit";
		}
		if (accType.toLowerCase().equals("savings")) {
			result = Math.pow((1+0.06), diff);
			result = result * balance;
		}
		if (accType.toLowerCase().equals("fixeddeposit")) {
			result = Math.pow((1+0.1), diff);
			result = result * balance;
		}
		if (accType.toLowerCase().equals("current")) {
			result = Math.pow((1+0.03), diff);
			result = result * balance;
		}
		System.out.println("\nIn Year "+end);
		return String.valueOf(result);
	}
	
	public void displayAccount() {
		Date today = new Date();
		long difference_In_Time = baseForInterest.getTime() - today.getTime();
		long difference_In_Years = (difference_In_Time / (1000l * 60 * 60 * 24 * 365));
		
		if (difference_In_Years==1) {
			if(accType.toLowerCase().equals("fixeddeposit")) {
				balance = (long) (balance + (balance*0.1));
				baseForInterest = new Date();
			}
			else if(accType.toLowerCase().equals("savings")) {
				balance = (long) (balance + (balance*0.06));
				baseForInterest = new Date();
			}
			else {
				balance = (long) (balance + (balance*0.03));
				baseForInterest = new Date();
			}
		}
		System.out.println("Account No - "+accNo);
		System.out.println("Name - "+name);
		System.out.println("Balance - "+balance);
		System.out.println("Account Type - "+accType);
		System.out.println("--------------------------------------------");
	}
	
	public void deposit() {
		if(accType.toLowerCase().equals("fixeddeposit")) {
			System.out.println("Cannot Deposit in Fixed Deposit Type Bank Account");
			return;
		}
		System.out.println("Enter amount to deposit - ");
		long amt = sc.nextLong();
		
		balance = balance + amt;
		System.out.println("\nUpdated Balance - "+balance);
	}
	
	public void withdraw() {
		System.out.println("check0");
		System.out.println(accType.toLowerCase());
		if(accType.toLowerCase().equals("fixeddeposit")) {
			System.out.println("check1");
			Date today = new Date();
			long difference_In_Time =accCreated.getTime() - today.getTime();
			long difference_In_Years = (difference_In_Time / (1000l * 60 * 60 * 24 * 365));
			System.out.println("check2");
			if (difference_In_Years<=0) {
				System.out.println("check3");
				System.out.println("\n Fixed Deposit cannot be withdrawn before 1 year");
				System.out.println("Seconds passed from account Creation are ");
				System.out.println(difference_In_Time);
				return;
			}
			
		}
		System.out.println("Enter amount to withdraw - ");
		String amt = sc.next(); 
		long amt1=Long.parseLong(amt); 
		if(balance-amt1 < 0) {
			System.out.println("Not enough balance to withdraw!");
			return;
		}
		balance = balance - amt1;
		System.out.println("\nUpdated Balance - "+balance);
	}
}
