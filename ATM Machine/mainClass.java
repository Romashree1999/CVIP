

import java.util.Scanner;

public class mainClass {
    public static void main(String[] args) {
        AtmOpertnInterface op= new AtmOpertnImpl();
        int atmNumber =24680;
        int atmPin =123;
        Scanner sc=new Scanner(System.in);
        System.out.println("Welcome to ATM Machine!!!");
        System.out.print("Enter ATM Number: ");
        int ATMNumber=sc.nextInt();
        System.out.print("Enter Pin: ");
        int pin=sc.nextInt();
        if((atmNumber==ATMNumber)&& (atmPin==pin)){
            while (true) {
                System.out.println("1.View Available Balance\n2.Withdraw Amount\n3.Deposit Amount\n4.View MiniStatement\n5.Exit");
                System.out.println("Enter your choice: ");
                int ch=sc.nextInt();
                if(ch==1){
                    op.viewBalance();
                   
                }
                else if(ch==2){
                    System.out.println("Enter amount to withdraw:");
                    double WithdrawAmount=sc.nextDouble();
                    op.WithdrawAmount(WithdrawAmount);
                }
                else if(ch==3){
                    System.out.println("Enter Amount deposit: ");
                    double DepositAmount=sc.nextDouble();
                    op.DepositAmount(DepositAmount);
                }
                else if(ch==4){
                    op.ViewMiniStatement();
                }
                else if(ch==5){
                    System.out.println("Collect your ATM Card\n Thank You for using ATM Machine");
                    System.exit(0);
                }
                else{
                    System.out.println("Please Enter Correct Choice!");
                }
            }
            
        }
        else{
            System.out.println("Incorrect ATM number or Pin");
            System.exit(0);
        }
    }
}
