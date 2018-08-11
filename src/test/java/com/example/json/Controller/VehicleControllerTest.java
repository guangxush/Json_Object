package com.example.json.Controller;

import net.minidev.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by gshan on 2018/8/11
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {VehicleController.class})
@EnableConfigurationProperties
public class VehicleControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;


    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void testupdatecar() throws Exception{
        Map<String,Object> map = new HashMap<>();
        map.put("color", "Blue");
        map.put("miles", 300);
        map.put("vin", "1234");
        String json = JSONObject.toJSONString(map);
        MvcResult result = mockMvc.perform(post("/vehicle/car")
                .contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isOk())// 模拟向testRest发送post请求
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))// 预期返回值的媒体类型text/plain;charset=UTF-8
                .andExpect(jsonPath("$.miles").value(400))
                .andReturn();// 返回执行请求的结果
        System.out.println(result.getResponse().getContentAsString());
    }

    @Test
    public void testupdatecartest() throws Exception{
        Map<String,Object> map = new HashMap<>();
        map.put("color", "Blue");
        map.put("miles", 300);
        map.put("vin", "1234");
        String json = JSONObject.toJSONString(map);
        MvcResult result = mockMvc.perform(post("/vehicle/car")
                .contentType(MediaType.APPLICATION_JSON).content(json)
                .accept(MediaType.APPLICATION_JSON)) //执行请求
                .andExpect(content().contentType(MediaType.APPLICATION_JSON)) //验证响应contentType
                .andExpect(jsonPath("$.miles").value(300))
                .andReturn();// 返回执行请求的结果
        System.out.println(result.getResponse().getContentAsString());
    }
}
