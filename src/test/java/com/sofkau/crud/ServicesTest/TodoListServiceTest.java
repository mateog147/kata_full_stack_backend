package com.sofkau.crud.ServicesTest;

import com.sofkau.crud.models.TodoList;
import com.sofkau.crud.repositories.TodoListRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static  org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class TodoListServiceTest {
    @Autowired
    TodoListRepository todoListRepository;

    @Test
    public void testGuardarUsuario(){
        TodoList todoList =new TodoList("test");
        TodoList todoListRegistrado = todoListRepository.save(todoList);
        assertNotNull(todoListRegistrado);
    }

    @Test
    public void testBuscarUsuarioPorId(){
        Long idBuscado=1L;
        Optional<TodoList> usuarioModelBuscado= todoListRepository.findById(idBuscado);
        assertThat(usuarioModelBuscado.get().getId()).isEqualTo(idBuscado);
    }

}
