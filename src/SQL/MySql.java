package SQL;

/** 
 * This is a very simple example representing how to work with MySQL 
 * using java JDBC interface;
 * The example mainly present how to read a table representing a set of WiFi_Scans
 * Note: for simplicity only two properties are stored (in the DB) for each AP:
 * the MAC address (mac) and the signal strength (rssi), the other properties (ssid and channel)
 * are omitted as the algorithms do not use the additional data.
 * 
 */
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import Project.LineFile;
import Project.Time;
import Project.Network;
import Project.Point_2D;
import java.sql.Statement;

public class MySql {
	/// חיבור לשרת של בועז 
	private static String _ip = "5.29.193.52";
	private static String _url = "jdbc:mysql://5.29.193.52:3306/oop_course_ariel";
	private static String _user = "oop1";
	private static String _password = "Lambda1();";
	private static Connection _con = null;
	private static String _tableName="";
	//////

	public static void main(String[] args) {
		List<LineFile> _line1 =	test_101("5.29.193.52", "jdbc:mysql://"+"5.29.193.52"+":3306/oop_course_ariel","oop1","Lambda1();","ex4_db");
		//;
	}


	public static List<LineFile> test_101(String _ip,String _url,String _user, String _password, String _tableName) {
		Statement st = null;
		ResultSet rs = null;
		Connection _con = null;
		int max_id = -1;
		List<LineFile> _line = new ArrayList<LineFile>();

		try {  
			_con = DriverManager.getConnection(_url, _user, _password);
			st = _con.createStatement();

			PreparedStatement pst = _con.prepareStatement("SELECT * FROM "+_tableName);
			rs = pst.executeQuery();
			ResultSetMetaData rsmd= rs.getMetaData();
			while (rs.next()) {
				Time t = new Time();
				t=t.set_Date(rs.getString(2));
				String model = rs.getString(3);
				double lat = rs.getDouble(4);
				double lon = rs.getDouble(5);
				Point_2D _p = new Point_2D(lon, lat);
				double alt = rs.getDouble(6);
				int numNetworks= rs.getInt(7);
				List<Network> _net = new ArrayList<Network>();
				for (int i = 8; i < rsmd.getColumnCount() ; i+=2) {
					if(rs.getString(i) != null){
						_net.add(new Network(rs.getString(i), rs.getInt(i+1)));
					}
				}
				_line.add(new LineFile(t, model, _p, alt, numNetworks, _net));    
			}
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(MySql.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
		} finally {
			try {
				if (rs != null) {rs.close();}
				if (st != null) { st.close(); }
				if (_con != null) { _con.close();  }
			} catch (SQLException ex) {

				Logger lgr = Logger.getLogger(MySql.class.getName());
				lgr.log(Level.WARNING, ex.getMessage(), ex);
			}
		}
		return _line;
	}
}
