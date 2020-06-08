package proj.java.user.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import proj.java.user.doa.MedDao;
import proj.java.user.model.Medicine;



/**
 * Servlet implementation class MedServlet
 */
@WebServlet("/MedServlet")
public class MedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MedDao medDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MedServlet() {
    	this.medDao=new MedDao();
       
    }
    /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getServletPath();

        try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertMed(request, response);
                    break;
                case "/update":
                    updateMed(request, response);
                    break;
                default:
                    listMed(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
	}
	
	private void listMed(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException, ServletException {
		        List < Medicine > listMed = medDao.selectAllMed();
		        request.setAttribute("listMed", listMed);
		        RequestDispatcher dispatcher = request.getRequestDispatcher("med-list.jsp");
		        dispatcher.forward(request, response);
		    }
	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
		    throws ServletException, IOException {
		        RequestDispatcher dispatcher = request.getRequestDispatcher("med-form.jsp");
		        dispatcher.forward(request, response);
		    }
	private void insertMed(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException {
		        String med_name = request.getParameter("med_name");
		        String category = request.getParameter("category");
		        int price = Integer.parseInt(request.getParameter("price"));
		        String exp_date = request.getParameter("exp_date");
		        Medicine newMed = new Medicine(med_name, category,price, exp_date);
		        medDao.insertMed(newMed);
		        response.sendRedirect("list");
		    }
	private void updateMed(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException {
		        int id = Integer.parseInt(request.getParameter("med_id"));
		        String name = request.getParameter("med_name");
		        String category = request.getParameter("category");
		        int price = Integer.parseInt(request.getParameter("price"));
		        String exp_date = request.getParameter("exp_date");


		        Medicine book = new Medicine(id, name, category, price, exp_date);
		        medDao.updateMed(book);
		        response.sendRedirect("list");
		    }
	

}
