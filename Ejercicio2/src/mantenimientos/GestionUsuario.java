package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
		}
		return rs;
	}

	@Override
	public Usuario validarUsuario(Usuario u) {
		// TODO Auto-generated method stub
		return null;
	}

}
