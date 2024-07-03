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
public class Wand
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private float length;
	private float flexibility;
	private String wood;
	private String core;
	
	// get set
	public float getLength() {return length;}
	public void setLength(float length) {this.length = length;}
	public float getFlexibility() {return flexibility;}
	public void setFlexibility(float flexibility) {this.flexibility = flexibility;}
	public String getWood() {return wood;}
	public void setWood(String wood) {this.wood = wood;}
	public String getCore() {return core;}
	public void setCore(String core) {this.core = core;}
}