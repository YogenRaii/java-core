package com.eprogrammerz.examples.design;

import org.junit.Test;

import java.time.LocalDateTime;
import java.util.*;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.MatcherAssert.assertThat;

public class TwitterTester {

    @Test
    public void test() {
        Twitter twitter = new Twitter();
        twitter.postTweet(1,5);
        twitter.postTweet(1,3);
        twitter.postTweet(1,101);
        twitter.postTweet(1,13);
        twitter.postTweet(1,10);
        twitter.postTweet(1,2);
        twitter.postTweet(1,94);
        twitter.postTweet(1,505);
        twitter.postTweet(1,333);

        System.out.println(twitter.getNewsFeed(1));
        assertThat(twitter.getNewsFeed(1), hasItems(333, 505, 94, 2, 10, 13, 101, 3, 5));
    }
}


class Twitter {

    private Map<Integer, List<Tweet>> m1;
    private Map<Integer, Set<Integer>> m2;

    private long timestamp;
    /** Initialize your data structure here. */
    public Twitter() {
        this.m1 = new HashMap<>();
        this.m2 = new HashMap<>();
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if (!m1.containsKey(userId)) {
            m1.put(userId, new ArrayList<>());
        }
        if (!m2.containsKey(userId)) {
            m2.put(userId, new HashSet<>());
        }
        this.m1.get(userId).add(new Tweet(tweetId, ++timestamp));
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> pq = new PriorityQueue<>(
                (t1, t2) -> (int) (t1.dateCreated - t2.dateCreated));
        List<Tweet> self = m1.get(userId);
        if (self != null && !self.isEmpty()) {
            for (Tweet tweet: self) {
                pq.offer(tweet);
                if (pq.size() > 10) pq.poll();
            }

        }

        Set<Integer> followees = m2.get(userId);
        if (followees != null) {
            for (int followee: followees) {
                List<Tweet> tweets = m1.get(followee);
                if (tweets == null) continue;

                for (Tweet tweet: tweets) {
                    pq.add(tweet);
                    if (pq.size() > 10) pq.poll();
                }
            }
        }

        LinkedList<Integer> posts = new LinkedList<>();
        while (!pq.isEmpty()) {
            posts.addFirst(pq.poll().tweetId);
        }
        return posts;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return;

        if (!m2.containsKey(followerId)) {
            m2.put(followerId, new HashSet<>());
        }
        this.m2.get(followerId).add(followeeId);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (!m2.containsKey(followerId)) return;
        m2.get(followerId).remove(followeeId);
    }


    class Tweet {
        int tweetId;
        long dateCreated;

        Tweet(int tweetId, long dateCreated) {
            this.tweetId = tweetId;
            this.dateCreated = dateCreated;
        }
    }
}
