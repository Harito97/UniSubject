# Khởi tạo giá trị
x = 10
y = 5

# Toán tử số học
print("Toán tử số học:")
sum_result = x + y
sub_result = x - y
mul_result = x * y
div_result = x / y
floor_div_result = x // y
mod_result = x % y
exponent_result = x ** y

arr_value = [sum_result, sub_result, mul_result, div_result, floor_div_result, mod_result, exponent_result]
arr_name = ["sum_result", "sub_result", "mul_result", "div_result", "floor_div_result", "mod_result", "exponent_result"]
for i in range(len(arr_value)):
    print(arr_name[i], ":", arr_value[i])
print("\n\n\n\n")

# Toán tử so sánh
print("Toán tử so sánh:")
is_equal = x == y
is_not_equal = x != y
is_greater = x > y
is_less = x < y
is_greater_or_equal = x >= y
is_less_or_equal = x <= y

arr_value = [is_equal, is_not_equal, is_greater, is_less, is_greater_or_equal, is_less_or_equal]
arr_name = ["is_equal", "is_not_equal", "is_greater", "is_less", "is_greater_or_equal", "is_less_or_equal"]
for i in range(len(arr_value)):
    print(arr_name[i], ":", arr_value[i])
print("\n\n\n\n")

# Toán tử logic
print("Toán tử logic:")
is_true = True
is_false = False
is_and = x and y
is_or = x or y
is_not = not x

arr_value = [is_true, is_false, is_and, is_or, is_not]
arr_name = ["is_true", "is_false", "is_and", "is_or", "is_not"]
for i in range(len(arr_value)):
    print(arr_name[i], ":", arr_value[i])
print("\n\n\n\n")

# Toán tử gán
print("Toán tử gán:")
x += 1  # x = x + 1
print("x = ", x)