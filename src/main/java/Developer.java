import developerProperties.DeveloperProperty;

import java.util.ArrayList;
import java.util.List;

public class Developer {

    private String name = "";
    private List<DeveloperProperty> properties = new ArrayList<>();

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public List<DeveloperProperty> getProperties() {
        return properties;
    }

    public void setProperties(List<DeveloperProperty> developerProperties) {
        this.properties = developerProperties;
    }
}
