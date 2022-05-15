package com.example.tt_prjoikesb7euqf;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemoController {
    private final MemoService memoService;

    public MemoController(MemoService dateService) {
        this.memoService = dateService;
    }

    /* Top */
    @GetMapping("/memos")
    public List<Memo> index() {
        return memoService.getMemoList();
    }
}
