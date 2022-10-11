package ssv.section2.domain;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;

@Data
@Entity
public class Author {



	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String firstName;
	private String laseName;

	public Author(String firstName, String laseName) {
		this.firstName = firstName;
		this.laseName = laseName;
	}
	public Author() {
    }

	@ManyToMany(mappedBy = "authors")
	private Set<Book> books = new HashSet<>();

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Author other = (Author) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public String toString() {
		return "Author [id=" + id + ", firstName=" + firstName + ", laseName=" + laseName + ", books=" + books + "]";
	}

}
