package org.example;
import java.util.ArrayList;
import java.util.Scanner;

    public class RentalDemo {
        private static ArrayList<> Arrays;

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            Rental.RentalDemo[] rentals = new Rental.RentalDemo[8];

            // Get data for Rental objects
            for (int i = 0; i < rentals.length; i++) {
                System.out.println("Enter details for Rental " + (i + 1) + ":");
                System.out.print("Contract Number: ");
                int contractNumber = scanner.nextInt();
                System.out.print("Price: ");
                double price = scanner.nextDouble();
                System.out.print("Equipment Type (0 - Personal Watercraft, 1 - Pontoon Boat, etc.): ");
                int equipmentType = scanner.nextInt();

                rentals[i] = new Rental.Rental(contractNumber, price, equipmentType);
            }

            while (true) {
                System.out.println("\nChoose a sorting option: ");
                System.out.println("1. Sort by Contract Number");
                System.out.println("2. Sort by Price");
                System.out.println("3. Sort by Equipment Type");
                System.out.println("Enter 0 to exit.");
                int choice = scanner.nextInt();

                if (choice == 0) {
                    break;
                }

                switch (choice) {
                    case 1:
                        Arrays.sort(rentals, Comparator.comparingInt(Rental.Rental::getContractNumber));
                        break;
                    case 2:
                        Arrays.sort(rentals, Comparator.comparingDouble(Rental.Rental::getPrice));
                        break;
                    case 3:
                        Arrays.sort(rentals, Comparator.comparing(Rental.Rental::getEquipmentTypeString));
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        continue;
                }

                System.out.println("Sorted Rentals:");
                for (Rental.Rental rental : rentals) {
                    System.out.println(rental);
                }
            }
            scanner.close();
        }

        public static void setArrays(ArrayList arrays) {
            Arrays = arrays;
        }
    }

}

