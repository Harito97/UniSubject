def factorial_by_loop(number):
    if number < 0:
        return -1
    if number == 0:
        return 1
    result = 1
    for i in range(1, number + 1):
        result *= i
    return result

def factorial_by_retrieval(number):
    if number < 0:
        return -1
    if number == 0:
        return 1
    return number * factorial_by_retrieval(number - 1)

def factorial_length(number):
    result = factorial_by_loop(number)
    return len(str(result))

print(factorial_by_loop(5))
print(factorial_by_retrieval(5))
print(factorial_by_loop(0))
print(factorial_by_retrieval(0))
print(factorial_by_loop(-9))
print(factorial_by_retrieval(-9))
print("So chu so cua 100! la: " + str(factorial_length(100)))
'''
Output:
120
120
1
1
-1
-1
So chu so cua 100! la: 158
'''