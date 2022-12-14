import java.util.HashMap;
import java.util.List;

public class ConcreteBill {

    public int billnumber;

    private FireBill fireinst;
    private SecurityBill securityinst;

    public ConcreteBill(int billnumber)
    {
        this.billnumber = billnumber;
        //calling firesingleton and securitysingleton objects
        this.fireinst = FireBill.getinstance(billnumber);
        this.securityinst = SecurityBill.getinstance(billnumber);
    }

    public long get_fire_bill(List<Room> fireroom, List<HashMap<String, Integer>> perroomprice)
    {
        long totalfireamt = this.fireinst.getfireserviceamount(fireroom, perroomprice);
        return totalfireamt;

    }
    public long get_security_bill(List<Room> securityroom, List<HashMap<String, Integer>> perroomprice)
    {
        long totalsecurityamt = this.securityinst.getsecurityserviceamount(securityroom, perroomprice);
        return totalsecurityamt;

    }

}

