package org.citizeninn;

import java.util.ArrayList;

public class OpinionPoll {
	
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
