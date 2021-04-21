package com.vi.shorturl.entity;
/*
 * This is confidential material created by myself
 *
 * @author varuzhan iritsyan
 * @version 1.0: $
 * @since x.y
 */

import com.vi.shorturl.constants.Constants;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
public class ShortUrl extends AbstractEntity {
    @Column(name="code")
    private String code;

    @Column(name="url")
    private String url;

    @Column(name="creationDate")
    private LocalDateTime creationDate;

    public ShortUrl() {
        this(Constants.NEW_DOMAIN);
        setCreationDate(LocalDateTime.now());
    }

    public ShortUrl(String url) {
        setUrl(url);
        setCreationDate(LocalDateTime.now());
    }
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return "ShortenUrl{" +
                "id=" + getId() +
                ", code='" + code + '\'' +
                ", url='" + url + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }
}
