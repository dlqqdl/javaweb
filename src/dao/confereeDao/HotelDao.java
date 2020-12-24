package dao.confereeDao;

import vo.confereeVo.Hotel;
import vo.confereeVo.User;

import java.util.List;

public interface HotelDao {
    /**
     * 查询某员工预定的酒店及信息
     * @param user
     * @return
     */
    public Hotel QueryAllHotelsByUserAndPassword(User user);

    /**
     * 显示所有酒店
     * @return
     */
    public List<Hotel> ShowAllHotels();

    /**
     * 获取酒店对象
     * @param hotelId
     * @return
     */
    public Hotel GetHotel(int hotelId);

    /**
     * 预定酒店
     * @param hotel
     * @param user
     */
    public void Insert(Hotel hotel,User user);
}
