package ec.edu.ups.ExamenAngelJadanServidor.gestion;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.ExamenAngelJadanServidor.dao.ProductoDAO;
import ec.edu.ups.ExamenAngelJadanServidor.model.Producto;

@Named
public class GestionProducto implements GestionProductoRemote{

	@Inject
	private ProductoDAO pdao;
	
	public boolean guardar(Producto producto) {
		try {
			pdao.insert(producto);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean actualizar(Producto producto) {
		try {
			pdao.update(producto);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public Producto buscar(Long id) {
		Producto prod = new Producto();
		try {
			prod = pdao.search(id);
			return prod;
		} catch (Exception e) {
			e.printStackTrace();
			return prod;
		}
	}
	public List<Producto> listar(){
		List<Producto> listado = new ArrayList<Producto>();
		try {
			listado=pdao.listado();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			return listado;
		}
	}

}
