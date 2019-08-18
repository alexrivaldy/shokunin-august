import java.util.Optional;

public class DeveloperFactory {

    LineParser lineParser;

    public DeveloperFactory() {
        lineParser = new LineParser();
    }

    public Developer createDeveloper() {
        return new Developer();
    }

    public Developer createDeveloper(String developerProperties) {
        Developer developer = new Developer();

        Optional<String> name = lineParser.parseName(developerProperties);

        developer.setName(name.get());
        return developer;
    }
}
