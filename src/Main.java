import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con = null;
		try {
			Class.forName("org.sqlite.JDBC");
			String dbFile = "myfirst.db";
			con = DriverManager.getConnection("jdbc:sqlite:" + dbFile);

			System.out.println("\n*** 데이터 조회 ***");
			Statement stat1 = con.createStatement();
			String sql1 = "select * from g_artists";
			ResultSet rs1 = stat1.executeQuery(sql1);
			while (rs1.next()) {
				String id = rs1.getString("id");
				String name = rs1.getString("name");
				String regdate = rs1.getString("regdate");
				System.out.println(id + " " + name + " " + regdate);
			}
			stat1.close();
			
			System.out.println("\n***새 데이터 추가***");
			Statement stat2 = con.createStatement();
			String sql2 = "insert into g_artists (name, a_type, a_year, debut, regdate)"+"values ('수지', '여성','2010년대', '2011년', datetime('now','localtime'));";
			int cnt = stat2.executeUpdate(sql2);
			if(cnt > 0) System.out.println("새로운 데이터가 추가되었습니다!");
			else System.out.println("[Error] 데이터 추가 오류!");
			stat2.close();
//			
			System.out.println("\n***데이터 수정***");
			Statement stat3 = con.createStatement();
			String sql3 = "update g_artists set a_year = '2000년대, 2010년대, 2020년대'"+" where id = 2;";
			int cnt3 = stat3.executeUpdate(sql3);
			if(cnt3>0) System.out.println("데이터가 수정되었습니다!");
			else System.out.println("[Error] 데이터 수정 오류!");
			stat3.close();
			
			System.out.println("\n***데이터 삭제***");
			Statement stat4 = con.createStatement();
			String sql4 = "delete from g_artists where id = 10;";
			int cnt4 = stat4.executeUpdate(sql4);
			if(cnt4>0) System.out.println("데이터가 삭제되었습니다!");
			else System.out.println("[Error] 데이터 삭제 오류!");
			stat4.close();
			
			System.out.println("\n*** 데이터 조회 ***");
			Statement stat5 = con.createStatement();
			String sql5 = "select * from g_artists";
			ResultSet rs5 = stat5.executeQuery(sql5);
			while (rs5.next()) {
				String id = rs5.getString("id");
				String name = rs5.getString("name");
				String regdate = rs5.getString("regdate");
				System.out.println(id + " " + name + " " + regdate);
			}
			stat5.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
				}
			}
		}

	}

}
