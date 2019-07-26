package com.github.yukihane.so56891;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@org.springframework.stereotype.Service
@Transactional(readOnly = true)
public class ServiceImpl implements Service
{
    @Autowired
    private Repository _repository;

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public boolean insert(String user) throws Exception
    {
        UserMst userMst = this.setUserMst(user);
        try
        {
            _repository.saveAndFlush(userMst);
        }catch(Exception e)
        {
            return false;
        }
        return true;
    }

    private UserMst setUserMst(String user)
    {
        UserMst userMst = new UserMst();
        userMst.setUserId(user);
        return userMst;
    }
}