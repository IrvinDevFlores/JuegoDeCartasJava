import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.IntStream;

public class Pruba
{
    public static void main(String args[])
    {
        Tablero tablero = new Tablero();

    }

    class Customer
    {
        void SearchCustomer(Customer customer)
        {
            //Should be 5 lines of code

        }

        void removeOrders(){}

        boolean isPrime(int number)
        {
            int limiteDePrimo = 2;
            return number > 1 &&
                    IntStream.range(limiteDePrimo,number)
                    .noneMatch(index -> number % index == 0);
        }
    }


}
