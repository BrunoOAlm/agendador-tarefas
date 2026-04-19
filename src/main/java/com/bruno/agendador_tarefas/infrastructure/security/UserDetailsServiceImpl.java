package com.bruno.agendador_tarefas.infrastructure.security;



import com.bruno.agendador_tarefas.business.dto.UsuarioDTORecord;
import com.bruno.agendador_tarefas.infrastructure.security.client.UsuarioClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl  {


    @Autowired
    private UsuarioClient client;

    public UserDetails carregaDadosUsuario(String email, String token){
        UsuarioDTORecord UsuarioDTORecord = client.buscaUsuarioPorEmail(email, token);

                return User
                                .withUsername(UsuarioDTORecord.email()) // Define o nome de usuário como o e-mail
                                .password(UsuarioDTORecord.senha()) // Define a senha do usuário
                                .build(); // Constrói o objeto UserDetails





    }
}
