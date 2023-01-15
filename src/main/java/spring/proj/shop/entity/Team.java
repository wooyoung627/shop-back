package spring.proj.shop.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@Getter
@ToString(of = {"id", "name"})
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor
public class Team {

    @Id
    @Column(name = "team_id")
    @GeneratedValue
    private Long id;

    private String name;

}
