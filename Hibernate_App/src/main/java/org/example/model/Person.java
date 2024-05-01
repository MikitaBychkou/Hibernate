package org.example.model;

import javax.persistence.*;// обязательно эту аннотацию использовать!!!!
import java.util.List;

@Entity //в классах с данной аннотацией обязательно должен быть конструктора без пораметров. Hibernate работает только с этими классами
@Table(name="Person") //(name="Person") писать необязательно, если таблица в бд имеет такое же название
public class Person {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "age")
	private int age;

	@OneToMany(mappedBy = "owner")
	private List<Item> items;

	public Person() {
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person{" +
				"id=" + id +
				", name='" + name + '\'' +
				", age=" + age +
				'}';
	}
}
