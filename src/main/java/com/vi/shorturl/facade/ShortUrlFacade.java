package com.vi.shorturl.facade;
/*
 * This is confidential material created by myself
 *
 * @author varuzhan iritsyan
 * @version 1.0: $
 * @since x.y
 */

import com.vi.shorturl.dto.ShortUrlDto;

import java.util.List;

public interface ShortUrlFacade {
    List<ShortUrlDto> getAllShortUrls();
    ShortUrlDto getShorUrlByUrl(String url);
    ShortUrlDto save(ShortUrlDto shortUrlDto);

    String getOriginURLByShort(String shortUrl);



}
