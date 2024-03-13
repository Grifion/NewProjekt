import java.util.Random;

public class RndNumb {
    private static Random random;


    public static int generate(double mean, int standardDeviation) {
        random = new Random();
        // Generowanie liczby z rozkładu normalnego
        double u1 = 1.0 - random.nextDouble(); // Zapobiega logarytmowi z 0
        double u2 = random.nextDouble();
        double z0 = Math.sqrt(-2.0 * Math.log(u1)) * Math.cos(2.0 * Math.PI * u2);

        // Przybliżanie do zadanej średniej i odchylenia standardowego
        return (int) (z0 * standardDeviation + mean);
    }
    public static int  generateWithWidth(double mean, int standardDeviation, double lowerBound, double upperBound) {

        double randomNumber;
        do {
            // Używamy metody nextGaussian() klasy Random, a następnie dostosowujemy do przedziału
            randomNumber = random.nextGaussian() * standardDeviation + mean;
        } while (randomNumber < lowerBound || randomNumber > upperBound);  // Sprawdzamy i ponawiamy generację, jeśli liczba jest poza przedziałem

        return(int) randomNumber;
    }

}
