package spring.proj.shop.repository;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import spring.proj.shop.dto.MemberDto;
import spring.proj.shop.dto.QMemberDto;

import static spring.proj.shop.entity.QMember.member;
import static spring.proj.shop.entity.QTeam.team;

@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepositoryDsl{

    private final JPAQueryFactory queryFactory;

    @Override
    public MemberDto findMemberDtoById(Long id) {
        return queryFactory
                .select(new QMemberDto(
                        member.id,
                        member.name,
                        member.age,
                        member.email,
                        team.id.as("team_id"),
                        team.name.as("team_name")))
                .from(member)
                .join(team).on(member.team_id.eq(team.id))
                .where(memberIdEqual(id))
                .fetchOne();
    }


    private BooleanExpression memberIdEqual(Long id) {
        return id != null ? member.id.eq(id) : null;
    }
}
