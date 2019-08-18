import exception.WrongFormatException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Optional;

import static developerProperties.DeveloperProperty.NOT_BEST;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;

public class LineParserTest {

    private LineParser subject = new LineParser();

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
    public void parseShouldReturnBackDeveloperWithName() throws WrongFormatException {
        String name = "Alex";

        Developer developer = new Developer();
        developer.setName(name);

        Developer actual = subject.parse(name);

        assertNotNull(actual);
        assertThat(actual.getName(), is(name));
    }

    @Test
    public void parseShouldThrowExceptionWhenNameHasUnknownSymbol() throws WrongFormatException {
        expectedException.expect(WrongFormatException.class);

        String name = "Alex,";

        Developer developer = new Developer();
        developer.setName(name);

        subject.parse(name);

    }

    @Test
    public void parseShouldThrowExceptionWhenDeveloperPropertiesIsNull() throws WrongFormatException {
        expectedException.expect(WrongFormatException.class);

        subject.parse(null);
    }

    @Test
    public void parseShouldThrowExceptionWhenDeveloperPropertiesIsEmpty() throws WrongFormatException {
        expectedException.expect(WrongFormatException.class);

        subject.parse(" ");
    }

    @Test
    public void parseShouldReturnDeveloperPropertyNotBestWhenLineHasNotBestIndicator() throws WrongFormatException {
        String developerProperties = "Alex is not the best developer.";

        Developer actual = subject.parse(developerProperties);

        assertNotNull(actual);
        assertThat(actual.getProperties().size(), is(1));
        assertTrue(actual.getProperties().containsKey(NOT_BEST));

    }


}