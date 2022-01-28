package phase1;

import java.util.Scanner;

public class stringEmail {

			public static void main(String[] args) {
				// TODO Auto-generated method stub

					    String[] mail = {"adithya@gmail.com", "bala@gmail.com", "dhanush@gmail.com", "goutham@gmail.com", "harish@gmail.com"};
					    Scanner in=new Scanner(System.in);
					    System.out.println("Enter the String: ");
					    String toFind=in.nextLine();
					    boolean found = false;

		    for (String n : mail) {
		      if (n.equals (toFind)) {
		        found = true;
		        break;
		      }
		    }
		    
		    if(found)
		      System.out.println(toFind + " is found.");
		    else
		      System.out.println(toFind + " is not found.");
		  }
		}
