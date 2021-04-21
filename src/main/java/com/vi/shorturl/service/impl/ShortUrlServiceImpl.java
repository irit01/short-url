package com.vi.shorturl.service.impl;
/*
 * This is confidential material created by myself
 *
 * @author varuzhan iritsyan
 * @version 1.0: $
 * @since x.y
 */

import com.vi.shorturl.entity.ShortUrl;
import com.vi.shorturl.repository.ShortURLRepository;
import com.vi.shorturl.service.ShortUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component(value = "shortUrlService")
public class ShortUrlServiceImpl implements ShortUrlService {
    @Autowired
    ShortURLRepository shortURLRepository;

    /**
     * get all short url objects in system
     *
     * @return
     */
    public List<ShortUrl> getAllShortUrls() {
        List<ShortUrl> returnValue = new ArrayList<>();
        Iterable<ShortUrl> suRepo = shortURLRepository.findAll();
        suRepo.forEach(a -> returnValue.add(a));
        return returnValue;
    }

    /**
     *
     * @param shortUrl
     * @return
     */
    public ShortUrl save(ShortUrl shortUrl) {
        return shortURLRepository.save(shortUrl);
    }

    public ShortUrl getShortUrlByCode(String code) {
        Optional<ShortUrl> opt = shortURLRepository.findByCode(code);
        if (opt.isEmpty()) {
            throw new EntityNotFoundException(String.format("No ShortUrl with code %s found", code));
        }
        return opt.get();

    }

    /**
     * Get short URL by origin URL
     *
     * @param url
     * @return
     */
    public ShortUrl getShortUrlByUrl(String url) {
        Optional<ShortUrl> opt = shortURLRepository.findByUrl(url);
        if (opt.isEmpty()) {
            throw new EntityNotFoundException(String.format("No ShortUrl with url %s found", url));
        }
        return opt.get();

    }

}
