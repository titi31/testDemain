package co.simplon.dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import co.simplon.entities.Accounts;
import co.simplon.entities.User;
public class UserDao extends Dao<User> {
	@Override
	public User find(int id) {
		String str = "select * from T_Users where Idcust=? AND nameUser=? AND passwordUser=?";
		PreparedStatement ps;
		User user = null;
		try {
			ps = connection.prepareStatement(str);
			ps.setInt(1,id);
			ps.setString(2, user.getNameUser());
			ps.setString(3, user.getPasswordUser());
			ResultSet resultSet = ps.executeQuery();
			if(resultSet.next()){
				user= new User(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3));
			}
		} catch (SQLException e) {
			System.out.println("not exist");
			//e.printStackTrace();
		}		
		return user;
	}

	@Override
	public boolean create(User obj) {
		String str = "INSERT INTO T_Users (IdCust,nameUser,passwordUser) VALUES (?, ? ,? );";
		PreparedStatement ps;
		boolean ok = false;
		try {
			ps = connection.prepareStatement(str);
			ps.setInt(1, obj.getIdCust());
			ps.setString(2,obj.getNameUser());
			ps.setString(3,obj.getPasswordUser());
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
	public boolean update(User obj) {		
		String str = " update T_Users set passwordUser=? where IdCust=?;";		
		PreparedStatement ps;
		boolean ok = false;
		try {
			ps = connection.prepareStatement(str);
			ps.setString(1,obj.getPasswordUser());
			ps.setInt(2,obj.getIdCust());
			int row = ps.executeUpdate();
			if(row > 0)	ok = true;			
		} catch (SQLException e) {
			System.out.println("not exist");
			//e.printStackTrace();
		}		
		return ok;
	}

	@Override
	public boolean delete(User obj) {
		String str = "delete from T_Users where IdCust=?;";	
		PreparedStatement ps;
		boolean ok = false;
		try {
			ps = connection.prepareStatement(str);
			ps.setInt(1,obj.getIdCust());
			int row = ps.executeUpdate();
			if(row > 0)	ok = true;
		} catch (SQLException e) {
			System.out.println("no exists");
			//	e.printStackTrace();
		}
		return ok;
	}

}
