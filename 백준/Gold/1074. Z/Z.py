n, r, c = map(int, input().split())
size = 2 ** n
sero, garo = 0, 0
result = 0
for i in range(n):
    serogaro = 2 ** (n - 1 - i)
    isero, igaro = sero + serogaro, garo + serogaro
    plus = (2 ** (n-1-i)) ** 2
    if r >= isero:
        result += plus * 2
        sero += serogaro
    if c >= igaro:
        result += plus
        garo += serogaro
    # print(plus, result, (isero, igaro))
print(result)