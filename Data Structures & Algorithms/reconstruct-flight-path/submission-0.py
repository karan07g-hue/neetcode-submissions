class Solution:
    def findItinerary(self, tickets: List[List[str]]) -> List[str]:
        premap = collections.defaultdict(list)

        for src, dst in tickets:
            premap[src].append(dst)
        for src in premap:
            premap[src].sort()

        res = []
        def dfs(src):
            while premap[src]:
                nxt = premap[src].pop(0)
                dfs(nxt)
            res.append(src)
        dfs("JFK")
        return res[::-1]