package dao.administratorDao;

import vo.administratorVo.Hotel;

import java.util.List;

public interface hotelDao {
    /**
     * 在数据库中增加一个酒店
     * @param
     * @return
     */
    public boolean deleteOneHotel(int id,String name);

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

    /**
     * @param hotelName
     * @return
     */
    public List<Hotel> searchHotel(String hotelName);
}
