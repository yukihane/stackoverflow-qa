package com.example.so62853218;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
@RequiredArgsConstructor
public class MyController {

    private final NoteService noteService;

    @GetMapping("")
    public String index(final Model model) {
        final List<Note> allNotes = List.of(new Note(1, "note1"));
        model.addAttribute("allNotes", allNotes);
        return "index";
    }

    @PostMapping("/editNote/{noteId}")
    public String editNote(@ModelAttribute("note") final Note note,
        @PathVariable(value = "noteId") final Integer noteId,
        final Model model) {
        System.out.println("noteid " + noteId);
        System.out.println("notedesc" + note.getNoteDescription());
        noteService.editNote(note);
        return "result";
    }
}
