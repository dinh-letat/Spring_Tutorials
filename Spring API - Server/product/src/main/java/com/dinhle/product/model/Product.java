package com.dinhle.product.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "product")
public class Product {

	@Id
	@Column(name = "id")
	private int id_product;
	
	@Column(name = "productName")
	private String productName;

	public int getId_product() {
		return id_product;
	}

	public void setId_product(int id_product) {
		this.id_product = id_product;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(int id_product, String productName) {
		super();
		this.id_product = id_product;
		this.productName = productName;
	}

	@Override
	public String toString() {
		return "Product [id_product=" + id_product + ", productName=" + productName + "]";
	}
	
}
