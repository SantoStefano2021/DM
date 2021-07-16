package com.example.DM.dispositivoMedico.component.test;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.IntStream;

import com.example.DM.dispositivoMedico.dto.DispositivoMedicoDTO;
import com.example.DM.dispositivoMedico.service.DefaultDispositivoMedicoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.DM.dispositivoMedico.component.DefaultDispositivoMedicoComponent;
import com.example.DM.dispositivoMedico.dao.DispositivoMedicoDAO;
import com.example.DM.dispositivoMedico.mapper.CommonMapper;
import com.example.DM.dispositivoMedico.model.DispositivoMedico;

/**
 * junit5
 * mentre
 * Nota che devi usare @RunWith(MockitoJUnitRunner.class)
 * o Mockito.initMocks(this) per inizializzare questi mock e iniettarli (JUnit 4).
 */
@ExtendWith(MockitoExtension.class)
class DefaultDispositivoMedicoComponentTest {


    @Mock
    private DispositivoMedicoDAO dmDao;

    @Mock
    private DefaultDispositivoMedicoService dmS;



    @Mock
    private CommonMapper commonMapper;

    @InjectMocks
    private DefaultDispositivoMedicoComponent underTest;

    /**
     * @Mock crea un mock.
     * @InjectMocks crea un'istanza della classe quindi viene iniettata
     */



        @Test

        void MatricolaTest(){

            //given
            final DispositivoMedico uno = DispositivoMedico.builder()
                    .nomeDispositivo("Termometro")
                    .matricola("TRM22")
                    .build();

            List<DispositivoMedico> lista = asList(uno);
            when(dmDao.findByMatricola("TRM22")).thenReturn(lista);
            //when

            List<DispositivoMedicoDTO> actual = underTest.findByMatricolaComponent("TRM22");

            //then

            //verify(dmS).findByMatricola("TRM22");
            assertEquals(1,actual.size());
            verify(dmDao).findByMatricola("TRM22");

        }





    @Test
    void hashSetTest(){
        final HashMap<DispositivoMedico, String> hashMap = new HashMap<>();

        hashMap.put(DispositivoMedico.builder().idDispositivo(1L).nomeDispositivo("pippo").build(), "first");
        hashMap.put(DispositivoMedico.builder().idDispositivo(1L).nomeDispositivo("pluto").build(), "second");
        hashMap.put(DispositivoMedico.builder().idDispositivo(1L).nomeDispositivo("paperino").build(), "third");


		/*
		me ne stamperà solo uno perché la chiave ha lo stesso hashCode e quindi
		va a valutare l'equals per definire se è lo stesso elemento.
		In questo caso, si quindi sovrascrive sempre, infatti mi aspetto che come valore corrispondente
		alla chiabe
		 */

        hashMap.forEach((dispositivoMedico, s) -> System.out.println("Stampo il nome "+ dispositivoMedico.getNomeDispositivo() + " con valore " + s));
       // hashMap.forEach(System.out::println);


    }


    @Test
    public void isPalindrome(){
        List<String> palindrome = Arrays.asList("anna", "abba","lol");

        boolean returnIsPalindrome =
                palindrome
                        .stream()
                        .allMatch(this::check);


        assertTrue(returnIsPalindrome);
    }

    public boolean check(String valore){
        System.out.println("Stringa che sto leggendo " + valore + " ha lunghezza " + valore.length());
        return IntStream.range(0,valore.length()/2)
                .noneMatch(i -> valore.charAt(i) != valore.charAt(valore.length()-i-1));
    }



    /**
     @Test
     public void findByNomePaziente() {
     //given
     final DispositivoMedico first = DispositivoMedico.builder()
     .matricola("AAA")
     .nomeDispositivo("Termometro")
     .build();
     final DispositivoMedico second = DispositivoMedico.builder()
     .matricola("BBB")
     .nomeDispositivo("Saturimetro")
     .build();
     final DispositivoMedico third = DispositivoMedico.builder()
     .matricola("CCC")
     .nomeDispositivo("Termometro")
     .build();
     List<DispositivoMedico> listsDispositivoMedicos = asList(first, second, third);

     when(dmDao.findByNomePaziente(anyString())).thenReturn(listsDispositivoMedicos);

     final DispositivoMedicoDTO expected = DispositivoMedicoDTO.builder()
     .matricola("BBB")
     .nomeDispositivo("Saturimetro")
     .build();
     when(commonMapper.map(any(DispositivoMedico.class))).thenReturn(expected);
     //when

     List<DispositivoMedicoDTO> actual = underTest.findByNomePaziente("Anna");


     //then
     verify(dmDao).findByNomePaziente("Anna");
     verify(commonMapper).map(second);
     assertTrue(actual.size() == 1);
     assertEquals(actual.get(0), expected);
     }**/
}
