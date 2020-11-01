package git_test;
import java.util.HashMap;
import java.util.Map.Entry;
/*
 * Let’s write an application for bookstores
 Rules
•You should create book id for every book. It should be start from 1000
•Every book should have some information like name, author, year of publication and price
•Program should start with a menu for user can pick any option
 1) add book
  2) search by book id
  3) search by any information
  4) delete by book id
  5) List all books
  6) Quit
 */
import java.util.Scanner;

public class BookStore {
	public static int bookID =1000;
	public static int count = 0;
	public static HashMap<Integer,String> books = new HashMap<>();
	public static void main(String[] args) {
		addSomeBooks();
		menu();
		
	}
	
	public static void addBook() {
		
		Scanner scan = new Scanner(System.in);
	
		System.out.println("Please enter book name");
		String bookName = scan.nextLine();
		System.out.println("Please enter author of the book");
		String bookAuthor = scan.nextLine();
		System.out.println("Please enter year of publication");
		String bookYear = scan.nextLine();
		System.out.println("Please enter year of publication");
		String bookPrice = scan.nextLine();
		String bookInfo = bookName + " " + bookAuthor + " " + bookYear + " " + bookPrice;
		bookID++;
		
		books.put(bookID, bookInfo);
		System.out.println("You added 1 book");
		System.out.println(books);
		menu();
	}
	public static void searchByInfo() {
		Scanner scan=new Scanner(System.in);
		System.out.println("Please enter any information about book");
		String searchInfo=scan.nextLine();
		int flag=0;
		for (Entry<Integer, String> entry : books.entrySet()) {
			if (entry.getValue().contains(searchInfo)) {
				System.out.println("Id = " + entry.getKey() + ", Book Information= " + entry.getValue());
				flag++;
			}
		} if(flag==0) {
			System.out.println("the book you are looking for was not found");}
		System.out.println("============================");
		menu();
		}
	public static void searchByID() {
		Scanner  scan = new Scanner(System.in);
		System.out.println("Please enter id from the list");
		System.out.println(books.keySet());
		Integer key= scan.nextInt();
		if(books.containsKey(key))
			System.out.println(books.get(key));
		else
			System.out.println("The book does not exist.");
		menu();
		//I presented the list for books before user entering the id
		//its better to check for list is empty
	}
	public static void deleteById() {
		Scanner  scan = new Scanner(System.in);
		System.out.println("Please enter id from the list");
		System.out.println(books.keySet());
		Integer key= scan.nextInt();
		if(books.containsKey(key))
			System.out.println("you removed the book with id :" + books.remove(key));
		else
			System.out.println("The book does not exist.");
		
		menu();
	}
	public static void listAllBooks() {
		if(!books.isEmpty())
			for (Integer keys : books.keySet())  
				{
					System.out.println(keys + ":"+ books.get(keys));
				}
		else
			System.out.println("No books in the store");
		
		menu();
	}
	public static void quit() {
		System.out.println("Thanks, bye");
	}
	public static void menu() {
		Scanner scan = new Scanner(System.in);
		System.out.println("PLease choose an option (1-6): \n1-Add book \n2-Search by book id\n3-search by any information \n4- delete by book \n5- List all books \n6- Quit");
		String option= scan.next().toUpperCase().trim();
		switch(option) {
		case "1":
			addBook();
			break;
		case "2":
			searchByID();
			break;
		case "3":
			searchByInfo();
			break;
		case "4":
			deleteById();
			break;
		case "5":
			listAllBooks();
			break;
		case "6":
			quit();
			break;
		}
	}
	
	public static void addSomeBooks() {
		books.put(9999, "Lords, John , 2001, 11");
		books.put(9998, "Countries, Ted, 2005, 10");
		books.put(9997, "Illness, Tulin, 2005, 21");
		books.put(9996, "Roads, Suzan, 2005, 30");		
	}

}
