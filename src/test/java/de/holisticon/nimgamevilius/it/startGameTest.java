//package de.holisticon.nimgamevilius.it;
//
//import com.google.gson.Gson;
//import de.holisticon.nimgamevilius.model.FirstTurn;
//import de.holisticon.nimgamevilius.model.Game;
//import de.holisticon.nimgamevilius.model.Settings;
//import de.holisticon.nimgamevilius.model.Strategy;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@AutoConfigureMockMvc
//@WebMvcTest
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
//        Gson gson = new Gson();
//        MvcResult mvcResult = mvc.perform(post("/api/start")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(gson.toJson(settings)))
//                .andExpect(status().isOk())
//                .andReturn();
//
//        String contentAsString = mvcResult.getResponse().getContentAsString();
//        Game game = gson.fromJson(contentAsString, Game.class);
//        System.out.println();
//    }
//
//}
