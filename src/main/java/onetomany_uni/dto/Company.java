package onetomany_uni.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Company {

	@Id
	private int id;
	private String name;
	private String location;
	
	@OneToMany
	private List<Employee> list;
}
