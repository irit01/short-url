package com.vi.shorturl.ws.rest;
/*
 * This is confidential material created by myself
 *
 * @author varuzhan iritsyan
 * @version 1.0: $
 * @since x.y
 */

import com.vi.shorturl.dto.ShortUrlDto;
import com.vi.shorturl.facade.ShortUrlFacade;
import org.springframework.boot.actuate.endpoint.web.annotation.RestControllerEndpoint;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class ShorturlController {
    @Resource
    private ShortUrlFacade shortUrlFacade;

    /**
     * Get all short URL objects in system
     *
     * @return List of ShortUrlDto objects
     */
    @GetMapping("/shorturls")
    public List<ShortUrlDto> getApplications() {
        List<ShortUrlDto> shortUrlDtoList = shortUrlFacade.getAllShortUrls();
        return shortUrlDtoList;
    }

    /**
     * Create and save shortUrlDto with given values per bady object
     *
     * @param shortUrlDto
     * @return created ShortUrlDto
     */
    @PostMapping(path = "/shorturls/create", consumes = "application/json", produces = "application/json")
    public ShortUrlDto saveShortUrl(@RequestBody ShortUrlDto shortUrlDto) {
        return shortUrlFacade.save(shortUrlDto);
    }

    /**
     * The methode checks origin url in system and, if exists, get short url as object,
     * or if does not exist, build new object with short url
     * @param url
     * @return ShortUrlDto object by
     */
    @GetMapping(path = "/shorturls/url", consumes = "application/json", produces = "application/json")
    public ShortUrlDto getShortUrlByUrl(@RequestParam String url) {
        ShortUrlDto shortUrlDto = shortUrlFacade.getShorUrlByUrl(url);
        return shortUrlDto;
    }

    /**
     * Get origin URL by short URL
     *
     * @param shortUrl
     * @return
     */
    @GetMapping(path = "/shorturls/originurl", consumes = "application/json", produces = "application/json")
    public String getOriginURLByShort(String shortUrl) {
        return shortUrlFacade.getOriginURLByShort(shortUrl);
    }

}
