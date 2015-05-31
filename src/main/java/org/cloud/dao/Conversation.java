package org.cloud.dao;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Conversation entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "conversation", catalog = "cloud")
public class Conversation implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer count;
	private String UName;
	private Set<Sms> smses = new HashSet<Sms>(0);

	// Constructors

	/** default constructor */
	public Conversation() {
	}

	/** minimal constructor */
	public Conversation(Integer count, String UName) {
		this.count = count;
		this.UName = UName;
	}

	/** full constructor */
	public Conversation(Integer count, String UName, Set<Sms> smses) {
		this.count = count;
		this.UName = UName;
		this.smses = smses;
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

	@Column(name = "count", nullable = false)
	public Integer getCount() {
		return this.count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	@Column(name = "u_name", nullable = false, length = 45)
	public String getUName() {
		return this.UName;
	}

	public void setUName(String UName) {
		this.UName = UName;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "conversation")
	public Set<Sms> getSmses() {
		return this.smses;
	}

	public void setSmses(Set<Sms> smses) {
		this.smses = smses;
	}

}