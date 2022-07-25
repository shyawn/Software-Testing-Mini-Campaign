import java.io.*;
import java.util.*;


public class Compare {
    public static Record makeRecord(String filename){
        try {
            File file = new File(filename);
            Scanner sc = new Scanner(file);
            Record record = new Record(sc.nextLine());
            while (sc.hasNextLine()){
                String data = sc.nextLine();
                record.addEntry(data);
            }
            sc.close();
            return record;
        } catch (FileNotFoundException e){
            System.out.println("Error");
            return null;
        }
    }

    public static void writeMismatch(String filename, String mismatch){
        try {
            FileWriter writer = new FileWriter(filename);
            writer.write(mismatch);
            writer.close();
        } catch (IOException e){
            System.out.println("Error");
        }
    }

    public static void main(String[] args) throws Exception {
        Record record_1 = makeRecord("src\\sample_file_1.csv");
        Record record_3 = makeRecord("src\\sample_file_3.csv");
        String mismatch = record_1.compareRecord(record_3);
        writeMismatch("output.txt", mismatch);
    }
}

