input()
n = map(int,input().split())
count = 0
for i in n: count += i
if count > 0: print("Right")
elif count == 0: print("Stay")
else: print("Left")