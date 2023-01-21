package spring.proj.shop.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import spring.proj.shop.dto.MemberDto;
import spring.proj.shop.entity.Member;
import spring.proj.shop.entity.Team;

import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;
    @Autowired
    TeamRepository teamRepository;

    @Test
    void findMemberDtoById() throws Exception {
        //given
        Long id = 1L;

        //when
        MemberDto memberDto = memberRepository.findMemberDtoById(id);
        Member member = memberRepository.findById(id).orElse(null);
        assert member != null;
        Team team = teamRepository.findTeamById(member.getTeam_id());

        //then
        assertThat(memberDto.getTeam_id()).isEqualTo(team.getId());
        assertThat(memberDto.getTeam_name()).isEqualTo(team.getName());
    }

}