n = int(input())
for _ in range(n):
    X, Y = map(int, input().split())
    print("MMM BRAINS" if X >= Y else "NO BRAINS")
