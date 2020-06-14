package model;

import lombok.Data;

@Data
public class Question {

    private String handle_name;
    private String title;
    private String contents;
    private String edit_delete_key;

    public Question() {
        this.handle_name = "my handle";
        this.title = "my title";
        this.contents = "my contents";
        this.edit_delete_key = "sample-del-key";
    }
}
