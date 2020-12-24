package service.administratorService;

import dao.administratorDao.impl.organizerDaoImpl;
import vo.administratorVo.Organizer;

import java.util.List;

public class organizerService {
   private organizerDaoImpl service=new organizerDaoImpl();
    public boolean deleteOneOrganizer(int id){return service.deleteOrganizer(id);}
    public boolean addOneOrganizer(Organizer organizer){return service.addOneOrganizer(organizer);}
    public List<Organizer> showOrganizer(int id){return service.showOrganizer(id);}
    public List<Organizer> showAllOrganizer(){return service.showAllOrganizer();}
}
