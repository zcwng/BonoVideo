package service;

import java.util.List;

public interface BaseService {
	void save(Object paramObject);

	void update(Object paramObject);

	void delete(Object paramObject);

	Object ReadByID(String paramString, int paramInt);

	List ReadAll(String paramString);

	List ReadByProperty(String paramString1, String paramString2, Object paramObject);

	Object ReadSingle(String paramString1, String paramString2, Object paramObject);

	List ReadLimitedByOrder(String paramString1, String paramString2, int paramInt, String paramString3);

	int ReadCount(String paramString);

	int ReadCountByProperty(String paramString1, String paramString2, Object paramObject);

	List ReadByPropertyAndLimitedByOrder(String paramString1, String paramString2, Object paramObject, String paramString3, int paramInt, String paramString4);
}
