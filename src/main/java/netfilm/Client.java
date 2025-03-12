package netfilm;

import com.joanseculi.timejump.TimeJump;

public class Client {
    private static final String END_DATE = "31/12/9999";
    private String code;
    private String name;
    private String dni;
    private Subscription subscription;
    private String initialDate;
    private String endDate;
    private String iban;
    private Bank bank;

    private static int idNext = 1;

    public Client(String name, String dni, Subscription subscription, String initialDate, String endDate, String iban,
            Bank bank) {
        this.code = generateCode(dni);
        this.name = name;
        this.dni = dni;
        this.subscription = subscription;
        this.initialDate = initialDate;
        this.endDate = endDate;
        this.iban = iban;
        this.bank = bank;
    }

    public Client(String name, String dni, Subscription subscription, String initialDate, String iban, Bank bank) {
        this(name, dni, subscription, initialDate, END_DATE, iban, bank);
    }

    public Client(String name, String dni, Subscription subscription, String iban, Bank bank) {
        this(name, dni, subscription, TimeJump.todayDate(), END_DATE, iban, bank);
    }

    /**
     * Generates a code with the following format:
     * XXXXX-YYYY
     * XXXXX: 5-digit number, with zeros on the left auto-incremented
     * YYYY: the 4 last digits of the dni. In case the dni is less than 4 digits,
     * the code will be padded with zeros on the left.
     * 
     * @param dni the dni of the client
     * @return the code of the client
     */
    private String generateCode(String dni) {
        String code = String.format("%05d", idNext++);
        return code + "-" + dni.substring(dni.length() - 4);
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Subscription getSubscription() {
        return subscription;
    }

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }

    public String getInitialDate() {
        return initialDate;
    }

    public void setInitialDate(String initialDate) {
        this.initialDate = initialDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    @Override
    public String toString() {
        return String.format("%-15s %-20s %-15s %-15s %-15s %-15s %-15s %-10s", code, name, dni, subscription, initialDate, endDate,
                iban, bank.getName());
    }
}
