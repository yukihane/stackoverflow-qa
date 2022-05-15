package com.example.tt_prjoikesb7euqf;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MemoService {
    private final MemoMapper memoMapper;

    public MemoService(MemoMapper memoMapper) {
        this.memoMapper = memoMapper;
    }

    // 全件取得
    public List<Memo> getMemoList() {
        return memoMapper.findAll();
    }
}