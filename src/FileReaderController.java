import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class FileReaderController {

    public static String[] readCompatibility(String wishfulCulture, String[] lastYearPlantings) throws IOException {
        String lineValue;
        String compatibility[] = new String[lastYearPlantings.length];
        for (int i = 0; i < lastYearPlantings.length; i++) {
            FileReader fr = new FileReader("src/Compatibilities/" + wishfulCulture + ".txt");
            Scanner scan = new Scanner(fr);
            while(scan.hasNextLine()) {
                lineValue = scan.nextLine().trim();
                if (lineValue.startsWith(lastYearPlantings[i])) {
                    compatibility[i] = scan.nextLine();
                }
            }
            fr.close();
            }
        return compatibility;
        }
    public static void readCultureList() throws IOException {
        FileReader fr = new FileReader("src/CultureList.txt");
        Scanner scan = new Scanner(fr);
//        List cultureList = new ArrayList();
        while(scan.hasNextLine()){
            System.out.println(scan.nextLine());
//            cultureList.add(scan.nextLine());
        }
        fr.close();
//        return cultureList;
    }

}
