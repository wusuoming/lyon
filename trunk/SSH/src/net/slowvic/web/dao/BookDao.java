package net.slowvic.web.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BookDao {
    /**
     * 增删改操作
     * @throws SQLException
     */
    public void crud() throws SQLException {
        //Connection conn = ConnectionManager.getMysqlConnection();
        Connection conn = ConnectionManager.getConnectionByDatasource();
        Statement stmt = null;
        try {
            conn.setAutoCommit(false);
            stmt = conn.createStatement();
            String sql = "insert into book(id,author,title) values('204','孙卫琴','Tomcat与JavaWeb开发技术')";
            stmt.execute(sql);
            
            sql = "update book set author = 'sunweiqin' where id = '204'";
            stmt.executeUpdate(sql);
            
            sql = "select id,author,title from book";
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("id  author      title");
            System.out.println("---------------------");
            while(rs.next()){
                System.out.println(rs.getString(1)+"    "+rs.getString(2)+"         "+rs.getString(3));
            }
            
            sql = "delete from book where id = '204'";
            stmt.execute(sql);
            
            conn.commit();
        }
        catch (SQLException e) {
            conn.rollback();
        }
        finally {
            stmt.close();
            conn.close();
        }
    }

    public static void main(String[] args) throws SQLException {
        BookDao bd = new BookDao();
        bd.crud();
    }
}
