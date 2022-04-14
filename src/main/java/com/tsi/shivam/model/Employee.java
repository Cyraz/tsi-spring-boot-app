package com.tsi.shivam.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @JsonProperty
    String name;

    @JsonProperty
    int age;

    @JsonProperty
    String jobTitle;

    @JsonProperty
    String company;
}
