package com.sofkau.crud.ControllerServiceTest;

import com.sofkau.crud.repositories.TodoListRepository;
import com.sofkau.crud.services.TodoListService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@SpringBootTest
public class TodoListServiceMockTest {

  @MockBean
  TodoListRepository todoListRepository;

  @Autowired
  TodoListService todoListService;

  @Test
  public void testUsuarioMock(){
    when(todoListRepository.findAll()).thenReturn(new ArrayList<>());
    assertThat(todoListService.getAllActives()).isEmpty();
    verify(todoListRepository).findAll();
  }

}
