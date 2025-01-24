public enum Status {
    TODO("todo"),
    IN_PROGRESS("in progress"),
    DONE("done");

    private final String value;

    private Status(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
       return value;
    }
}
