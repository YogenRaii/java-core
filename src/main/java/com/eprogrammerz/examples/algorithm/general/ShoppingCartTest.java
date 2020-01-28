package com.eprogrammerz.examples.algorithm.general;

import com.google.common.collect.Sets;
import lombok.EqualsAndHashCode;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ShoppingCartTest {

    @Test
    public void test() {
        ShoppingCart cart = new ShoppingCart();
        cart.addOffer(1, 100, 300);
        cart.addOffer(1, 200, 450);
        cart.addOffer(2, 300, 50);

        // offer close to lower bound
        Set<Offer> offers1 = Sets.newHashSet(new Offer(1, 100, 300));
        assertThat(cart.getClosestOffer(1, 200), is(offers1));

        Set<Offer> offers2 = Sets.newHashSet(new Offer(1, 200, 450));
        assertThat(cart.getClosestOffer(1, 500), is(offers2));

        // remove offer
        cart.removeOffer(200);

        // the query should return the lower bound
        assertThat(cart.getClosestOffer(1, 500), is(offers1));
    }

}

/**
 * Assume a Google Shopping cart application. There are multiple products being sold, each product is sold by multiple vendors each having their own offer with a price.
 * so each product can have multiple offers.
 * <p>
 * There are three entities prodcutID, offerID, and Price.
 * <p>
 * Implement these three methods in the most efficient manner :
 * <p>
 * public class ShoppingCart {
 * <p>
 * public void addOffer(long productID, long offerID, double price) {
 * }
 * <p>
 * public void removeOffer(long offerID) {
 * }
 * <p>
 * public long getClosestOffer(long productID, double price) {
 * }
 * <p>
 * }
 * P1 - O1 - $300
 * P1 - O2 - $450
 * P2 - O3 - $50
 * <p>
 * getClosestOffer(P1, 250) -> O1
 * getClosestOffer(P1, 500) -> O2
 * <p>
 * return the offer which is closest to a given price.
 * <p>
 * Assume there is no memory restriction.
 */
class ShoppingCart {
    private Map<Long, TreeMap<Double, Set<Offer>>> store = new HashMap<>();
    private Map<Long, Offer> offers = new HashMap<>();

    /**
     * Creates new entry for given product id and offers associated if not existed before
     * else updated offers with new offer for that particular product
     * <p>
     * Time: O(logm) - for one product, m = no. of offers for particular product
     * O(n*logm) - for n products
     *
     * @param productID
     * @param offerID
     * @param price
     */
    public void addOffer(long productID, long offerID, double price) {
        Offer offer = new Offer(productID, offerID, price);

        store.computeIfAbsent(productID, s -> new TreeMap<>());

        store.get(productID).computeIfAbsent(price, s -> new HashSet<>());

        store.get(productID).get(price).add(offer);

        offers.put(offerID, offer);
    }

    // Time O(logm) for one
    //      O(n * logm) for n
    public void removeOffer(long offerID) {
        if (offers.containsKey(offerID)) {
            Offer offer = offers.remove(offerID);

            TreeMap<Double, Set<Offer>> map = store.get(offer.productId);

            map.get(offer.price).remove(offer);

            if (map.get(offer.price).isEmpty()) {
                map.remove(offer.price);
            }
        }
    }

    // Time O(logm)
    public Set<Offer> getClosestOffer(long productID, double price) {
        TreeMap<Double, Set<Offer>> map = store.get(productID);

        if (offers == null) return null;

        Double smaller = map.floorKey(price);
        Double larger = map.ceilingKey(price);

        if (smaller == null && larger == null) return null;

        if (smaller != null && larger != null) {
            double d1 = price - smaller;
            double d2 = larger - price;

            double close = d1 < d2 ? smaller : larger;

            return map.get(close);
        }

        if (smaller == null) return map.get(larger);
        else return map.get(smaller);
    }


}

@EqualsAndHashCode
class Offer {
    long productId;
    long offerId;
    double price;

    Offer(long productId, long offerId, double price) {
        this.productId = productId;
        this.offerId = offerId;
        this.price = price;
    }
}
