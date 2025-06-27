import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

@WebServlet("/find-by-id")
public class FindPlayerByIdServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) {
		int id = Integer.parseInt(req.getParameter("id"));
		
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_playerdb?user=student&password=student");
			PreparedStatement pstmt = conn.prepareStatement("select * from players where playerId=?");
			pstmt.setInt(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			req.setAttribute("player", rs);
			req.getRequestDispatcher("updatePlayer.jsp").forward(req, res);
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
