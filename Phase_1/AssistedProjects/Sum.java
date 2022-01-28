package pillarsOfOops;

public class Sum {
    public int sum(int x, int y) 
    { 
        return (x + y); 
    } 
    public int sum(int x, int y, int z) 
    { 
        return (x + y + z); 
    } 
    public double sum(double x, double y) 
    { 
        return (x + y); 
    } 
    public static void main(String args[]) 
    { 
        Sum s = new Sum(); 
        System.out.println(s.sum(100, 200)); 
        System.out.println(s.sum(150, 250, 350)); 
        System.out.println(s.sum(15.5, 20.5)); 
    } 
}
