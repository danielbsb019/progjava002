package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Pais;
import service.Services;


/**
 * Servlet implementation class ManterPaisController
 */
@WebServlet("/ManterPais.do")


public class ManterPaisController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	/**
	 * @throws IOException 
	 * @throws ServletException 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		String pNome= request.getParameter("nome");
		long pPopulacao = Long.parseLong(request.getParameter("populacao"));
		double pArea= Double.parseDouble(request.getParameter("area"));
		
		//instanciar os bagulho
		
		Pais pais=new Pais();
		pais.setNome(pNome);
		pais.setPop(pPopulacao);
		pais.setArea(pArea);
		
		// instanciar o server
		
		Services sv = new Services();
		sv.criar(pais);
		pais= sv.carregar(pais.getId());
		
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Cliente Cadastrado</title></head><body>");
		out.println(	"id: "+pais.getId()+"<br>");
		out.println(	"Nome: "+pais.getNome()+"<br>");
		out.println(	"População: "+pais.getPop()+"<br>");
		out.println(	"Area: "+pais.getArea()+"<br>");
	    out.println("</body></html>");

	    request.setAttribute("Pais", pais);
		RequestDispatcher view =
		request.getRequestDispatcher("ExibePais.jsp");
		view.forward(request, response);
	
	}
	
}
