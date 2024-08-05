import java.awt.datatransfer.StringSelection;
import java.sql.Array;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        ArrayList<String> teams = new ArrayList<String>();
        Scanner input = new Scanner(System.in);

        System.out.println("Takımları giriniz: ");
        while (true) {
            String inputTeam = input.nextLine();
            if (inputTeam.equalsIgnoreCase("ok")) {
                break;
            }
            teams.add(inputTeam);
        }
        input.close();

        //Liste uzunluğu tek ise "Bay" takımını ekle
        int listeUzunlugu = teams.size();
        int matchPerRound = listeUzunlugu / 2;

        if (listeUzunlugu % 2 != 0) {
            teams.add("Bay");
        }
        //Karıştır
        Collections.shuffle(teams);
        //Toplam maç sayısı
        int numMatch = (listeUzunlugu * (listeUzunlugu - 1));
        //Toplam Round sayısı
        int numRound = numMatch / (matchPerRound);
        
        ArrayList<String> macListes = new ArrayList<String>();

        for(int i=0;i<listeUzunlugu;i++) {

            for(int j=0;j<listeUzunlugu;j++){
                if(i!=j && i<j) {
                    macListes.add( teams.get(i) + " vs " + teams.get(j));

                    macListes.add( teams.get(j) + " vs " + teams.get(i));

                }
            }
        }
        int machNum=0;
        // Takımları döndür
        Collections.rotate(macListes.subList(1, macListes.size()), 1);

        for (int r = 1; r <= numRound; r++) {
            System.out.println(r + ". Round");
            for (int mpr = 1; mpr <= matchPerRound; mpr++) {
                System.out.println(macListes.get(machNum));
                machNum++;
            }
        }



    }


}
