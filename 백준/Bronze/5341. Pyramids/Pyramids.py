dp = [0] * 10000001
for i in range(1, 10000001) :
    dp[i] += dp[i - 1] + i
while True :
    n = int(input())
    if n == 0 : break
    print(dp[n])