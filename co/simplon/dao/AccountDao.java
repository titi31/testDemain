package co.simplon.dao;

import co.simplon.entities.Accounts;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class AccountDao extends Dao<Accounts> {
	@Override
	public Accounts find(int id) {
		String str = "select * from T_Account where NumCpte=?";
		PreparedStatement ps;
		Accounts Account = null;
		try {
			ps = connection.prepareStatement(str);
			ps.setInt(1,id);
			ResultSet resultSet = ps.executeQuery();
			if(resultSet.next()){
				Account= new Accounts(resultSet.getInt(1),resultSet.getDouble(2),resultSet.getInt(3),resultSet.getDate(4));
			}
		} catch (SQLException e) {
			System.out.println("not exist");
			//e.printStackTrace();
		}		
		return Account;
	}

	@Override
	public boolean create(Accounts obj) {
		String str = "INSERT INTO T_Account (NumCt,Balance,IdCust) VALUES (?, ? ,? );";
		PreparedStatement ps;
		boolean ok = false;
		try {
			ps = connection.prepareStatement(str);
			ps.setInt(1, obj.getNumCt());
			ps.setDate(2, (java.sql.Date)obj.getDateCreation());
			ps.setDouble(2,obj.getBalance());
			ps.setInt(3,obj.getIdCust());
			ps.executeQuery();
			ok = true;
		} catch (SQLException e) {
			System.out.println("exist");
			//e.printStackTrace();
		}
		return ok;
	}

	@Override
	public boolean update(Accounts obj) {		
		String str = " update T_Account set Balance=? where IdCust=?;";		
		PreparedStatement ps;
		boolean ok = false;
		try {
			ps = connection.prepareStatement(str);
			ps.setDouble(1,obj.getBalance());
			ps.setInt(2,obj.getNumCt());
			int row = ps.executeUpdate();
			if(row > 0)	ok = true;			
		} catch (SQLException e) {
			System.out.println("not exist");
			//e.printStackTrace();
		}		
		return ok;
	}

	@Override
	public boolean delete(Accounts obj) {
		String str = "delete from T_Account where NumCpte=?;";	
		PreparedStatement ps;
		boolean ok = false;
		try {
			ps = connection.prepareStatement(str);
			ps.setInt(1,obj.getNumCt());
			int row = ps.executeUpdate();
			if(row > 0)	ok = true;
		} catch (SQLException e) {
			System.out.println("no exists");
			//	e.printStackTrace();
		}
		return ok;
	}
}