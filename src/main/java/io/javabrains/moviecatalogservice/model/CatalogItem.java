package io.javabrains.moviecatalogservice.model;

public class CatalogItem {
	
	private String name;
	private String desc;
	private String raiting;
	
	
	
	
	public CatalogItem(String name, String desc, String raiting) {
		
		this.name = name;
		this.desc = desc;
		this.raiting = raiting;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getRaiting() {
		return raiting;
	}
	public void setRaiting(String raiting) {
		this.raiting = raiting;
	}
	
	
	

}
