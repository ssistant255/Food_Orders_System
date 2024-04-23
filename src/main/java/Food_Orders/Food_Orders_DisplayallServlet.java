package Food_Orders;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/Food_Orders_DisplayallServlet")
public class Food_Orders_DisplayallServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.getWriter().println("<!DOCTYPE html>");
        resp.getWriter().println("<html>");
        resp.getWriter().println("<head>");
        resp.getWriter().println("<title>Background Image</title>");
        resp.getWriter().println("<style>");
        resp.getWriter().println("body {");
        resp.getWriter().println("    background-image:url('https://wallpapers.com/images/hd/food-delivery-in-pink-oqi3x301x86i9vwl.jpg');");
        resp.getWriter().println("    background-size: cover;");
        resp.getWriter().println("}");
        resp.getWriter().println("form {");
        resp.getWriter().println("background-color: green");
        resp.getWriter().println("text-align: center;");
        resp.getWriter().println("}");
        resp.getWriter().println("</style>");
        resp.getWriter().println("</head>");
        resp.getWriter().println("<body>");
        resp.getWriter().println("</body>");
        resp.getWriter().println("</html>");
		PrintWriter out = resp.getWriter();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/food_order_system", "root",
					"darshan3009");
			Statement st = conn.createStatement();
			String Query = "SELECT * FROM register";
//				PreparedStatement p1 = conn.prepareStatement(Query);
//				p1.setString(1, Email_Id);
				ResultSet rs1 = st.executeQuery(Query);
				while(rs1.next())
				{
					out.print(rs1.getInt(1)+" "+rs1.getString(2)+" "+rs1.getString(3)+" "+rs1.getString(4)+" "+rs1.getString(5)+" "+rs1.getString(6)+" "+rs1.getString(7));
				}
		} 
		catch (Exception e)
		{
			e.getStackTrace();
		}
	}
}
