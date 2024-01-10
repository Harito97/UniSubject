def count_number_three_digits_sum20():
    count = 0
    for i in range(100, 1000):
        number = i
        sum_num = 0
        while (number != 0):
            sum_num += number % 10
            number /= 10
        if sum_num == 20:
            count += 1
    print(count)

count_number_three_digits_sum20() # print 15 so thoa man