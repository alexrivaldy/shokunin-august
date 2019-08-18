package developerProperties;

import exception.WrongFormatException;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PropertiesParser {


    public Map<DeveloperProperty, String> parse(String developerProperties) throws WrongFormatException {

        Map<DeveloperProperty, String> properties = new HashMap<>();

        try {
            for (DeveloperProperty developerProperty : DeveloperProperty.values()) {
                checkLine(properties, developerProperty, developerProperties);
            }
        } catch (NullPointerException e) {
            throw new WrongFormatException("ERROR! Properties are not in the right format");
        }

        return properties;

    }

    private void checkLine(Map<DeveloperProperty, String> properties,
                           DeveloperProperty developerProperty,
                           String developerProperties) throws WrongFormatException {

        if (hasProperty(developerProperties, developerProperty)) {
            if (developerProperty.isCheckName()) {
                properties.put(developerProperty, retrieveSecondNameFromLine(developerProperties));
            } else {
                properties.put(developerProperty, "");
            }
        }
    }

    private boolean hasProperty(String developerProperties, DeveloperProperty property) {
        String propertyRegex = property.getPattern();
        Pattern propertyPattern = Pattern.compile(propertyRegex);
        Matcher matcher = propertyPattern.matcher(developerProperties);

        return matcher.matches();
    }

    private String retrieveSecondNameFromLine(String developerProperties) throws WrongFormatException {
        String secondNameRegex = " [A-Z][a-z]*";
        Pattern secondNamePattern = Pattern.compile(secondNameRegex);
        Matcher matcher = secondNamePattern.matcher(developerProperties);

        if (matcher.find()) {
            return matcher.group().trim();
        }
        throw new WrongFormatException("ERROR! No other developer name!");
    }

}
