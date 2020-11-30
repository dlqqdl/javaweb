package vo;

/**
 * 酒店实体类
 */
public class Hotel {
    private int hotel_id;//酒店id
    private String hotel_name;//酒店名称
    private String address;//酒店地址
    private int tel;//酒店电话
    private int rooms;//酒店剩余房间

    public Hotel() {
    }

    public Hotel(int hotel_id, String hotel_name, String address, int tel, int rooms) {
        this.hotel_id = hotel_id;
        this.hotel_name = hotel_name;
        this.address = address;
        this.tel = tel;
        this.rooms = rooms;
    }

    public int getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(int hotel_id) {
        this.hotel_id = hotel_id;
    }

    public String getHotel_name() {
        return hotel_name;
    }

    public void setHotel_name(String hotel_name) {
        this.hotel_name = hotel_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }
}
