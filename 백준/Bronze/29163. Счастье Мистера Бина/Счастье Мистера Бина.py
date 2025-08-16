n = int(input())

nums = list(map(int, input().split()))
odd, even = 0, 0

for num in nums:
    if num % 2 == 0:
        even += 1
    else:
        odd += 1

print("Sad" if odd >= even else "Happy")