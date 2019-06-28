package com.xiazhe.service.technologyService;

import com.xiazhe.bean.Process;
import com.xiazhe.mapper.ProcessMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProcessServiceImpl implements ProcessService {
    @Autowired
    ProcessMapper processMapper;
    @Override
    public int deleteByPrimaryKey(String[] processId) {
        return processMapper.deleteByPrimaryKey(processId);
    }

    @Override
    public int insert(Process record) {
        return processMapper.insert(record);
    }

    @Override
    public Process[] selectByPrimaryKey(String processId) {
        return processMapper.selectByPrimaryKey(processId);
    }

    @Override
    public List<Process> queryAllProcess() {
        return processMapper.queryAllProcess();
    }

    @Override
    public int updateByPrimaryKey(Process record) {
        return processMapper.updateByPrimaryKey(record);
    }
}
