package service.administratorService;

import dao.administratorDao.impl.hotelDaoImpl;
import vo.administratorVo.Hotel;

import java.util.List;

public class hotelService {
    private hotelDaoImpl hotelService=new hotelDaoImpl();
    public List<Hotel> showAllHotel(){return hotelService.showAllHotel();}
    public List<Hotel> searchHotel(String hotelName){return hotelService.searchHotel(hotelName);}
    public boolean addOneHotel(Hotel hotel){return hotelService.addOneHotel(hotel);}
    public boolean deleteHotel(int id,String name){return hotelService.deleteOneHotel(id,name);}
}
