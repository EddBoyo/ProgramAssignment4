import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


public class DuplicateCounter {
    private ArrayList<Integer> wordCounter;
    private ArrayList<String> words;

    public DuplicateCounter() {
        wordCounter = new ArrayList<Integer>();
        words = new ArrayList<String>();
    }
    // try catch implemented as shown in class Thursday
    public void count(String dataFile) {
        try {
            FileReader read = new FileReader(dataFile);
            Scanner scan = new Scanner(read);
            HashMap<String, Integer> counter = new HashMap<String, Integer>();
            Set<String> holdUnique = new HashSet<String>();
            while (scan.hasNext()){
                String current = scan.next();
                holdUnique.add(current);
                if (counter.containsKey(current)) {
                    counter.put(current, (counter.get(current) + 1));
                }
                else {
                    counter.put(current, 1);
                }
            }
            for(String s: holdUnique)  {
                wordCounter.add(counter.get(s));
                words.add(s);
            }
            scan.close();
            read.close();
        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }

    public void write(String outputFile) {
        try {
            File test = new File(outputFile);
            test.createNewFile();
            FileWriter writer = new FileWriter(outputFile, false);
            for (int i = 0; i < wordCounter.size(); i++) {
                writer.write(words.get(i));
                writer.write(": ");
                String current = Integer.toString(wordCounter.get(i));
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
