import org.junit.Test;

import static org.junit.Assert.*;

public class DeveloperTest {

    @Test
    public void shouldCreateDeveloperCorrectly() {
        Developer developer = new Developer();

        assertNotNull(developer);
    }

}