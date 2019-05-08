package transaction.impl;

import java.sql.*;

import transaction.Transaction;
import util.JDBCUtil;

public class TransactionImpl implements Transaction{
	JDBCUtil jdbcUtil=new JDBCUtil();
	Connection connection=JDBCUtil.getConnection();
	@Override
	public void startTransaction() throws SQLException {
		// TODO Auto-generated method stub
		connection.setAutoCommit(false);
	}

	@Override
	public void commit() throws SQLException {
		// TODO Auto-generated method stub
		connection.commit();
		JDBCUtil.close(null, null, connection);
	}

	@Override
	public void rollback() throws SQLException {
		// TODO Auto-generated method stub
		connection.rollback();
		JDBCUtil.close(null, null, connection);
	}

}
