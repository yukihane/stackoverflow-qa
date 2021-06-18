package jaso77627;

import jakarta.ws.rs.POST;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

public abstract class MyAbstractResource<RESP extends ResponseObjBase, REQ extends RequestObjBase> {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public RESP execute(final REQ request) {

        // ...
        // 共通処理実行

        return executeSub(request);
    }

    protected abstract RESP executeSub(REQ request);

}
