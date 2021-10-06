package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import modelo.ClienteDAO;
import modelo.ClienteDTO;

/**
 * Servlet implementation class Servletcliente
 */
@WebServlet("/Servletcliente")
public class Servletcliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servletcliente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean x;
		long cedulacliente ;
		String direccioncliente;
		String emailcliente;
		String nombrecliente;
		String telefonocliente;
		ClienteDAO clidao;
		ClienteDTO clidto;
		ClienteDTO cliregistro;
		//Insertar
		if (request.getParameter("btninsc")!=null) {
			cedulacliente=Long.parseLong(request.getParameter("cedulacliente"));
			direccioncliente=request.getParameter("direccioncliente");
			emailcliente=request.getParameter("emailcliente");
			nombrecliente=request.getParameter("nombrecliente");
			telefonocliente=request.getParameter("telefonocliente");
			clidto= new ClienteDTO(cedulacliente, direccioncliente, emailcliente, nombrecliente, telefonocliente);
			clidao= new ClienteDAO();
			x=clidao.insertarcliente(clidto);
			if (x==true) {
				JOptionPane.showMessageDialog(null, "El cliente fue insertado");
				response.sendRedirect("PaginaCliente.jsp");
			}
			else {
				JOptionPane.showMessageDialog(null, "El cliente no fue insertado");
				response.sendRedirect("PaginaCliente.jsp");
			}
		}
	   //Consultar
		if(request.getParameter("btncrsu")!=null) {
			cedulacliente=Long.parseLong(request.getParameter("cedulacliente"));
			clidto= new ClienteDTO(cedulacliente);
			clidao= new ClienteDAO();
			cliregistro=clidao.consultarcliente(clidto);
			
			if (cliregistro!=null) {
			cedulacliente=cliregistro.getCedulacliente();
			direccioncliente=cliregistro.getDireccioncliente();
			emailcliente=cliregistro.getEmailcliente();
			nombrecliente=cliregistro.getNombrecliente();
			telefonocliente=cliregistro.getTelefonocliente();
			response.sendRedirect("PaginaCliente.jsp?ce="+cedulacliente+"&&di="+direccioncliente+"&&em="+emailcliente+"&&nom="+nombrecliente+"&&tel="+telefonocliente);
			}
			else {
				JOptionPane.showMessageDialog(null,"No existen datos");
			}
		}
		//Actualizar
		if(request.getParameter("btnacsu")!=null) {
			int dat;
			cedulacliente=Long.parseLong(request.getParameter("cedulacliente"));
			direccioncliente=request.getParameter("direccioncliente");
			emailcliente=request.getParameter("emailcliente");
			nombrecliente=request.getParameter("nombrecliente");
			telefonocliente=request.getParameter("telefonocliente");
			clidto= new ClienteDTO(cedulacliente, direccioncliente, emailcliente, nombrecliente, telefonocliente);
			clidao= new ClienteDAO();
			dat=clidao.actualizarcliente(clidto);
			if(dat>0) {
				JOptionPane.showMessageDialog(null, "Registro actualizado");
				response.sendRedirect("PaginaCliente.jsp");
			}
			else {
				JOptionPane.showMessageDialog(null, "Registro no actualizado");
				response.sendRedirect("PaginaCliente.jsp");
			}
			
		}
		//Eliminar
		if(request.getParameter("btnelsu")!=null) {
			int dat;
			cedulacliente=Long.parseLong(request.getParameter("cedulacliente"));
			clidto= new ClienteDTO(cedulacliente);
			clidao= new ClienteDAO();
			dat=clidao.eliminarcliente(clidto);
			if (dat>0) {
				JOptionPane.showMessageDialog(null, "Registro eliminado");
				response.sendRedirect("PaginaCliente.jsp");
			}
			else {
				JOptionPane.showMessageDialog(null, "Registro no eliminado");
				response.sendRedirect("PaginaCliente.jsp");
			}
			
		}
	}

}
