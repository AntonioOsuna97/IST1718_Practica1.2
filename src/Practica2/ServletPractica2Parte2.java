package Practica2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletPractica2Parte2
 */
@WebServlet("/ServletPractica2Parte2")
public class ServletPractica2Parte2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPractica2Parte2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		
		
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Practica 2 Parte 2</title></head>");
		out.println("<body ><center><h1> Test practica 2 </h1>");
		String user = request.getParameter("username");
		//Creamos una cookie llamada Usuario para poder obtener el valor 
		//de la cookie mediante un metodo de esta clase
		Cookie c = new Cookie("Usuario", user);
		//Obtenemos el valor de nuestra cookie
		out.println("<h3> El usuario es : " + c.getValue() + "</h3>");
		String pass =request.getParameter("pass");
		out.println("<h3> La contraseña es : "+ pass + "</h3>");
		String ema = request.getParameter("email");
		out.println("<h3> El email es: " + ema + "</h3>");
		Date date = new Date();
		out.println("<h3>Tiempo a la hora que se realizó el test:  " + date.toString() +"</h3>");
		out.println("</center></body></html>");
		out.close();
		}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
