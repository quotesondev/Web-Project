import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

@WebServlet("/delete-by-id")
public class DeletePlayerByIdServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
		int id = Integer.parseInt(req.getParameter("id"));
		
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_playerdb?user=student&password=student");
			PreparedStatement pstmt = conn.prepareStatement("delete from players where playerId=?");
			
			pstmt.setInt(1,  id);
			
			pstmt.executeUpdate();
			
			resp.sendRedirect("display-all");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}

}
