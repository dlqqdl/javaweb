package service.organService;


import vo.organVo.DriverPick;

import java.util.List;

public interface ConfereeService {
    List<DriverPick> driverPick(int  flag,int organID);
}
