package dao;

import vo.Hotel;

import java.util.List;

public interface hotelDao {
    /**
     * 在数据库中增加一个酒店
     * @param hotel
     * @return
     */
    public boolean deleteOneHotel(Hotel hotel);

    /**
     * 在数据库中删除该酒店信息
     * @param hotel
     * @return
     */
    public boolean addOneHotel(Hotel hotel);

    /**
     * 查看所有的合作酒店
     * @return
     */
    public List<Hotel> showAllHotel();
}
