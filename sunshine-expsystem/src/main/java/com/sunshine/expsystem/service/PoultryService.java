package com.sunshine.expsystem.service;

import com.sunshine.common.pojo.CommonResult;

/**
 * Created by kong on 16/7/6.
 * 畜禽预测服务
 */
public interface PoultryService {

    public CommonResult getTopics();

    public CommonResult getSymtomsByTopicName(String field);

}
