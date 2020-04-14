package com.github.yukihane.so;

import com.github.yukihane.so.deps.CommonUtil;
import com.github.yukihane.so.deps.Dept;
import com.github.yukihane.so.deps.DeptDao;
import com.github.yukihane.so.deps.EditBean;
import com.github.yukihane.so.deps.FacesContext;
import com.github.yukihane.so.deps.MyBean;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class MyBeanImpl implements MyBean {

    @Inject
    private DeptDao dao;

    /**
     * 保存処理
     * @param bean 編集画面のバッキングBean
     */
    @Override
    public boolean save(EditBean bean){
        Dept dept = new Dept();
        dept.setId(bean.getId());
        dept.setDeptName(bean.getDeptName());
        dept.setDeptNo(bean.getDeptNo());
        dept.setLoc(bean.getLoc());
        if(bean.getVersionNo() != null){
            dept.setVersionNo(bean.getVersionNo());
        }else{
            dept.setVersionNo(0);
        }

        if(bean.isDisableId()){
            // deptNo非重複時エラー
            if((dao.findDeptNo(bean.getDeptNo())) == null){
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage("", CommonUtil.getFacesInfoMessage("messages.add.error.dept.notfound"));
                return false;
            // 更新
            }else{
                // versionNo不一致時エラー
                if(bean.getVersionNo() != dao.findVersionNo(bean.getDeptNo())){
                    FacesContext context = FacesContext.getCurrentInstance();
                    context.addMessage("", CommonUtil.getFacesInfoMessage("messages.add.error.dept.exclusive"));
                    // データ再取得、取得データ画面表示
                    Dept dept2 = dao.findById(bean.getId());
                    bean.setId(dept2.getId());
                    bean.setDeptName(dept2.getDeptName());
                    bean.setDeptNo(dept2.getDeptNo());
                    bean.setLoc(dept2.getLoc());
                    bean.setVersionNo(dept2.getVersionNo());
                    bean.setDisableId(true);
                    bean.setDisableDeptNo(true);
                    return false;
                }
                // versionNo一致時 更新処理
                else{
                    dao.update(dept);
                    bean.setVersionNo(dept.getVersionNo());
                    return true;
                }
            }
        }else{
            // deptNo重複時エラー
            if((dao.findDeptNo(bean.getDeptNo())) != null){
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage("", CommonUtil.getFacesInfoMessage("messages.add.error.dept.duplicate"));
                return false;
            }else{
                // 新規登録
                dao.insert(dept);
                bean.setDisableId(true);
                bean.setDisableDeptNo(true);
                return true;
            }
        }
    }
}
