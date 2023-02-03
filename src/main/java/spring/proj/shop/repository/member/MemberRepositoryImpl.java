package spring.proj.shop.repository.member;

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


    private BooleanExpression memberIdEqual(Long id) {
        return id != null ? member.id.eq(id) : null;
    }
}
