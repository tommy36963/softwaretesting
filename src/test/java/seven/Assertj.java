package seven;

import org.junit.Test;

import javax.swing.text.html.CSS;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.entry;
import static org.mockito.Matchers.contains;
import static org.assertj.core.api.Assertions.assertThat;


public class Assertj {

    @Test
    public void testAssertThatWithStringArray() {
        String[] stringArray = {"abc", "cde", "efg"};
        assertThat (stringArray).hasSize(3).
                contains("cde").doesNotContain("xyz");
    }
    @Test
    public void testAssertThatWithUniCode() {
        assertThat('d')
                .isNotEqualTo('a')
                .inUnicode()
                .isGreaterThanOrEqualTo('b')
                .isLowerCase();
    }
    @Test
    public void testAssertThatWithFile() {
        assertThat(new File("\"C:\\Users\\ehggthm\\Documents\\CSS Project 1.txt\""))
                .exists()
                .isFile()
                .canRead()
                .canWrite();

    }
    @Test
    public void testAssertThatWithMap() {
        Map<Integer,String> map = new HashMap<>();
        map.put(2,"a");
        assertThat(map)
                .isNotEmpty()
                .containsKey(2)
                .doesNotContainKeys(10)
                .contains(entry(2, "a"));
    }
}
