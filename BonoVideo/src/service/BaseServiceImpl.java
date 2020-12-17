package service;

import dao.BaseDao;
import java.util.List;


























public class BaseServiceImpl
implements BaseService
{
	private BaseDao baseDao;

	public void save(Object object) { this.baseDao.save(object); }




	public void update(Object object) { this.baseDao.update(object); }




	public void delete(Object object) { this.baseDao.delete(object); }




	public Object ReadByID(String targetName, int id) { return this.baseDao.ReadSingle(targetName, "id", Integer.valueOf(id)); }





	public List ReadAll(String targetName) { return this.baseDao.ReadAll(targetName); }



	public BaseDao getBaseDao() { return this.baseDao; }



	public void setBaseDao(BaseDao baseDao) { this.baseDao = baseDao; }





	public List ReadByProperty(String targetName, String propertyName, Object propertyValue) { return this.baseDao.ReadByProperty(targetName, propertyName, propertyValue); }





	public Object ReadSingle(String targetName, String propertyName, Object propertyValue) { return this.baseDao.ReadSingle(targetName, propertyName, propertyValue); }




	public List ReadLimitedByOrder(String targetName, String propertyName, int num, String order) { return this.baseDao.ReadLimitedByOrder(targetName, propertyName, num, order); }




	public int ReadCount(String targetName) { return this.baseDao.ReadCount(targetName).intValue(); }




	public int ReadCountByProperty(String targetName, String propertyName, Object value) { return this.baseDao.ReadCountByProperty(targetName, propertyName, value).intValue(); }




	public List ReadByPropertyAndLimitedByOrder(String targetName, String readpropertyName, Object readvalue, String orderpropertyName, int num, String order) {
		return this.baseDao.ReadByPropertyAndLimitedByOrder(targetName, readpropertyName, readvalue, 
				orderpropertyName, num, order);
	}
}


