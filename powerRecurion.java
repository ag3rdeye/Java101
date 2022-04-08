/**
 * @author Arzun Giri
 */
import java.util.Scanner;
public class powerRecurion {
    public static int pow(int base, int power){
        if(power==0){
            return 1;
        }
        else{
            return base*pow(base,power-1);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter base and power respectively: ");
       System.out.println("Result: "+pow(sc.nextInt(),sc.nextInt())); 
       sc.close();
    }
    
}
