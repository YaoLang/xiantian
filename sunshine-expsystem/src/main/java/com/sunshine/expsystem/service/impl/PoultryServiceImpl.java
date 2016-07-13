package com.sunshine.expsystem.service.impl;

import com.sunshine.common.pojo.CommonResult;
import com.sunshine.common.utils.GepClient;
import com.sunshine.expsystem.service.PoultryService;

import java.util.List;

/**
 * Created by kong on 16/7/6.
 */
public class PoultryServiceImpl implements PoultryService {

    private GepClient gepClient;

    private String topic;

    @Override
    public CommonResult getTopics() {
        List<String> topics = gepClient.getTopics(topic);
        return CommonResult.ok(topics);
    }

    @Override
    public CommonResult getSymtomsByTopicName(String field) {
        List<String> symptoms = gepClient.getSymtomsByTopicField(topic,field);
        return null;
    }

    public GepClient getGepClient() {
        return gepClient;
    }

    public void setGepClient(GepClient gepClient) {
        this.gepClient = gepClient;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
}
