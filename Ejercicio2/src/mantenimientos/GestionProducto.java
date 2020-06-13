package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import interfaces.ProductoInterface;
import model.Categoria;
import model.Producto;
import util.MySQLConexion;

public class GestionProducto implements ProductoInterface {

	@Override
	public ArrayList<Categoria> listarCategorias() {
		ArrayList<Categoria> lista = new ArrayList<Categoria>();
		Categoria categoria = null;
		PreparedStatement pst = null;
		Connection con = null;
		ResultSet rs = null;

		try {
			String cadena = "select * from tb_categorias";
			con = MySQLConexion.getConexion();
			pst = con.prepareStatement(cadena);
			rs = pst.executeQuery();
			while (rs.next()) {
				categoria = new Categoria();
				categoria.setIdcat(rs.getInt(1));
				categoria.setDescripcion(rs.getString(2));
				lista.add(categoria);
			}

		} catch (SQLException sql) {
			System.out.println("ERROR SQL:" + sql);

		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return lista;
	}

	@Override
	public ArrayList<Producto> listarProductos() {
		// TODO Auto-generated method stub
		ArrayList<Producto> lista = new ArrayList<Producto>();
		Producto producto = null;
		PreparedStatement pst = null;
		Connection con = null;
		ResultSet rs = null;

		try {
			String cadena = "select * from tb_productos";
			con = MySQLConexion.getConexion();
			pst = con.prepareStatement(cadena);
			rs = pst.executeQuery();
			while (rs.next()) {
				producto = new Producto();
				producto.setCodigo(rs.getString(1));
				producto.setDescripcion(rs.getString(2));
				producto.setStock(rs.getInt(3));
				producto.setPrecio(rs.getDouble(4));
				producto.setIdcat(rs.getInt(5));
				producto.setEstado(rs.getInt(6));
				lista.add(producto);
			}

		} catch (SQLException sql) {
			System.out.println("ERROR SQL:" + sql);

		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return lista;
	}

	@Override
	public ArrayList<Categoria> filtrarCategorias(String texto) {
		ArrayList<Categoria> lista = new ArrayList<Categoria>();
		Categoria categoria = null;
		PreparedStatement pst = null;
		Connection con = null;
		ResultSet rs = null;

		try {
			String cadena = "select * from tb_categorias where descripcion like '%" + texto + "%'";// like
																									// concat('%',?,'%');
			con = MySQLConexion.getConexion();
			pst = con.prepareStatement(cadena);
			// Se pondria la sgte linea :
			// pst.setString(1,texto);
			rs = pst.executeQuery();
			while (rs.next()) {
				categoria = new Categoria();
				categoria.setIdcat(rs.getInt(1));
				categoria.setDescripcion(rs.getString(2));
				lista.add(categoria);
			}

		} catch (SQLException sql) {
			System.out.println("ERROR SQL:" + sql);

		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return lista;
	}

	@Override
	public int registrarProducto(Producto p) {
		int i = 0;
		PreparedStatement pst = null;
		Connection con = null;
		try {
			con = MySQLConexion.getConexion();
			//insert into tb_productos values('P0040','Caramelitos de menta',30,2.09,2,1);

			String sql ="insert into tb_productos values(?,?,?,?,?,?)";
			pst= con.prepareStatement(sql);
			pst.setString(1, p.codigo);
			pst.setString(2, p.descripcion);
			pst.setInt(3, p.stock);
			pst.setDouble(4, p.precio);
			pst.setInt(5, p.idcat);
			pst.setInt(6, p.estado);
			i = pst.executeUpdate();
		} catch (SQLException sql) {
			System.out.println("ERROR SQL:" + sql);

		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return i;
	}

}
