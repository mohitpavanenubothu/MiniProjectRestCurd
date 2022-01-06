package com.springrest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "SPM_REST_TOURIST")
public class Tourist {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer tid;

	@Column(length = 20)
	@NonNull
	private String name;

	@Column(length = 20)
	@NonNull
	private String city;

	@Column(length = 20)
	@NonNull
	private String packageType;

	@NonNull
	private Double budget;

}
