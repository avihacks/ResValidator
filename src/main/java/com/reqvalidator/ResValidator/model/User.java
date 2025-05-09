package com.reqvalidator.ResValidator.model;

import java.time.LocalDate;
import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.experimental.Accessors;


@Table(name = "users")
@Entity
@Data
@Accessors(chain = true)
public class User {
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	  private int id;

	  @Column(length = 100, nullable = false)
	  private String name;

	  @Column(unique = true, nullable = false)
	  private String email;

	  @Column(nullable = false)
	  private LocalDate birthDate;

	  @Column(length = 10, nullable = false)
	  private String gender;

	  @CreationTimestamp
	  @Column(updatable = false)
	  private Date createdAt;

	  @UpdateTimestamp
	  private Date updatedAt;
	  
	  @OneToOne(cascade = CascadeType.REMOVE)
	  @JoinColumn(name = "address_id", referencedColumnName = "id", nullable = false)
	  private Address address;
	  
	 
}
