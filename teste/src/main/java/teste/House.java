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
public class House
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String name;
	private String color;
	private String symbol;
	
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public String getColor() {return color;}
	public void setColor(String color) {this.color = color;}
	public String getSymbol() {return symbol;}
	public void setSymbol(String symbol) {this.symbol = symbol;}
}
