package spring.proj.shop.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@NoArgsConstructor
public class TeamId implements Serializable {
    private Long id;
    private String name;
}
