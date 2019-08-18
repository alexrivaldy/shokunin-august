import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public Developer parse(String developerProperties) throws WrongFormatException {
        Developer developer = new Developer();
        try {
            StringTokenizer stringTokenizer = new StringTokenizer(developerProperties, WHITE_SPACE_DELIMITER);

            String name = stringTokenizer.nextToken();

            if (!isNameValid(name)) {
                throw new WrongFormatException("ERROR! Name is not in the right format");
            }

            developer.setName(name);

        } catch (NullPointerException | NoSuchElementException e) {
            throw new WrongFormatException("ERROR! Line is not in the right format");
        }

        return developer;

    }

    private boolean isNameValid(String name) {
        String nameRegex = "^[A-Z][a-z]*$";
        Pattern namePattern = Pattern.compile(nameRegex);
        Matcher matcher = namePattern.matcher(name);

        return matcher.matches();

    }
}
