package impl;

import java.sql.*;

import objectFactory.ObjectFactory;
import transaction.Transaction;
import util.JDBCUtil;

public class TransactionImpl implements Transaction {
	JDBCUtil jdbcUtil = (JDBCUtil) ObjectFactory.getoObject("JDBCUtil");

	@Override
	public void startTransaction() throws SQLException {
		// TODO Auto-generated method stub
		jdbcUtil.getConnection().setAutoCommit(false);
	}

	@Override
	public void commit() throws SQLException {
		// TODO Auto-generated method stub
		jdbcUtil.getConnection().commit();
		jdbcUtil.close(null, null, jdbcUtil.getConnection());
	}

	@Override
	public void rollback() throws SQLException {
		// TODO Auto-generated method stub
		jdbcUtil.getConnection().rollback();
		jdbcUtil.close(null, null, jdbcUtil.getConnection());
	}

}
