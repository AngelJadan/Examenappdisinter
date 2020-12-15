package ec.edu.ups.ExamenAngelJadanServidor.vista;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.ExamenAngelJadanServidor.gestion.GestionProducto;
import ec.edu.ups.ExamenAngelJadanServidor.model.Producto;

@Named
@RequestScoped
public class ProductoBeans {
	@Inject
	private GestionProducto gproducto;
	private Producto producto;
	private ArrayList<Producto> productos;
	
	private long id;
	private String nombre;
	private double medida;
	private String unidadMedida;
	private int cantidad;
	private double costo;
	
	public ProductoBeans() {
		listar();
	}
	@PostConstruct
	public void init() {
		producto = new Producto();
	}
	public String buscar(){
		try {
			Producto prod = gproducto.buscar(id);
			setId(prod.getId());
			setNombre(prod.getNombre());
			setMedida(prod.getMedida());;
			setUnidadMedida(prod.getUnidadMedida());
			setCantidad(prod.getCantidad());
			setCosto(prod.getCosto());
		} catch (Exception e) {
			FacesMessage sms = new FacesMessage(FacesMessage.SEVERITY_INFO,
					e.getMessage(), "Producto no encontrado");
			FacesContext.getCurrentInstance().addMessage("producto:txtid", sms);
			e.printStackTrace();
		}
		return null;
	}
	public void listar() {
		List<Producto> produc = gproducto.listar();
		
		for (Producto prod : produc) {
			productos.add(prod);
		}
	}
	
	public String doSave() {
		gproducto.guardar(producto);
		System.out.println("Producto guardado");
		return null;
	}
	public String doUpdate() {
		gproducto.actualizar(producto);
		System.out.println("Actualizado");
		return null;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public GestionProducto getGproducto() {
		return gproducto;
	}
	public void setGproducto(GestionProducto gproducto) {
		this.gproducto = gproducto;
	}
	public ArrayList<Producto> getProductos() {
		return productos;
	}
	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getMedida() {
		return medida;
	}
	public void setMedida(double medida) {
		this.medida = medida;
	}
	public String getUnidadMedida() {
		return unidadMedida;
	}
	public void setUnidadMedida(String unidadMedida) {
		this.unidadMedida = unidadMedida;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public double getCosto() {
		return costo;
	}
	public void setCosto(double costo) {
		this.costo = costo;
	}
}
