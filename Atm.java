import java.util.*;
class Atm{
    static List<Integer> trans = new ArrayList<>();
    public static int withdraw(int draw, int amount){
      if(draw > amount){
          System.out.println("Insufficient money");
      }
      else if(draw <= 0){
          System.out.println("Recheck the amount you want to withdraw");
      }
      else{
          amount -= draw;
          trans.add(draw);
      }
      return amount;
    }
    public static void money_tranc() {
        if(!trans.isEmpty()) {
            int i = 1;
            for (Integer val : trans) {
                System.out.println("Transaction " + i +" : "+ val);
                i++;
            }
        }
        else{
            System.out.println("No transactions happpened");
        }
    }
    public static void password_change(int new_password, int confirm_password,List<Integer> pins,int index){
        if(new_password == confirm_password) {
            pins.set(index,new_password);
            System.out.println("Your password has been updated");
        }
        else{
            System.out.println("Your password doesn't match");
            System.out.println("Try again");
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Atm");
        boolean quit = false;
        List<Integer> accounts = new ArrayList<>();
        accounts.add(112233);
        accounts.add(223344);
        accounts.add(445566);
        accounts.add(667788);
        List<Integer> pins = new ArrayList<>();
        pins.add(1234);
        pins.add(2345);
        pins.add(3456);
        pins.add(4567);
        List<Integer> amounts = new ArrayList<>();
        amounts.add(3000);
        amounts.add(5000);
        amounts.add(4000);
        amounts.add(90000);

        System.out.println("Enter your Account number:");
        int acc_num = sc.nextInt();
        System.out.println("Enter your Pin:");
        int pin = sc.nextInt();
        int amount = 0;
        int index = 0;
        if(accounts.contains(acc_num)){
            index = accounts.indexOf(acc_num);
            if(pins.get(index) == pin){
                amount = amounts.get(index);
            }
            else{
                System.out.println("Incorrect password...");
                System.out.println("Please check your password");
                quit = true;
            }
        }
        else{
            System.out.println("Invalid Data... ");
            System.out.println("Please try again Later");
            quit = true;
        }
        while(!quit){
            System.out.println("MENU :");
            System.out.println("1.Balance");
            System.out.println("2.Withdraw");
            System.out.println("3.Transaction");
            System.out.println("4.Change password");
            System.out.println("5.Quit");
            System.out.println("\n");
            System.out.println("Please select an option");
            int option = sc.nextInt();

            switch(option){
                case 1:
                    System.out.println("Your current balance is : " + amount);
                    break;
                case 2:
                    System.out.println("Enter the money you want to withdraw");
                    int draw = sc.nextInt();
                    System.out.println("Money withdraw :" + draw);
                    amount = Atm.withdraw(draw,amount);
                    amounts.set(index , amount);
                    break;
                case 3:
                    System.out.println("Transactions are");
                    Atm.money_tranc();
                    break;
                case 4:
                    System.out.println("Enter your new password");
                    int new_password = sc.nextInt();
                    System.out.println("Confirm your new password");
                    int confirm_password = sc.nextInt();
                    password_change(new_password,confirm_password,pins,index);
                    break;
                case 5:
                    System.out.println("Thank you for using our service");
                    System.out.println("Have a great day");
                    quit = true;
                    break;
                default:
                    System.out.println("Check your option again");
                    break;
            }
        }
    }
}
