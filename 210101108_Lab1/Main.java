import java.util.*;


// class PrintPrimeBetweenGivenRange {

//     public static int isprime(int n) {
//       // for loop from 2 to n
//       for (int i = 2; i < n; i++) {
//         // if the number is divisible return -1
//         if (n % i == 0) {
//           return -1;
//         }
//       }
  
//       // return 1 if number is prime
//       return 1;
//     }
  
//     public static void main(String args[]) {
//       // initializing the lower_bound and upper_bound
//       int lower_bound = 2, upper_bound = 50;
  
//       for (int i = lower_bound; i <= upper_bound; i++) {
//         // if the number is prime print the number
//         if (isprime(i) == 1) {
//           System.out.print(i + " ");
//         }
//       }
//     }
//   }
  

// needs to be inherited from Thread
// class for multithreading
// class GeeksForGeeks extends Thread {
// 	private String mssg;

// 	GeeksForGeeks(String mssg)
// 	{
// 		this.mssg = mssg;
// 	}
    
// 	// invoked when we
// 	// call start() method
// 	public void run()
// 	{
// 		// prints only when start variable
// 		// is true (variable present in Main class)
		
		
// 	}
// }



public class Main {
	// public static variable and it's value
	// will be false when user enter input
	// public static boolean start = true;
    static int globalSum = 0;
    
    public Object globalLock = new Object();
	public static void main(String[] args)
	{
        // Declare the variables
        int num;
 
        // Input the integer
        System.out.println("Enter the integer: ");
 
        // Create Scanner object
        Scanner s = new Scanner(System.in);
         
        // Read the next integer from the screen
        num = s.nextInt();
        long[] result = {0};
        int numThreads = 4;
        int numbersPerThread = num / numThreads;
        // Display the integer
        System.out.println("Entered integer is: "
                           + num);


        
		// GeeksForGeeks newThread = new GeeksForGeeks("Manish Loves GFG!");
     
		// child thread execution
		// starts here
		// newThread.start();

         int lowB=0;
         int upB=0;
         int k=3;
        while(upB<num && lowB<upB)
        {
            PrimeCheck newThread = new PrimeCheck(lowB,upB);

            newThread.start();
            
            if(upB+k<=num)
            {
                lowB=upB+1;
                upB+=k;

            }
            else{
                upB=upB+2;
                lowB=upB+1;

            }
            

        }
        
      
		
      s.close();
		
	}
}

class PrimeCheck extends Thread {
    // private Object lock;
    // public PrimeCheck(Object lock) {
    //     this.lock = lock;
    // }
	private int lower_bound;
    private int upper_bound;

	PrimeCheck(int low,int up)
	{
		this.lower_bound = low;
        this.upper_bound=up;
	}
    public static int isprime(int n) 
    {
        // for loop from 2 to n
        for (int i = 2; i < n; i++) 
        {
          // if the number is divisible return -1
          if (n % i == 0) 
          {
            return -1;
          }
        }
    
        // return 1 if number is prime
        return 1;
    }

	// invoked when we
	// call start() method
    @Override
	public void run()
	{   
        
            int sum=0;
            for (int i = this.lower_bound; i <= this.upper_bound; i++) 
            {
                // if the number is prime print the number
                if (isprime(i) == 1) 
                {
                    System.out.println(i + " : Current Thread Name: "+ Thread.currentThread().getName());
                    // System.out.println( ); 
                    
                    // // gets the ID of the current thread 
                    // System.out.println( "Current Thread ID: "+ Thread.currentThread().getId()); 
                    
                    Main.globalSum+=i;
                    sum+=i;
                    System.out.println("Global Sum is : " +Main.globalSum);
                }
            }
            System.out.println("local Sum is : " +sum + " of "+  Thread.currentThread().getId() );
           
        
	}
}
