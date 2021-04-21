package com.vi.shorturl.facade.impl;
/*
 * This is confidential material created by myself
 *
 * @author varuzhan iritsyan
 * @version 1.0: $
 * @since x.y
 */

import com.vi.shorturl.constants.Constants;
import com.vi.shorturl.converter.ShortUrlConverter;
import com.vi.shorturl.converter.ShortUrlDtoConverter;
import com.vi.shorturl.dto.ShortUrlDto;
import com.vi.shorturl.entity.ShortUrl;
import com.vi.shorturl.facade.ShortUrlFacade;
import com.vi.shorturl.service.ShortUrlService;
import com.vi.shorturl.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component(value = "shortUrlFacade")
public class ShortUrlFacadeImpl implements ShortUrlFacade {
    @Autowired
    private ShortUrlService shortUrlService;

    @Autowired
    ShortUrlConverter shortUrlConverter;
    @Autowired
    ShortUrlDtoConverter shortUrlDtoConverter;

    /**
     * Get all ShortUrl objects in system
     *
     * @return
     */
    public List<ShortUrlDto> getAllShortUrls() {
        return shortUrlService.getAllShortUrls().stream().map(a -> shortUrlConverter.convert(a)).
                collect(Collectors.toList());

    }

    /**
     * Convert ShortUrl object from DTO and save in db
     *
     * @param shortUrlDto
     * @return
     */
    public ShortUrlDto save(ShortUrlDto shortUrlDto) {
        ShortUrl shortUrl = shortUrlDtoConverter.convert(shortUrlDto);
        ShortUrl app = shortUrlService.save(shortUrl);
        ShortUrlDto dto = shortUrlConverter.convert(app);
        return dto;

    }

    /**
     * Get short URL by origin URL
     *
     * @param url
     * @return
     */
    public ShortUrlDto getShorUrlByUrl(String url) {
        ShortUrl shortUrl = null;
        //Clearing URL
        url = Utils.clearingURL(url);
        try {
            shortUrl = shortUrlService.getShortUrlByUrl(url);
        } catch (EntityNotFoundException e) {
            shortUrl = new ShortUrl(url);
            shortUrl.setCode(Utils.generateKey());
            shortUrl.setUrl(url);
            shortUrl.setCreationDate(LocalDateTime.now());
            shortUrl = shortUrlService.save(shortUrl);
        }
        return shortUrlConverter.convert(shortUrl);

    }

    /**
     * Get origin URL by short URL
     *
     * @param shortUrl
     * @return
     */
    public String getOriginURLByShort(String shortUrl) {
        String code = shortUrl.substring(Constants.NEW_DOMAIN.length() + 1);
        return shortUrlConverter.convert(shortUrlService.getShortUrlByCode(code)).getUrl();
    }
}
