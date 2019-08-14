import org.junit.Test;

import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;

public class PropertiesParserTest {

    PropertiesParser subject = new PropertiesParser();

    @Test
    public void parseNameShouldReturnBackName() {
        String name = "Alex";

        Optional<String> actual = subject.parseName(name);

        assertTrue(actual.isPresent());
        assertThat(actual.get(), is(name));
    }

    @Test
    public void parseNameShouldReturnOnlyName() {
        String name = "Alex !first";

        Optional<String> actual = subject.parseName(name);

        assertTrue(actual.isPresent());
        assertThat(actual.get(), is("Alex"));
    }

    @Test
    public void parseNameShouldReturnEmptyWhenDataIsEmpty() {
        String name = "";

        Optional<String> actual = subject.parseName(name);

        assertFalse(actual.isPresent());
    }


    @Test
    public void parseNameShouldReturnEmptyWhenDataIsNull() {
        String name = null;

        Optional<String> actual = subject.parseName(name);

        assertFalse(actual.isPresent());
    }

}