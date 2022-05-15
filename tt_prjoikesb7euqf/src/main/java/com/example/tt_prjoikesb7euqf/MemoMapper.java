package com.example.tt_prjoikesb7euqf;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemoMapper {
    // 全件取得
    public List<Memo> findAll();
}
