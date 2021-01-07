package com.example.so65612634.security;

import com.example.so65612634.repository.RepositoryNote;
import com.example.so65612634.repository.RepositoryUser;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FilterNotePermissionProcessor implements Filter {

    private final RepositoryNote repositoryNote;
    private final RepositoryUser repositoryUser;
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
        throws IOException, ServletException {
        
        chain.doFilter(request, response);
    }
    

}
