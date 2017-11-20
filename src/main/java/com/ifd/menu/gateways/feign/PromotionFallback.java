package com.ifd.menu.gateways.feign;

import com.ifd.menu.domains.Promotion;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PromotionFallback implements FallbackFactory<PromotionClient> {
    @Override
    public PromotionClient create(final Throwable t) {
        log.error(t.getMessage(), t);
        return queryMap -> {
            final Promotion promotion = new Promotion();
            promotion.setId("default_promo");
            promotion.setDiscount(0);
            return promotion;
        };
    }
}
