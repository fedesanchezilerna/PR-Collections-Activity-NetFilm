package netfilm;

import com.joanseculi.timejump.TimeJump;

import java.util.ArrayList;
import java.util.List;

public class NetFilm {
    private String name;
    private List<Client> clients;

    public NetFilm(String name) {
        this.name = name;
        this.clients = new ArrayList<>();
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    /**
     * Adds a Client object to the NetFilm collection . It will only add it if it
     * is not in the list, and the list does not contain any client with the same
     * id . It returns true if it has been inserted, false otherwise.
     *
     * @param client the client to add
     * @return true if the client has been inserted, false otherwise
     */
    public boolean signSubscription(Client client) {
        if (clients.contains(client)) {
            return false;
        }
        // Check if client already exists by DNI
        for (Client existingClient : clients) {
            if (existingClient.getDni().equals(client.getDni())) {
                return false;
            }
        }
        clients.add(client);
        return true;
    }

    public int countSubscriptions() {
        return clients.size();
    }

    /**
     * Returns the number of Clients who are subscribed on a given date.
     *
     * @param date the date to check
     * @return the number of Clients who are subscribed on the given date
     */
    public int countSubscriptionsDate(String date) {
        int count = 0;
        for (Client client : clients) {
            if (TimeJump.compareStringTime(client.getInitialDate(), date) <= 0 && TimeJump.compareStringDates(client.getEndDate(), date) >= 0) {
                count++;
            }
        }
        return count;
    }

    /**
     * Returns the Client knowing its code. If the code does not exist, returns
     * null.
     *
     * @param code the code of the client
     * @return the client with the given code, or null if it does not exist
     */
    public Client searchClient(String code) {
        for (Client client : clients) {
            if (client.getCode().equals(code)) {
                return client;
            }
        }
        return null;
    }

    /**
     * Calculates the days of the Client's subscription. Difference between the
     * end date and the initial date.
     *
     * @param code the code of the client
     * @return the number of days of the subscription
     */
    public long duration(String code) {
        Client client = searchClient(code);
        if (client == null) return 0;

        return TimeJump.getDays(client.getInitialDate(), client.getEndDate());

//        String[] initialDate = client.getInitialDate().split("/");
//        String[] endDate = client.getEndDate().split("/");
//
//        int initialDay = Integer.parseInt(initialDate[0]);
//        int initialMonth = Integer.parseInt(initialDate[1]);
//        int initialYear = Integer.parseInt(initialDate[2]);
//
//        int endDay = Integer.parseInt(endDate[0]);
//        int endMonth = Integer.parseInt(endDate[1]);
//        int endYear = Integer.parseInt(endDate[2]);
//
//        return (endYear - initialYear) * 365L + (endMonth - initialMonth) * 30L + (endDay - initialDay);
    }

    /**
     * Returns the subscription fee of a Client if they are subscribed, otherwise,
     * return -1
     *
     * @param code the code of the client
     * @return the subscription fee of the client, or -1 if they are not subscribed
     */
    public float getMonthlyFee(String code) {
        Client client = searchClient(code);
        if (client == null) return -1;
        return client.getSubscription().getFee();
    }

    /**
     * Returns subscribers who are active on a specified date.
     *
     * @param date the date to check
     * @return the list of active subscribers
     */
    public List<Client> listActiveSubscriptions(String date) {
        List<Client> activeSubscribers = new ArrayList<>();
        for (Client client : clients) {
            if (countSubscriptionsDate(date) > 0) {
                activeSubscribers.add(client);
            }
        }
        return activeSubscribers;
    }

    /**
     * Uptades the subscription to the one indicated by parameter, the subscription can
     * only be updated if the specified date is between initialDate and endDate.
     *
     * @param code         the code of the client
     * @param date         the date to check
     * @param subscription the new subscription
     * @return true if the change is satisfactory, false otherwise
     */
    public boolean changeSubscription(String code, String date, Subscription subscription) {
        Client client = searchClient(code);
        if (client == null) return false;

        if (countSubscriptionsDate(date) > 0) {
            client.setSubscription(subscription);
            return true;
        }
        return false;
    }

    /**
     * Ends a Client's subscription on the specified date, checks that the date is
     * greater than initialDate, if so, changes the endDate to the specified date.
     *
     * @param code the code of the client
     * @param date the date to check
     * @return true if the change was successful, false otherwise
     */
    public boolean endSubscription(String code, String date) {
        Client client = searchClient(code);
        if (client == null) return false;

        if (client.getInitialDate().compareTo(date) <= 0) {
            client.setEndDate(date);
            return true;
        }
        return false;
    }

    /**
     * Returns the amount that will be invoiced on a specific date, only taking
     * into account Clients who are registered on the specified date.
     *
     * @param date the date to check
     * @return the amount that will be invoiced
     */
    public float totalValue(String date) {
        float total = 0;
        for (Client client : clients) {
            if (countSubscriptionsDate(date) > 0) {
                total += client.getSubscription().getFee();
            }
        }
        return total;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(
                "-----------------------------------------------------------------------------------------------------------------------------\n");
        sb.append(String.format("%-15s %-20s %-15s %-15s %-15s %-15s %-15s %-10s\n",
                "CODE", "NAME", "DNI", "SUBSCR.", "INIT", "END", "IBAN", "BANK"));
        sb.append(
                "-----------------------------------------------------------------------------------------------------------------------------\n");
        for (Client client : clients) {
            sb.append(client.toString()).append("\n");
        }
        return sb.toString();
    }
}
