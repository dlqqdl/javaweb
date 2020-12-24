package service.organService;

import dao.organDao.impl.RemoveConfereeDaoImpl;
import dao.organDao.test.RemoveConfereeDao;

public class RemoveConfereeService {
    public int removeConferee(int meetid){
        RemoveConfereeDao removeConfereeDao=new RemoveConfereeDaoImpl();
        int i = removeConfereeDao.removeConferee(meetid);
        return i;
    }
}
