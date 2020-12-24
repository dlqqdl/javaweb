package vo.organVo;

public class Organ {
    private Integer organ_id;
    private String org_name;
    private Integer telephone;
    private String password;

    public Organ() {
    }

    public Organ(String org_name, String password) {
        this.org_name = org_name;
        this.password = password;
    }

    public Organ(Integer organ_id, String org_name, Integer telephone, String password) {
        this.organ_id = organ_id;
        this.org_name = org_name;
        this.telephone = telephone;
        this.password = password;
    }

    public Integer getOrgan_id() {
        return organ_id;
    }

    public void setOrgan_id(Integer organ_id) {
        this.organ_id = organ_id;
    }

    public String getOrg_name() {
        return org_name;
    }

    public void setOrg_name(String org_name) {
        this.org_name = org_name;
    }

    public Integer getTelephone() {
        return telephone;
    }

    public void setTelephone(Integer telephone) {
        this.telephone = telephone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
