package developerProperties;

import exception.WrongFormatException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.List;

import static developerProperties.DeveloperProperty.NOT_BEST;
import static developerProperties.DeveloperProperty.NOT_WORST;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class PropertiesParserTest {

    PropertiesParser subject = new PropertiesParser();

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void shouldReturnEmptyListWhenLineIsEmpty() throws WrongFormatException {
        List<DeveloperProperty> actual = subject.parse("");

        assertNotNull(actual);
        assertThat(actual.size(), is(0));
    }

    @Test
    public void shouldReturnEmptyListWhenLineIsnull() throws WrongFormatException {
        expectedException.expect(WrongFormatException.class);

        List<DeveloperProperty> actual = subject.parse(null);
    }

    @Test
    public void shouldReturnNotBestPropertyWhenLineHasNotBest() throws WrongFormatException {
        String developerProperties = "Alex is not the best developer.";

        List<DeveloperProperty> actual = subject.parse(developerProperties);

        assertNotNull(actual);
        assertThat(actual.size(), is(1));
        assertThat(actual.get(0), is(NOT_BEST));

    }

    @Test
    public void shouldReturnNotBestPropertyWhenLineHasNotWorst() throws WrongFormatException {
        String developerProperties = "Alex is not the worst developer.";

        List<DeveloperProperty> actual = subject.parse(developerProperties);

        assertNotNull(actual);
        assertThat(actual.size(), is(1));
        assertThat(actual.get(0), is(NOT_WORST));

    }

    @Test
    public void shouldReturnTwoPropertiesWhenLineHasNotBestAndNotWorst() throws WrongFormatException {
        String developerProperties = "Alex is not the best or the worst developer.";

        List<DeveloperProperty> actual = subject.parse(developerProperties);

        assertNotNull(actual);
        assertThat(actual.size(), is(2));
        assertThat(actual, hasItem(NOT_WORST));
        assertThat(actual, hasItem(NOT_BEST));

    }

}