package vn.projectLTW.service.Impl;

import vn.projectLTW.Dao.ILogDao;
import vn.projectLTW.Dao.Impl.LogDaoImpl;
import vn.projectLTW.model.Log;
import vn.projectLTW.service.ILogService;

public class LogServiceImpl implements ILogService {

    ILogDao logDao=new LogDaoImpl();
    @Override
    public void insert(Log log) {
        logDao.insert(log);
    }
}
