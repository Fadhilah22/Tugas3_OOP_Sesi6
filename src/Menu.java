import java.util.Scanner;
import java.util.ArrayList;

public class Menu {

    static ArrayList<Sedan> sedan_container = new ArrayList<Sedan>();
    static ArrayList<Suv> suv_container = new ArrayList<Suv>();
    static ArrayList<Jeep> jeep_container = new ArrayList<Jeep>();

    static String[] suvList = {"Toyota RAV4", "Honda CR-V", "Ford Escape", "Subaru Outback", "Chevrolet Equinox", "Nissan Rogue", "Hyundai Tucson", "Mazda CX-5", "Kia Seltos", "Volkswagen Tiguan"};
    static String[] jeepList = {"Jeep Wrangler", "Jeep Grand Cherokee", "Jeep Compass", "Jeep Renegade", "Jeep Cherokee", "Jeep Gladiator", "Jeep Patriot", "Jeep Liberty", "Jeep Commander", "Jeep CJ-5"};
    static String[] sedanList = {"Honda Civic", "Toyota Camry", "Ford Fusion", "Hyundai Sonata", "Chevrolet Malibu", "Nissan Altima", "Volkswagen Passat", "Mazda6", "Kia Optima", "Subaru Legacy"};
    static int length = 10;

    static Scanner scan = new Scanner(System.in);

    public static void inputCar(int type, int name){
        if(type == 1){
          Sedan sedan = new Sedan(sedanList[name]);
          sedan_container.add(sedan);
        } else if(type == 2){
          Suv suv = new Suv(suvList[name]);
          suv_container.add(suv);
        } else if(type == 3){
          Jeep jeep = new Jeep(jeepList[name]);
          jeep_container.add(jeep);
        }
    }

    public static void printSedanList(){
      for(int sedan = 0; sedan < 10; sedan ++){
          System.out.println(sedan + " " + sedanList[sedan]);
      }
    }
    public static void printJeepList(){
      for(int jeep = 0; jeep < 10; jeep ++){
          System.out.println(jeep + " " + jeepList[jeep]);
      }
    }
    public static void printSuvList(){
      for(int suv = 0; suv < 10; suv ++){
          System.out.println(suv + " " + suvList[suv]);
      }
    }

    public static void showAll() {
    System.out.println("======== [ Sedan ] ========");
    for (Sedan sedan : sedan_container) {
        System.out.println(sedan.car_name); // Use the correct field name
    }
    System.out.println("========= [ Suv ] =========");
    for (Suv suv : suv_container) {
        System.out.println(suv.car_name); // Use the correct field name
    }
    System.out.println("========== [Jeep] =========");
    for (Jeep jeep : jeep_container) {
        System.out.println(jeep.car_name); // Use the correct field name
    }
}

    public static void printMenu(){
        System.out.println("==== [Menu] ====");
        System.out.println("1. Buy");
        System.out.println("2. Show");
        System.out.println("0. Exit");
        System.out.print("Enter option >> ");
    }

    public static void main(String[] args) {
        int option = 99;
        while(option != 0) {
          printMenu();
          option = scan.nextInt();
          if(option == 1){
            int typeOption = 99;
            int carOption = 0;

            while(typeOption != 0) {
                System.out.println("1. Sedan");
                System.out.println("2. Suv");
                System.out.println("3. Jeep");
                System.out.println("0. back");
                System.out.println("Select your car type >> ");
                typeOption = scan.nextInt();

                if(typeOption == 1) printSedanList();
                else if (typeOption == 2) printSuvList();
                else if (typeOption == 3) printJeepList();

                Boolean chooseCar = true;

                while(chooseCar & typeOption > 0 && typeOption < 4) {
                    System.out.print("Select your car >> ");
                    carOption = scan.nextInt();
                    if(carOption > length){
                        System.out.println("Choose valid car");
                    }
                    else {
                      inputCar(typeOption, carOption);
                      chooseCar = false;
                    }
                }
            }
            System.out.println("Car has been selected successfully!");
          } else if(option == 2){
                showAll();
          } else if(option == 0){
              return;
          } else System.out.println("Invalid input");
        }
    }
}
