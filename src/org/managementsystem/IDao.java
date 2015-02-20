package org.managementsystem;

import java.util.List;

public interface IDao<T> {
	public List<T> getDataList();

	public void setData(T t);

	public void updateData(T t);

	public void deleteData(T t);
}
