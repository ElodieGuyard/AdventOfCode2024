/*Maybe the lists are only off by a small amount! To find out, pair up the numbers and measure how far apart they are. Pair up the smallest number in the left list with the smallest number in the right list, then the second-smallest left number with the second-smallest right number, and so on.

Within each pair, figure out how far apart the two numbers are; you'll need to add up all of those distances. For example, if you pair up a 3 from the left list with a 7 from the right list, the distance apart is 4; if you pair up a 9 with a 3, the distance apart is 6.

In the example list above, the pairs and distances would be as follows:

The smallest number in the left list is 1, and the smallest number in the right list is 3. The distance between them is 2.
The second-smallest number in the left list is 2, and the second-smallest number in the right list is another 3. The distance between them is 1.
The third-smallest number in both lists is 3, so the distance between them is 0.
The next numbers to pair up are 3 and 4, a distance of 1.
The fifth-smallest numbers in each list are 3 and 5, a distance of 2.
Finally, the largest number in the left list is 4, while the largest number in the right list is 9; these are a distance 5 apart.

To find the total distance between the left list and the right list, add up the distances between all of the pairs you found. In the example above, this is 2 + 1 + 0 + 1 + 2 + 5, a total distance of 11!

Your actual left and right lists contain many location IDs. What is the total distance between your lists?*/

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        String pathFile = "src/main/resources/input.txt";
        List<Integer> leftClmNumbers = new ArrayList();
        List<Integer> rightClmNumbers = new ArrayList();
        List<Integer> subNumbers = new ArrayList();
        Integer sumNumbers = 0;

        List<String> linePerLine = readTheFile(pathFile); //lire le fichier et le mettre dans une liste
        parseOurDatas(linePerLine, leftClmNumbers, rightClmNumbers);
        sortMyList(leftClmNumbers, rightClmNumbers);
        substractIds(leftClmNumbers, rightClmNumbers, subNumbers);
        sumDistances(subNumbers, sumNumbers);
        similaryScore(leftClmNumbers,rightClmNumbers);

    }

    public static List<String> readTheFile(String pathFile) throws IOException {

        try {
            Path path = Paths.get(pathFile);
            Stream<String> streamWithCharset = Files.lines(path, Charset.forName("UTF-8")); //Précise l'encodage
            List <String> linePerLine = streamWithCharset.toList();
            //System.out.println(linePerLine);
            return linePerLine;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void parseOurDatas(List<String> linePerLine, List<Integer> leftClmNumbers, List<Integer> rightClmNumbers){

        for (String iterationLine : linePerLine) {
            String[] words = iterationLine.split(" {3}"); //Regex 3 fois espaces
            //words =["18102","93258"]
            leftClmNumbers.add(Integer.valueOf(words[0]));
            rightClmNumbers.add(Integer.valueOf(words[1]));
            //System.out.println(leftClmNumbers.getLast() + " " + rightClmNumbers.getLast());
        }
    }

    public static void sortMyList(List<Integer> leftClmNumbers, List<Integer> rightClmNumbers){
        Collections.sort(leftClmNumbers);
        Collections.sort(rightClmNumbers);
        System.out.println(leftClmNumbers + " \n" + rightClmNumbers);
    }

    public static void substractIds(List<Integer> leftClmNumbers, List<Integer> rightClmNumbers, List<Integer> subNumbers){
        int TAILLE_DES_LISTES = leftClmNumbers.size();
        for (int i = 0; i < TAILLE_DES_LISTES; i++) {
            if (leftClmNumbers.get(i) > rightClmNumbers.get(i)){
                subNumbers.add(leftClmNumbers.get(i)-rightClmNumbers.get(i));
            } else {
                subNumbers.add(rightClmNumbers.get(i)-leftClmNumbers.get(i));
            }
        }
        System.out.println(subNumbers);
    }

    public static void sumDistances(List<Integer> subNumbers, Integer sumNumbers){
        for (int i = 0; i < subNumbers.size(); i++) {
            sumNumbers += subNumbers.get(i);
        }
        System.out.println("My puzzle answer is : " + sumNumbers);
    }

    public static void similaryScore(List<Integer> leftClmNumbers, List<Integer> rightClmNumbers) {
        Integer currentNumber = 0;
        Integer currentOccurence = 0;
        Integer similarityScore = 0;

        for (int i = 0; i < rightClmNumbers.size(); i++) {
            currentNumber = leftClmNumbers.get(i);
            currentOccurence = Collections.frequency(rightClmNumbers, currentNumber);
            similarityScore += (currentNumber * currentOccurence);
            System.out.println(leftClmNumbers.get(i) + " " + Collections.frequency(rightClmNumbers, currentNumber));
        }
        System.out.println("Le score de similaritude est de : " + similarityScore);
    }
}