package modelo;

import java.sql.*;

import controlador.conexion;

public class ProveedoresDAO {
	
	conexion cn= new conexion();
	Connection cnn=cn.conexionbd();
	PreparedStatement ps;
	ResultSet rs;
	ProveedoresDTO usdto=null;
	
	public boolean insertarproveedor(ProveedoresDTO us) {
		int c;
		boolean d=false;
		try {
			ps=cnn.prepareStatement("INSERT INTO proveedores VALUES(?,?,?,?,?)");
			ps.setLong(1, us.getNit());
			ps.setString(2,us.getCiudad());
			ps.setString(3,us.getDireccion());
			ps.setString(4,us.getNombre());
			ps.setString(5,us.getTelefono());
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
	public ProveedoresDTO consultarproveedor(ProveedoresDTO us) {
		try {
			ps=cnn.prepareStatement("SELECT * FROM proveedores where nitproveedor=? ");
			ps.setLong(1, us.getNit());
			rs=ps.executeQuery();
			if(rs.next()) {
				usdto= new ProveedoresDTO(rs.getLong(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
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
	public int actualizarproveedor(ProveedoresDTO us) {
		int x=0;
		try {
			ps=cnn.prepareStatement("UPDATE proveedores SET ciudad_proveedor=?,direccion_proveedor=?,nombre_proveedor=?,telefono_proveedor=? WHERE nitproveedor=?");
			ps.setString(1, us.getCiudad());
			ps.setString(2,us.getDireccion());
			ps.setString(3, us.getNombre());
			ps.setString(4, us.getTelefono());
			ps.setLong(5, us.getNit());
			x=ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return x;
		
	}
	public int eliminarproveedor(ProveedoresDTO us) {
		int x=0;
		try {
			ps=cnn.prepareStatement("DELETE FROM proveedores WHERE nitproveedor=?");
			ps.setLong(1, us.getNit());
			x=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return x;

	}
	

}
