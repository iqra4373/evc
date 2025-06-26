import java.util.Scanner;

public class evcplus {
    private static double balance = 200.0;
    private static int pin = 8989;
    private static final String ZIP_CODE = "*770#";
    private static Scanner scanner = new Scanner(System.in);

    // Array loogu talagalay kaydinta 3-dii dhaqdhaqaaq ee ugu dambeysay
    private static String[] lastThreeActions = new String[3];
    private static int actionIndex = 0;

    public static void main(String[] args) {
        System.out.print("Fadlan Geli Code-ka: ");
        String code = scanner.nextLine();

        if (code.equals(ZIP_CODE)) {
            System.out.print("Fadlan Geli Pin-kaaga: ");
            int enteredPin = Integer.parseInt(scanner.nextLine());

            if (enteredPin == pin) {
                displayMainMenu();
            } else {
                System.out.println("Number-ka Sirta Waa Khalad.");
            }
        } else {
            System.out.println("Sida aad Isticmashay " + code + " Waa Khalad.");
        }
    }

    private static void displayMainMenu() {
        System.out.println("\n[EVC PLUS]");
        System.out.println("-HORMUUD SERVICE-");
        System.out.println("1: Itus Haraaga");
        System.out.println("2: Kaarka Hadalka");
        System.out.println("3: Bixi Biil");
        System.out.println("4: Uwareeji");
        System.out.println("5: Warbixin Kooban");
        System.out.println("6: Salaam Bank");
        System.out.println("7: Maareynta");
        System.out.print("Geli Doorashada: ");
        String choice = scanner.nextLine();

        switch (choice) {
            case "1": itusHaraaga(); break;
            case "2": kaarkaHadalka(); break;
            case "3": bixiBiil(); break;
            case "4": uwareeji(); break;
            case "5": warbixinKooban(); break;
            case "6": salaamBank(); break;
            case "7": maareeyntaFile(); break;
            default: System.out.println("Doorashada aan sax ahayn"); displayMainMenu();
        }
    }

    private static void itusHaraaga() {
        System.out.println("\nHaraagaagu Waa $" + balance);
        addAction("Itus Haraaga → $" + balance);
        returnToMainMenu();
    }

    private static void kaarkaHadalka() {
        System.out.print("Geli Number-ka: ");
        String telephone = scanner.nextLine();

        if (telephone.length() <= 10) {
            System.out.print("Geli Lacagta: $");
            double money = Double.parseDouble(scanner.nextLine());

            if (money <= balance) {
                System.out.println("[EVC-PLUS] Mahubtaa Inaad $" + money + " Ugushubto " + telephone);
                System.out.println("1: Haa\n2: Maya");
                String valid = scanner.nextLine();

                if (valid.equals("1")) {
                    if (enterPin()) {
                        balance -= money;
                        System.out.println("[EVC-PLUS] Waxaad $" + money + " Ugushubtay " + telephone);
                        System.out.println("Haraagagu Waa $" + balance);
                        addAction("Kaarka Hadalka $" + money + " → " + telephone);
                    }
                } else {
                    System.out.println("Macsalaama!");
                }
            } else {
                System.out.println("Haraagagu Kuguma Filna.");
            }
        } else {
            System.out.println("Number-ka aad Gelisay Majiro.");
        }
        returnToMainMenu();
    }

    private static void bixiBiil() {
        System.out.print("Geli Aqoonsiga Ganacsiga: ");
        String businessMan = scanner.nextLine();

        System.out.print("Geli Number-ka Ganacsadaha: ");
        String businessNumber = scanner.nextLine();

        if (businessNumber.length() <= 6) {
            System.out.print("Geli Lacagta: $");
            double money = Double.parseDouble(scanner.nextLine());

            if (money <= balance) {
                System.out.println("Mahubtaa Inaad $" + money + " Udirtid " + businessMan);
                System.out.println("1: Haa\n2: Maya");
                String valid = scanner.nextLine();

                if (valid.equals("1")) {
                    if (enterPin()) {
                        balance -= money;
                        System.out.println("[EVC-PLUS] Waxaad $" + money + " Udirtay " + businessMan);
                        System.out.println("Haraagagu Waa $" + balance);
                        addAction("Bixi Biil $" + money + " → " + businessMan);
                    }
                } else {
                    System.out.println("Macsalaama!");
                }
            } else {
                System.out.println("Haraagagu Kuguma Filna.");
            }
        } else {
            System.out.println("Number-ka Aad Gelisay Majiro.");
        }
        returnToMainMenu();
    }

    private static void uwareeji() {
        System.out.print("Geli Mobile-ka: ");
        String number = scanner.nextLine();

        if (number.length() <= 10) {
            System.out.print("Geli Lacagta: $");
            double money = Double.parseDouble(scanner.nextLine());

            if (money <= balance) {
                System.out.println("Mahubtaa Inaad $" + money + " Uwareejiso " + number);
                System.out.println("1: Haa\n2: Maya");
                String valid = scanner.nextLine();

                if (valid.equals("1")) {
                    if (enterPin()) {
                        balance -= money;
                        System.out.println("[EVC-PLUS] Waxaad $" + money + " Uwareejisay " + number);
                        System.out.println("Haraagagu Waa $" + balance);
                        addAction("Uwareeji $" + money + " → " + number);
                    }
                } else {
                    System.out.println("Macsalaama!");
                }
            } else {
                System.out.println("Haraagagu Kuguma Filna.");
            }
        } else {
            System.out.println("Number-ka Aad Gelisay Majiro.");
        }
        returnToMainMenu();
    }

    private static void warbixinKooban() {
        System.out.println("\nWarbixin Kooban");
        System.out.println("1: 3-dii Dhaqdhaqaaq ee Ugu Dambeeyay");
        System.out.println("2: Back");
        System.out.print("Geli Doorashada: ");
        String choice = scanner.nextLine();

        if (choice.equals("1")) {
            showLastThreeActions();
        } else if (choice.equals("2")) {
            returnToMainMenu();
            return;
        } else {
            System.out.println("Doorashada aan sax ahayn.");
        }
        returnToMainMenu();
    }

    private static void salaamBank() {
        System.out.print("Geli Koontada: ");
        int accountNumber = Integer.parseInt(scanner.nextLine());

        System.out.print("Geli Lacagta: $");
        double amount = Double.parseDouble(scanner.nextLine());

        if (amount <= balance) {
            System.out.println("Mahubtaa Inaad $" + amount + " Kudirto Koontada " + accountNumber);
            System.out.println("1: Haa\n2: Maya");
            String valid = scanner.nextLine();

            if (valid.equals("1")) {
                if (enterPin()) {
                    balance -= amount;
                    System.out.println("[Salaam Bank] Waxaad $" + amount + " Udirtay " + accountNumber);
                    System.out.println("Haraagagu Waa $" + balance);
                    addAction("Salaam Bank $" + amount + " → " + accountNumber);
                }
            } else {
                System.out.println("Macsalaama!");
            }
        } else {
            System.out.println("Haraagagu Kuguma Filna.");
        }
        returnToMainMenu();
    }

    private static void maareeyntaFile() {
        System.out.println("\nMaareynta");
        System.out.println("1: Badel Pin-ka");
        System.out.println("2: Kabax");
        System.out.print("Geli Doorashada: ");
        String choice = scanner.nextLine();

        if (choice.equals("1")) {
            System.out.print("Geli Pin Cusub: ");
            int newPin = Integer.parseInt(scanner.nextLine());

            System.out.print("Mar Kale Geli Pin Cusub: ");
            int confirmPin = Integer.parseInt(scanner.nextLine());

            if (newPin == confirmPin) {
                pin = newPin;
                System.out.println("Pin-kaaga Waa La Badalay.");
                addAction("Badel Pin");
            } else {
                System.out.println("Pin-kaga Ma Wada Mid Noqon.");
            }
        } else {
            System.out.println("Macsalaama!");
            System.exit(0);
        }
        returnToMainMenu();
    }

    // 🔥 Method: Hubinta Pin
    private static boolean enterPin() {
        System.out.print("Geli Pin-kaaga: ");
        int inputPin = Integer.parseInt(scanner.nextLine());
        if (inputPin == pin) {
            return true;
        } else {
            System.out.println("Number-ka Sirta Waa Khalad.");
            return false;
        }
    }

    // 🔥 Method: Ku dar Dhaqdhaqaaqyada
    private static void addAction(String action) {
        lastThreeActions[actionIndex % 3] = action;
        actionIndex++;
    }

    // 🔥 Method: Tus Dhaqdhaqaaqyadii
    private static void showLastThreeActions() {
        System.out.println("\n3-dii Dhaqdhaqaaq ee Ugu Dambeeyay:");
        boolean empty = true;
        for (String action : lastThreeActions) {
            if (action != null) {
                System.out.println("- " + action);
                empty = false;
            }
        }
        if (empty) {
            System.out.println("Ma jiraan wax dhaqdhaqaaq ah wali.");
        }
    }

    // 🔥 Method: Return Menu
    private static void returnToMainMenu() {
        System.out.println("\n1: Ku noqo menu-ga");
        System.out.println("0: Kabax");
        System.out.print("Geli Doorashada: ");
        String choice = scanner.nextLine();
        if (choice.equals("1")) {
            displayMainMenu();
        } else {
            System.out.println("Macsalama!");
            System.exit(0);
        }
    }
}