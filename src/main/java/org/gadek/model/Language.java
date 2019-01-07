package org.gadek.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "language")
public class Language {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
	@Column 
	private String descriptions;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "language", orphanRemoval = true)
    private Set<Movie> movie = new HashSet<>();
    
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}



	public Language( @NotNull String descriptions) {
		super();
		this.descriptions = descriptions;
	}



	public String getDescriptions() {
		return descriptions;
	}
	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}

}
