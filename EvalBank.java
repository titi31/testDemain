import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
//import java.beans.Statement;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class EvalBank {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		
				final Properties prop = new Properties();
				InputStream input = null;

				try {

					input = new FileInputStream("src/config.properties");

					// load a properties file
					prop.load(input);

					// get the property value and print it out
					Class.forName(prop.getProperty("db.driver")); System.out.println("Driver O.K.");
					Connection conn = DriverManager.getConnection(prop.getProperty("db.url"), prop.getProperty("db.username"), prop.getProperty("db.password"));
					Statement state = (Statement) conn.createStatement();

				} catch (final IOException ex) {
					ex.printStackTrace();
				} finally {
					if (input != null) {
						try {
							input.close();
						} catch (final IOException e) {
							e.printStackTrace();
						}
					}
				}
				
				





	}

}