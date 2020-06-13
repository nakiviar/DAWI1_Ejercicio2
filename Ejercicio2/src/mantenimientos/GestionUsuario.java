package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import interfaces.UsuarioInterface;
import model.Usuario;
import util.MySQLConexion;

public class GestionUsuario implements UsuarioInterface{

	@Override
	public int registrarUsuario(Usuario u) {
		// TODO Auto-generated method stub
		int rs = 0;
		Connection con =null;
		PreparedStatement pst=null;
		try {
			con = MySQLConexion.getConexion();
			String sql="insert into tb_usuarios values (null,?,?,?,?,?,2,1)";
			pst=con.prepareStatement(sql);
			pst.setString(1, u.nombre);
			pst.setString(2, u.apellido);
			pst.setString(3, u.usuario);
			pst.setString(4, u.clave);
			pst.setString(5, u.fecha);
			rs=pst.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return rs;
	}

	@Override
	public Usuario validarUsuario(Usuario u) {
		// TODO Auto-generated method stub
		Usuario usuario = null;
		Connection con =null;
		PreparedStatement pst=null;
		ResultSet rs = null;
		try {
			con = MySQLConexion.getConexion();
			String sql="select * from tb_usuarios where usuario = ? and clave = ?";
			pst=con.prepareStatement(sql);
			pst.setString(1, u.usuario);
			pst.setString(2, u.clave);
			rs=pst.executeQuery();
			if(rs.next()) {
				usuario = new Usuario();
				usuario.setCodigo(rs.getInt(1));
				usuario.setNombre(rs.getString(2));
				usuario.setApellido(rs.getString(3));
				usuario.setUsuario(rs.getString(4));
				usuario.setClave(rs.getString(5));
				usuario.setFecha(rs.getString(6));
				usuario.setTipo(rs.getInt(7));
				usuario.setEstado(rs.getInt(8));
				
			}
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return usuario;
	}

}
