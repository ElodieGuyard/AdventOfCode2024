import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;

import java.io.IOException;
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
        assertThat(Main.readTheFile("test/Resource/inputTest.txt"), CoreMatchers.equalTo(expected));
    }

    @Test
    void parseOurDatas() {
    }

    @Test
    void sortMyList() {
    }

    @Test
    void substractIds() {
    }

    @Test
    void sumDistances() {
    }
}