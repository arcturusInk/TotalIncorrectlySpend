import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class UpdatedFrom4 {
    public static void main(String[] args){
        try{
            //Reading in csv file with the help of opencsv library
            CSVReader fileHandler3 = new CSVReader(new FileReader("updatedFrom3.csv"));
            CSVReader fileHandler4 = new CSVReader(new FileReader("delta4.csv"));
            String[] nextLine3 = fileHandler3.readNext();
            String[] nextLine4 = fileHandler4.readNext();

            // create FileWriter object with file as parameter
            FileWriter outputFile = new FileWriter(new File("C:/Users/Swati/Documents/Java/ActionIQ/updatedFrom4.csv"));
            // create CSVWriter object filewriter object as parameter
            CSVWriter writer = new CSVWriter(outputFile);

            // adding header to csv
            String[] header = {nextLine3[0], nextLine3[1], nextLine3[2], nextLine3[3], nextLine3[4]};
            writer.writeNext(header);

            // add data to csv

            while ((nextLine4 = fileHandler4.readNext()) != null) {
                while ((nextLine3 = fileHandler3.readNext()) != null) {
                    if (nextLine3[0].equals(nextLine4[0]) && Integer.parseInt(nextLine4[4]) > Integer.parseInt(nextLine3[4])) {
                        String[] data = {nextLine4[0], nextLine4[1], nextLine4[2], nextLine4[3], nextLine4[4]};
                        writer.writeNext(data);
                        break;
                    } else {
                        String[] data = {nextLine3[0], nextLine3[1], nextLine3[2], nextLine3[3], nextLine3[4]};
                        writer.writeNext(data);
                    }
                }
            }
            // closing writer connection
            writer.close();
        }catch(Exception e){
            System.out.print(e);
        }
    }
}
