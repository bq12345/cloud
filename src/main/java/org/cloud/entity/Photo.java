package org.cloud.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Photo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "photo", catalog = "cloud")
public class Photo implements java.io.Serializable {

	// Fields

	private Integer id;
	private String path;

	// Constructors

	/** default constructor */
	public Photo() {
	}

	/** full constructor */
	public Photo(String path) {
		this.path = path;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "path", nullable = false, length = 45)
	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}