package com.huaweiproject.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateDTO {
    private long id;
    @JsonProperty(value = "checked")
    private boolean isChecked;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }
}
