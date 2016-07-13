package com.gep.test;

import com.sunshine.common.pojo.GepDocument;
import com.sunshine.common.utils.GepClient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by kong on 16/7/4.
 */
public class GepClientTest {

    public static void main(String[] args) {
        GepDocument gepDocument = new GepDocument();
        gepDocument.setId("fish");
        Map<String,Object> map = new HashMap<>();
        map.put("tb_head","2");
        map.put("tb_tail","21");
        map.put("tb_body","3");
        map.put("tb_blood","6");
        map.put("tb_fins","65");
        map.put("tb_action","77");
        map.put("tb_bug","41");
        map.put("tb_eyes","22");
        map.put("tb_mouth","33");


        gepDocument.setMap(map);

        GepClient gepClient = new GepClient("127.0.0.1",8087);
        List<String> topics = gepClient.getSymtomsByTopicField("fish","tb_head");
        System.out.println(topics);
    }
}
