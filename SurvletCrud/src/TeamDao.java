import java.util.*;
import java.sql.*;

public class TeamDao {

	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "tiger");
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}

	public static int save(Team e) {
		int status = 0;
		try {
			Connection con = TeamDao.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into Team(id,teamname,captain,rank) values (?,?,?,?)");
			ps.setInt(1, e.getId());
			ps.setString(2, e.getTeamname());
			ps.setString(3, e.getCaptain());
			ps.setString(4, e.getRank());

			status = ps.executeUpdate();

			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return status;
	}

	public static int update(Team e) {
		int status = 0;
		try {
			Connection con = TeamDao.getConnection();
			PreparedStatement ps = con.prepareStatement("update Team set Teamname=?,captain=?,rank=? where id=?");
			ps.setString(1, e.getTeamname());
			ps.setString(2, e.getCaptain());
			ps.setString(3, e.getRank());
			ps.setInt(4, e.getId());

			status = ps.executeUpdate();

			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return status;
	}

	public static int delete(int id) {
		int status = 0;
		try {
			Connection con = TeamDao.getConnection();
			PreparedStatement ps = con.prepareStatement("delete from Team where id=?");
			ps.setInt(1, id);
			status = ps.executeUpdate();

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}

	public static Team getTeamById(int id) {
		Team e = new Team();

		try {
			Connection con = TeamDao.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from Team where id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				e.setId(rs.getInt(1));
				e.setTeamname(rs.getString(2));
				e.setCaptain(rs.getString(3));
				e.setRank(rs.getString(4));

			}
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return e;
	}

	public static List<Team> getAllTeams() {
		List<Team> list = new ArrayList<Team>();

		try {
			Connection con = TeamDao.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from Team");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Team e = new Team();
				e.setId(rs.getInt(1));
				e.setTeamname(rs.getString(2));
				e.setCaptain(rs.getString(3));
				e.setRank(rs.getString(4));

				list.add(e);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
}
