package com.github.yukihane.so.deps;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;

@Dependent
public class EditLogicImpl implements EditLogic{

    @Inject
    private DeptDao dao;
    
    /**
     * 保存処理
     * @param bean 編集画面のバッキングBean
     * @see https://ja.stackoverflow.com/q/65320/2808
     */
    @Override
    public void save(EditBean bean){
        Dept dept = new Dept();
        dept.setId(bean.getId());
        dept.setDeptName(bean.getDeptName());
        dept.setDeptNo(bean.getDeptNo());
        dept.setLoc(bean.getLoc());
        if(bean.getVersionNo() != null){
            dept.setVersionNo(bean.getVersionNo());
        }else{
        }

        if(bean.isDisableId()){
            // 更新
            dao.update(dept);
            bean.setVersionNo(dept.getVersionNo());
        }else{
            // 新規登録
            dao.insert(dept);
            bean.setDisableId(true);
        }
    }
}
