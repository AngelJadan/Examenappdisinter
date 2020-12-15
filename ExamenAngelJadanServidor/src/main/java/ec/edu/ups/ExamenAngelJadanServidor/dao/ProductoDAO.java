package ec.edu.ups.ExamenAngelJadanServidor.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.ExamenAngelJadanServidor.model.Producto;

@Stateless
public class ProductoDAO {
	@Inject
	private Connection connection;
	
	@Inject
	private EntityManager entityManager;
	
	public void insert(Producto producto)throws SQLException {
		entityManager.persist(producto);
	}
	public boolean update(Producto producto)throws SQLException{
		entityManager.merge(producto);
		return true;
	}
	public Producto search(Long id)throws SQLException{
		Producto prod = new Producto();
		return prod;
	}
	public List<Producto> listado(){
		List<Producto> productos = new ArrayList<Producto>();
		try {
			String cons = "SELECT * FROM PRODUCTOS";
			Query result = entityManager.createQuery(cons);
			productos=result.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			return productos;
		}
	}
}
