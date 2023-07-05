package stu.sk47kt.sk47kt_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import stu.sk47kt.sk47kt_spring.domain.Member;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    @Override
    Optional<Member> findByName(String name);
}
