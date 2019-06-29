package com.xiazhe.service.processCountCheckService;

import com.xiazhe.bean.ProcessCountCheck;
import com.xiazhe.mapper.ProcessCountCheckMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ZhengX
 * @create 2019-06-29 17:56
 **/
@Service
public class ProcessCountCheckServiceImpl implements ProcessCountCheckService {
    @Autowired
    ProcessCountCheckMapper processCountCheckMapper;
    @Override
    public int deleteByPrimaryKey(String[] pCountCheckIds) {
        return processCountCheckMapper.deleteByPrimaryKey(pCountCheckIds);
    }

    @Override
    public int insert(ProcessCountCheck record) {
        return processCountCheckMapper.insert(record);
    }

    @Override
    public int insertSelective(ProcessCountCheck record) {
        return processCountCheckMapper.insertSelective(record);
    }

    @Override
    public List<ProcessCountCheck> selectByPrimaryKey(String pCountCheckId) {
        return processCountCheckMapper.selectByPrimaryKey(pCountCheckId);
    }

    @Override
    public int updateByPrimaryKeySelective(ProcessCountCheck record) {
        return processCountCheckMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(ProcessCountCheck record) {
        return processCountCheckMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<ProcessCountCheck> queryAll() {
        return processCountCheckMapper.queryAll();
    }
}
