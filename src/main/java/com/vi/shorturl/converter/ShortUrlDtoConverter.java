package com.vi.shorturl.converter;
/*
 * This is confidential material created by myself
 *
 * @author varuzhan iritsyan
 * @version 1.0: $
 * @since x.y
 */

import com.vi.shorturl.dto.ShortUrlDto;
import com.vi.shorturl.entity.ShortUrl;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component(value = "shortUrlDtoConverter")
public class ShortUrlDtoConverter implements Converter<ShortUrlDto, ShortUrl> {
    public ShortUrl convert(ShortUrlDto source) {
        ShortUrl target = new ShortUrl();
        target.setUrl(source.getUrl());
        target.setCode(source.getCode());
        target.setCreationDate(source.getCreationDate());

        return target;
    }
}
