/**
 * @author Arzun Giri
 */
public class TowerofHanoi {
    public void TOH(char a,char b, char c, int n){
       if(n>0){
        TOH(a, c, b, n-1);
        System.out.println("Move "+n+" from " +a+" to "+c+" using "+b);
        TOH(b, a, c, n-1);
       }
    }
    public static void main(String[] args) {
        TowerofHanoi toh = new TowerofHanoi();
        toh.TOH('a', 'b', 'c', 4); // Any numbers of plates can be inserted at n
    }
    
}
