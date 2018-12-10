package cn.wilmar.demo.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;


@Data
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "roleKey", unique = true)
    @NotEmpty @NonNull String key;

    @Column(unique = true)
    @NotEmpty @NonNull String name;

    String description;

}

