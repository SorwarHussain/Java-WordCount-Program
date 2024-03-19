import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

class HelloWorld {
    public static void main(String[] args) {
        //Give the path of the text file
        String fileName = "/home/username/Qtec/input.txt";
        Map<String, Integer> wordCountMap = new TreeMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
            String[] sentences = line.split("\\.");
                for (String sentence : sentences) {
                   Set<String> uniqueWords = new HashSet<>();
                   String[] words = sentence.trim().split("\\s+");
                   for (String word : words) {
                       word = word.replaceAll("[^a-zA-Z]", "");
                       word = word.toLowerCase();
                       if (!word.isEmpty()) {
                           uniqueWords.add(word);
                       }
                   }
                   for (String uniqueWord : uniqueWords) {
                       wordCountMap.put(uniqueWord, wordCountMap.getOrDefault(uniqueWord, 0) + 1);
                   }
               }
            }
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
            System.exit(1);
        }
        for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
