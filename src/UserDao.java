import java.sql.*;

import static java.sql.DriverManager.getConnection;

public class UserDao {

    //등록
    public void add (User user) throws ClassNotFoundException, SQLException {
        Connection c = getConnection();
        PreparedStatement ps = c.prepareStatement(
                "insert into TOBIUSER(id, name, password) values(?,?,?)");
        ps.setString(1,user.getId());
        ps.setString(2,user.getName());
        ps.setString(3,user.getPassword());

        ps.executeUpdate();
        ps.close(); //Statement 리소스는 작업을 마친 후 반드시 닫아준다.
        c.close();  //Connection 리소스는 작업을 마친 후 반드시 닫아준다.
    }

    //조회
    public User get(String id) throws ClassNotFoundException, SQLException{
        Connection c = getConnection();
        Class.forName("oracle.jdbc.driver.OracleDriver");

        PreparedStatement ps = c.prepareStatement(
                "select * from TOBIUSER where id = ?");
        ps.setString(1,id);

        ResultSet rs = ps.executeQuery();
        rs.next();
        User user = new User(); // 새로운 user 이름 의 User객체 생성
        user.setId(rs.getString("id"));
        user.setName(rs.getString("name"));
        user.setPassword(rs.getString("password"));

        rs.close(); // ResultSet 작업 마쳤으니 닫고
        ps.close(); // 쿼리실행 닫고
        c.close(); // 커넥션 닫고 (실행 역 순서대로?)

        return user;
    }
    private Connection getConnection() throws ClassNotFoundException, SQLException{
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection c = DriverManager.getConnection(
                "jdbc:oracle:thin:@129.154.204.240:1521:hibdbcs","CP" ,"PCWKpcwkj12_#");
        return c;
    }
}
