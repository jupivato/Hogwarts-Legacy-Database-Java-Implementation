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
public class Enemy
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String name;
	private String enemyType;
	private int attackSkills;
	private int alive;
	
	// get set
	// get set
	public String getEnemyType() {return enemyType;}
	public void setEnemyType(String enemyType) {this.enemyType = enemyType;}
	public int getAttackSkills() {return attackSkills;}
	public void setAttackSkills(int attackSkills) {this.attackSkills = attackSkills;}
	public int getAlive() {return alive;}
	public void setAlive(int alive) {this.alive = alive;}
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
}
