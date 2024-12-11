package org.example;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

class MainTest {

    @Test
    void isContentFileNotNull() throws IOException {
        assertThat(Main.readTheFile("src/main/resources/input.txt"), CoreMatchers.notNullValue());
    }

    @Test
    void TestreadTheFile() throws IOException {
        List<String> expected = Arrays.asList("Success !!");
        assertThat(Main.readTheFile("src/test/java/org/example/Ressource/inputTest.txt"), CoreMatchers.equalTo(expected));
    }

    @Test
    void isCorrectlyParsed() {
        List<String> input = new ArrayList<>(List.of("1 3 2 4 5"));
        List<Integer> tmp =new ArrayList<>(Arrays.asList(1, 3, 2, 4, 5));
        List<List<Integer>> expectedOutput = new ArrayList<>();
        expectedOutput.add(tmp);
        assertThat(Main.parserToInteger(input), CoreMatchers.equalTo(expectedOutput));
    }

    @Test
    void isNumber() {

    }

    @Test
    void isIncreasing() {
        List<Integer> input=Arrays.asList(1, 2, 3);
        assertThat(Main.isIncreasing(input), CoreMatchers.equalTo(true));
        List<Integer> input2 = new ArrayList<>(Arrays.asList(3, 5, 7, 10, 11, 11));
        assertThat(Main.isIncreasing(input2), CoreMatchers.equalTo(false));
        List<Integer> input3 = new ArrayList<>(Arrays.asList(35, 37, 39, 42, 46));
        assertThat(Main.isIncreasing(input3), CoreMatchers.equalTo(true));

    }

    @Test
    void isIncreasingFalse() {
        List<Integer> input=Arrays.asList(3, 2, 1);
        assertThat(Main.isIncreasing(input), CoreMatchers.equalTo(false));
    }

    @Test
    void isDecreasing() {
        List<Integer> input=Arrays.asList(3, 2, 1);
        assertThat(Main.isDecreasing(input),CoreMatchers.equalTo(true));
        List<Integer> input2=Arrays.asList(3, 2, 1, 1);
        assertThat(Main.isDecreasing(input2), CoreMatchers.equalTo(false));
    }

    @Test
    void isDecreasingFalse() {
        List<Integer> input=Arrays.asList(1, 2, 3);
        assertThat(Main.isDecreasing(input), CoreMatchers.equalTo(false));
        List<Integer> input2 = new ArrayList<>(Arrays.asList(35, 37, 39, 42, 46));
        assertThat(Main.isDecreasing(input2), CoreMatchers.equalTo(false));

    }

    @Test
    void isAdjDifferByOne() {
        assertThat(Main.isDifferingByOne(1,2), CoreMatchers.equalTo(true));
        assertThat(Main.isDifferingByOne(3,7), CoreMatchers.equalTo(false));
        assertThat(Main.isDifferingByOne(1,3), CoreMatchers.equalTo(false));
        assertThat(Main.isDifferingByOne(35,37), CoreMatchers.equalTo(false));
        assertThat(Main.isDifferingByOne(37,39), CoreMatchers.equalTo(false));
        assertThat(Main.isDifferingByOne(39,42), CoreMatchers.equalTo(false));
        assertThat(Main.isDifferingByOne(42,46), CoreMatchers.equalTo(false));
    }

    @Test
    void isAdjDifferByTwo() {
        assertThat(Main.isDifferingByTwo(1,3), CoreMatchers.equalTo(true));
        assertThat(Main.isDifferingByTwo(1,2), CoreMatchers.equalTo(false));
        assertThat(Main.isDifferingByTwo(8,5), CoreMatchers.equalTo(false));
        assertThat(Main.isDifferingByTwo(35,37), CoreMatchers.equalTo(true));
        assertThat(Main.isDifferingByTwo(37,39), CoreMatchers.equalTo(true));
        assertThat(Main.isDifferingByTwo(39,42), CoreMatchers.equalTo(false));
        assertThat(Main.isDifferingByTwo(42,46), CoreMatchers.equalTo(false));
    }

    @Test
    void isAdjDifferByThree() {
        assertThat(Main.isDifferingByThree(1,4), CoreMatchers.equalTo(true));
        assertThat(Main.isDifferingByThree(1,2), CoreMatchers.equalTo(false));
        assertThat(Main.isDifferingByThree(1,3), CoreMatchers.equalTo(false));
        assertThat(Main.isDifferingByThree(35,37), CoreMatchers.equalTo(false));
        assertThat(Main.isDifferingByThree(37,39), CoreMatchers.equalTo(false));
        assertThat(Main.isDifferingByThree(39,42), CoreMatchers.equalTo(true));
        assertThat(Main.isDifferingByThree(42,46), CoreMatchers.equalTo(false));
    }

    @Test
    void isSafeIncreasingOnly() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        List<Integer> input2 = new ArrayList<>(Arrays.asList(1,3,5,7,9));
        List<Integer> input3 = new ArrayList<>(Arrays.asList(1,4,7,10,13));
        List<Integer> input4 = new ArrayList<>(Arrays.asList(1,2,4,7,8));
        List<Integer> input5 = new ArrayList<>(Arrays.asList(1,50,60,84,97));

        assertThat(Main.isSafe(input), CoreMatchers.equalTo("Safe"));
        assertThat(Main.isSafe(input2), CoreMatchers.equalTo("Safe"));
        assertThat(Main.isSafe(input3), CoreMatchers.equalTo("Safe"));
        assertThat(Main.isSafe(input4), CoreMatchers.equalTo("Safe"));
        assertThat(Main.isSafe(input5), CoreMatchers.equalTo("Unsafe"));
    }

    @Test
    void isSafeDecreasingOnly() {
        List<Integer> input = new ArrayList<>(Arrays.asList(5,4,3,2,1));
        List<Integer> input2 = new ArrayList<>(Arrays.asList(9,7,5,3,1));
        List<Integer> input3 = new ArrayList<>(Arrays.asList(13,10,7,4,1));
        List<Integer> input4 = new ArrayList<>(Arrays.asList(99,84,56,20));


        assertThat(Main.isSafe(input), CoreMatchers.equalTo("Safe"));
        assertThat(Main.isSafe(input2), CoreMatchers.equalTo("Safe"));
        assertThat(Main.isSafe(input3), CoreMatchers.equalTo("Safe"));
        assertThat(Main.isSafe(input4), CoreMatchers.equalTo("Unsafe"));
    }

    @Test
    void isSafe(){
        List<Integer> input = new ArrayList<>(Arrays.asList(90,91,93,96,93));
        assertThat(Main.isSafe(input), CoreMatchers.equalTo("Unsafe"));
        List<Integer> input2 = new ArrayList<>(Arrays.asList(3, 5, 7, 10, 11, 11));
        assertThat(Main.isSafe(input2), CoreMatchers.equalTo("Unsafe"));
        List<Integer> input3 = new ArrayList<>(Arrays.asList(35, 37, 39, 42, 46));
        assertThat(Main.isSafe(input3), CoreMatchers.equalTo("Unsafe"));
        List<Integer> input4 = new ArrayList<>(Arrays.asList(67, 70, 72, 74, 79));
        assertThat(Main.isSafe(input4), CoreMatchers.equalTo("Unsafe"));
    }

    @Test
    void isSafePart2Increasing(){
        List<Integer> input = new ArrayList<>(Arrays.asList(90,91,93,96,93));
        assertThat(Main.isSafePart2Increasing(input), CoreMatchers.equalTo("Safe"));
        List<Integer> input3 = new ArrayList<>(Arrays.asList(1 ,2 ,7, 8, 9));
        assertThat(Main.isSafePart2Increasing(input3), CoreMatchers.equalTo("Unsafe"));
        List<Integer> input5 = new ArrayList<>(Arrays.asList(1, 3, 2, 4 ,5));
        assertThat(Main.isSafePart2Increasing(input5), CoreMatchers.equalTo("Safe"));
        List<Integer> input7 = new ArrayList<>(Arrays.asList(1, 3, 6, 7, 9));
        assertThat(Main.isSafePart2Increasing(input7), CoreMatchers.equalTo("Safe"));
        List<Integer> input8 = new ArrayList<>(Arrays.asList(1, 1, 1, 1, 1));
        assertThat(Main.isSafePart2Increasing(input8), CoreMatchers.equalTo("Unsafe"));
    }

    @Test
    void isSafePart2Decreasing(){
        List<Integer> input2 = new ArrayList<>(Arrays.asList(7, 6, 4, 2, 1));
        assertThat(Main.isSafePart2Decreasing(input2), CoreMatchers.equalTo("Safe"));
        List<Integer> input4 = new ArrayList<>(Arrays.asList(9, 7, 6, 2, 1));
        assertThat(Main.isSafePart2Decreasing(input4), CoreMatchers.equalTo("Unsafe"));
        List<Integer> input6 = new ArrayList<>(Arrays.asList(8, 6, 4, 4, 1));
        assertThat(Main.isSafePart2Decreasing(input6), CoreMatchers.equalTo("Safe"));
        List<Integer> input7 = new ArrayList<>(Arrays.asList(1, 1, 1, 1, 1));
        assertThat(Main.isSafePart2Decreasing(input7), CoreMatchers.equalTo("Unsafe"));
    }

    @Test
    void howManySafePart2(){
        List<Integer> input = new ArrayList<>(Arrays.asList(9, 12, 13, 16, 15, 16, 19));
        assertThat(Main.howManySafePart2(input), CoreMatchers.equalTo("Unsafe"));

        List<Integer> input7 = new ArrayList<>(Arrays.asList(1, 1, 1, 1, 1));
        assertThat(Main.howManySafePart2(input7), CoreMatchers.equalTo("Unsafe"));

    }
}