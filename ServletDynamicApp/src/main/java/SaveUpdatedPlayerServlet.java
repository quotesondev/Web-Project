import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

@WebServlet("/update-player")
public class SaveUpdatedPlayerServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
		int id = Integer.parseInt(req.getParameter("playerId"));
		String title=req.getParameter("title");
		int age = Integer.parseInt(req.getParameter("age"));
		String team=req.getParameter("team");
		String nationality=req.getParameter("nationality");
		
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_playerdb?user=student&password=student");
			PreparedStatement pstmt = conn.prepareStatement("update players set title=?, age=?, team=?, nationality=? where playerId=?");
			pstmt.setInt(5, id);
			pstmt.setString(1, title);
			pstmt.setInt(2, age);
			pstmt.setString(3, team);
			pstmt.setString(4, nationality);
			
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
					e.printStackTrace();
				}
			}
		}
	}

}
