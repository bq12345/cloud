package org.cloud.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Sms entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sms", catalog = "cloud")
public class Sms implements java.io.Serializable {

	// Fields

	private Integer id;
	private Conversation conversation;
	private String content;
	private Short type;

	// Constructors

	/** default constructor */
	public Sms() {
	}

	/** full constructor */
	public Sms(Conversation conversation, String content, Short type) {
		this.conversation = conversation;
		this.content = content;
		this.type = type;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "c_id", nullable = false)
	public Conversation getConversation() {
		return this.conversation;
	}

	public void setConversation(Conversation conversation) {
		this.conversation = conversation;
	}

	@Column(name = "content", nullable = false, length = 140)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "type", nullable = false)
	public Short getType() {
		return this.type;
	}

	public void setType(Short type) {
		this.type = type;
	}

}