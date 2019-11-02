import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class DuplicateRemover {
    private ArrayList<String> uniqueWords;

    public DuplicateRemover() {
        uniqueWords = new ArrayList<String>();
    }
    // try catch implemented as shown in class Thursday
    public void remove(String dataFile) {
        try {
            FileReader read = new FileReader(dataFile);
            Scanner scan = new Scanner(read);
            Set<String> remover = new HashSet<String>();
            while (scan.hasNext()) {
                remover.add(scan.next());
            }
            for (String s : remover) {
                uniqueWords.add(s);
            }
            scan.close();
            read.close();
        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }

    public void write(String outputFile) {
        File test = new File(outputFile);
        try {
            test.createNewFile();
            FileWriter writer = new FileWriter(test, false);
            for (String current : uniqueWords) {
                writer.write(current);
                writer.write("\n");
            }
            test = null;
            writer.close();
        } catch(IOException ex) {
            ex.printStackTrace();
        }


    }

}
