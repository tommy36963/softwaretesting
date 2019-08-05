package six;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.anyOf;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.AnyOf.anyOf;


public class AssertThatMatchers {
    @Test
    public void assertThatWithTwo() {
        int a = 1, b = 1;
        assertThat(a,is(b));
        assertThat(a, equalTo(b));
        assertThat(a, is(equalTo(b)));
    }
    @Test
    public void assetThatWithThree(){
        int a = 1, b = 1, c = 2;
        assertThat(a, anyOf(is(b), is(c)));
    }
    @Test
    public void testAssetThatHasItems(){
        assertThat(Arrays.asList("Java", "Kotlin", "Scala" ), hasItems("Java", "Kotlin"));
}
    @Test
    public void testAssetThatAnyOfContainsString(){
        assertThat("test", anyOf(is("testing"), containsString("test")));

}
}
