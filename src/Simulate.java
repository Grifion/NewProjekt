public class Simulate {
    static int guestCount;
    static int gamesCount;

    public Simulate(int guests, int games) {
        guestCount = guests;
        gamesCount = games;

        // add generate machines
        for (int i = 0; i < Machine.count; i++) {
            Machine machine = new Machine();
            Machine.machineList.add(machine);
        }
        // generate guest
        for (int i = 0; i < guestCount; i++) {
            Guest guest = new Guest();
            Guest.guestList.add(guest);
        }
    }


    // losowo wybierana maszyna, przyciągana do najlepszej
    private int getindexCloseBest(){
        int indexOfBest = Machine.getBestMachine();
        return RndNumb.generateWithWidth(indexOfBest, Machine.count /4, 0, Machine.count);

    }
    private int getindexClose(){
        Guest guest = new Guest();
        // generacja numera maszyny
        int indexOfBest = guest.getMacmhine();
        return RndNumb.generateWithWidth(indexOfBest, Machine.count /4, 0, Machine.count);

    }

    public void ModeB() {
        for (int i = 0; i < guestCount; i++) {
            for (int j = 0; j < gamesCount; j++) {
                if (j < 1){
                    // losowe wybieranie pierwszej maszyny do gry
                    int machineIndex = Guest.getrndMachine();
                    Machine machines = Machine.machineList.get(machineIndex);
                    machines.simulate(machineIndex);
                }else {
                    // wybieranie maszyny w zależności od ilości wygrań na mszynie
                    Machine machine = Machine.machineList.get(getindexCloseBest());
                    machine.simulate(getindexCloseBest());
                }
            }
        }
    }
    public void ModeA() {
        for (int i = 0; i < guestCount; i++) {
            for (int j = 0; j < gamesCount; j++) {
                if (j < 1){
                    // losowe wybieranie pierwszej maszyny do gry
                    int machineIndex = Guest.getrndMachine();
                    Machine machine = Machine.machineList.get(machineIndex);
                    Guest guest = new Guest();
                    boolean win = machine.simulate(machineIndex);
                    guest.addToHistory(machineIndex, win);
                }else {
                    // wybieranie maszyny w zależności od ilości wygrań gościa na maszynie
                    int best = getindexClose();
                    Machine machine = Machine.machineList.get(best);
                    boolean win = machine.simulate(best);
                    Guest guest = new Guest();
                    guest.addToHistory(best, win);
                }
            }
        }
    }
}
