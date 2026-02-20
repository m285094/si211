    // Sam Pirkl and Sean Beckford

    import si211.*;
    import java.util.*;

    public class TweetQueueIter extends TweetQueue {
    private int numTweets;

    // constructor for making brand new queuelist
    public TweetQueueIter(Scanner fin) {
        super();
        numTweets = 0;
        while(fin.hasNext()) // loop through tweets in file and enqueue
            enqueue(Tweet.read(fin));
    }

    // constructor for resetting the queue list
    public TweetQueueIter() {
        super();
        numTweets = 0;
    }

    public int getTweets() { return numTweets; }

    public void enqueue(Tweet t) {
        super.enqueue(t); // override the enqueue with call
        numTweets++; // and numtweets calculation
    }

    public void resetNumTweets() {
        int count = 0;
        Iter itr = iterator();
        while(itr.hasNext()) { // loop through tweets
            Tweet tweet = itr.next();
            count++; // and count how many 
        }

        numTweets = count; //set numtweets equal to that
    }

    public void printDump() {
        Iter itr = iterator();
        while(itr.hasNext()) { // loop through tweets
            System.out.println(itr.next()); // and print them
        }
        System.out.println(numTweets + " tweets");
    }

    public TweetQueueIter filter(String s) {
        Iter itr = iterator(); 
        TweetQueueIter q = new TweetQueueIter(); // make new queue list

        while (itr.hasNext()) { // loop through tweets
            Tweet tweet = itr.next(); // get the tweet
            if (tweet.getText().indexOf(s) != -1) // if keyword exists
                q.enqueue(tweet);  // enqueue tweet
        }

        System.out.println(q.getTweets() + " tweets");
        return q; // return new queue list
    }

    public TweetQueueIter filterNot(String s) {
        Iter itr = iterator();
        TweetQueueIter q = new TweetQueueIter(); // make new queue list

        while (itr.hasNext()) { // loop through tweets
            Tweet tweet = itr.next(); // get the tweet
            if (tweet.getText().indexOf(s) == -1) // keyword doesnt exist
                q.enqueue(tweet); // enqueue tweet
        }

        System.out.println(q.getTweets() + " tweets");
        return q; // return new queue list
    }
}