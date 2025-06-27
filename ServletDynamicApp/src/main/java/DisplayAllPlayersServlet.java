import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

@WebServlet("/display-all")
public class DisplayAllPlayersServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp){
		// JDBC Logic
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_playerdb?user=student&password=student");
			
			PreparedStatement pst = conn.prepareStatement("select * from players");
			
			ResultSet rs = pst.executeQuery();
			
			// Transferring the ResultSet to Display Page
			req.setAttribute("players", rs);
			req.getRequestDispatcher("displayAllPlayers.jsp").forward(req, resp);
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
