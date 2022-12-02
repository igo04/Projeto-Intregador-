package br.com.gestaojogos.controller;

import br.com.gestaojogos.app.controller.JogoController;
import br.com.gestaojogos.repository.LoginRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc

public class TesteController {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    LoginRepository loginRepository;

    @Test
    void JogoController()  throws Exception{
        var jogo =new game();
        game.setNome("God Of War");
        Mockito.when(JogoController.findAll());


    }


}