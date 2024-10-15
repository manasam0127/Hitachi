package com.kitchensink.kitchensink.controller;

import com.kitchensink.kitchensink.model.Member;
import com.kitchensink.kitchensink.service.MemberRegistration;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



@Controller
@RequestMapping("/members")
public class MemberController {

    @Autowired
    private MemberRegistration memberRegistration;

    @GetMapping
    public String listMembers(Model model) {
        model.addAttribute("members", memberRegistration.findAllMembers());
        return "members";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("member", new Member());
        return "createMember";
    }

    @PostMapping
    public String createMember(@Valid Member member, BindingResult result,
                               RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "createMember";
        }

        memberRegistration.register(member);
        redirectAttributes.addFlashAttribute("successMessage", "Registered!");
        return "redirect:/members";
    }
}
