import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int sectorsAmount = Main.getSectorsAmount();
        int[] sectorsArea = Main.getSectorsArea(sectorsAmount);
        Main.getFieldArea(sectorsAmount, sectorsArea);
        String[] lastYearPlantings = Main.getLastYearPlantings(sectorsAmount);
        String wishfulCulture = getWishfulCulture();
        switch(wishfulCulture){
                        case("Pea"):
                            Culture.setPeaCompatibilities();
                            break;
                        case("Wild Strawberry"):
                            Culture.setWildStrawberryCompatibility();
                            break;
                        case("Cabbage"):
                            Culture.setCabbageCompatibilities();
                            break;
                        case("Potatoes"):
                            Culture.setPotatoesCompatibilities();
                            break;
                        case("Kohlrabi"):
                            Culture.setKohlrabiCompatibilities();
                            break;
                        case("Corn"):
                            Culture.setCornCompatibilities();
                            break;
                        case("Onion"):
                            Culture.setOnionCompatibilities();
                            break;
                        case("Leek"):
                            Culture.setLeekCompatibilities();
                            break;
                        case("Carrot"):
                            Culture.setCarrotCompatibilities();
                            break;
                        case("Cucumber"):
                            Culture.setCucumberCompatibilities();
                            break;
                        case("Parsnip"):
                            Culture.setParsnipCompatibilities();
                            break;
                        case("Tomato"):
                            Culture.setTomatoCompatibilities();
                            break;
                        case("Radish"):
                            Culture.setRadishCompatibilities();
                            break;
                        case("Lettuce"):
                            Culture.setLettuceCompatibilities();
                            break;
                        case("Beet"):
                            Culture.setBeetCompatibilities();
                            break;
                        case("Celery"):
                            Culture.setCeleryCompatibilities();
                            break;
                        case("Dill"):
                            Culture.setDillCompatibilities();
                            break;
                        case("Beans"):
                            Culture.setBeansCompatibilities();
                            break;
                        case("Garlic"):
                            Culture.setGarlicCompatibilities();
                            break;
                        case("Spinach"):
                            Culture.setSpinachCompatibilities();
                            break;
                        default:
                            System.out.println("You entered wrong wishful culture name, please restart program.");
                            System.exit(0);
                }
        Culture.checkCompatibleArea(lastYearPlantings, wishfulCulture, sectorsAmount, sectorsArea);
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

    private static String[] getLastYearPlantings(int sectorsAmount){
        Scanner input = new Scanner(System.in);

        System.out.println("What were your sectors planted last year? Pick from those listed below:");
        System.out.println("Pea");
        System.out.println("Wild Strawberry");
        System.out.println("Cabbage");
        System.out.println("Potatoes");
        System.out.println("Kohlrabi");
        System.out.println("Corn");
        System.out.println("Onion");
        System.out.println("Leek");
        System.out.println("Carrot");
        System.out.println("Cucumber");
        System.out.println("Parsnip");
        System.out.println("Tomato");
        System.out.println("Radish");
        System.out.println("Lettuce");
        System.out.println("Beet");
        System.out.println("Celery");
        System.out.println("Dill");
        System.out.println("Beans");
        System.out.println("Garlic");
        System.out.println("Spinach");
        System.out.println(" ");

        String[] lastYearPlantings = new String[sectorsAmount];

        for (int i = 0; i < sectorsAmount; i++){
            System.out.print("Sector #" + (i+1));
            lastYearPlantings[i] = input.nextLine();
        }
        return lastYearPlantings;
    }

    private static String getWishfulCulture(){
        Scanner input = new Scanner(System.in);

        System.out.println(" ");
        System.out.println("What culture do you want to plant this year?");

        String wishfulCulture = input.nextLine();
        return wishfulCulture;
    }

}