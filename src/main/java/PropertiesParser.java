import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.StringTokenizer;

public class PropertiesParser {

    private final static String WHITE_SPACE_DELIMITER = " ";

    public Optional<String> parseName(String developerProperties) {
        try {
            StringTokenizer stringTokenizer = new StringTokenizer(developerProperties, WHITE_SPACE_DELIMITER);

            return Optional.of(stringTokenizer.nextToken());

        } catch (NullPointerException | NoSuchElementException e) {
            return Optional.empty();
        }
    }

}
