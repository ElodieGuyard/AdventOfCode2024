package org.example;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        String pathFile = "src/main/resources/input.txt";
        List<String> linePerLine = readTheFile(pathFile); //lire le fichier et le mettre dans une liste, the exception can come from here
        List<List<Integer>> inputToGO = parserToInteger(linePerLine);
        int compteur = 0;
        for (List<Integer> toGO : inputToGO) {
            if (isSafe(toGO).equals("Safe")) {
                compteur += 1;
            }
        }
        System.out.println(compteur);

        int compteurPart2 = 0;
        for (int i = 0; i < inputToGO.size(); i++) {
            if (howManySafePart2(inputToGO.get(i)).equals("Safe")) {
                compteurPart2 += 1;
            }
        }
        System.out.println(compteurPart2);
    }

    public static List<String> readTheFile(String pathFile) throws IOException {

        try {
            Path path = Paths.get(pathFile);
            Stream<String> streamWithCharset = Files.lines(path, Charset.forName("UTF-8")); //Précise l'encodage
            List<String> linePerLine = streamWithCharset.toList();
            //System.out.println(linePerLine);
            return linePerLine;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<List<Integer>> parserToInteger(List<String> input) {
        List<List<Integer>> parsedOutput = new ArrayList<>();

        for (int i = 0; i < input.size(); i++) {

            List<Integer> intermediateFormatData = new ArrayList<>();

            for (String s : input.get(i).split(" ")) {
                int currentInt = Integer.parseInt(s);
                intermediateFormatData.add(currentInt);
            }
            parsedOutput.add(intermediateFormatData);
        }
        return parsedOutput;
    }

    public static boolean isIncreasing(List<Integer> input) {
        for (int i = 0; i < input.size() - 1; i++) {
            int j = i + 1;
            int numToTest1 = input.get(i);
            int numToTest2 = input.get(j);
            if (numToTest1 >= numToTest2) {
                return false;
            }
        }
        return true;
    }

    public static Boolean isDecreasing(List<Integer> input) {
        for (int i = 0; i < input.size() - 1; i++) {
            int j = i + 1;
            int numToTest1 = input.get(i);
            int numToTest2 = input.get(j);
            if (numToTest1 <= numToTest2) {
                return false;
            }
        }
        return true;
    }

    public static Boolean isDifferingByOne(int inputi, int inputj) {
        Integer numToTest1 = inputi;
        Integer numToTest2 = inputj;
        if (numToTest2 - numToTest1 == 1) {
        } else {
            return false;

        }
        return true;
    }

    public static Boolean isDifferingByTwo(int inputi, int inputj) {
        Integer numToTest1 = inputi;
        Integer numToTest2 = inputj;
        if (numToTest2 - numToTest1 == 2) {
        } else {
            return false;
        }
        return true;
    }

    public static boolean isDifferingByThree(int inputi, int inputj) {
        Integer numToTest1 = inputi;
        Integer numToTest2 = inputj;
        if ((numToTest2 - numToTest1) == 3) {
        } else {
            return false;
        }
        return true;
    }

    public static boolean isIntervalUnSafe(Integer inputi, Integer inputj) {
        return (!isDifferingByOne(inputi, inputj)
                && !isDifferingByTwo(inputi, inputj)
                && !isDifferingByThree(inputi, inputj));
    }

    public static String isSafe(List<Integer> input) {

        if (isIncreasing(input)) {
            for (int i = 0; i < input.size() - 1; i++) {
                int j = i + 1;
                if (isIntervalUnSafe(input.get(i), input.get(j))) {
                    return "Unsafe";
                }
            }
        } else if (isDecreasing(input)) {
            for (int i = 0; i < input.size() - 1; i++) {
                int j = i + 1;
                if (isIntervalUnSafe(input.get(j), input.get(i))) {
                    return "Unsafe";
                }
            }
        } else {
            return "Unsafe";
        }
        return "Safe";
    }

    public static String isSafePart2Increasing(List<Integer> input) {
        if (isSafe(input).equals("Unsafe")) {
            boolean removed = false;
            for (int i = 0; i < input.size() - 1; i++) {
                int j = i + 1;
                int toTest1 = input.get(i);
                int toTest2 = input.get(j);
                if (!(toTest1 < toTest2) && !removed) { //si on a pas déjà removed une entrée, on remove la problèmatique et on rééssaie is increasing
                    input.remove(j);
                    removed = true;
                    i = 0;
                } else if (isIntervalUnSafe(input.get(i), input.get(j))) {
                    return "Unsafe";
                } else if ((toTest1 == toTest2)) {
                    return "Unsafe";
                }
            }
        }
        return "Safe";
    }

    public static String isSafePart2Decreasing(List<Integer> input) {
        if (isSafe(input).equals("Unsafe")) {
            boolean removed = false;
            for (int i = 0; i < input.size() - 1; i++) {
                int j = i + 1;
                if (!(input.get(j) < input.get(i)) && !removed) { //si on a pas déjà removed une entrée, on remove la problèmatique et on rééssaie is increasing
                    input.remove(i);
                    removed = true;
                    i = 0;
                } else if (isIntervalUnSafe(input.get(j), input.get(i))) {
                    return "Unsafe";
                }
            }
        }
        return "Safe";
    }

    public static String howManySafePart2(List<Integer> input) {
        if (isSafePart2Increasing(input).equals("Safe")) {
            return "Safe";
        } else if (isSafePart2Decreasing(input).equals("Safe")) {
            return "Safe";
        } else {
            return "Unsafe";
        }

    }
}