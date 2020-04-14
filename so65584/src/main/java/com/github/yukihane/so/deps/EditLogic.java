package com.github.yukihane.so.deps;

public interface EditLogic {

    /**
     * 保存処理
     * @param bean 編集画面のバッキングBean
     * @return 
     */
    boolean save(EditBean bean);

}
