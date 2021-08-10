package com.example.jaso72892;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FullName implements Serializable {
    /** 姓 */
    private String sei;
    /** 名 */
    private String mei;
}
