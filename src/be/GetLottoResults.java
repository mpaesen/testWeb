package be;

import lotto.db.LottoSerializedFileIn;
import lotto.model.LottoCombination;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

public class GetLottoResults extends HttpServlet {

	// process "get" requests from clients
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(response);
	}

	private void processRequest(HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		// send XHTML page to client

		// start XHTML document
		out.println("<?xml version = \"1.0\"?>");

		out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD "
				+ "XHTML 1.0 Strict//EN\" \"http://www.w3.org"
				+ "/TR/xhtml1/DTD/xhtml1-strict.dtd\">");

		out.println("<html xmlns = \"http://www.w3.org/1999/xhtml\">");

		// head section of document
		out.println("<head>");
		out.println("<title>Get Lotto Results</title>");
		out.println("</head>");

		// body section of document
		out.println("<body>");
		out.println("<h1>Lotto!</h1>");
		try {
			showInput(out);
		} catch (FileNotFoundException e) {

			out.println(e.getMessage());
		} catch (IOException e) {

			out.println(e.getMessage());
		} catch (ClassNotFoundException e) {

			out.println(e.getMessage());
		}
		out.println("</body>");

		// end XHTML document
		out.println("</html>");
		out.close(); // close stream to complete the page
	}

	public static void showInput(PrintWriter out) throws IOException,
            ClassNotFoundException {

		LottoSerializedFileIn in = new LottoSerializedFileIn();
		String inputStream = "";
		
		String dataPath =System.getProperty("user.home");
		dataPath += "/Documents/data/";
		inputStream = dataPath + "result.ser";
		ArrayList serializedList = in.getSerializedList(inputStream);

		in.fillUp(serializedList);

		LottoCombination actueelElement;
		for (Iterator it = serializedList.iterator(); it.hasNext();) {
			actueelElement = (LottoCombination) it.next();
			out.println(actueelElement.toString());
			out.println("<br>");
		}

	}

}

