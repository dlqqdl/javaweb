package vo.administratorVo;

/**
 * 会议组织者
 */
public class Organizer {
    private int organ_id;
    private String organ_name;
    private int telephone;
    private String password;

    public Organizer() {
    }

    public Organizer(int organ_id, String organ_name, int telephone, String password) {
        this.organ_id = organ_id;
        this.organ_name = organ_name;
        this.telephone = telephone;
        this.password = password;
    }

    public int getOrgan_id() {
        return organ_id;
    }

    public void setOrgan_id(int organ_id) {
        this.organ_id = organ_id;
    }

    public String getOrgan_name() {
        return organ_name;
    }

    public void setOrgan_name(String organ_name) {
        this.organ_name = organ_name;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
