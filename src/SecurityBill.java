import java.util.HashMap;
import java.util.List;

public class SecurityBill {

    private static SecurityBill instancecopy;

    private int billnumber;
    private long securityservicebillamount;

    private SecurityBill(int billnumber)
    {
        this.billnumber = billnumber;
        System.out.println("*****bill number is "+this.billnumber);

    }

    public static SecurityBill getinstance(int billnumber)
    {
        if (instancecopy == null)
        {
            instancecopy = new SecurityBill(billnumber);
        }
        return instancecopy;
    }

    public long getsecurityserviceamount(List<Room> securityroom, List<HashMap<String, Integer>> perroomprice)
    {
        if (securityroom.size() >0)
        {
            System.out.println("room 0 id is "+securityroom.get(0).getId());

            BillStrategy bswithcamera = new ConcreteSecurityStrategy();
            long billwithcamera = bswithcamera.generatebill(securityroom, perroomprice);

            BillStrategy bswithoutcamera = new ConcreteSecurityWithoutCameraStrategy();
            long billwithoutcamera = bswithoutcamera.generatebill(securityroom, perroomprice);

            this.securityservicebillamount = billwithcamera + billwithoutcamera;
            return this.securityservicebillamount;
        }
        return this.securityservicebillamount;
    }

}
