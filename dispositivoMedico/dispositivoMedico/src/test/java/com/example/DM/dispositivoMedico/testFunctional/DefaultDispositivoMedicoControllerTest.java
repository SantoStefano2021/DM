package com.example.DM.dispositivoMedico.testFunctional;

import static java.util.Arrays.asList;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Ignore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.DM.dispositivoMedico.controller.DispositivoMedicoController;
import com.example.DM.dispositivoMedico.dto.DispositivoMedicoDTO;
import com.example.DM.dispositivoMedico.service.DispositivoMedicoSevice;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class DefaultDispositivoMedicoControllerTest {

    private MockMvc mockMvc;

    @MockBean
    private DispositivoMedicoSevice dmcService;

    @InjectMocks
    private DispositivoMedicoController underTest;

    //
    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();
    }


    @Test
    public void insertDispositivo() {
        //given
      //  final DispositivoMedicoDTO dispositivoMedicoDTO = DispositivoMedicoDTO.builder()
        //        .build();


        //when
//		mockMvc.perform(MockMvcRequestBuilders.post("/private/insert"))
//		.andExpect(ResultMatchers.isSuccessful());


        //then
    }

   // private static String convertJson(final DispositivoMedicoDTO disp) throws JsonProcessingException {
     //   final ObjectMapper obj = new ObjectMapper();
       // return obj.writeValueAsString(obj);
    //}



    @Test
    void findAll() throws Exception {
        //given
        final DispositivoMedicoDTO dispositivoMedicoDTO = DispositivoMedicoDTO.builder()
                .nomeDispositivo("Termometro")
                .matricola("TRM222")
                .build();


        when(dmcService.findAll()).thenReturn(asList(dispositivoMedicoDTO));



        //when
        mockMvc.perform(get("/private/findAll"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].matricola").value("TRM222"))
                .andExpect(jsonPath("$[0].nomeDispositivo").value("Termometro"))
                .andReturn();

        //then
        verify(dmcService).findAll();
    }
}
