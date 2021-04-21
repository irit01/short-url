package com.vi.shorturl.service;
/*
 * This is confidential material created by myself
 *
 * @author varuzhan iritsyan
 * @version 1.0: $
 * @since x.y
 */


import com.vi.shorturl.entity.ShortUrl;

import java.util.List;

public interface ShortUrlService {
    List<ShortUrl> getAllShortUrls();
    ShortUrl save(ShortUrl shortUrl);
    ShortUrl getShortUrlByUrl(String url);
    ShortUrl getShortUrlByCode(String code);
}
