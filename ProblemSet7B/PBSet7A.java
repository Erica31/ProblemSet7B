
/**
 * Write a description of class PBSet7A here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.ArrayList;
public class PBSet7A
{
    public static void main(String[] args){
        //test Prime list
        System.out.println("PrimeNums"+sieve(30));
        
        //test Goldbatch
        System.out.println("Summands:"+goldbatch(18));
        
        //test BigInts
        ArrayList<Integer> val1 = new ArrayList();
        ArrayList<Integer> val2 = new ArrayList();
        val1.add(5);
        val1.add(1);
        val1.add(9);//val1=519
        val2.add(3);
        val2.add(5);
        val2.add(2);//val2=352
        System.out.println("Sum:"+bigInts(val1, val2));
    }
    
    //Question 1: Sieve of Eratosthenes 
    public static ArrayList<Integer> sieve(int n){
        ArrayList<Integer> sieve = new ArrayList();
        for(int i=2; i<n+1; i++){
            sieve.add(i);
        }
        for(int i=0; i<sieve.size(); i++){
            int prime = sieve.get(i);
            for(int i2=i+1; i2<sieve.size(); i2++){
                if(sieve.get(i2)%prime == 0){
                    sieve.remove(i2);
                    i2--;
                }
            }
        }
        return sieve;
    }
    
    //Question 2: Goldbach Conjecture
    public static ArrayList<Integer> goldbatch(int sum){
        ArrayList<Integer> primes = sieve(sum);
        ArrayList<Integer> nums = new ArrayList();
        for(int i=0; i<primes.size(); i++){
            int val1 = primes.get(i);
            int val2 = sum-val1;
            if(primes.contains(val2)){
                nums.add(val1);
                nums.add(val2);
                break;
            }
        }
        return nums;
    }
    
    //Question 3: Adding BigInts
    public static ArrayList<Integer> bigInts(ArrayList<Integer> num1, ArrayList<Integer> num2){
        ArrayList<Integer> sum = new ArrayList();
        ArrayList<Integer> revNum1 = new ArrayList();
        ArrayList<Integer> revNum2 = new ArrayList();
        //to reverse num1
        for(int i=num1.size()-1;i>=0;i--){
            revNum1.add(num1.get(i));
        }
        //to reverse num2
        for(int i=num2.size()-1;i>=0;i--){
            revNum2.add(num2.get(i));
        }
        //adding
        if(num1.size()>=num2.size()){
            boolean carry1 = false;
            for(int i=0; i<num1.size(); i++){
                if(i<num2.size()){
                    int val1 = revNum1.get(i);
                    int val2 = revNum2.get(i);
                    int tempSum = val1 + val2;
                    if(tempSum>9){
                        if(carry1)
                            sum.add(0,tempSum-10+1);
                        else
                            sum.add(0,tempSum-10);
                        carry1 = true;
                    }else{
                        if(carry1)
                            sum.add(0,tempSum+1);
                        else
                            sum.add(0,tempSum);
                        carry1 = false;
                    }
                }else{
                    if(carry1)
                        sum.add(0,revNum1.get(i)+1);
                    else
                        sum.add(0,revNum1.get(i));
                    }
            }
        }else if(num1.size()<num2.size()){
            boolean carry1 = false;
            for(int i=0; i<num2.size(); i++){
                if(i<num1.size()){
                    int val1 = revNum1.get(i);
                    int val2 = revNum2.get(i);
                    int tempSum = val1 + val2;
                    if(tempSum>9){
                        if(carry1)
                            sum.add(0,tempSum-10+1);
                        else
                            sum.add(0,tempSum-10);
                        carry1 = true;
                    }else{
                        if(carry1)
                            sum.add(0,tempSum+1);
                        else
                            sum.add(0,tempSum);
                        carry1 = false;
                    }
                }else{
                    if(carry1)
                        sum.add(0,revNum2.get(i)+1);
                    else
                        sum.add(0,revNum2.get(i));
                    }
            }
        }
        return sum;
    }
}
