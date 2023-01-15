package spring.proj.shop.controller;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.proxy.HibernateProxy;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import spring.proj.shop.entity.Member;
import spring.proj.shop.entity.Team;
import spring.proj.shop.repository.MemberRepository;
import spring.proj.shop.repository.TeamRepository;

import javax.annotation.PostConstruct;

@RequiredArgsConstructor
@RestController
public class MemberController {

    private final MemberRepository memberRepository;
    private final TeamRepository teamRepository;

    @PostConstruct
    void initDb(){
        Team teamA = Team.builder().name("TeamA").build();

        Member memberA = Member.builder().age(10).email("memberA@gmail.com").name("memberA").team(teamA).build();
        Member memberB = Member.builder().age(10).email("memberB@gmail.com").name("memberB").team(teamA).build();

        teamRepository.save(teamA);
        memberRepository.save(memberA);
        memberRepository.save(memberB);
    }

    @GetMapping("/members/v1/{id}")
    public Member getMember1(@PathVariable("id") Long id){
        return memberRepository.findById(id).orElse(null);
    }


    @GetMapping("/members/v2/{id}")
    public Member getMember2(@PathVariable("id") Long id){
        return memberRepository.findEntityGraphById(id);
    }


    @GetMapping("/members/v3/{id}")
    public MemberDto getMember3(@PathVariable("id") Long id){
        Member member = memberRepository.findEntityGraphById(id);
        MemberDto dto = new MemberDto(member);
        return dto;
    }

    @Data
    @NoArgsConstructor
    static class MemberDto {
        private String name;
        private int age;
        private Team team;

        public MemberDto(Member member) {
            this.name = member.getName();
            this.age = member.getAge();
            this.team = member.getTeam();
        }
    }

}
