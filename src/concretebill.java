import java.util.HashMap;
import java.util.List;

public class concretebill {

    public int billnumber;

    private firesingleton fireinst;
    private securitysingleton securityinst;

    public concretebill(int billnumber)
    {
        this.billnumber = billnumber;
        //calling firesingleton and securitysingleton objects
        this.fireinst = firesingleton.getinstance(billnumber);
        this.securityinst = securitysingleton.getinstance(billnumber);
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

