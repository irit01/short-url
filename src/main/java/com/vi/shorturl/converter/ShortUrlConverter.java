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

@Component(value = "shortUrlConverter")
public class ShortUrlConverter implements Converter<ShortUrl, ShortUrlDto> {
    public ShortUrlDto convert(ShortUrl source) {
        ShortUrlDto target = new ShortUrlDto();

        target.setId(source.getId());
        target.setCode(source.getCode());
        target.setUrl(source.getUrl());

        target.setCreationDate(source.getCreationDate());

        return target;
    }
}
