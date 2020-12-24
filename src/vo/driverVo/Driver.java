package vo.driverVo;

public class Driver {
//    driver_id            int not null,
//    telephone            int,
//    name                 varchar(45),
//    password             varchar(45),
    private int driver_id;
    private int telephone;
    private String name;
    private String password;
    private int dflag;

    public int getDflag() {
        return dflag;
    }

    public void setDflag(int dflag) {
        this.dflag = dflag;
    }

    public Driver(int driver_id, String password) {
        this.driver_id = driver_id;
        this.password = password;
    }

    public Driver() {
    }

    public int getDriver_id() {
        return driver_id;
    }

    public void setDriver_id(int driver_id) {
        this.driver_id = driver_id;
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
}
