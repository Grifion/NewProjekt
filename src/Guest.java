import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Guest {
    private int indexOfLMachine;
    public static List<Guest> guestList = new ArrayList<Guest>();

    private int[] arrayOfWins = new int[Machine.count];


    public static int getrndMachine (){
        Random rnd = new Random();
        return (int) ((Machine.count) * rnd.nextDouble());
    }
    public void addToHistory (int machineNumber, boolean win){
        if (win){
            arrayOfWins[machineNumber]++;
        }
    }
    public int getMacmhine (){
        int bestMachine = 0;
        for (int i = 0; i < Machine.count; i++) {
            if (bestMachine < arrayOfWins[i]){
                bestMachine = i;
            }
        }
        return bestMachine;
    }
}
