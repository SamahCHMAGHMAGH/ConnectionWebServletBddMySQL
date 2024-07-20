package registrationController;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import registrationDao.EmployeDao;
import registrationModel.Employe;

import java.io.IOException;

/**
 * Servlet implementation class EmployeServlet
 */
@WebServlet("/register")
public class EmployeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private EmployeDao employeDao = new EmployeDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/employeRegister.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String username = request.getParameter("userName");
		String password = request.getParameter("password");
		String address = request.getParameter("address");
		String contact = request.getParameter("contact");
		
		Employe employe = new Employe();
		employe.setFirstname(firstName);
		employe.setLastname(lastName);
		employe.setUsername(username);
		employe.setPassword(password);
		employe.setAdress(address);
		employe.setContact(contact); 
		
		try {
			employeDao.registreEmploye(employe);
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/employedetails.jsp");
		dispatcher.forward(request, response);
		
		
		
	}

}
