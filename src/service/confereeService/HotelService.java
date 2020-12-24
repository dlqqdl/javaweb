package service.confereeService;

import vo.confereeVo.Hotel;
import vo.confereeVo.User;

public interface HotelService {
    /**
     * 查询当前用户所入住酒店
     * @param user
     * @return
     */
    public Hotel viewMyHotelInfo(User user);

    /**
     * 预定酒店
     * @param hotel
     * @param user
     */
    public void bookHotel(Hotel hotel,User user);

}
