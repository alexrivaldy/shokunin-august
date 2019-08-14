

public class DeveloperFactory {

    public Developer createDeveloper() {
        return new Developer();
    }

    public Developer createDeveloper(String developerProperties) {
        Developer developer = new Developer();
        developer.setName(developerProperties);
        return developer;
    }
}
