package com.github.yukihane.so;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import com.github.yukihane.so.deps.Dept;
import com.github.yukihane.so.deps.DeptDao;
import com.github.yukihane.so.deps.EditBean;
import com.github.yukihane.so.deps.EditLogicImpl;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import org.jglue.cdiunit.CdiRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;

public class AppTest {
    @RunWith(CdiRunner.class)
    public static class SaveTest {

        @Inject
        private EditLogicImpl logic;

        @Mock
        @Produces
        private DeptDao dao;

            /**
         * 登録成功
         */
        @Test
        public void testSaveInsert() {
            // モックの戻り値設定
            long id = 1;
            Integer deptNo = 1;
            String deptName = "総務部";
            String loc = "新宿";
            Integer versionNo = 1;
            Dept dept = new Dept();
            dept.setId(id);
            dept.setDeptNo(deptNo);
            dept.setDeptName(deptName);
            dept.setLoc(loc);
            dept.setVersionNo(versionNo);

            // 実行設定
            EditBean bean = new EditBean();
            bean.setDisableId(false);
            bean.setDisableDeptNo(false);
            bean.setId(id);
            bean.setDeptNo(deptNo);
            bean.setDeptName(deptName);
            bean.setLoc(loc);
            bean.setVersionNo(versionNo);

            ArgumentCaptor<Dept> ac = ArgumentCaptor.forClass(Dept.class);
            doNothing().when(dao).insert(ac.capture());

            //try{
                logic.save(bean);
                Dept arg = ac.getValue();
                // 結果を確認
                assertEquals((long)id, (long)arg.getId());
                assertEquals(deptNo, arg.getDeptNo());
                assertEquals(deptName, arg.getDeptName());
                assertEquals(loc, arg.getLoc());
                assertEquals((int)versionNo,(int)arg.getVersionNo());
                // 呼び出し回数と引数を確認
                verify(dao, times(1)).insert(arg);
                verify(dao, times(0)).update(null);
                verify(dao, times(0)).findDeptNo(arg.getDeptNo());
                verify(dao, times(0)).findVersionNo(arg.getVersionNo());

            //}catch(NullPointerException e){
            //  Dept arg = ac.getValue();
            //  verify(dao, times(0)).insert(arg);
            //}
        }
    }
    }
