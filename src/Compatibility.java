import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Compatibility {
    static List goodCompatibleSectors = new ArrayList();
    static List normalCompatibleSectors = new ArrayList();
    static List totalCompatibleSectors = new ArrayList();
    static int goodCompatibleArea = 0;
    static int normalCompatibleArea = 0;
    static int totalCompatibleArea = 0;
    static int uncompatibleArea = 0;

    static public void resetVariables() {
        goodCompatibleSectors.clear();
        normalCompatibleSectors.clear();
        totalCompatibleSectors.clear();
        goodCompatibleArea = 0;
        normalCompatibleArea = 0;
        totalCompatibleArea = 0;
        uncompatibleArea = 0;
    }

    static public void checkCompatibility(String wishfulCulture, String[] lastYearPlantings, int[] sectorsArea) throws IOException {
        String compatibility[] = FileReaderController.readCompatibility(wishfulCulture, lastYearPlantings);
        for (int i = 0; i < lastYearPlantings.length; i++) {
            switch (compatibility[i]) {
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
            }
        }

    static public void showCompatibilityInfo(String wishfulCulture){
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
