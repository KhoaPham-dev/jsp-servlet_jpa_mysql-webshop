package com.ns4finalproject.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;
	
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	private Collection<Ordered> ordereds; 
	
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	private Collection<Review> reviews; 
	
	@ManyToOne
	@PrimaryKeyJoinColumn (name= "catalog_id")
	private Catalog catalog;
	
	private String catalog_id;
	private String name;
	private String price;
	private String status;
	private String description;
	private String content;
	private String image_link;
	private String created;
	private String discount;
	public Product() {}
	public Product(String id, String catalog_id, String name, String price, String status, String description, String content,
			String discount, String image_link, String created) {
		super();
		this.id = id;
		this.catalog_id = catalog_id;
		this.name = name;
		this.price = price;
		this.status = status;
		this.description = description;
		this.content = content;
		this.discount = discount;
		this.image_link = image_link;
		this.created = created;
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCatalog_id() {
		return catalog_id;
	}
	public void setCatalog_id(String product_cate) {
		this.catalog_id = product_cate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String product_price) {
		this.price = product_price;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDiscount() {
		return discount;
	}
	public void setDiscount(String discount) {
		this.discount = discount;
	}
	public String getImage_link() {
		return image_link;
	}
	public void setImage_link(String image_link) {
		this.image_link = image_link;
	}
	public String getCreated() {
		return created;
	}
	public void setCreated(String product_day) {
		this.created = product_day;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", catalog_id=" + catalog_id + ", name=" + name + ", price=" + price + ", status="
				+ status + ", description=" + description + ", content=" + content + ", discount=" + discount
				+ ", image_link=" + image_link + ", created="
				+ created + "]";
	}

	
}
