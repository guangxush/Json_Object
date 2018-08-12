package com.example.json.Controller;

import com.example.json.Dao.Car;
import com.example.json.Dao.Truck;
import com.example.json.Services.RequestWrapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
/**
 * Created by gshan on 2018/8/11
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class VehicleControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private Car car;

    @Autowired
    private Truck truck;

    @Autowired
    private RequestWrapper requestWrapper;

    @Autowired
    private ObjectMapper mapper;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void testjson() throws Exception{
        Map<String,Object> map = new HashMap<>();
        map.put("color", "Blue");
        map.put("miles", 300);
        map.put("vIN", "1234");
        String json = JSONObject.toJSONString(map);
        MvcResult result = mockMvc.perform(post("/vehicle/car")
                .contentType(MediaType.APPLICATION_JSON_UTF8).content(json)
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8)) //验证响应contentType
                .andExpect(jsonPath("$.vIN").value("1234"))
                .andReturn();
        System.out.println(result.getResponse().getContentAsString());
    }

    @Test
    public void testupdatecar() throws Exception{
        Map<String,Object> map = new HashMap<>();
        map.put("color", "Blue");
        map.put("miles", 300);
        map.put("vin", "1234");
        String json = JSONObject.toJSONString(map);
        MvcResult result = mockMvc.perform(post("/vehicle/car")
                .contentType(MediaType.APPLICATION_JSON_UTF8).content(json)
                .accept(MediaType.APPLICATION_JSON_UTF8)) //执行请求
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8)) //验证响应contentType
                .andExpect(jsonPath("$.miles").value(400))
                .andReturn();// 返回执行请求的结果
        System.out.println(result.getResponse().getContentAsString());
    }

    @Test
    public void testgetcar() throws Exception{
        MvcResult result = mockMvc.perform(get("/vehicle/car")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)) //执行请求
                .andDo(print())
                .andReturn();// 返回执行请求的结果
        System.out.println(result.getResponse().getContentAsString());
    }

    @Test
    public void testupdatecars() throws Exception{
        Map<String,Object> map1 = new HashMap<>();
        map1.put("color", "Blue");
        map1.put("miles", 300);
        map1.put("vin", "1234");
        Map<String,Object> map2 = new HashMap<>();
        map2.put("color", "Red");
        map2.put("miles", 300);
        map2.put("vin", "1235");
        List<Map> jsonArray = new ArrayList<Map>();
        jsonArray.add(map1);
        jsonArray.add(map2);
        String json = JSONArray.toJSONString(jsonArray);
        System.out.println(json);
        /**String json = "[\n" +
                "  {\n" +
                "    \"color\":\"Blue\",\n" +
                "    \"miles\":200,\n" +
                "    \"vin\":\"1234\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"color\":\"Red\",\n" +
                "    \"miles\":500,\n" +
                "    \"vin\":\"1235\"\n" +
                "  }\n" +
                "]";**/
        MvcResult result = mockMvc.perform(post("/vehicle/cars")
                .contentType(MediaType.APPLICATION_JSON_UTF8).content(json)
                .accept(MediaType.APPLICATION_JSON_UTF8)) //执行请求
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8)) //验证响应contentType
                .andReturn();// 返回执行请求的结果
        System.out.println("*****************");
        System.out.println(result.getResponse().getContentAsString());
    }

    @Test
    public void testupdateWithMultipleObjects() throws Exception{
        Map<String,Object> map = new HashMap<>();
        Map<String,Object> map1 = new HashMap<>();
        map1.put("color", "Blue");
        map1.put("miles", 100);
        map1.put("vin", "1234");
        Map<String,Object> map2 = new HashMap<>();
        map2.put("color", "Red");
        map2.put("miles", 200);
        map2.put("vin", "1235");
        List<Map> jsonArray = new ArrayList<>();
        jsonArray.add(map1);
        jsonArray.add(map2);

        Map<String,Object> map3 = new HashMap<>();
        map3.put("color", "Green");
        map3.put("miles", 300);
        map3.put("vin", "1236");

        map.put("cars",jsonArray);
        map.put("truck",map3);

        String json = JSONObject.toJSONString(map);
        System.out.println(json);
        MvcResult result = mockMvc.perform(post("/vehicle/carsandtrucks")
                .contentType(MediaType.APPLICATION_JSON_UTF8).content(json)
                .accept(MediaType.APPLICATION_JSON_UTF8)) //执行请求
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8)) //验证响应contentType
                .andReturn();// 返回执行请求的结果
        System.out.println(result.getResponse().getContentAsString());
    }


    //test Object transfer to json
    @Test
    public void testupdateWithMultipleObjectsUsingObject() throws Exception{
        List<Car> carArray = new ArrayList<>();
        car.setColor("Blue");
        car.setMiles(100);
        car.setVIN("1234");

        carArray.add(car);

        car.setColor("Red");
        car.setMiles(200);
        car.setVIN("1235");

        carArray.add(car);
        requestWrapper.setCars(carArray);

        truck.setColor("Green");
        truck.setMiles(400);
        truck.setVIN("1236");

        requestWrapper.setTruck(truck);
        System.out.println("JSON to Object:"+requestWrapper.toString());
        String json = "";
        try{
            json = mapper.writeValueAsString(requestWrapper);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(json);
        MvcResult result = mockMvc.perform(post("/vehicle/carsandtrucks")
                .contentType(MediaType.APPLICATION_JSON_UTF8).content(json)
                .accept(MediaType.APPLICATION_JSON_UTF8)) //执行请求
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8)) //验证响应contentType
                .andReturn();// 返回执行请求的结果
        String returnjson = result.getResponse().getContentAsString();
        System.out.println(returnjson);
        try{
            requestWrapper = mapper.readValue(returnjson, RequestWrapper.class);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("JSON to Object:"+requestWrapper.toString());
    }
}
