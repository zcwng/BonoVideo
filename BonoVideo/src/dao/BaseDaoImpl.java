package dao;

import java.sql.SQLException;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;



























public class BaseDaoImpl
extends HibernateDaoSupport
implements BaseDao
{
	public void save(Object object) { getHibernateTemplate().save(object); }



	public void delete(Object object) { getHibernateTemplate().delete(object); }



	public void update(Object object) { getHibernateTemplate().update(object); }



	public Object ReadSingle(final String targetName, final String propertyName, final Object value) {
		return getHibernateTemplate().execute(new HibernateCallback<Object>()
		{
			public Object doInHibernate(Session session) throws HibernateException, SQLException
			{
				String hql = "from " + targetName + " as " + targetName + " where " + targetName + "." + propertyName + "=:value";
				Query query = session.createQuery(hql);
				query.setParameter("value", value);
				return query.uniqueResult();
			}
		});
	}



	public List<Object> ReadAll(String targetName) {
		String hql = "from " + targetName;
		return getHibernateTemplate().find(hql);
	}




	public List<Object> ReadByProperty(final String targetName, final String propertyName, final Object value) {
		return (List<Object>)getHibernateTemplate().execute(new HibernateCallback<Object>()
		{
			public Object doInHibernate(Session session) throws HibernateException, SQLException
			{
				String hql = "from " + targetName + " as " + targetName + " where " + targetName + "." + propertyName + "=:value";
				Query query = session.createQuery(hql);
				query.setParameter("value", value);
				return query.list();
			}
		});
	}




	public List<Object> ReadByPropertyList(String targetName, String propertyName, Object value) { return null; }






	public Integer ReadCount(final String targetName) {
		return (Integer)getHibernateTemplate().execute(new HibernateCallback<Object>()
		{
			public Object doInHibernate(Session session) throws HibernateException, SQLException
			{
				String hql = "select count(*) from " + targetName;


				return Integer.valueOf(((Number)session.createQuery(hql).iterate().next()).intValue());
			}
		});
	}


	public Integer ReadCountByProperty(final String targetName, final String propertyName, final Object value) {
		return (Integer)getHibernateTemplate().execute(new HibernateCallback<Object>()
		{
			public Object doInHibernate(Session session) throws HibernateException, SQLException
			{
				String hql = "select count(*) from " + targetName + " as " + targetName + " where " + targetName + "." + propertyName + "=:value";

				Query query = session.createQuery(hql);
				query.setParameter("value", value);


				return Integer.valueOf(((Number)query.iterate().next()).intValue());
			}
		});
	}




	public List<Object> ReadLimitedByOrder(final String targetName, final String propertyName, final int num, final String order) {
		return (List<Object>)getHibernateTemplate().execute(new HibernateCallback<Object>()
		{
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				String hql = "from " + targetName + " as " + targetName + " order by " + targetName + "." + propertyName + " " + order;
				Query query = session.createQuery(hql);
				query.setMaxResults(num);

				return query.list();
			}
		});
	}




	public List<Object> ReadByPropertyAndLimitedByOrder(final String targetName, final String readpropertyName, final Object readvalue, final String orderpropertyName, final int num, final String order) {
		return (List<Object>)getHibernateTemplate().execute(new HibernateCallback<Object>()
		{
			public Object doInHibernate(Session session) throws HibernateException, SQLException
			{
				String hql = "from " + targetName + " as " + targetName + " where " + targetName + "." + readpropertyName + "=:value" + 
						" order by " + targetName + "." + orderpropertyName + " " + order;
				Query query = session.createQuery(hql);
				query.setParameter("value", readvalue);
				query.setMaxResults(num);
				return query.list();
			}
		});
	}
}


