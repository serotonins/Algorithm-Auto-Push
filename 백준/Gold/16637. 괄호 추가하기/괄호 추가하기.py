n = int(input())
susik = list(input())
buho = []
answer = []
for b in range(1, n, 2): buho.append(b)

def cal(a, b, _buho):
    if _buho == '+': return a + b
    elif _buho == '-': return a - b
    elif _buho == '*': return a * b

def mamuri(buho):
    answer.append([])
    answer[-1].append(susik[0])
    for h in range(len(buho)):
        mybuhoidx = 2 * h + 1
        if buho[h]:
            gwalho = cal(int(susik[mybuhoidx - 1]), int(susik[mybuhoidx + 1]), susik[mybuhoidx])
            del answer[-1][-1]
            answer[-1].append(gwalho)
        else: answer[-1] += [susik[mybuhoidx] , int(susik[mybuhoidx + 1])]

    ans = int(answer[-1][0])
    for j in range(1, len(answer[-1]), 2):
        ans = cal(ans, answer[-1][j+1], answer[-1][j])
    answer[-1] = ans

def dfs(buho, b, tf):
    buho[b] = tf

    if b == len(buho) - 1: # 마지막 부호면 식 계산 후 턴을 종료
        mamuri(buho)
        return

    if tf == True:
        buho[b+1] = False
        nextb = b+2
        if nextb >= len(buho):
            mamuri(buho)
            return
    else:
        nextb = b + 1

    dfs(buho, nextb, True)
    dfs(buho, nextb, False)

if n != 1:
    dfs(buho, 0, True)
    dfs(buho, 0, False)
else: answer = [int(susik[0])]

print(max(answer))