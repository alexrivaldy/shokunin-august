import developerProperties.DeveloperProperty;

import java.util.HashMap;
import java.util.Map;

public class Developer {

    private String name = "";
    private Map<DeveloperProperty, String> properties = new HashMap<>();

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Map<DeveloperProperty, String> getProperties() {
        return properties;
    }

    public void setProperties(Map<DeveloperProperty, String> developerProperties) {
        this.properties = developerProperties;
    }
}
