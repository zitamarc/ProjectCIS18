import java.util.*;

public class ZitaElectronics {

static Scanner scan = new Scanner(System.in);

static double total = 0.0;

static String invoice = "\nDescription Quantity Amount \n" + "------------------------------ \n";

static double VizioTVPrice = 679.99;

static double SamsungTvPrice = 799.99;

static double SonoSpeakerPrice = 459.99;

static double BoseSpeakerPrice = 299.99;

static double deliveryOption1 = 0.0;

static double deliveryOption2 = 25.99;

static double deliveryOption3 = 50.99;

static double deliveryOption4 = 89.99;

static double morningInstallation = 49.99;

static double afternoonInstallation = 39.99;

static double tax = 0.08; // 8% tax

public static void main(String[] args) {

Boolean flag = true;

int number;

System.out.println("Welcome to Zita Electronics!");

while (flag) {

displayMenu();

number = scan.nextInt();

switch (number) {               //switch case for option menu on what you want to do.

case 1:

displayInventory();

break;

case 2:

getDeliveryOption();

break;

case 3:

scheduleHomeInstallation();

break;

case 4:

displayInvoice();

break;

case 5:

System.out.println("You have paid your invoice. Good-bye!");

flag = false;

break;

default:

System.out.println("---------Enter valid option---------");

}

}

}

public static void displayMenu() {          //displays menu.

System.out.println(

"\nChoose from the following options: \n 1: Purchase electronics \n 2: Select a delivery option \n 3: Schedule a home installation option \n 4: View invoice \n 5: Pay and Exit Store");

}

public static void displayInventory() {             //displays the inventory

System.out.println(" \nInventory");

System.out.println("1: Vizio TV: $679.99");

System.out.println("2: Samsung TV: $799.99");

System.out.println("3: Sono Speaker: $459.99");

System.out.println("4: Bose Speaker $299.99");

System.out.println("Enter inventory number:");

int invent = scan.nextInt();

System.out.println("Enter quantity:");

int quantity = scan.nextInt();

if (quantity > 0 && (invent > 0 && invent < 5)) {

double ElectronicsCost = calculateElectronicsPrice(invent, quantity);

updateTotal(ElectronicsCost);

invoice += " " + quantity + " $" + ElectronicsCost + "";

} else {

System.out.println("quantity is less than 1 or the inventory number does not exist"); // error message for invalid inputs

}

}

public static double calculateElectronicsPrice(int invent, int quantity) {  //calculates price of item and quantity.

double price = 0.0;

switch (invent) {

case 1:

invoice += "Vizio Tv ";

price = (VizioTVPrice * quantity);

break;

case 2:

invoice += "Samsung Tv ";

price = SamsungTvPrice * quantity;

break;

case 3:

invoice += "Sono Speaker ";

price = SonoSpeakerPrice * quantity;

break;

case 4:

invoice += "Bose Speaker ";

price = BoseSpeakerPrice * quantity;

break;

}

return price;

}

public static void updateTotal(double amount) { //updates the total of all prices charged

total += amount;

System.out.println("Current total: $" + total + "");

}

public static void getDeliveryOption() {

System.out.println(

"\n 1: 5-7 days free shipping \n 2: 3-5 days at $25.99 \n 3: Two-day shipping at $50.99 \n 4: overnight shipping at $150.99");

System.out.println("Choose delivery option:");

int number = scan.nextInt();

getDeliveryFee(number);

}

public static void scheduleHomeInstallation() {  // home installation option

System.out

.println("Would you like a morning or afternoon appointment?(1 = Morning, 2 = Afternoon, 3 = exit)");

int number = scan.nextInt();

switch (number) {

case 1:

System.out.println("Morning installations cost $" + morningInstallation);

updateTotal(morningInstallation);

invoice += "\nMorning installation  $" + morningInstallation + "\n";

break;

case 2:

System.out.println("Afternoon installations cost $" + afternoonInstallation);

updateTotal(afternoonInstallation);

invoice += "\nAfternoon installation - $" + afternoonInstallation + "";

break;

    }

}

public static void displayInvoice() {

System.out.println(invoice);

System.out.println("Total before tax: $" + total + "");

System.out.println("tax: $" + (total * tax) + "");

System.out.println("Total after tax: $" + (total + (total * tax)) + "");

}

public static void getDeliveryFee(int deliveryFee) {

if (deliveryFee > 0 && deliveryFee < 5) {           //switch statement for delivery option

switch (deliveryFee) {

case 1:

invoice += " \n5-7 days free shipping:" + deliveryOption1 + "";

updateTotal(deliveryOption1);

break;

case 2:

invoice += " \n3-5 days shipping: $" + deliveryOption2 + "";

updateTotal(deliveryOption2);

break;

case 3:

invoice += " \nTwo-day shipping: $" + deliveryOption3 + "";

updateTotal(deliveryOption3);

break;

case 4:

invoice += " \nNext day shipping: $" + deliveryOption4 + "";

updateTotal(deliveryOption4);

break;

    }

} else {

System.out.println("Invalid delivery option");

        }

    }

}