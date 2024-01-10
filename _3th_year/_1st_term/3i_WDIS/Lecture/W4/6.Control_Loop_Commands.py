# Lệnh điều khiển
print("Lệnh điều khiển")
def check_grade(grade):
    if grade >= 60:
        print("Passed!")
    else:
        print("Failed")

def score_division(grade):
    if grade >= 90:
        print("Grade A+")
    elif grade >= 85:
        print("Grade A")
    elif grade >= 80:
        print("Grade B+")
    elif grade >= 75:
        print("Grade B")
    elif grade >= 70:
        print("Grade C+")
    elif grade >= 60:
        print("Grade C")
    elif grade >= 50:
        print("Grade D+")
    elif grade >= 40:
        print("Grade D")
    else:
        print("Grade F")

check_grade(70)
check_grade(30)
score_division(90)
score_division(50)
score_division(30)

# Vòng lặp với for
print("Vòng lặp với for _______")
number_list = [1,2,3,4,5,6,7,8,9,10]
for number in number_list:
    print(number, end=" ")
print()
for i in range(1,11):
    print(i, end=" ")
print()
for i in range(1,11,1):
    print(i, end=" ")
print()
for i in range(1,11,2):
    print(i, end=" ")
print()
for i in range(10,0,-1):
    print(i, end=" ")
print()

# Vòng lặp với while
print("Vòng lặp với while _______")
flag = 10
while 3:
    print("Hello World!", flag)
    flag -= 1
    if flag == 0:
        print("Launched!", flag)
        break