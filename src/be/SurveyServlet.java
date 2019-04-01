package be;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import data.AnimalSurvey;

public class SurveyServlet extends HttpServlet {

	// process "get" requests from clients
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();
		try {

			AnimalSurvey dataObject = new AnimalSurvey();

		// head section of document
			dataObject.initialize();


			out.println("<head>");
			out.println("<title>A Database Servlet Example</title>");
			out.println("</head>");
			out.println("<h1>"+"AnimalSurvey"+"</h1>");
			out.println("<table>");
			out.println("<thead>");
			out.println(dataObject.columnHeaders());
			out.println("</thead>");
			out.println("<tbody>");
		int size;
			while (dataObject.getRs().next()) {
				out.println("<tr>");
				for (int i = 0; i < dataObject.getRmd().getColumnCount(); i++) {
					size = dataObject.getSize(i);
					out.print("<td>");
					out.print(String.format("%"+size+"s", dataObject.column(i + 1)));
					out.print("</td>");
				}
				out.println("</tr>");
			}
			out.println("</tbody>");
			out.println("</table>");
			out.println("</body>");
			/*
		 * We release the result and statement resources.
		 */
		/*
		 * We end the transaction and the connection.
		 */
			dataObject.getRs().close();
			dataObject.getConn().commit();
			dataObject.getConn().close();
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		System.out.println("Committed transaction and closed connection");


		// start XHTML document
		out.println("<?xml version = \"1.0\"?>");

		out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD "
				+ "XHTML 1.0 Strict//EN\" \"http://www.w3.org"
				+ "/TR/xhtml1/DTD/xhtml1-strict.dtd\">");

		out.println("<html xmlns = \"http://www.w3.org/1999/xhtml\">");

		// end XHTML document
		out.println("</html>");
		out.close(); // close stream to complete the page
	}
}


