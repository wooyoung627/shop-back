package spring.proj.shop.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Getter
@ToString(of = {"id", "name"})
@IdClass(TeamId.class)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor
public class Team implements Serializable {

    @Id
    @Column(name = "team_id")
    @GeneratedValue
    private Long id;

    @Id
    private String name;

}
