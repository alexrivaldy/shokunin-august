package developerProperties;

import exception.WrongFormatException;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.Arrays.asList;

public class PropertiesParser {


    public List<DeveloperProperty> parse(String developerProperties) throws WrongFormatException {

        List<DeveloperProperty> properties = new ArrayList<>();

        try {
            asList(DeveloperProperty.values())
                .forEach(developerProperty -> {
                    if (hasProperty(developerProperties, developerProperty)) {
                        properties.add(developerProperty);
                    }
                });
        } catch (NullPointerException e) {
            throw new WrongFormatException("ERROR! Properties are not in the right format");
        }

        return properties;

    }

    private boolean hasProperty(String developerProperties, DeveloperProperty property) {
        String propertyPattern = property.getPattern();
        Pattern namePattern = Pattern.compile(propertyPattern);
        Matcher matcher = namePattern.matcher(developerProperties);

        return matcher.matches();
    }

}
