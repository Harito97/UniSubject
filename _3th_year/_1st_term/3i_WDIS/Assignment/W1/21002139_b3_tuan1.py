def days_of_month(month):
    if month in [1, 3, 5, 7, 8, 10, 12]:
        return 31
    elif month in [4, 6, 9, 11]:
        return 30
    elif month == 2:
        return [28, 29]

print(days_of_month(1))
print(days_of_month(2))
print(days_of_month(11))