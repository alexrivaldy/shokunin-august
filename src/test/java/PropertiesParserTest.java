import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;

public class PropertiesParserTest {

    private PropertiesParser subject = new PropertiesParser();

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void parseNameShouldReturnBackName() {
        String name = "Alex";

        Optional<String> actual = subject.parseName(name);

        assertTrue(actual.isPresent());
        assertThat(actual.get(), is(name));
    }

    @Test
    public void parseNameShouldReturnEmptyWhenDataIsEmpty() {
        Optional<String> actual = subject.parseName("");

        assertFalse(actual.isPresent());
    }


    @Test
    public void parseNameShouldReturnEmptyWhenDataIsNull() {
        Optional<String> actual = subject.parseName(null);

        assertFalse(actual.isPresent());
    }

    @Test
    public void parseNameShouldReturnBackDeveloperWithName() throws WrongFormatException {
        String name = "Alex";

        Developer developer = new Developer();
        developer.setName(name);

        Developer actual = subject.parse(name);

        assertNotNull(actual);
        assertThat(actual.getName(), is(name));
    }

    @Test
    public void parseNameShouldThrowExceptionWhenNameHasUnknownSymbol() throws WrongFormatException {
        expectedException.expect(WrongFormatException.class);

        String name = "Alex,";

        Developer developer = new Developer();
        developer.setName(name);

        subject.parse(name);

    }

    @Test
    public void parseNameShouldThrowExceptionWhenDeveloperPropertiesIsNull() throws WrongFormatException {
        expectedException.expect(WrongFormatException.class);

        subject.parse(null);
    }

    @Test
    public void parseNameShouldThrowExceptionWhenDeveloperPropertiesIsEmpty() throws WrongFormatException {
        expectedException.expect(WrongFormatException.class);

        subject.parse(" ");
    }


}