import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Compatibility {

   static public void checkCompatibility(String wishfulCulture, String[] lastYearPlantings, int[] sectorsArea) throws IOException {
        String lineValue;
        String compatibility = " ";

        List goodCompatibleSectors = new ArrayList();
        List normalCompatibleSectors = new ArrayList();
        List totalCompatibleSectors = new ArrayList();
        int goodCompatibleArea = 0;
        int normalCompatibleArea = 0;
        int totalCompatibleArea = 0;
        int uncompatibleArea = 0;

        for (int i = 0; i < lastYearPlantings.length; i++) {
            FileReader fr = new FileReader("src/Compatibilities/" + wishfulCulture + ".txt");
            Scanner scan = new Scanner(fr);
            while(scan.hasNextLine()) {
                lineValue = scan.nextLine().trim();
                if (lineValue.startsWith(lastYearPlantings[i])) {
                    compatibility = scan.nextLine();
                }
            }
                    switch (compatibility) {
                        case ("0"):
                            uncompatibleArea += sectorsArea[i];
                            break;
                        case ("1"):
                            normalCompatibleSectors.add(i + 1);
                            totalCompatibleSectors.add(i + 1);
                            normalCompatibleArea += sectorsArea[i];
                            totalCompatibleArea += sectorsArea[i];
                            break;
                        case ("2"):
                            goodCompatibleSectors.add(i + 1);
                            totalCompatibleSectors.add(i + 1);
                            goodCompatibleArea += sectorsArea[i];
                            totalCompatibleArea += sectorsArea[i];
                        default:
                            break;
                }
            fr.close();
        }
        if (goodCompatibleSectors.size() != 0) {
            System.out.println(" ");
            System.out.println("Good compatible sectors for " + wishfulCulture + " planting is:");
            for (int i = 0; i < goodCompatibleSectors.size(); i++) {
                if (i == (goodCompatibleSectors.size() - 1)) {
                    System.out.print(goodCompatibleSectors.get(i) + ". ");
                } else {
                    System.out.print(goodCompatibleSectors.get(i) + ", ");
                }
            }
        }
        if (normalCompatibleSectors.size() != 0) {
            System.out.println(" ");
            System.out.println("Normal compatible sectors for " + wishfulCulture + " planting is:");
            for (int i = 0; i < normalCompatibleSectors.size(); i++) {
                if (i == (normalCompatibleSectors.size() - 1)) {
                    System.out.print(normalCompatibleSectors.get(i) + ". ");
                } else {
                    System.out.print(normalCompatibleSectors.get(i) + ", ");
                }
            }
        }
        if (totalCompatibleSectors.size() != 0) {
            System.out.println(" ");
            System.out.println("Total compatible sectors for " + wishfulCulture + " planting is:");
            for (int i = 0; i < totalCompatibleSectors.size(); i++) {
                if (i == (totalCompatibleSectors.size() - 1)) {
                    System.out.print(totalCompatibleSectors.get(i) + ". ");
                } else {
                    System.out.print(totalCompatibleSectors.get(i) + ", ");
                }
            }
        }
        if (goodCompatibleArea != 0) {
            System.out.println(" ");
            System.out.println("Good compatible area: " + goodCompatibleArea);
        }
        if (normalCompatibleArea != 0) {
            System.out.println(" ");
            System.out.println("Normal compatible area: " + normalCompatibleArea);
        }
        System.out.println(" ");
        System.out.println("Total compatible area: " + totalCompatibleArea);
        System.out.println(" ");
        System.out.println("Not compatible area: " + uncompatibleArea);
    }

}
