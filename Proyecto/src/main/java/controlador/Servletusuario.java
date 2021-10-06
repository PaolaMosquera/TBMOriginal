package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import modelo.UsuariosDAO;
import modelo.UsuariosDTO;

/**
 * Servlet implementation class Servletusuario
 */
@WebServlet("/Servletusuario")
public class Servletusuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servletusuario() {
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
		long cedulausuario; 
		String emailusuario; 
		String nombreusuario; 
		String password; 
		String usuario;
		UsuariosDTO usudto;
		UsuariosDAO usudao;
		UsuariosDTO usuregistro;
		
		//Insertar
		if(request.getParameter("btninsu")!=null) {
			cedulausuario=Long.parseLong(request.getParameter("cedulausuario"));
			emailusuario=request.getParameter("emailusuario");
			nombreusuario=request.getParameter("nombreusuario");
			password=request.getParameter("password");
			usuario=request.getParameter("usuario");
			usudto=new UsuariosDTO(cedulausuario, emailusuario, nombreusuario, password, usuario);
			usudao=new UsuariosDAO();
			x=usudao.insertarusuario(usudto);
			if(x==true) {
				JOptionPane.showMessageDialog(null, "El usuario fue insertado");
				response.sendRedirect("PaginaUsuario.jsp");
			}
			else {
				JOptionPane.showMessageDialog(null, "El usuario no fue insertado");
				response.sendRedirect("PaginaUsuario.jsp");
			}
		}
		//Consultar
		
		if(request.getParameter("btncrsu")!=null) {
			cedulausuario=Long.parseLong(request.getParameter("cedulausuario"));
			usudto=new UsuariosDTO(cedulausuario);
			usudao=new UsuariosDAO();
			usuregistro=usudao.consultarusuario(usudto);
			
			if (usuregistro!=null) {
			cedulausuario=usuregistro.getCedulausuario();
			emailusuario=usuregistro.getEmailusuario();
			nombreusuario=usuregistro.getNombreusuario();
			password=usuregistro.getPassword();
			usuario=usuregistro.getUsuario();
			response.sendRedirect("PaginaUsuario.jsp?ce="+cedulausuario+"&&em="+emailusuario+"&&nom="+nombreusuario+"&&pass="+password+"&&usu="+usuario);
			}
			else {
				JOptionPane.showMessageDialog(null,"No existen datos");
			}
			}
		//Actualizar
		if(request.getParameter("btnacsu")!=null) {
			int dat;
			cedulausuario=Long.parseLong(request.getParameter("cedulausuario"));
			emailusuario=request.getParameter("emailusuario");
			nombreusuario=request.getParameter("nombreusuario");
			password=request.getParameter("password");
			usuario=request.getParameter("usuario");
			usudto=new UsuariosDTO(cedulausuario, emailusuario, nombreusuario, password, usuario);
			usudao=new UsuariosDAO();
			dat=usudao.actualizarusuario(usudto);
			if(dat>0) {
				JOptionPane.showMessageDialog(null, "Registro actualizado");
				response.sendRedirect("PaginaUsuario.jsp");
			}
			else {
				JOptionPane.showMessageDialog(null, "Registro no actualizado");
				response.sendRedirect("PaginaUsuario.jsp");
			}
			
		}
		//Eliminar
		if(request.getParameter("btnelsu")!=null) {
			int dat;
			cedulausuario=Long.parseLong(request.getParameter("cedulausuario"));
			usudto=new UsuariosDTO(cedulausuario);
			usudao=new UsuariosDAO();
			dat=usudao.eliminarusuario(usudto);
			if (dat>0) {
				JOptionPane.showMessageDialog(null, "Registro eliminado");
				response.sendRedirect("PaginaUsuario.jsp");
			}
			else {
				JOptionPane.showMessageDialog(null, "Registro no eliminado");
				response.sendRedirect("PaginaUsuario.jsp");
			}
		}
		
	}

}
