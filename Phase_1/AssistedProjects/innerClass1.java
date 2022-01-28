package innerClasses;


public class innerClass1 {

	 private String msg="Welcome to Java"; 
	 
	 class Inner{  
	  void hello(){System.out.println(msg+", Let us start learning Inner Classes");}  
	 }  


	public static void main(String[] args) {

		innerClass1 obj=new innerClass1();
		innerClass1.Inner in=obj.new Inner();  
		in.hello();  
	}
}


