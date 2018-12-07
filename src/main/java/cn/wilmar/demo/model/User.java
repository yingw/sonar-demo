package cn.wilmar.demo.model;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;


@Data
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String username;
    private String password;
    private Gender gender = Gender.randomGender();

    Set<Role> roles = new HashSet<>();
}
