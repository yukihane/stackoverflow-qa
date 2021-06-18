package jaso77627;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Response1 extends ResponseObjBase {
    String status;
    String message;
}