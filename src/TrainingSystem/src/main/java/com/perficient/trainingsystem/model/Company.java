package com.perficient.trainingsystem.model;


import java.util.Arrays;
import org.springframework.data.annotation.Id;

public class Company {
	@Id
	private String id;
	private String name;
	private String logo;
	private String type;
	private String introduce;
	private String address;
	private String phone;
	private String[] introPhoto;
	private String status;
    private String popularity;
    private String score;
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	

	public String[] getIntroPhoto() {
		return introPhoto;
	}

	public void setIntroPhoto(String[] introphoto) {
		this.introPhoto = introphoto;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	

	public String getPopularity() {
		return popularity;
	}

	public void setPopularity(String popularity) {
		this.popularity = popularity;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", logo=" + logo + ", type=" + type + ", introduce=" + introduce
				+ ", address=" + address + ", phone=" + phone + ", introPhoto=" + Arrays.toString(introPhoto)
				+ ", status=" + status + ", popularity=" + popularity + ", score=" + score + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Company other = (Company) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
