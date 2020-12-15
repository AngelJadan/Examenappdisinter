package ec.edu.ups.ExamenAngelJadanServidor.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Productos", schema = "public")
public class Producto implements Serializable{
	@Id
	@SequenceGenerator(name = "pro_id_seq", sequenceName = "pro_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pro_id_seq")
	private Long id;
	
	@Column(name = "pro_nombre", nullable = false)
	private String nombre;
	
	@Column(name = "pro_medida", nullable = false)
	private double medida;
	
	@Column(name = "pro_umedida" , nullable = false)
	private String unidadMedida;
	
	@Column(name = "pro_cantidad", nullable = false)
	private int cantidad;
	
	@Column(name = "pro_costo", nullable = false)
	private double costo;
	
	public Producto() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
