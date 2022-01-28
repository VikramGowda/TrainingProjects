package accessSpecifier;

class privateaccessspecifier1 
{ 
   private void display() 
    { 
        System.out.println("You are using private access specifier"); 
    } 
} 
public class privateAccessSpecifier {

	public static void main(String[] args) {
		//private
		System.out.println("Private Access Specifier");
		privateaccessspecifier1  obj = new privateaccessspecifier1(); 
        //trying to access private method of another class 
        //obj.display();

	}
}

