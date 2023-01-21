package spring.proj.shop.repository;

import spring.proj.shop.dto.MemberDto;

import java.util.List;

public interface MemberRepositoryDsl {

    MemberDto findMemberDtoById(Long id);

}
