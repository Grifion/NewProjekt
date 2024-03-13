import java.util.ArrayList;
import java.util.List;

public class Machine {
    /* klasa machine zawiera w sobie dla każdej maszyny:
        1. ilość geir
        2. ilość winów

        klasa machine zawiera w sobie:
        1. ilość maszyn
        2. metode do generowania szansy wygranej
     */
    private int gamesCount;
    private int winsCount;

    public final static int count = 100; // ilość maszyn do gry
    public static List<Machine> machineList  = new ArrayList<>();

    public boolean simulate(int machineIndex) {
        // genegowanie chansu wyniku

        int rndnumb = RndNumb.generate(0, machineIndex);
        int rndnumb2 = RndNumb.generate(0, machineIndex);


        boolean win = rndnumb > rndnumb2;
        // zwiększenie czysla winówn jeżeli wygrano
        if (win){winsCount++;}
        // zwiększenie czysla geir
        gamesCount++;
        return win;
    }
    public static int getBestMachine() {
        int indexOfBest = 0;
        for (int i = 0; i < count; i++) {
            if (machineList.get(i).winsCount > machineList.get(indexOfBest).winsCount){
                indexOfBest = i;
            }
        }
        return indexOfBest;
    }

    public static void print () {
        for (int i = 0; i < count; i+=10 ) {
            Machine machine = machineList.get(i);
            System.out.println("Id: " + i + "; Games: " + machine.gamesCount + "; Wins: " + machine.winsCount);
        }
    }
}