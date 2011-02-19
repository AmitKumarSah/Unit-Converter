package com.joopware.unitconverter;
public class Currency {	
	
	private String title, link, guid, pubDate, description, category;
	
	public Currency(){
		
	}
	
	public Currency(String name, int id, int age, String type) {
//		this.name = name;
//		this.age = age;
//		this.id  = id;
//		this.type = type;
		
	}
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}
	
	public String getPubDate() {
		return pubDate;
	}

	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}	
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Currency Details - ");
		sb.append("Title:" + getTitle());
		sb.append(", ");
		sb.append("Link:" + getLink());
		sb.append(", ");
		sb.append("Guid:" + getGuid());
		sb.append(", ");
		sb.append("PubDate:" + getPubDate());
		sb.append(", ");
		sb.append("Description:" + getDescription());
		sb.append(", ");
		sb.append("Category:" + getCategory());
		sb.append(".");
		
		return sb.toString();
	}
}