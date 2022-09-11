package magar.atul.webapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="feedback_data")
public class FeedBack {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="feedback_no")
	private int id;
	
	@Column(name="employee_name")
	private String name;
	
	@Column(name="employee_email")
	private String email;
	
	@Column(name="employedd_feedback")
	private String feedBack;
	
	//constructor
	public FeedBack() {}

	public FeedBack(int id, String name, String email, String feedBack) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.feedBack = feedBack;
	}
	
	public FeedBack(String name, String email, String feedBack) {
		super();
		this.name = name;
		this.email = email;
		this.feedBack = feedBack;
	}

	//getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFeedBack() {
		return feedBack;
	}

	public void setFeedBack(String feedBack) {
		this.feedBack = feedBack;
	}

	//tostring
	@Override
	public String toString() {
		return "FeedBack [id=" + id + ", name=" + name + ", email=" + email + ", feedBack=" + feedBack + "]";
	}
	
}
