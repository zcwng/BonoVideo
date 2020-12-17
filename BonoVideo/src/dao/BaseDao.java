package dao;

import java.util.List;

public interface BaseDao {
	void save(Object paramObject);

	void update(Object paramObject);

	void delete(Object paramObject);

	Object ReadSingle(String paramString1, String paramString2, Object paramObject);

	List<Object> ReadByProperty(String paramString1, String paramString2, Object paramObject);

	List<Object> ReadAll(String paramString);

	List<Object> ReadByPropertyList(String paramString1, String paramString2, Object paramObject);

	Integer ReadCount(String paramString);

	Integer ReadCountByProperty(String paramString1, String paramString2, Object paramObject);

	List<Object> ReadLimitedByOrder(String paramString1, String paramString2, int paramInt, String paramString3);

	List<Object> ReadByPropertyAndLimitedByOrder(String paramString1, String paramString2, Object paramObject, String paramString3, int paramInt, String paramString4);
}

