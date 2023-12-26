import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        UserDao dao = new UserDao();

        User user = new User();
        user.setId("woori");
        user.setName("이순신");
        user.setPassword("tobi");
        //Id, Name, Password 컬럼에 넣어질 값들
        dao.add(user);  // 추가한다고 명령

        System.out.println(user.getId() + "등록 성공");

        User user2 = dao.get(user.getId()); // 아이디 조회해서 새로운 객체 user2 에 넣는다.
        System.out.println(user2.getName()); //이름 출력
        System.out.println(user2.getPassword()); // 비밀번호 출력
        System.out.println(user2.getId() + "조회 성공");
    }
}