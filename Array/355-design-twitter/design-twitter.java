class Twitter {

    private static class Tweet {
        int tweetId;
        int time;

        Tweet(int tweetId, int time) {
            this.tweetId = tweetId;
            this.time = time;
        }
    }

    private Map<Integer, Set<Integer>> followMap;
    private Map<Integer, List<Tweet>> tweetMap;
    private int timestamp;

    public Twitter() {
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
        timestamp = 0;
    }

    public void postTweet(int userId, int tweetId) {
        tweetMap.putIfAbsent(userId, new ArrayList<>());
        tweetMap.get(userId).add(new Tweet(tweetId, timestamp++));
    }

    public List<Integer> getNewsFeed(int userId) {

        PriorityQueue<Tweet> pq =
                new PriorityQueue<>((a, b) -> b.time - a.time);

        // user's own tweets
        if (tweetMap.containsKey(userId)) {
            for (Tweet t : tweetMap.get(userId)) {
                pq.offer(t);
            }
        }

        // followees' tweets
        Set<Integer> followees =
                followMap.getOrDefault(userId, new HashSet<>());

        for (int followee : followees) {
            if (tweetMap.containsKey(followee)) {
                for (Tweet t : tweetMap.get(followee)) {
                    pq.offer(t);
                }
            }
        }

        List<Integer> ans = new ArrayList<>();

        while (!pq.isEmpty() && ans.size() < 10) {
            ans.add(pq.poll().tweetId);
        }

        return ans;
    }

    public void follow(int followerId, int followeeId) {

        if (followerId == followeeId)
            return;

        followMap.putIfAbsent(followerId, new HashSet<>());
        followMap.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {

        if (followMap.containsKey(followerId)) {
            followMap.get(followerId).remove(followeeId);
        }
    }
}