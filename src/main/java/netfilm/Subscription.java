package netfilm;

public enum Subscription {
    BASIC_ADVERTS(5.49f),
    BASIC(7.99f),
    STANDARD(12.99f),
    PREMIUM(17.99f);

    private float fee;

    Subscription(float fee) {
        this.fee = fee;
    }

    public float getFee() {
        return fee;
    }
}
