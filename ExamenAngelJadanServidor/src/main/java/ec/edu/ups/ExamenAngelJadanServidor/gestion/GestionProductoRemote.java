package ec.edu.ups.ExamenAngelJadanServidor.gestion;

import java.util.List;

import javax.ejb.Remote;

import ec.edu.ups.ExamenAngelJadanServidor.model.Producto;

@Remote
public interface GestionProductoRemote {
	public boolean guardar(Producto producto);
	public boolean actualizar(Producto producto);
	public Producto buscar(Long id);
	public List<Producto> listar();
}
