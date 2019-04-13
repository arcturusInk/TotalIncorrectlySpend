import com.opencsv.*;
import java.io.*;

public class FindTotalSumInAIQ {

    public static void main(String[] args){
        try {
            //Reading in csv file with the help of opencsv library
            int sumAIQ = 0, sumJohn = 0, sumUF4 = 0;
            CSVReader readerAIQ = new CSVReader(new FileReader("AIQ-user-summary.csv"));
            CSVReader readerJohn = new CSVReader(new FileReader("Johnny-user-summary.csv"));
            CSVReader readerUpdatedFrom4 = new CSVReader(new FileReader("updatedFrom4.csv"));
            String[] nextLineJohn = readerJohn.readNext(); String[] nextLineAIQ = readerAIQ.readNext();
            String[] nextLineUF4 = readerUpdatedFrom4.readNext();

        while ((nextLineAIQ = readerAIQ.readNext()) != null && (nextLineJohn = readerJohn.readNext()) != null
                && (nextLineUF4 = readerUpdatedFrom4.readNext()) != null ) {
            sumAIQ += Integer.parseInt(nextLineAIQ[1]);
            sumJohn += Integer.parseInt(nextLineJohn[1]);
            sumUF4 += Integer.parseInt(nextLineUF4[1]);
        }
        System.out.println("Sum of AIQ: " + sumAIQ);
        System.out.println("Sum of Johnny: " + sumJohn);
        System.out.println("Sum of the file I had created: " + sumUF4);
        }catch(Exception e){
            System.out.print(e);
        }

    }
}
