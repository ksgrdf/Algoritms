
import java.math.BigInteger;


public class Factorial {

    public static void main(String[] args)
    {

      BigInteger bi = factorial(new BigInteger("100")); //value number of factorial
      long sum =0;

       while(bi.compareTo(BigInteger.ZERO)>0) {
           sum+=bi.mod(BigInteger.TEN).longValue(); //remainder of the division
           bi = bi.divide(BigInteger.TEN);//the number of factorials divided by ten (delete the last digit)

       }
      System.out.println(sum);
    }


    public static BigInteger factorial(BigInteger n) //Recursive search for the number of factorial
    {
        BigInteger fac = BigInteger.ONE;

        if(n.equals(fac)) return fac;

        return n.multiply(factorial(n.subtract(fac)));

    }
}
