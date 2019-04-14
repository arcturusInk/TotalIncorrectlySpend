import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class FindDifference {
    public static void main(String[] args){
        try{
            //Reading in csv file with the help of opencsv library
            CSVReader fileHandlerAIQ = new CSVReader(new FileReader("AIQ-user-summary.csv"));
            CSVReader fileHandlerMine = new CSVReader(new FileReader("updatedFrom4.csv"));
            String[] nextLineAIQ = fileHandlerAIQ.readNext();
            String[] nextLineMine = fileHandlerMine.readNext();

            // create FileWriter object with file as parameter
            FileWriter outputFile = new FileWriter(new File("C:/Users/Swati/Documents/Java/ActionIQ/differentRows.csv"));
            // create CSVWriter object filewriter object as parameter
            CSVWriter writer = new CSVWriter(outputFile);

            // adding header to csv
            String[] header = {"user_id","Total_spend_correctly_updated" ,"count_saved_items_correctly_updated" ,"loyalty_credits_correctly_updated", "batch_id_correctly_updated",
            "", "Total_spend_incorrectly_updated", "count_saved_items_correctly_updated", "loyalty_credits_incorrectly_updated", "batch_id_incorrectly_updated"};
            writer.writeNext(header);

            // add data to csv

            while ((nextLineAIQ = fileHandlerAIQ.readNext()) != null && (nextLineMine = fileHandlerMine.readNext()) != null){
                if(nextLineAIQ[0].equals(nextLineMine[0]) && !nextLineAIQ[4].equals(nextLineMine[4])){
                    String[] data = {nextLineMine[0], nextLineMine[1], nextLineMine[2], nextLineMine[3], nextLineMine[4], "",
                            nextLineAIQ[1], nextLineAIQ[2], nextLineAIQ[3], nextLineAIQ[4]};
                    writer.writeNext(data);
                }
            }
            // closing writer connection
            writer.close();
        }catch(Exception e){
            System.out.print(e);
        }
    }
}
