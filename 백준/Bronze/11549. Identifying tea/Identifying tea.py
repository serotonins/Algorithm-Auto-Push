T = int(input())
answers = list(map(int, input().split()))
print(sum(a == T for a in answers))