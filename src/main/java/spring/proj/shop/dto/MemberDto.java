package spring.proj.shop.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MemberDto {

    private Long id;

    private String name;

    private int age;

    private String email;

    private Long team_id;

    private String team_name;


    @QueryProjection
    public MemberDto(Long id, String name, int age, String email, Long team_id, String team_name) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.team_id = team_id;
        this.team_name = team_name;
    }
}
