package interfaces;

import java.util.ArrayList;

import model.Categoria;
import model.Producto;
import model.Usuario;

public interface ProductoInterface {
	
	public ArrayList<Categoria> listarCategorias();
	
	public ArrayList<Categoria> filtrarCategorias(String texto);

	public ArrayList<Producto> listarProductos();
	
	public int registrarProducto(Producto p);
	
}
