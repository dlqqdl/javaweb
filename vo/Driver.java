package vo;

/**
 * 司机实体类
 */
public class Driver {
    private int driver_id;//司机id
    private String name;//司机名称
    private String password;//司机登录密码
    private int telephone;//司机联系电话

    public Driver() {
    }

    public Driver(int driver_id,int telephone,String name, String password) {
        this.driver_id = driver_id;
        this.telephone = telephone;
        this.name = name;
        this.password = password;
    }

    public int getDriver_id() {
        return driver_id;
    }

    public void setDriver_id(int driver_id) {
        this.driver_id = driver_id;
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

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }
}
