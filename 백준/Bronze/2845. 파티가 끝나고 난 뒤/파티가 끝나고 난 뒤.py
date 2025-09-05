a, b = map(int, input().split())
list = map(int, input().split())
print(*[x - a * b for x in list])