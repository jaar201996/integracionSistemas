package com.producto.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="inventario_producto")

public class Product {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="v_idAdministrador",nullable=false,length=30)
	private String v_idAdministrador;
	
	@Column(name="v_nombreProducto",nullable=false,length=30)
	private String v_nombreProducto;
	
	@Column(name="f_precioUnitario",nullable=true,length=30)
	private Float f_precioUnitario;
	
	@Column(name="i_stockProducto",nullable=true,length=30)
	private int i_stockProducto;

	@Column(name="v_marcaProducto",nullable=true,length=30)
	private String v_marcaProducto;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getV_idAdministrador() {
		return v_idAdministrador;
	}

	public void setV_idAdministrador(String v_idAdministrador) {
		this.v_idAdministrador = v_idAdministrador;
	}

	public String getV_nombreProducto() {
		return v_nombreProducto;
	}

	public void setV_nombreProducto(String v_nombreProducto) {
		this.v_nombreProducto = v_nombreProducto;
	}

	public Float getF_precioUnitario() {
		return f_precioUnitario;
	}

	public void setF_precioUnitario(Float f_precioUnitario) {
		this.f_precioUnitario = f_precioUnitario;
	}

	public int getI_stockProducto() {
		return i_stockProducto;
	}

	public void setI_stockProducto(int i_stockProducto) {
		this.i_stockProducto = i_stockProducto;
	}

	public String getV_marcaProducto() {
		return v_marcaProducto;
	}

	public void setV_marcaProducto(String v_marcaProducto) {
		this.v_marcaProducto = v_marcaProducto;
	}

	
}
