//package de.holisticon.nimgamevilius.it;
//
//import com.google.gson.Gson;
//import de.holisticon.nimgamevilius.controller.RequestController;
//import de.holisticon.nimgamevilius.model.FirstTurn;
//import de.holisticon.nimgamevilius.model.Settings;
//import de.holisticon.nimgamevilius.model.Strategy;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.ResultActions;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@SpringBootTest
//@WebMvcTest(RequestController.class)
//public class startGameTest {
//
//    @Autowired
//    MockMvc mvc;
//
//    @Test
//    void startTest() throws Exception {
//
//        Settings settings = new Settings(Strategy.RANDOM, FirstTurn.PLAYER);
//
//        ResultActions resultActions = mvc.perform(post("/api/start")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(new Gson().toJson(settings)))
//                .andExpect(status().isOk());
//
//        System.out.println();
//    }
//
//}
