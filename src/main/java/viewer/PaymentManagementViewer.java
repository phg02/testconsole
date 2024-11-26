package viewer;

import controller.impl.PaymentManagerImpl;
import model.Payment;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.time.ZoneId;
import java.util.Scanner;

public class PaymentManagementViewer {
    private final PaymentManagerImpl paymentManager;
    private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public PaymentManagementViewer(PaymentManagerImpl paymentManager) {
        this.paymentManager = paymentManager;
    }

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

    public void paymentViewerManager(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("You have chosen to check the payment dashboard.");
        boolean exitPayment = false;
        try{
            while (!exitPayment) {
                printPaymentManagementMenu();
                int choicePayment = scanner.nextInt();
                scanner.nextLine();
                switch (choicePayment) {
                    case 1:
                        System.out.println("Add Payment");
                        break;
                    case 2:
                        System.out.println("Update Payment");
                        break;
                    case 3:
                        System.out.println("Delete Payment");
                        break;
                    case 4:
                        System.out.println("View All Payments");
                        printAllPayments();
                        break;
                    case 5:
                        System.out.println("Search Payment by ID");
                        String id = scanner.nextLine();
                        printPaymentByID(id);
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

    public void printAllPayments(){
        printTable(paymentManager.getAllPayments());
    }

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