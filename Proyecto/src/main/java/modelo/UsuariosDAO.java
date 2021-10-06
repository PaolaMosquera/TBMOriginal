package modelo;
import java.sql.*;
import controlador.conexion;

public class UsuariosDAO {
	
	conexion cn= new conexion();
	Connection cnn=cn.conexionbd();
	PreparedStatement ps;
	ResultSet rs;
	UsuariosDTO usdto=null;
	
	public boolean insertarusuario(UsuariosDTO us) {
		int c;
		boolean d=false;
		try {
			ps=cnn.prepareStatement("INSERT INTO usuarios VALUES(?,?,?,?,?)");
			ps.setLong(1, us.getCedulausuario());
			ps.setString(2,us.getEmailusuario());
			ps.setString(3,us.getNombreusuario());
			ps.setString(4,us.getPassword());
			ps.setString(5,us.getUsuario());
			c=ps.executeUpdate();
			if (c>0) {
				d=true;
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return d;
	}
	
	public UsuariosDTO consultarusuario(UsuariosDTO us) {
		try {
			ps=cnn.prepareStatement("SELECT * FROM usuarios where cedula_usuario=? ");
			ps.setLong(1, us.getCedulausuario());
			rs=ps.executeQuery();
			if(rs.next()) {
				usdto= new UsuariosDTO(rs.getLong(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
			}
			else {
				return null;
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return usdto;
	}
	public int actualizarusuario(UsuariosDTO us) {
		int x=0;
		try {
			ps=cnn.prepareStatement("UPDATE usuarios SET email_usuario=?,nombre_usuario=?,password=?,usuario=? WHERE cedula_usuario=?");
			ps.setString(1, us.getEmailusuario());
			ps.setString(2,us.getNombreusuario());
			ps.setString(3, us.getPassword());
			ps.setString(4, us.getUsuario());
			ps.setLong(5, us.getCedulausuario());
			x=ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return x;
		
	}
	public int eliminarusuario(UsuariosDTO us) {
		int x=0;
		try {
			ps=cnn.prepareStatement("DELETE FROM usuarios WHERE cedula_usuario=?");
			ps.setLong(1, us.getCedulausuario());
			x=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return x;
	}
	
	
}
