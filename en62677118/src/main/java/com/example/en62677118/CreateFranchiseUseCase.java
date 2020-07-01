package com.example.en62677118;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

@Service
@Scope(WebApplicationContext.SCOPE_REQUEST)
public class CreateFranchiseUseCase {

    public String getText() {
        return this.toString();
    }
}
