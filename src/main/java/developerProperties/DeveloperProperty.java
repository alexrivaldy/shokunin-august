package developerProperties;

public enum DeveloperProperty {

    NOT_BEST(".*not.*best.*", false),
    NOT_WORST(".*not.*worst.*", false),
    BETTER_THAN(".*better.*than.*", true),
    NOT_DIRECTLY_NEAR(".*not.*directly.*", true);

    private String pattern;
    private boolean checkName;

    DeveloperProperty(String pattern, boolean checkName) {
        this.pattern = pattern;
        this.checkName = checkName;
    }

    public String getPattern() {
        return pattern;
    }

    public boolean isCheckName() {
        return checkName;
    }
}

