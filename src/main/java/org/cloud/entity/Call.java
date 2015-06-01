package org.cloud.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Call entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "call", catalog = "cloud")
public class Call implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer type;
	private String name;
	private String phone;
	private Timestamp time;
	private Integer duration;

	// Constructors

	/** default constructor */
	public Call() {
	}

	/** minimal constructor */
	public Call(String name, String phone, Timestamp time, Integer duration) {
		this.name = name;
		this.phone = phone;
		this.time = time;
		this.duration = duration;
	}

	/** full constructor */
	public Call(Integer type, String name, String phone, Timestamp time,
			Integer duration) {
		this.type = type;
		this.name = name;
		this.phone = phone;
		this.time = time;
		this.duration = duration;
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

	@Column(name = "type")
	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	@Column(name = "name", nullable = false, length = 45)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "phone", nullable = false, length = 45)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "time", nullable = false, length = 19)
	public Timestamp getTime() {
		return this.time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	@Column(name = "duration", nullable = false)
	public Integer getDuration() {
		return this.duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

}