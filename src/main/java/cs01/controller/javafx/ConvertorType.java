package cs01.controller.javafx;

public enum ConvertorType {
    DEC_2_BIN("Decimal", "Binary"), BIN_2_DEC("Binary", "Decimal");

    private final String origin;
    private final String target;

    ConvertorType(String origin, String target) {
        this.origin = origin;
        this.target = target;
    }

    public String getOrigin() {
        return origin;
    }

    public String getTarget() {
        return target;
    }

    public String generateTitle() {
        return origin + " to " + target;
    }
}
