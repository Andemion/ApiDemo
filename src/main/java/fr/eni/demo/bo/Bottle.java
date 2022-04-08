package fr.eni.demo.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

@Entity
@Table(name="BOTTLE")
public class Bottle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(length = 50 , nullable = false)
	@NotBlank
	@Size(min=5, max=50)
	private String name;
	
	private boolean sparkling;
	
	@Column(length = 4)
	private String vintage;
	
	@Min(value = 0)
	private int quantity;
	
	@NotNull
	@ManyToOne(fetch=FetchType.EAGER)
	private Color color;
	
	@NotNull
	@ManyToOne(fetch=FetchType.EAGER)
	private Region region;
		
	public Bottle() {
	}

	public Bottle(int id, @NotBlank @Size(min = 5, max = 50) String name, boolean sparkling, String vintage,
			@Min(1) int quantity, Color color, Region region) {
		this.id = id;
		this.name = name;
		this.sparkling = sparkling;
		this.vintage = vintage;
		this.quantity = quantity;
		this.color = color;
		this.region = region;
	}

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

	public boolean isSparkling() {
		return sparkling;
	}

	public void setSparking(boolean sparkling) {
		this.sparkling = sparkling;
	}

	public String getVintage() {
		return vintage;
	}

	public void setVintage(String vintage) {
		this.vintage = vintage;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	@Override
	public String toString() {
		return "Bottle [id=" + id + ", name=" + name + ", sparkling=" + sparkling + ", vintage=" + vintage + ", quantity="
				+ quantity + ", color=" + color + ", region=" + region + "]";
	}
	
	
}
