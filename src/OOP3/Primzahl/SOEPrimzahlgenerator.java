package OOP3.Primzahl;

import java.util.Vector;

/**
 * @author Erik
 *
 * Generiert Primzahlen mit dem Sieb des Erastothenes
 */
public class SOEPrimzahlgenerator extends Primzahlgenerator
{
    private static final int batchSize = 10000;
    /**
     * @author Erik
     *
     * Generiert eine Zufällige Primzahl
     *
     * @return Eine Zufällige Primzahl
     */
    @Override
    public int generierePrimzahl()
    {
        int primeCeil = getRandomPrimeCeiling();
        int divideCeil = (int)(Math.floor(Math.sqrt(primeCeil)));

        Vector<Integer> primes = new Vector<>();

        int batchFloor = 2;
        int batchCeil;

        //Calculate Primes increasing from 3
        boolean gotDivides = false;

        do {
            //Check if Full Batch Ceiling is greater than the square root of our prime Ceiling
            if((batchFloor + batchSize) > divideCeil)
            {
                batchCeil = batchFloor + (divideCeil - batchFloor);
                gotDivides = true;
            }
            else{
                batchCeil = batchFloor + batchSize;
            }
            int size = batchCeil - batchFloor;
            boolean[] batch = new boolean[size];

            //Initialize the Array to true Values
            for(int i = 0; i < size; i++)
            {
                batch[i] = true;
            }

            //Scratch all Numbers in the Array that are divisible by already known Primes
            for(int i : primes)
            {
                for(int n = 0; n < size; n++)
                {
                    if(batch[n] && (batchFloor + n) % i == 0)
                    {
                        batch[n] = false;
                    }

                }
            }

            //Check if we may have Numbers lower in the Array that divide Numbers higher in the Array and if so, scratch them too
            if((int)Math.floor(Math.sqrt(batchCeil)) > batchFloor)
            {
                for(int n = 0; n < size; n++)
                {
                    if(batch[n])
                    {
                        int prim = batchFloor + n;

                        for(int m = n; m < size; m++)
                        {
                            if(batch[m] && (batchFloor + m) % prim == 0)
                            {
                                batch[m] = false;
                            }
                        }
                    }
                }
            }

            //Add all Numbers not scratched to the Prime list
            for(int n = 0; n < size; n++)
            {
                if(batch[n])
                {
                    primes.add(batchFloor + n);
                }
            }

            batchFloor = batchCeil;
        }
        while(!gotDivides);

        //Calculate Primes decreasing from Ceil
        boolean gotPrime = false;
        int prime = 0;
        batchCeil = primeCeil;
        do {
            boolean gotAll = false;

            //Check if Batch Floor of a full batch is smaller than the square root of our prime Ceiling
            if((batchCeil - batchSize) < divideCeil)
            {
                batchFloor = batchCeil - (batchCeil - divideCeil);
                gotAll = true;
            }
            else {
                batchFloor = batchCeil - batchSize;
            }
            int size = batchCeil - batchFloor;

            boolean[] batch = new boolean[size];

            //Initialize Batch with all true
            for(int i = 0; i < size; i++)
            {
                batch[i] = false;
            }

            //Scratch Multiples of known primes in batch
            for(int p : primes)
            {
                for(int i = 0; i < size; i++)
                {
                    if(batch[i] && (batchFloor + i) % p == 0)
                    {
                        batch[i] = false;
                    }
                }
            }

            //Check if we found a prime
            for(int i = size; i > 0; i--)
            {
                if(batch[i])
                {
                    gotPrime = true;
                    prime = batchFloor + 1;
                }
            }

            //If we computed all numbers from Prime Ceil to Divide Ceil and found no Prime, return the biggest computed prime smaller than divide Ceil
            if(gotAll && !gotPrime)
            {
                prime = primes.lastElement();
                gotPrime = true;
            }

            batchCeil = batchFloor;
        }
        while(!gotPrime);


        return 0;
    }

}
