package org.citizeninn;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
public class OpinionPoll {
	
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	private ArrayList<Opinion> opinions = new ArrayList<Opinion>();
	
	public void addOpinion(Opinion opinion)
	{
		opinions.add(opinion);
	}
	
	
	//TO-DO implement deep copy of elements
	public ArrayList<Opinion> getOpinions()
	{
		return opinions;
	}

}
