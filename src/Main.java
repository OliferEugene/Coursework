import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        int programIsOn = 1;
        System.out.println("====================Decision support system for planning crop rotation==================== \n" +
                           "===Follow the hints at the command line so that the system helps you plan crop rotation===");
        int sectorsAmount = Main.getSectorsAmount();
        int[] sectorsArea = Main.getSectorsArea(sectorsAmount);
        Main.getFieldArea(sectorsAmount, sectorsArea);
        String[] lastYearPlantings = Main.getLastYearPlantings(sectorsAmount);
        while(programIsOn == 1) {
            String wishfulCulture = getWishfulCulture().trim();
            Compatibility.checkCompatibility(wishfulCulture, lastYearPlantings, sectorsArea);
            Compatibility.showCompatibilityInfo(wishfulCulture);

            Scanner input = new Scanner(System.in);

            System.out.println("Do you want to change wishful culture? (1 - yes/2 - no)");
            programIsOn = input.nextInt();
            if(programIsOn == 1){
                Compatibility.resetVariables();
            }
        }
    }

    private static int getSectorsAmount() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter amount of sectors: ");
        int sectorsAmount = input.nextInt();
        return sectorsAmount;
    }
    private static int[] getSectorsArea(int sectorsAmount) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter areas of sectors in square metres:");

        int[] sectorsArea = new int[sectorsAmount];
        for (int i = 0; i < sectorsAmount; i++){
            System.out.print("Enter the area of sector #" + (i + 1) + ": ");
            sectorsArea[i] = input.nextInt();
        }
        return sectorsArea;
    }
    private static int getFieldArea(int sectorsAmount, int[] sectorsArea) {
        int fieldArea = 0;
        for (int i = 0; i < sectorsAmount; i++) {
            fieldArea += sectorsArea[i];
        }
        System.out.println("Total field area is " + fieldArea + " square meters.");
        System.out.println(" ");
        return fieldArea;
    }
    private static String[] getLastYearPlantings(int sectorsAmount) throws IOException {
        Scanner input = new Scanner(System.in);

        System.out.println("What were your sectors planted with last year? Pick from those listed below:\n");

        FileReaderController.readCultureList();

        System.out.println(" ");
        String[] lastYearPlantings = new String[sectorsAmount];

        for (int i = 0; i < sectorsAmount; i++){
            System.out.print("Sector #" + (i+1) + " ");
            lastYearPlantings[i] = input.nextLine();
        }
        return lastYearPlantings;
    }
    private static String getWishfulCulture(){
        Scanner input = new Scanner(System.in);

        System.out.println(" ");
        System.out.println("What culture do you want to plant this year?");
        String wishfulCulture = input.nextLine().trim();
        return wishfulCulture;
    }
}