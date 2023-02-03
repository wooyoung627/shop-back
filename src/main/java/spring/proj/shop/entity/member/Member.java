package spring.proj.shop.entity.member;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Builder
@ToString
@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor
public class Member implements Serializable {

    @Id
    @Column(name = "member_id")
    @GeneratedValue
    private Long id;

    private String name;

    private int age;

    private String email;

    private String phone;
}
