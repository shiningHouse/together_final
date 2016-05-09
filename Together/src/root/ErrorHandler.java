package root;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.Tags;

@SuppressWarnings("serial")
public class ErrorHandler extends HttpServlet{
	
	// ����GET���������󷽷�
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
					throws ServletException, IOException
	{
		request.getRequestDispatcher(Tags.ErrorHandler_PATH).forward(request, response);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doGet(req, resp);
	}
	
	
	
}
