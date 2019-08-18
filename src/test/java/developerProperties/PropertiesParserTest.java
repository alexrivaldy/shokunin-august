package developerProperties;

import exception.WrongFormatException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.List;
import java.util.Map;

import static developerProperties.DeveloperProperty.*;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class PropertiesParserTest {

    PropertiesParser subject = new PropertiesParser();

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void shouldReturnEmptyListWhenLineIsEmpty() throws WrongFormatException {
        Map<DeveloperProperty, String> actual = subject.parse("");

        assertNotNull(actual);
        assertThat(actual.size(), is(0));
    }

    @Test
    public void shouldReturnEmptyListWhenLineIsnull() throws WrongFormatException {
        expectedException.expect(WrongFormatException.class);

        Map<DeveloperProperty, String> actual = subject.parse(null);
    }

    @Test
    public void shouldReturnNotBestPropertyWhenLineHasNotBest() throws WrongFormatException {
        String developerProperties = "Alex is not the best developer.";

        Map<DeveloperProperty, String> actual = subject.parse(developerProperties);

        assertNotNull(actual);
        assertThat(actual.size(), is(1));
        assertTrue(actual.containsKey(NOT_BEST));
        assertTrue(actual.get(NOT_BEST).isEmpty());
    }

    @Test
    public void shouldReturnNotBestPropertyWhenLineHasNotWorst() throws WrongFormatException {
        String developerProperties = "Alex is not the worst developer.";

        Map<DeveloperProperty, String> actual = subject.parse(developerProperties);

        assertNotNull(actual);
        assertThat(actual.size(), is(1));
        assertTrue(actual.containsKey(NOT_WORST));
        assertTrue(actual.get(NOT_WORST).isEmpty());
    }

    @Test
    public void shouldReturnTwoPropertiesWhenLineHasNotBestAndNotWorst() throws WrongFormatException {
        String developerProperties = "Alex is not the best or the worst developer.";

        Map<DeveloperProperty, String> actual = subject.parse(developerProperties);

        assertNotNull(actual);
        assertThat(actual.size(), is(2));
        assertTrue(actual.containsKey(NOT_BEST));
        assertTrue(actual.containsKey(NOT_WORST));
        assertTrue(actual.get(NOT_BEST).isEmpty());
        assertTrue(actual.get(NOT_WORST).isEmpty());
    }

    @Test
    public void shouldReturnBetterThanWithDeveloperNameWhenLineHasBetterThan() throws WrongFormatException {
        String developerProperties = "Alex is a better developer than Jesslyn.";

        Map<DeveloperProperty, String> actual = subject.parse(developerProperties);

        assertNotNull(actual);
        assertThat(actual.size(), is(1));
        assertTrue(actual.containsKey(BETTER_THAN));
        assertThat(actual.get(BETTER_THAN), is("Jesslyn"));

    }

    @Test
    public void shouldReturnNotDirectlyNearWithDeveloperNameWhenLineHasNotDirectlyNear() throws WrongFormatException {
        String developerProperties = "Alex is not directly below or above Jesslyn as a developer.";

        Map<DeveloperProperty, String> actual = subject.parse(developerProperties);

        assertNotNull(actual);
        assertThat(actual.size(), is(1));
        assertTrue(actual.containsKey(NOT_DIRECTLY_NEAR));
        assertThat(actual.get(NOT_DIRECTLY_NEAR), is("Jesslyn"));

    }

}