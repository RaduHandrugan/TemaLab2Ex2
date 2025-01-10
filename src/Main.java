/*
2. Fișierul cantec_in.txt conține versurile unui cântec la alegere. Să se scrie un
program care creează fișierul cantec_out.txt, care conține versurile cântecului original dar în
plus în dreptul fiecărui rând sunt afișate numărul de cuvinte de pe rând şi numărul de vocale
de pe fiecare rând. În dreptul rândurilor care se încheie cu o grupare de litere aleasă se va
pune o steluță (*). Rândurile pentru care un număr generat aleator este mai mic decât 0.1 vor
fi scrise cu majuscule (se vor genera aleator numere între 0 şi 1).
Se va defini o clasă Vers, care are o variabilă membră privată un șir de caractere
reprezentând versul și se va dezvolta câte un operator pentru fiecare cerință de mai sus (o
metodă care returnează numărul de cuvinte, o metodă care returnează numărul de vocale, etc).
Se va crea un vector de obiecte de tip Vers care va conține informația preluată din fișierul de
intrare.
 */

import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        String inputFile = "E:\\Java\\Proiecte\\Tema Lab 2 - Ex2\\src\\cantec_in.txt";
        String outputFile = "cantec_out.txt";

        String grupareLitere = "la";    //am ales gruparea "la" . unde aceasta se afla la sf de rand va fi pusa *

        Random random = new Random();

        try   //citire fisier + eroare la citire
        {
            List<Vers> versuri = new ArrayList<>();
            try (BufferedReader br = new BufferedReader(new FileReader(inputFile)))
            {
                String line;
                while ((line = br.readLine()) != null)
                {
                    versuri.add(new Vers(line));
                }
            }

            //scriere in fisier
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile)))
            {
                for (Vers vers : versuri)
                {
                    int numarCuvinte = vers.getNumarCuvinte();
                    int numarVocale = vers.getNumarVocale();

                    boolean areStea = vers.terminare(grupareLitere);   // verificare daca versul e terminat in gruparea mentionata

                    if (random.nextDouble() < 0.1)    //transf. majuscule daca nr generat e mai mic 0.1
                    {
                        vers.transformaInMajuscule();
                    }

                    String outputLine = vers.getText() + " Nr. de cuvinte in vers: " + numarCuvinte + " Nr de vocale in vers: " + numarVocale;
                    if (areStea)
                    {
                        outputLine += " *";
                    }

                    bw.write(outputLine);

                    bw.newLine();
                }
            }

            System.out.println("Fisier creat cu succes! " + outputFile);
        } catch (IOException e)
        {
            System.out.println("Eroare la fisier!" + e.getMessage());
        }
    }
}
