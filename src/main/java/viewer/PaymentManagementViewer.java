package viewer;
/*
  @author <Nguyen Minh Phuong - s4063236>
 */

import controller.impl.PaymentManagerImpl;
import model.Payment;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.time.ZoneId;
import java.util.Scanner;

/**
 * Viewer class for managing payments.
 * Provides methods to display and interact with payment data.
 */
public class PaymentManagementViewer {
    private final PaymentManagerImpl paymentManager;
    private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    /**
     * Constructor to initialize the payment manager.
     *
     * @param paymentManager The payment manager implementation.
     */
    public PaymentManagementViewer(PaymentManagerImpl paymentManager) {
        this.paymentManager = paymentManager;
    }

    /**
     * Prints the payment management menu options to the console.
     */
    public void printPaymentManagementMenu(){
        System.out.println("==========================================");
        System.out.println("|           Payment Management           |");
        System.out.println("==========================================");
        System.out.println("|  1. Add Payment                        |");
        System.out.println("|  2. Update Payment                     |");
        System.out.println("|  3. Delete Payment                     |");
        System.out.println("|  4. View All Payments                  |");
        System.out.println("|  5. Search Payment by ID               |");
        System.out.println("|  6. Exit                               |");
        System.out.println("==========================================");
        System.out.println("Enter your choice: ");
    }

    /**
     * Manages the payment viewer operations based on user input.
     */
    public void paymentViewerManager(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Payment Management");
        boolean exitPayment = false;
        try{
            while (!exitPayment) {
                printPaymentManagementMenu();
                int choicePayment = scanner.nextInt();
                scanner.nextLine();
                switch (choicePayment) {
                    case 1:
                        System.out.println("Add Payment");
                        System.out.println("Functionality not implemented yet due to assignment requirements.");
                        break;
                    case 2:
                        System.out.println("Update Payment");
                        System.out.println("Functionality not implemented yet due to assignment requirements.");
                        break;
                    case 3:
                        System.out.println("Delete Payment");
                        System.out.println("Functionality not implemented yet due to assignment requirements.");
                        break;
                    case 4:
                        System.out.println("View All Payments");
                        printAllPayments();
                        System.out.println("Press Enter to continue...");
                        scanner.nextLine();
                        break;
                    case 5:
                        System.out.println("Search Payment by ID");
                        String id = scanner.nextLine();
                        printPaymentByID(id);
                        System.out.println("Press Enter to continue...");
                        scanner.nextLine();
                        break;
                    case 6:
                        System.out.println("Exiting Payment Management");
                        exitPayment = true;
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            }
        }catch (Exception e){
            System.out.println("Invalid input. Please try again.");
        }
    }

    /**
     * Prints all payments in a tabular format.
     */
    public void printAllPayments(){
        printTable(paymentManager.getAllPayments());
    }

    /**
     * Prints a payment by its ID.
     *
     * @param id The ID of the payment.
     */
    public void printPaymentByID(String id){
        Payment payment = paymentManager.getPaymentByID(id);
        if(payment != null) {
            HashSet<Payment> payments = new HashSet<>();
            payments.add(payment);
            printTable(payments);
        }
        else{
            System.out.println("Payment not found");
        }
    }

    /**
     * Prints a table of payments with their details.
     *
     * @param payments The set of payments to be printed.
     */
    public void printTable(HashSet<Payment> payments) {
        System.out.println("---------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-10s | %-20s | %-20s | %-15s | %-30s |\n",
                "Payment ID", "Tenant", "Amount", "Date", "Method");
        System.out.println("---------------------------------------------------------------------------------------------------------------");
        for (Payment payment : payments) {
            System.out.printf("| %-10s | %-20s | %-20s | %-15s | %-30s |\n",
                    payment.getId(), payment.getTenant().getFullName(), payment.getAmount(), dtf.format(payment.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime()),
                    payment.getPaymentMethod());
        }
        System.out.println("---------------------------------------------------------------------------------------------------------------");
    }
}