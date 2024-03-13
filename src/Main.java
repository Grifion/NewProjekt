import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please wright number of guests: ");
        int guests = scanner.nextInt();
        System.out.print("Please wright number of Games: ");
        int games = scanner.nextInt();
        Simulate simulate = new Simulate(guests, games);

        System.out.printf("""
                Każdy z gości gra niezależnie i eksploruje wszystkie maszyny, ale jest przyciągany do:
                (a) własnego najlepszego wyniku, tj. maszyny, dla której do tej pory uzyskał najwyższą empiryczną średnią;
                (b) najlepszego wyniku całej hordy, tj. maszyny, która do tej pory miała globalnie najwyższą średnią empiryczną.%n""");
        if (scanner.hasNext("a")){
            simulate.ModeA();
        } else if (scanner.hasNext("b")) {
            simulate.ModeB();
        }
        Machine.print();
    }
}