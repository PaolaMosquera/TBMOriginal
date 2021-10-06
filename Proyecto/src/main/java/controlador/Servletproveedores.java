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
import modelo.ProveedoresDAO;
import modelo.ProveedoresDTO;

/**
 * Servlet implementation class Servletproveedores
 */
@WebServlet("/Servletproveedores")
public class Servletproveedores extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servletproveedores() {
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
		long nit;
		String ciudad;
		String direccion;
		String nombre;
		String telefono;
		ProveedoresDAO prodao;
		ProveedoresDTO prodto;
		ProveedoresDTO proregistro;
		//Insertar
		if (request.getParameter("btninsc")!=null) {
			nit=Long.parseLong(request.getParameter("nit"));
			ciudad=request.getParameter("ciudad");
			direccion=request.getParameter("direccion");
			nombre=request.getParameter("nombre");
			telefono=request.getParameter("telefono");
			prodto= new ProveedoresDTO(nit, ciudad, direccion, nombre, telefono);
			prodao= new ProveedoresDAO();
			x=prodao.insertarproveedor(prodto);
			if (x==true) {
				JOptionPane.showMessageDialog(null, "El proveedor fue insertado");
				response.sendRedirect("PaginaProveedores.jsp");
			}
			else {
				JOptionPane.showMessageDialog(null, "El proveedor no fue insertado");
				response.sendRedirect("PaginaProveedores.jsp");
			}
		}
		   //Consultar
			if(request.getParameter("btncrsu")!=null) {
				nit=Long.parseLong(request.getParameter("nit"));
				prodto= new ProveedoresDTO(nit);
				prodao= new ProveedoresDAO();
				proregistro=prodao.consultarproveedor(prodto);
				
				if (proregistro!=null) {
				nit=proregistro.getNit();
				ciudad=proregistro.getCiudad();
				direccion=proregistro.getDireccion();
				nombre=proregistro.getNombre();
				telefono=proregistro.getTelefono();
				response.sendRedirect("PaginaProveedores.jsp?ni="+nit+"&&ci="+ciudad+"&&di="+direccion+"&&no="+nombre+"&&te="+telefono);
				}
				else {
					JOptionPane.showMessageDialog(null,"No existen datos");
				}
			}
			//Actualizar
			if(request.getParameter("btnacsu")!=null) {
				int dat;
				nit=Long.parseLong(request.getParameter("nit"));
				ciudad=request.getParameter("ciudad");
				direccion=request.getParameter("direccion");
				nombre=request.getParameter("nombre");
				telefono=request.getParameter("telefono");
				prodto= new ProveedoresDTO(nit, ciudad, direccion, nombre, telefono);
				prodao= new ProveedoresDAO();
				dat=prodao.actualizarproveedor(prodto);
				if(dat>0) {
					JOptionPane.showMessageDialog(null, "Registro actualizado");
					response.sendRedirect("PaginaProveedores.jsp");
				}
				else {
					JOptionPane.showMessageDialog(null, "Registro no actualizado");
					response.sendRedirect("PaginaProveedores.jsp");
				}
				
			}
			//Eliminar
			if(request.getParameter("btnelsu")!=null) {
				int dat;
				nit=Long.parseLong(request.getParameter("nit"));
				prodto= new ProveedoresDTO(nit);
				prodao= new ProveedoresDAO();
				dat=prodao.eliminarproveedor(prodto);
				if (dat>0) {
					JOptionPane.showMessageDialog(null, "Registro eliminado");
					response.sendRedirect("PaginaProveedores.jsp");
				}
				else {
					JOptionPane.showMessageDialog(null, "Registro no eliminado");
					response.sendRedirect("PaginaProveedores.jsp");
				}
				
			}

		
	}

}
