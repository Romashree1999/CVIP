import java.util.HashMap;
import java.util.Map;
public class AtmOpertnImpl implements AtmOpertnInterface {
    AtmMachine atm=new AtmMachine();
    Map<Double,String> MiniStatement=new HashMap<>();
    @Override
    public void viewBalance(){
        System.out.println("Available Balance is:"+ atm.getBalance());
    }

    @Override
    public void WithdrawAmount(double WithdrawAmount){
        if(WithdrawAmount <= atm.getBalance()){
            MiniStatement.put(WithdrawAmount, " Amount Withdrawn");
            System.out.println("Collect the Cash:"+WithdrawAmount);
            atm.setBalance(atm.getBalance()-WithdrawAmount);
            viewBalance();
        }
        else{
            System.out.println("Ooo..U have Insufficient Balance");
        }
        
    }

    @Override
    public void DepositAmount(double DepositAmount){
        MiniStatement.put(DepositAmount, " Amount Deposited");
        System.out.println(DepositAmount+" Deposited Successfully!");
        atm.setBalance(atm.getBalance()+DepositAmount);
        viewBalance();
    }

    @Override
    public void ViewMiniStatement(){
        for(Map.Entry<Double,String> m:MiniStatement.entrySet()){
            System.out.println(m.getKey()+""+m.getValue());
        }

    }
}
