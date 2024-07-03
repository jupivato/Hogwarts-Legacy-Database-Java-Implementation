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
public class Broomstick {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int seriesNumber;

    private String name;
    private String wood;
    private float resistance;
	
    public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public String getWood() {return wood;}
	public void setWood(String wood) {this.wood = wood;}
	public float getResistance() {return resistance;}
	public void setResistance(float resistance) {this.resistance = resistance;}

    // Construtor, getters e setters
    // Lombok gera automaticamente os getters, setters e construtor vazio
}
