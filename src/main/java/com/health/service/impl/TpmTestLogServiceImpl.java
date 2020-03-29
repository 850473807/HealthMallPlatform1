package com.health.service.impl;

import com.health.mapper.TpmTestLogMapper;
import com.health.model.TpmTestLog;
import com.health.service.TpmTestLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @TpmTestLogServiceImpl
 * @ServiceImpl
 * @version : Ver 1.0
 */
@Service
@Transactional
public class TpmTestLogServiceImpl implements TpmTestLogService {

    @Autowired
    private TpmTestLogMapper tpmTestLogMapper;

    @Override
    public Long ceshi(TpmTestLog tpmTestLog) {
        return tpmTestLogMapper.insert(tpmTestLog);

    }
}