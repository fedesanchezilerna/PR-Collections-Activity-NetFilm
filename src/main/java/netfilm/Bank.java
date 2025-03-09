package netfilm;

public class Bank {
    private String name;
    private String swiftCode;

    public Bank(String name, String swiftCode) {
        this.name = name;
        this.swiftCode = swiftCode;
    }

    @Override
    public String toString() {
        return "Bank [name=" + name + ", swiftCode=" + swiftCode + "]";
    }

    public String getName() {
        return name;
    }

    public String getSwiftCode() {
        return swiftCode;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSwiftCode(String swiftCode) {
        this.swiftCode = swiftCode;
    }
}
