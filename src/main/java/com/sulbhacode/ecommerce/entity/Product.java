
package com.sulbhacode.ecommerce.entity;

import java.math.BigDecimal;
import java.sql.Date;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Table(name="product")
@Data
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	@ManyToOne
	@JoinColumn(name="category_id", nullable = false)
	private ProductCategory category;
	
	@Column(name="sku")
	private String sku;
	
	@Column(name="name")	
	private String name;
	
	@Column(name="description")
	private String description;
	
	@Column(name="unit_price")	
	private BigDecimal unitPrice;
	
	@Column(name="image_url")	
	private String imageUrl;
	
	@Column(name="active")	
	private boolean active;
	
	@Column(name="units_in_Stock")		
	private int unitsInStock;
	
	@Column(name="date_created")
	@CreationTimestamp
	private Date dateCreated; 
	
	@Column(name="last_updated")
	@CreationTimestamp
	private Date lastUpdated;
	
	

}
