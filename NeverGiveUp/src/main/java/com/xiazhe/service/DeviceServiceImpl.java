package com.xiazhe.service;

import com.xiazhe.bean.DeviceType;
import com.xiazhe.mapper.DeviceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    DeviceMapper deviceMapper;

    @Override
    public List queryAllDeviceType() {
        List list = deviceMapper.queryAllDeviceType();

        return list;
    }
}
