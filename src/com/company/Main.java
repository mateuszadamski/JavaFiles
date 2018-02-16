package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try {
            Scanner sc = new Scanner(new File("dane.txt"));
            PrintWriter pw = new PrintWriter(new File("dane1.txt"));

            String wyrazZliczany = "a";
            char  literaZliczana = 'a';
            int licznikWyrazow = 0;
            int licznikLiter = 0;
            String target = "bbb";
            String replacement = "ddd";
            String lineToRemove = "dac";

            while (sc.hasNext()) {
                String wyraz = sc.next();
                wyraz=wyraz.replace(target,replacement);
                if (!wyraz.trim().equals(lineToRemove)) {
                    pw.println(wyraz);

                }
                if(wyraz.equals(wyrazZliczany)){
                    licznikWyrazow++;
                }
                char[] znakArr = wyraz.toCharArray();
                for(int i=0;i<znakArr.length;i++){
                    if(znakArr[i]==literaZliczana){
                        licznikLiter++;
                    }
                }
               System.out.println(znakArr);
            }
            System.out.println("ilosc slow "+wyrazZliczany+ " w pliku = "+licznikWyrazow);
            System.out.println();
            System.out.println("ilosc liter "+literaZliczana+ " w pliku = "+licznikLiter);

            /*while (sc.hasNext()) {
                String wyraz = sc.next();
                if (!wyraz.trim().equals(lineToRemove)) {
                    pw.println(wyraz);
                    pw.flush();
                }
            }*/

            pw.flush();

            sc.close();
            pw.close();

        } catch (FileNotFoundException ex) {
            System.out.println("Problem z plikiem");
        }


    }
}
