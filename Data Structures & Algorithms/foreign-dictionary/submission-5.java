

class Solution {
    private Map<Character, Set<Character>> adj = new HashMap<>();
    private Map<Character, Boolean> visit = new HashMap<>();
    private List<Character> res = new ArrayList<>();

    public String foreignDictionary(String[] words) {
        for (String w : words) {
            for (char c : w.toCharArray()) {
                adj.putIfAbsent(c, new HashSet<>());
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i], w2 = words[i + 1];
            int minLen = Math.min(w1.length(), w2.length());

            if (w1.length() > w2.length() && w1.substring(0, minLen).equals(w2.substring(0, minLen))) {
                return "";
            }

            for (int j = 0; j < minLen; j++) {
                if (w1.charAt(j) != w2.charAt(j)) {
                    adj.get(w1.charAt(j)).add(w2.charAt(j));
                    break;
                }
            }
        }

        for (char c : adj.keySet()) {
            if (dfs(c)) {
                return "";
            }
        }

        Collections.reverse(res);
        StringBuilder sb = new StringBuilder();
        for (char c : res) {
            sb.append(c);
        }
        return sb.toString();
    }

    private boolean dfs(char c) {
        if (visit.containsKey(c)) {
            return visit.get(c);
        }

        visit.put(c, true);
        for (char nei : adj.get(c)) {
            if (dfs(nei)) {
                return true;
            }
        }

        visit.put(c, false);
        res.add(c);
        return false;
    }
}