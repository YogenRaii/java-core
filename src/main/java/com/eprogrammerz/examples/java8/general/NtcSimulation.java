/*
package abstractClass.assignment;

import java.util.Scanner;

*/
/**
 * Created by Usha Adhikari on 2016-11-21.
 *//*

public class NtcSimulation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (input.equals("1415")) {
//            this must be removed because you can not instantiate abstract class; here CustomerService is abstract
//            CustomerService customerService = new CustomerService();
            new NtcSimulation().callCustomerService();
        }

    }

    public void callCustomerService() {

        //to make use of polymorphism, we will keep reference of parent ie CustomerService
        CustomerService customerService = null;

        System.out.println("Please dial 1 for English and 2 for Nepali: ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        if (choice == 1) {
            //now if user wants service in english language, then create CustomerServiceInEnglish object
            customerService = new CustomerServiceInEnglish();
//            CustomerServiceInEnglish customerServiceInEnglish = new CustomerServiceInEnglish();
//            customerServiceInEnglish.processInEnglish();
        } else if (choice == 2) {
            //now if user wants service in english language, then create CustomerServiceInEnglish object
            customerService = new CustomerServiceInNepali();
//            CustomerServiceInNepali customerServiceInNepali = new CustomerServiceInNepali();
//            customerServiceInNepali.processInNepali();
        } else {
            callCustomerService();
        }
        //if input is any of 1 or 2, call requestProcess()
        customerService.processRequest();
    }


}
*/
