package com.softfz.jdbc;

public interface TransactionManager {
	public void beginTransaction();

	public void commit();

	public void rollback();

	public void endTransaction();
}
