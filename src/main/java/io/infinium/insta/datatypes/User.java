package io.infinium.insta.datatypes;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable {

    List<String> id;

    public List<String> getId() {
        return id;
    }

    public void setId(List<String> id) {
        this.id = id;
    }
}
