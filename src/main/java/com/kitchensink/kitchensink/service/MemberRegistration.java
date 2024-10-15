package com.kitchensink.kitchensink.service;
import com.kitchensink.kitchensink.data.MemberRepository;
import com.kitchensink.kitchensink.model.Member;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberRegistration {

    private static final Logger log = LoggerFactory.getLogger(MemberRegistration.class);

    @Autowired
    private MemberRepository memberRepository;

    public List<Member> findAllMembers() {
        return memberRepository.findAll();
    }

    public Member findById(Long id) {
        return memberRepository.findById(id).orElse(null);

    }


    public void register(Member member) {
        log.info("Registering " + member.getName());
        memberRepository.save(member);
    }


}
