package impl;

import java.sql.*;
import transaction.Transaction;
import util.JDBCUtil;

public class TransactionImpl implements Transaction {
	Connection conn=JDBCUtil.getConnection();
	@Override
	public void startTransaction() throws SQLException {
		// TODO Auto-generated method stub
		conn.setAutoCommit(false);
	}

	@Override
	public void commit() throws SQLException {
		// TODO Auto-generated method stub
		conn.commit();
		JDBCUtil.close(null, null, conn);
	}

	@Override
	public void rollback() throws SQLException {
		// TODO Auto-generated method stub
		conn.rollback();
		JDBCUtil.close(null, null, conn);
	}

}
