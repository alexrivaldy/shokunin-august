package developerProperties;

public enum DeveloperProperty {

    NOT_BEST(".*not.*best.*"),
    NOT_WORST(".*not.*worst.*");

    private String pattern;

    DeveloperProperty(String pattern) {
        this.pattern = pattern;
    }

    public String getPattern() {
        return pattern;
    }
}

