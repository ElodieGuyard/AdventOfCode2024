import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;

class MainTest {

    @Test
    void isContentFileNotNull() throws IOException {
        assertThat(Main.readTheFile(), CoreMatchers.notNullValue());
    }

    @Test
    void TestreadTheFile() {
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