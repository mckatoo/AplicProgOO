package app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        List<Naipes> naipesList = new ArrayList<Naipes>(EnumSet.allOf(Naipes.class));
        List<Cartas> cartasList = new ArrayList<Cartas>(EnumSet.allOf(Cartas.class));
        List<String> cartas = new ArrayList<>();

        System.out.println("============ EM SEQUENCIA NÚMERICA POR NAIPE ============");
        for (int i = 0; i < 13; i++) {
            for (int u = 0; u < 4; u++) {
                cartas.add(cartasList.get(i).name() + " de " + naipesList.get(u).name());
                System.out.print(cartasList.get(i).name());
                System.out.println(" de " + naipesList.get(u).name());
            }
        }

        System.out.println("============ EMBARALHADO ============");
        Collections.shuffle(cartas);
        for (String carta : cartas) {
            System.out.println(carta);
        }
    }
}