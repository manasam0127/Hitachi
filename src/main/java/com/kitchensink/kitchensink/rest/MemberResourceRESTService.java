package com.kitchensink.kitchensink.rest;
import com.kitchensink.kitchensink.model.Member;
import com.kitchensink.kitchensink.service.MemberRegistration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import  org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/members")
public class MemberResourceRESTService {

    @Autowired
    private MemberRegistration memberRegistration;

    @GetMapping
    public List<Member> listAllMembers() {
        return memberRegistration.findAllMembers();
    }

    @GetMapping("/{id:[0-9][0-9]*}")
    public ResponseEntity<Member> lookupMemberById(@PathVariable("id") long id) {
        Member member = memberRegistration.findById(id);
        if (member == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(member, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Member> createMember(@RequestBody Member member) {
        memberRegistration.register(member);

        return new ResponseEntity<>(member, HttpStatus.CREATED);
    }
}

