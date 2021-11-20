package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.cliente;
import modelo.connection;
import modelo.consultas;


/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	HttpSession sesion;
	String email;
	String pass;
	 consultas c;
	 cliente cli;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		
		
			
			email=request.getParameter("username");
			pass=request.getParameter("password");
			
			c=new consultas();
			
			
				boolean esta=c.consultar(email, pass);
				
				
				if(esta==true) {
					sesion=request.getSession();
					sesion.setAttribute("iniciado", 1);
					cli=c.consultarnombre(email,pass);
					sesion.setAttribute("datos", cli);
					
					
					
					
					request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
					
				}else {
					
					 
					
					request.getRequestDispatcher("/WEB-INF/completarcodigo.jsp").forward(request, response);
				}
			
		


	}

	

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		// TODO Auto-generated method stub
		return email;
	}
}
