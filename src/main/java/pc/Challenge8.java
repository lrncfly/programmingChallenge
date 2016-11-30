package pc;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Challenge8 {
    String[] candidates;
    double quorum = 0.0;
    Map<String, List<int[]>> voting;
    int[][] ballots;

    public static void main(String[] args) {
        String[] candidates = new String[] { "John Doe", "Jane Doe", "Jane Austen", "John Grisham" };
        Challenge8 c = new Challenge8();
        int[][] ballots = { { 1, 2, 3, 4 }, { 4, 2, 1, 3 }, { 2, 4, 3, 1 }, { 1, 2, 4, 3 }, { 3, 1, 4, 2 },
                { 4, 3, 2, 1 } };
        c.setBallots(ballots);
        c.setCandidates(candidates);
        List<String> returned = c.count();
        for (String string : returned) {
            System.out.println(string);
        }
    }

    public List<String> count() {
        int preference = 1;
        distributePreferences(this.ballots, preference);
        List<String> elected = findElectedCandidates();
        while (elected.isEmpty()) {
            List<Entry<String, List<int[]>>> eliminated = eliminateLowestCandidates();
            if (eliminated.size() == voting.size()) {
                for (Entry<String, List<int[]>> entry : eliminated) {
                    elected.add(entry.getKey());
                }
                break;
            }
            redistributeVotes(eliminated, preference + 1);
            elected = findElectedCandidates();
        }
        return elected;
    }

    void distributePreferences(int[][] ballots, int preference) {
        int i = 0;
        int tmpPreference = preference;
        while (i < ballots.length) {
            int[] ballot = ballots[i];
            int j = 0;
            while (tmpPreference <= candidates.length && j < candidates.length) {
                if (ballot[j] == tmpPreference && voting.containsKey(candidates[j])) {
                    addBallotToCandidate(candidates[j], ballot);
                    break;
                } else if (ballot[j] == tmpPreference && !voting.containsKey(candidates[j])) {
                    tmpPreference++;
                    j = 0;
                } else
                    j++;
            }
            i++;
        }
    }

    private void addBallotToCandidate(String name, int[] ballot) {
        voting.get(name).add(ballot);
    }

    List<String> findElectedCandidates() {
        List<String> elected = new LinkedList<>();
        for (Entry<String, List<int[]>> candidate : voting.entrySet()) {
            if (candidate.getValue().size() > this.quorum)
                elected.add(candidate.getKey());
        }
        return elected;
    }

    List<Entry<String, List<int[]>>> eliminateLowestCandidates() {
        List<Entry<String, List<int[]>>> eliminated = new LinkedList<>();
        double eliminationCount = this.quorum;
        for (Entry<String, List<int[]>> candidate : voting.entrySet()) {
            if (candidate.getValue().size() < eliminationCount) {
                eliminationCount = candidate.getValue().size();
                eliminated = new LinkedList<>();
            }
            if (candidate.getValue().size() <= eliminationCount)
                eliminated.add(candidate);
        }
        return eliminated;
    }

    void redistributeVotes(List<Entry<String, List<int[]>>> eliminated, int preference) {
        int votesToDistribute = 0;
        for (Entry<String, List<int[]>> candidate : eliminated) {
            votesToDistribute += candidate.getValue().size();
        }
        int[][] distributionVotes = new int[votesToDistribute][this.candidates.length];
        int i = 0;
        for (Entry<String, List<int[]>> candidate : eliminated) {
            for (int[] ballot : candidate.getValue()) {
                distributionVotes[i] = ballot;
                i++;
            }
            voting.remove(candidate.getKey());
        }
        this.distributePreferences(distributionVotes, preference);
    }

    public void setCandidates(String[] candidates) {
        this.candidates = candidates;
        this.voting = new HashMap<>();
        for (String c : candidates)
            this.voting.put(c, new LinkedList<>());
    }

    public void setBallots(int[][] ballots) {
        this.ballots = ballots;
        this.quorum = Math.ceil((double) (ballots.length) / 2);
    }

}
