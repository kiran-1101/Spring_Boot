package com.kiran.user.service.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @Column(name= "ID")
    private String userId;
    @Column(name="NAME",length = 20)
    private String name;
    @Column(name="EMAIL")
    private String Email;
    @Column(name= "ABOUT")
    private String about;
    @Transient
    private List<Rating> ratings = new ArrayList<>();



}
