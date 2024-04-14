package com.Media_File.Media_File;

import java.util.Arrays;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="ImagesTable")
public class Image {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	private String name;
	private String desc;
	
	@Lob
	private byte[]image;
	 @Transient ////this annotation does notwrite into db
	 private String base64Image;
	
	

	public String getBase64Image() {
		return base64Image;
	}

	public void setBase64Image(String base64Image) {
		this.base64Image = base64Image;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Image [id=" + id + ", name=" + name + ", desc=" + desc + ", image=" + Arrays.toString(image) + "]";
	}

	public Image() {
	
	
	}

	
	
	

}
