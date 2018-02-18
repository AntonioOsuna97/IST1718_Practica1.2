package Practica2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletPractica2
 */
@WebServlet("/ServletPractica2")
public class ServletPractica2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPractica2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Inicio de sesion
		HttpSession sesion = request.getSession(true);
		response.setContentType("text/html");
		PrintWriter html = response.getWriter();
		html.print("<strong>");
		//Obtenemos cabeceras de petición
		requestHeader(request, response);
		html.print("<br>Fin de cabeceras de petición. <br>");
		
		responseHeader(request, response);
		
		Date date = (Date)sesion.getAttribute("date");
		if(date != null) {
		html.print("<br>Último acceso de la sesión: " + date + "<br>");
		}
		else {
		html.print("Este es el primer acceso de la sesión <br>");
		}
		date = new Date();
		sesion.setAttribute("date", date);
		html.print("Fecha actual: " + date);
		html.print("</strong>");
		
		
		}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	
	//Creamos un método que nos permita obtener las cabeceras de petición HTTP
		public void requestHeader(HttpServletRequest req, HttpServletResponse res) throws IOException {
					//Definimos una variable out de tipo Printwriter.
					//Esta clase imprime representaciones formateadas de objetos en una secuencia de salida de texto.
			        PrintWriter out = res.getWriter();
			        
			        out.write("Cabeceras de petición: ");
			        //Interfaz Enumeration: Un objeto que implementa la interfaz Enumeration permite generar series de elementos
			        //Enumeración llamada headerNames a la que le asignamos las distintas cabeceras sin su valor
			        Enumeration<String> headerNames = req.getHeaderNames();
			        
			        while (headerNames.hasMoreElements()) { //hasMoreElements()-> prueba si esta enumeración contiene más elementos
			        	//Definimos una variable headerName de tipo String y le asignamos el valor siguiente de headerNames (contiene
			        	//los nombres de las cabeceras)
			            String headerName = headerNames.nextElement();
			            //En nuestra salida, escribe un salto de línea + el nombre de la cabecera
			            out.write("<br>"+headerName);
			            
			            //Enumeracion de tipo string llamada header a la que le asignamos el valor de las distintas cabeceras
			            //req.getHeaders(headerName) -> Obtiene el valor de las cabeceras de la petición
			            Enumeration<String> headers = req.getHeaders(headerName);
			            
			            while (headers.hasMoreElements()) { //prueba si esta enumeración contiene más elementos
		
			            	//Definimos una variable que contendra el valor de nuestra cabecera y se lo asignamos
			                String headerValue = headers.nextElement();
			                //Escribe en nuestra página web : y el valor de la cabecera
			                out.write(":"+headerValue);
			            }

			        }
		}
		
		//Falta obtener cabeceras de respuesta
		//******************MAL, no recorre las cabeceras, el iterador no recorre la lista*********************
		//Creamos un método que nos permita obtener las cabeceras de respuesta HTTP
				public void responseHeader(HttpServletRequest req, HttpServletResponse res) throws IOException {
							//Definimos una variable out de tipo Printwriter.
							//Esta clase imprime representaciones formateadas de objetos en una secuencia de salida de texto.
					        PrintWriter out = res.getWriter();
					        
					        out.write("Cabeceras de respuesta: ");
					        
					        Collection<String> headerNames = res.getHeaderNames();
				 

					        	while(headerNames.iterator().hasNext()){
					        	String headerName = headerNames.iterator().next();
					        	out.write(headerName);
					        	
					        	Collection<String> headersValue = res.getHeaders(headerName);
					        	
					        		//while(headersValue.iterator().hasNext()) {
					        			String headerValue = headersValue.iterator().next();
					        			out.write(headerValue);
					        		//}
					        	}
					        	
					        
					        
					       
				}
		
}
