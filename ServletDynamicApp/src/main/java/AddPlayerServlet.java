import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

@WebServlet("/add-player")
public class AddPlayerServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) {
		int id = Integer.parseInt(req.getParameter("playerId"));
		String title=req.getParameter("title");
		int age = Integer.parseInt(req.getParameter("age"));
		String team=req.getParameter("team");
		String nationality=req.getParameter("nationality");
		
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_playerdb?user=student&password=student");
			
			PreparedStatement pstmt = conn.prepareStatement("insert into players values(?,?,?,?,?)");
			pstmt.setInt(1, id);
			pstmt.setString(2, title);
			pstmt.setInt(3, age);
			pstmt.setString(4, team);
			pstmt.setString(5, nationality);
			
			pstmt.executeUpdate();
			
			res.sendRedirect("index.jsp");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(conn!=null) {
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
