package model.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.vo.User; 
public class UserJDBC {
	 /* 插入 */
    public void save(User user) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        /* 通过连接工厂获取连接对象 */
        conn = ConnectionFactory.getConnection();

        try {
            String insertSQL = "insert into student values(?,?,?,?)";
            pstmt = conn.prepareStatement(insertSQL);
            pstmt.setString(1, user.getUserName());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getChrName());
            pstmt.setString(4, user.getEmail());
            

            int rows = pstmt.executeUpdate();
            System.out.println("成功插入记录：" + rows + "条");
        } catch (SQLException e) {
            e.printStackTrace();
            /* 如果操作出现问题，将事务回滚 */
            try {
                conn.rollback();
            } catch (SQLException e1) {
            }
        } finally {
            DBUtils.close(conn);
            DBUtils.close(pstmt);
            DBUtils.close(rs);
        }
    }

    /* 删除 */
    public void delete(Integer id) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        /* 通过连接工厂获取连接对象 */
        conn = ConnectionFactory.getConnection();

        try {
            String insertSQL = "delete from student where id=?";
            pstmt = conn.prepareStatement(insertSQL);
            pstmt.setInt(1, id);
            int rows = pstmt.executeUpdate();
            System.out.println("成功删除记录：" + rows + "条");
        } catch (SQLException e) {
            e.printStackTrace();
            /* 如果操作出现问题，将事务回滚 */
            try {
                conn.rollback();
            } catch (SQLException e1) {
            }
        } finally {
            DBUtils.close(conn);
            DBUtils.close(pstmt);
        }
    }


}
