package service.confereeService.impl;

import dao.confereeDao.impl.HotelDaoImpl;
import service.confereeService.HotelService;
import vo.confereeVo.Hotel;
import vo.confereeVo.User;

public class HotelServiceImpl implements HotelService {

    @Override
    public Hotel viewMyHotelInfo(User user) {
        HotelDaoImpl hotelDao=new HotelDaoImpl();
        Hotel hotel = hotelDao.QueryAllHotelsByUserAndPassword(user);
        return hotel;
    }

    @Override
    public void bookHotel(Hotel hotel, User user) {
        HotelDaoImpl hotelDao=new HotelDaoImpl();
        hotelDao.Insert(hotel,user);
    }
}
