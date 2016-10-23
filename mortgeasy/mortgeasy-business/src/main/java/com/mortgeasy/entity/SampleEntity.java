package com.mortgeasy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.mortgeasy.common.BaseEntity;

@Entity
@Table(name = SampleEntity.TABLE_NAME)
@SequenceGenerator(allocationSize = 1, name = "gen_sample_entity", sequenceName = "sample_entity_seq")
public class SampleEntity extends BaseEntity<Integer> {

	private static final long serialVersionUID = 4594625642635423343L;

	public static final String TABLE_NAME = "sample_entity";

	private Integer id;
	private String description;
	
	public SampleEntity() {
		
	}
	
	@Id
	@GeneratedValue(generator = "gen_sample_entity", strategy = GenerationType.SEQUENCE)
	@Column(name = "id_tag", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
		
	@Column(name = "description", length = 100, unique = true)
	@Size.List({
		@Size(min=1, message="Description must be filled."),
		@Size(max=100, message="Description max size is {max}.")
		})
	@NotNull(message="Description field is required")
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}