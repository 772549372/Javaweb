package model.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.vo.User; 
public class UserJDBC {
	 /* ���� */
    public void save(User user) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        /* ͨ�����ӹ�����ȡ���Ӷ��� */
        conn = ConnectionFactory.getConnection();

        try {
            String insertSQL = "insert into student values(?,?,?,?)";
            pstmt = conn.prepareStatement(insertSQL);
            pstmt.setString(1, user.getUserName());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getChrName());
            pstmt.setString(4, user.getEmail());
            

            int rows = pstmt.executeUpdate();
            System.out.println("�ɹ������¼��" + rows + "��");
        } catch (SQLException e) {
            e.printStackTrace();
            /* ��������������⣬������ع� */
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

    /* ɾ�� */
    public void delete(Integer id) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        /* ͨ�����ӹ�����ȡ���Ӷ��� */
        conn = ConnectionFactory.getConnection();

        try {
            String insertSQL = "delete from student where id=?";
            pstmt = conn.prepareStatement(insertSQL);
            pstmt.setInt(1, id);
            int rows = pstmt.executeUpdate();
            System.out.println("�ɹ�ɾ����¼��" + rows + "��");
        } catch (SQLException e) {
            e.printStackTrace();
            /* ��������������⣬������ع� */
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
