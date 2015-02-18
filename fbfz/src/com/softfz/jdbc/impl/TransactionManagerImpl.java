package com.softfz.jdbc.impl;

import java.sql.SQLException;

import com.softfz.jdbc.TransactionManager;

public class TransactionManagerImpl implements TransactionManager {

	public void beginTransaction(){
		DataSourceHandler.beginTransaction();
	}

	public void commit() {
		DataSourceHandler.commit();
	}

	public void rollback() {
		DataSourceHandler.rollback();
	}

	public void endTransaction() {
		DataSourceHandler.endTransaction();
	}

}
