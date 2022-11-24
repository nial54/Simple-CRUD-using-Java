package com.mvc.model;

public class Model {
	protected int id;
	protected String name, email, address, phone, city, country, education;
	protected String photo;
	protected byte[] image;
	
	public Model(int id, String name, String email, String address, String phone, String city, String country, String education, byte[]image)
	{
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.city = city;
		this.country = country;
		this.education = education;
		this.image = image;
	}
	
	public Model(int id, String name, String email, String address, String phone, String city, String country, String education)
	{
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.city = city;
		this.country = country;
		this.education = education;
	}
	
	public Model(int id, String name, String city)
	{
		super();
		this.id = id;
		this.name = name;
		this.city = city;
	}
	
	public Model(String name, String email, String address, String phone, String city, String country, String education, String photo)
	{
		super();
		this.name = name;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.city = city;
		this.country = country;
		this.education = education;
		this.photo = photo;
	}
	
	public Model(int id, String name, String email, String address, String phone, String city, String country, String education, String photo)
	{
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.city = city;
		this.country = country;
		this.education = education;
		this.photo = photo;
	}
	
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	
	public String getAddress()
	{
		return address;
	}
	public void setAddress(String address)
	{
		this.address = address;
	}
	
	public String getPhone()
	{
		return phone;
	}
	public void setPhone(String phone)
	{
		this.phone = phone;
	}
	
	public String getCity()
	{
		return city;
	}
	public void setCity(String city)
	{
		this.city = city;
	}
	
	public String getCountry()
	{
		return country;
	}
	public void setCountry(String country)
	{
		this.country = country;
	}
	
	public String getEducation()
	{
		return education;
	}
	public void setEducation(String education)
	{
		this.education = education;
	}
	
	public String getPhoto()
	{
		return photo;
	}
	public void setPhoto(String photo)
	{
		this.photo = photo;
	}
	
	public byte[]getImage()
	{
		return image;
	}
	public void setImage(byte[] image)
	{
		this.image = image;
	}
}
