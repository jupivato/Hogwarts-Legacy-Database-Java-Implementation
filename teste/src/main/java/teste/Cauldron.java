package teste;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Cauldron 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int seriesNumber;
	
	private String metal;
	private int size;
	
	// get set
	public String getMetal() {return metal;}
	public void setMetal(String metal) {this.metal = metal;}
	public int getSize() {return size;}
	public void setSize(int size) {this.size = size;}
}
