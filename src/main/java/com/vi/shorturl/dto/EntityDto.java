package com.vi.shorturl.dto;
/*
 * This is confidential material created by myself
 *
 * @author varuzhan iritsyan
 * @version 1.0: $
 * @since x.y
 */

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class EntityDto {
    @NotNull
    @NotEmpty
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
