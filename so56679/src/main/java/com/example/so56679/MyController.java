package com.example.so56679;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MyController {
    
    private final PrefectureRepository prefectureRepository;
    private final ActorRepository actorRepository;
    private final MessageSource msg;

    @GetMapping("/actor/create")
    public String create(ActorForm form, Model model) {
        List<Prefecture> pref = prefectureRepository.findAll();
        model.addAttribute("pref", pref);
        return "Actor/create";
    }

    @PostMapping("/actor/save")
    public String save(@Validated @ModelAttribute ActorForm form, BindingResult result, Model model, Locale locale) {
        if (result.hasErrors()) {
            String message = msg.getMessage("actor.validation.error", null, locale);
            model.addAttribute("errorMessage", message);
            return create(form, model);
        }
        Actor actor = convert(form);
        actor = actorRepository.saveAndFlush(actor);
        return "redirect:/actor/" + actor.getId().toString();
    }

    /**
     * convert form to model.
     */
    private Actor convert(ActorForm form) {
        Actor actor = new Actor();
        actor.setName(form.getName());
        if (StringUtils.isNotEmpty(form.getHeight())) {
            actor.setHeight(Integer.valueOf(form.getHeight()));
        }
        if (StringUtils.isNotEmpty(form.getBlood())) {
            actor.setBlood(form.getBlood());
        }
        if (form.getBirthday() != null) {
            LocalDateTime parsed = form.getBirthday().atStartOfDay();
            Instant instant = parsed.toInstant(ZoneOffset.ofHours(9));
            actor.setBirthday(Date.from(instant));
        }
        if (StringUtils.isNotEmpty(form.getBirthplaceId())) {
            actor.setBirthplaceId(Integer.valueOf(form.getBirthplaceId()));
        }
        actor.setUpdateAt(new Date());
        return actor;
    }
}
