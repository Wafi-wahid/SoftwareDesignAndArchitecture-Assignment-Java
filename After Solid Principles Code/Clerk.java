
package LMS;

public class Clerk extends Staff {
  
    int deskNo;     //Desk Number of the Clerk
    public static int currentdeskNumber = 0;
  
    public Clerk(int id, String n, String a,int ph, double s,int dk) // para cons.
    {
        super(id,n,a,ph,s);
        
        if(dk == -1)
        {
            deskNo = currentdeskNumber;
        }
        else
        {
            deskNo=dk;
        }
        
        currentdeskNumber++;
    }
    
   
}   // Clerk's Class Closed