package homework1;

import java.util.Random;

public class Homework {
    //metoda preluata de pe pagina cursului
    static String createRandomWord(int len, char[] alphabet) {  //metoda care genereaza random un cuv de lungime len
        StringBuilder word = new StringBuilder();               // folosind litere din alphabet
        Random rand = new Random();
        for (int i = 0; i < len; i++) {
            int k = rand.nextInt(alphabet.length);
            word.append(alphabet[k]);
        }
        return word.toString();
    }

    //metoda de validare a argumentelor
    static boolean validareArgumente(String[] args) {
        int n = 0, p = 0;
        int m = args.length - 2;
        if (args.length < 3) {   // se verifica nr de arg ( cel putin 3 trebuie sa fie )
            System.out.println("incomplete arguments!");
            return false;
        }
        // se verifica daca primele 2 arg sunt integer, in caz negativ se arunca o exceptie
        try {
            n = Integer.parseInt(args[0]);
            //System.out.println("n:" + n + " is an integer");

        } catch (Exception e) {
            System.out.println("n:" + n + " is not an integer");
            return false;
        }
        try {
            p = Integer.parseInt(args[1]);
            // System.out.println("p:" + p + " is an integer");

        } catch (Exception e) {
            System.out.println("p: " + p + "is not an integer");
            return false;
        }
        //se verifica daca restul argumentelor sunt litere
        for (int i = 0; i < m; i++) {
            if (!Character.isLetter(args[i + 2].charAt(0))) {
                System.out.println("Character: " + args[i + 2].charAt(0) + " at position: " + (i + 2) + " is not a Letter!! ");
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        long t1 = System.nanoTime();

        if (!validareArgumente(args)) {
            System.out.println("Problems with arguments!! ");
            return;
        }
        System.out.println("Arguments are ok! ");

        int n = Integer.parseInt(args[0]);// nr. de string-uri care se vor genera random cu literele date ca argumente
        int p = Integer.parseInt(args[1]);// nr. care reprezinta lungimea pe care il va avea avea fiecare string generat
        int m = args.length - 2;// nr. de litere date ca argumente

        char[] alphabet = new char[m]; // array de caractere care va pastra cele m litere date ca argumente
        String[] words = new String[n]; //array de string-uri care va memora cele n string-uri generate random cu literele din alphabet, avand exact p litere

        Boolean[][] neighborsAdjacency = new Boolean[n][n];// matrice nxn cu valori booleene , reprezentand adiacenta cuv. generate
        String[][] neighbors = new String[n][];// structura de date care pastreaza vecinii fiecarui cuv.
        int[] nrNeighbors = new int[n];// array de int-uri, reprezentand nr. de vecini al fiecarui cuv. generat
        int[] nrNeighborsCopy = new int[n];

        for (int i = 0; i < m; i++) {    //preluarea literelor date ca argumente
            alphabet[i] = args[i + 2].charAt(0);
        }
        System.out.println("n:" + n + "\np:" + p);
        System.out.println(alphabet);
        System.out.println("......");

        // se genereaza cele n string-uri, prin apelul metodei createRandomWord si se memoreza in words,
        for (int i = 0; i < n; i++) {  // la apel se dau ca parametri:p-lungimea unui cuv si alfabetul care contine literele date ca argumente.
            words[i] = createRandomWord(p, alphabet);
        }
        System.out.print(words[0]);
        for (int i = 1; i < words.length; i++) {
            System.out.print("  " + words[i]);
        }
        System.out.println("\n.............................");
        int nrCharCom = 0;// var. va reprezenta nr. de caractere comune intre doua cuvinte
        char ch = '\0';   // var. va reprezenta primul caracter comun al celor doua cuvinte curente

        for (int i = 0; i < n; i++) {
            neighborsAdjacency[i][i] = false;  // se trateaza diagonala principala
            for (int j = 0; j < i; j++) {    // datorita simetriei, se va parcurge doar sub diagonala principala
                nrCharCom = 0;
                for (int k = 0; k < p && nrCharCom < 2; k++) { //se parcurge cuv. curent,
                    if (words[j].indexOf(words[i].charAt(k)) != -1) {  //daca se gaseste al doilea caracter comun nu are rost sa continuam, deci se opreste parcurgerea
                        nrCharCom++;
                        if (nrCharCom == 1) { //se inlocuieste primul caracter comun in cuv comparat cu '-'
                            ch = words[i].charAt(k);
                            words[j] = words[j].replace(ch, '-');
                        }
                    }
                }
                if (nrCharCom != 0) // se aduce cuv modificat la forma sa initiala
                    words[j] = words[j].replace('-', ch);

                if (nrCharCom == 1) {  // daca s-a gasit exact un caracter comun, atunci cele doua cuv sunt adiacente
                    neighborsAdjacency[i][j] = true;
                    neighborsAdjacency[j][i] = true;
                    nrNeighbors[i] += 1; // se incrementeaza si nr vecinilor celor doua cuv
                    nrNeighbors[j] += 1;
                } else {
                    neighborsAdjacency[i][j] = false;
                    neighborsAdjacency[j][i] = false;
                }
            }
        }
        //se afiseaza matricea de adiacenta
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(neighborsAdjacency[i][j] + " ");
            }
            System.out.println();
        }
        // se face o copie a nr de vecini, folosita pentru afisarea structurii de date
        System.arraycopy(nrNeighbors, 0, nrNeighborsCopy, 0, nrNeighbors.length);

        for (int i = 0; i < n; i++) { // se declara spatiul ocupat in memorie, in functie de nr de vecini
            neighbors[i] = new String[nrNeighbors[i]];
            if (nrNeighbors[i] >= 1)  //daca un cuv are cel putin un vecin
                nrNeighbors[i]--; // se decrementeaza nr, astfel incat sa putem aseza vecinii pe pozitia corespunzatoare in structura
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (neighborsAdjacency[i][j]) {  // se parcurge matricea de adiacenta, iar prentru val de true(pt cuv adiacente)
                    neighbors[i][nrNeighbors[i]] = words[j];  // se intregeste lista de vecini
                    neighbors[j][nrNeighbors[j]] = words[i];
                    if (nrNeighbors[i] >= 1)   // daca cuv mai au cel putin un vecin, se pregateste pozitia urmatorului
                        nrNeighbors[i]--;       // scanzand nr de vecini care au ramas de adaugat
                    if (nrNeighbors[j] >= 1)
                        nrNeighbors[j]--;
                }
            }
        }
        // se afiseaza structura de date
        for (int i = 0; i < n; i++) {
            System.out.print(words[i] + ": ");
            for (int j = 0; j < nrNeighborsCopy[i]; j++) {
                System.out.print(neighbors[i][j] + " ");
            }
            System.out.println();
        }

        long t2 = System.nanoTime();
        System.out.println((t2 - t1));

    }

}


