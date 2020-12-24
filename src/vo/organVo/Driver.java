package vo.organVo;

/**
 * @Author ExilePluto
 * @Date 2020/12/21
 */
public class Driver {
    private int driverid;
    private int telephone;
    private String name;
    private String password;
    private int dflag;

    public Driver(int driverid, int telephone, String name, String password, int dflag) {
        this.driverid = driverid;
        this.telephone = telephone;
        this.name = name;
        this.password = password;
        this.dflag = dflag;
    }

    public Driver(int driverid, int telephone, String name) {
        this.driverid = driverid;
        this.telephone = telephone;
        this.name = name;
    }

    public Driver() {
    }

    public int getDriverid() {
        return driverid;
    }

    public void setDriverid(int driverid) {
        this.driverid = driverid;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getDflag() {
        return dflag;
    }

    public void setDflag(int dflag) {
        this.dflag = dflag;
    }
}
