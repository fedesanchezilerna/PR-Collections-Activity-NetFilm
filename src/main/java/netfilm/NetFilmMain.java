package netfilm;

public class  NetFilmMain {
    public static void main(String[] args) {
        // Instantiate NetFilm
        System.out.println("Instantiate NetFilm");
        NetFilm netFilm = new NetFilm("NETFILM");

        // Instantiate Banks
        System.out.println("Instantiate Banks");
        Bank freeBank = new Bank("FreeBank", "FREEMMYES");
        System.out.println(freeBank.toString());
        Bank coolBank = new Bank("CoolBank", "COOLSSES");
        System.out.println(freeBank.toString());

        // Instantiate clients
        System.out.println("Instantiate Clients");
        Client cl1 = new Client("Kate Winslet", "11111111A", Subscription.BASIC_ADVERTS, "01/01/2010", "31/12/2022",
                "ES001111", freeBank);
        Client cl2 = new Client("Timothée Chalamet", "22222222A", Subscription.BASIC, "01/02/2000", "28/02/2022",
                "ES002222", freeBank);
        Client cl3 = new Client("Viola Davis", "33333333A", Subscription.STANDARD, "01/01/2000", "31/01/2000",
                "ES003333", freeBank);
        Client cl4 = new Client("Chris Evans", "44444444A", Subscription.PREMIUM, "01/03/2001", "30/03/2001",
                "ES004444", freeBank);
        Client cl5 = new Client("Robert Downey Jr", "55555555A", Subscription.BASIC, "01/01/2021", "ES005555",
                freeBank);
        Client cl6 = new Client("Jennifer Lawrence", "66666666A", Subscription.BASIC, "01/01/2020", "ES006666",
                freeBank);
        Client cl7 = new Client("Channing Tatum", "77777777A", Subscription.STANDARD, "01/03/2000", "ES007777",
                coolBank);
        Client cl8 = new Client("Johnny Depp", "88888888A", Subscription.PREMIUM, "ES008888", coolBank);
        Client cl9 = new Client("Jared Leto", "99999999A", Subscription.PREMIUM, "ES009999", coolBank);
        Client cl10 = new Client("Kate Winslet", "00000000A", Subscription.BASIC_ADVERTS, "ES009999", coolBank);

        // Two clients with same dni
        Client cl11 = new Client("Cate Blanchett", "99999999A", Subscription.BASIC, "ES009999", freeBank);
        Client cl12 = new Client("Audrey Hepburn", "00000000A", Subscription.BASIC, "01/01/2000", "ES009999", freeBank);

        System.out.println("Print Clients");
        System.out.println(cl1);
        System.out.println(cl2);
        System.out.println(cl3);
        System.out.println(cl4);
        System.out.println(cl5);
        System.out.println(cl6);
        System.out.println(cl7);
        System.out.println(cl8);
        System.out.println(cl9);
        System.out.println(cl10);
        System.out.println(cl11); // Duplicated dni
        System.out.println(cl12); // Duplicated dni

        System.out.println("Sign Subscriptions");
        System.out.println(netFilm);
        System.out.println(netFilm.signSubscription(cl1));
        System.out.println(netFilm.signSubscription(cl2));
        System.out.println(netFilm.signSubscription(cl3));
        System.out.println(netFilm.signSubscription(cl4));
        System.out.println(netFilm.signSubscription(cl5));
        System.out.println(netFilm.signSubscription(cl6));
        System.out.println(netFilm.signSubscription(cl7));
        System.out.println(netFilm.signSubscription(cl8));
        System.out.println(netFilm.signSubscription(cl9));
        System.out.println(netFilm.signSubscription(cl10));
        System.out.println(netFilm.signSubscription(cl11));
        System.out.println(netFilm.signSubscription(cl12));
        System.out.println(netFilm);
    }
}
