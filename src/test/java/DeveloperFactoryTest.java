import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class DeveloperFactoryTest {

    DeveloperFactory subject = new DeveloperFactory();

    @Test
    public void shouldCreateDeveloperCorrectly() {
        Developer developer = subject.createDeveloper();

        assertNotNull(developer);
    }

    @Test
    public void shouldCreateDeveloperWithName() {
        String developerProperties = "Alex";

        Developer developer = subject.createDeveloper(developerProperties);

        assertNotNull(developer);
        assertThat(developer.getName(), is("Alex"));
    }

}