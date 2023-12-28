def check_pass(string):
    special_char = "!@#$%^&*()_"
    if len(string) < 8:
        return False
    
    count_digit, count_letter, count_special = 0, 0, 0
    for character in string:
        if character.isdigit():
            count_digit += 1
        elif character.isalpha():
            count_letter += 1
        elif character in special_char:
            count_special += 1
    
    if count_letter < 1 or count_digit < 2 or count_special < 1:
        return False
   
    return True

string = input("Input a valid password:")
password = string if check_pass(string) else None
while (password == None):
    print("Invalid password! Please think another password!")
    string = input()
    password = string if check_pass(string) else None

print("Valid password!")

