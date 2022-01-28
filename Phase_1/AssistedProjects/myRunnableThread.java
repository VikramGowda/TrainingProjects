package threads;

public class myRunnableThread implements Runnable{
	 
    public static int myCount = 0;
    public myRunnableThread(){
         
    }
    public void run() {
        while(myRunnableThread.myCount <= 15){
            try{
                System.out.println("Expl Thread: "+(++myRunnableThread.myCount));
                Thread.sleep(150);
            } catch (InterruptedException iex) {
                System.out.println("Exception in thread: "+iex.getMessage());
            }
        }
    } 
    public static void main(String a[]){
        System.out.println("Starting Main Thread...");
        myRunnableThread mrt = new myRunnableThread();
        Thread t = new Thread(mrt);
        t.start();
        while(myRunnableThread.myCount <= 15){
            try{
                System.out.println("Main Thread: "+(++myRunnableThread.myCount));
                Thread.sleep(150);
            } catch (InterruptedException iex){
                System.out.println("Exception in main thread: "+iex.getMessage());
            }
        }
        System.out.println("End of Main Thread...");
    }
}
