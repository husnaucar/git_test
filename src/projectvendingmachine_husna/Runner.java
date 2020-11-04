package projectvendingmachine_husna;

import java.util.Scanner;

public class Runner {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Products product = new Products();
		Methods method = new Methods();
		
		 
		char z = 'y';
		
		do {
			
			double selectedItemPrice = method.select(product);
			System.out.println(selectedItemPrice);
			if( method.getBalance() >= selectedItemPrice ) {
			
			method.setBalance(method.getBalance() - selectedItemPrice);
			System.out.println("Your new balance is: $" + method.getBalance());
			System.out.println("Would you like to keep shopping? : y or n");
			z = scan.next().charAt(0);
			
			}
			else {
			System.out.println("Would you like to add money in your account? : y or n");
			char x ;
				do{
					x= scan.next().charAt(0);
						
					if( x == 'y') {
						System.out.println("How much money do you want to add?");
						method.addMoney(scan.nextDouble());
						System.out.println("Your new balance is $"+ method.getBalance());
						break;
				
					}
					else if(x=='n') {
						z = 'n';
						break;
					}
					else 
						System.out.println("Please choose y or n");
				}while(x!='y' && x != 'n');
			}
		}while(z != 'n');
		
		System.out.println("Your balance is $" +method.getBalance());
		System.out.println("Have a good day");
	}

}
