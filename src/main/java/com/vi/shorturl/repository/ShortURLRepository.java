package com.vi.shorturl.repository;
/*
 * This is confidential material created by myself
 *
 * @author varuzhan iritsyan
 * @version 1.0: $
 * @since x.y
 */

import com.vi.shorturl.entity.ShortUrl;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ShortURLRepository extends CrudRepository<ShortUrl, Long> {
    ShortUrl save(ShortUrl shortUrl);
    Optional<ShortUrl> findByCode(String code);
    Optional<ShortUrl> findByUrl(String url);
}
