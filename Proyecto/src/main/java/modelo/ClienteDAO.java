package modelo;

import java.sql.*;

import controlador.conexion;

public class ClienteDAO {
	
	conexion cn= new conexion();
	Connection cnn=cn.conexionbd();
	PreparedStatement ps;
	ResultSet rs;
	ClienteDTO usdto=null;
	
	public boolean insertarcliente(ClienteDTO us) {
		int c;
		boolean d=false;
		try {
			ps=cnn.prepareStatement("INSERT INTO clientes VALUES(?,?,?,?,?)");
			ps.setLong(1, us.getCedulacliente());
			ps.setString(2,us.getDireccioncliente());
			ps.setString(3,us.getEmailcliente());
			ps.setString(4,us.getNombrecliente());
			ps.setString(5,us.getTelefonocliente());
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
	public ClienteDTO consultarcliente(ClienteDTO us) {
		try {
			ps=cnn.prepareStatement("SELECT * FROM clientes where cedula_cliente=? ");
			ps.setLong(1, us.getCedulacliente());
			rs=ps.executeQuery();
			if(rs.next()) {
				usdto= new ClienteDTO(rs.getLong(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
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
	
	public int actualizarcliente(ClienteDTO us) {
		int x=0;
		try {
			ps=cnn.prepareStatement("UPDATE clientes SET direccion_cliente=?,email_cliente=?,nombre_cliente=?,telefono_cliente=? WHERE cedula_cliente=?");
			ps.setString(1, us.getDireccioncliente());
			ps.setString(2,us.getEmailcliente());
			ps.setString(3, us.getNombrecliente());
			ps.setString(4, us.getTelefonocliente());
			ps.setLong(5, us.getCedulacliente());
			x=ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return x;
		
	}
	public int eliminarcliente(ClienteDTO us) {
		int x=0;
		try {
			ps=cnn.prepareStatement("DELETE FROM clientes WHERE cedula_cliente=?");
			ps.setLong(1, us.getCedulacliente());
			x=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return x;

	}
	

}
