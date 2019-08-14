import java.util.Optional;

public class DeveloperFactory {

    PropertiesParser propertiesParser;

    public DeveloperFactory() {
        propertiesParser = new PropertiesParser();
    }

    public Developer createDeveloper() {
        return new Developer();
    }

    public Developer createDeveloper(String developerProperties) {
        Developer developer = new Developer();

        Optional<String> name = propertiesParser.parseName(developerProperties);

        developer.setName(name.get());
        return developer;
    }
}
