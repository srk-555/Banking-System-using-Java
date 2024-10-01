import java.io.*;
import java.util.Date;
import java.util.ArrayList;
import java.util.Scanner;

public class MT22069_Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		
		
		
		boolean go_on = true;
		
		
		System.out.println("How many accounts you want to open initially- ");
		int count = sc.nextInt();
		MT22069_Bank ac[] = new MT22069_Bank[count];
		for (int i = 0; i < count; i++) {  
            ac[i] = new MT22069_Bank();  
            ac[i].openAccount(i);  
        }  
		
		while(go_on) {
			int i = 0;
			System.out.println("\nEnter your choice - ");
			System.out.println("1. Display All Accounts");
			System.out.println("2. Display Account by acc No");
			System.out.println("3. WithDraw");
			System.out.println("4. Deposit");
			System.out.println("5. Add Services");
			System.out.println("6. Show Available and Purchased Services");
			System.out.println("7. Check Future Projected Interest for my Account");
			//System.out.println("8. Add New Bank Account");
			System.out.println("8. Quit");
			
			int ip = sc.nextInt();
			String acno;
			
			
			switch(ip) {
			case 1:
				for(int j=0; j<ac.length; j++) {
					ac[j].displayAccount();
				}
				
				break;
			case 2:
				System.out.println("Enter acc No - ");
				acno = sc.next();
			 
                boolean found = false;  
                for (int k = 0; k < ac.length; k++) {  
                    found = ac[k].search(acno);  
                    if (found) {  
                    	ac[k].displayAccount();
                        break;  
                    }  
                }  
                if (!found) {  
                    System.out.println("Search failed! Account doesn't exist..!!");  
                }  
                break;  
			case 3:
				System.out.println("Enter acc No - ");
				acno = sc.next();
			 
                boolean found1 = false;  
                for (int k = 0; k < ac.length; k++) {  
                	found1 = ac[k].search(acno);  
                    if (found1) {  
                    	ac[k].withdraw();
                        break;  
                    }  
                }  
                if (!found1) {  
                    System.out.println("Search failed! Account doesn't exist..!!");  
                }  
                break; 
				
	
			case 4:
				System.out.println("Enter acc No - ");
				acno = sc.next();
			 
                boolean found2 = false;  
                for (int k = 0; k < ac.length; k++) {  
                	found2 = ac[k].search(acno);  
                    if (found2) {  
                    	ac[k].deposit();
                        break;  
                    }  
                }  
                if (!found2) {  
                    System.out.println("Search failed! Account doesn't exist..!!");  
                }  
                break; 
			
			case 5:
				System.out.println("What to add 1.Priority Queue 2.Personal Manager 3.Cash Delhivery at Home (input - 1/2/3)");
				int ip1 = sc.nextInt();
				if (ip1<1 && ip1>3) {
					System.out.println("Bad Input !");
					return;
				}
				System.out.println("Enter acc No - ");
				acno = sc.next();
			 
                boolean found3 = false;  
                for (int k = 0; k < ac.length; k++) {  
                	found3 = ac[k].search(acno);  
                    if (found3) {
                    	found3 = true;
                    	if(ip1==1){
                    		//System.out.println("ip is 1");
                    		if(ac[k].priority_queue == true) {
                    			System.out.println("This service is already added!");
                    			break;
                    		}
                    		ac[k].priority_queue = true;
                    		System.out.println("Service Added!");
                    	}
                    	else if (ip1==2) {
                    		if(ac[k].password_manager == true) {
                    			System.out.println("This service is already added!");
                    			break;
                    		}
                    		ac[k].password_manager = true;
                    		System.out.println("Service Added!");
                    	}
                    	else {
                    		if(ac[k].cash_delhivery == true) {
                    			System.out.println("This service is already added!");
                    			break;
                    		}
                    		ac[k].cash_delhivery = true;
                    		System.out.println("Service Added!");
                    	}
                        break;  
                    }  
                }  
                if (!found3) {  
                    System.out.println("Search failed! Account doesn't exist..!!");  
                }  
                break;
                
			case 6:
				System.out.println("Enter acc No - ");
				acno = sc.next();
				ArrayList<String> available = new ArrayList<String>();
				ArrayList<String> purchased = new ArrayList<String>();
                boolean found4 = false;  
                for (int k = 0; k < ac.length; k++) {  
                	found4 = ac[k].search(acno);  
                    if (found4) {  
                    	
                    	if(ac[k].password_manager == true) {
                			purchased.add("Password Manager");
                		}
                    	else {
                    		//System.out.println("avail.............");
                    		available.add("Password Manager");
                    	}
                    	
                    	if(ac[k].priority_queue == true) {
                    		
                    		
                			purchased.add("Priority Queue");
                		}
                    	else {
                    		//System.out.println("avail.............");
                    		available.add("Priority Queue");
                    	}
                    	if(ac[k].password_manager == true) {
                			purchased.add("Cash On Delhivery");
                		}
                    	else {
                    		//System.out.println("avail.............");
                    		available.add("Cash On Delhivery");
                    	}
                    	
                    	
                    	System.out.println("\nAvailable Services Are - ");
                    	for(int z=0; z<available.size(); z++) {
                    		System.out.println(available.get(z));
                    	}
                    	System.out.println("\nPurchased Services Are - ");
                    	for(int u=0; u<purchased.size(); u++) {
                    		System.out.println(purchased.get(u));
                    	}
                        break;  
                    }  
                }  
                if (!found4) {  
                    System.out.println("Search failed! Account doesn't exist..!!");  
                }  
                break;
             
			case 7:
				System.out.println("----------------------");
				System.out.println("Enter the year(yyyy) for which you want to check your Interest");
				int end = sc.nextInt();
				System.out.println("Enter acc No - ");
				acno = sc.next();
				
				boolean found5 = false;  
                for (int k = 0; k < ac.length; k++) {  
                	found5 = ac[k].search(acno);  
                    if (found5) {  
                    	Date today = new Date();
                    	//int start = (ac[k].accCreated.getYear()+1900);
                    	
                    	
                    	  
                    	System.out.println("New Balance would be - \n"+ac[k].getInterest(end));
                    }  
                }  
                if (!found5) {  
                    System.out.println("Search failed! Account doesn't exist..!!");  
                }
				
				
				
				
				break;
				
		
				
			case 8:
				go_on = false;
				break;
			default:
				System.out.println("Bad Input!");
				return;
			}
			
			
		}
		
		
	}

}
