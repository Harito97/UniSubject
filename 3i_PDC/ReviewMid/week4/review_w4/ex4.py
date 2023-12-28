"""
Bài 4: Viết chương trình tạo một từ điển gồm khóa là xâu độ dài 5 được sinh ngẫu nhiên, 
và giá trị của mỗi khóa là số nguyên cũng được sinh ngẫu nhiên, ghi từ điển ra file 
dict.dat (ghi đối tượng), đọc đối tượng từ điển từ  file dict.dat và in kết quả ra  màn 
hình Gợi ý: sử dụng module pickle.
"""

import pickle
import random
import string

def generate_random_string(length):
    return ''.join(random.choice(string.ascii_letters) for _ in range(length))

def generate_random_dictionary():
    random_dict = {generate_random_string(5): random.randint(1, 100) for _ in range(10)}
    return random_dict

def save_dictionary_to_file(dictionary, filename):
    with open(filename, 'wb') as file:
        pickle.dump(dictionary, file)
    print(f"Dictionary saved to {filename}")

def load_dictionary_from_file(filename):
    with open(filename, 'rb') as file:
        loaded_dict = pickle.load(file)
    return loaded_dict

def print_dictionary(dictionary):
    for key, value in dictionary.items():
        print(f"{key}: {value}")

def main():
    # Generate a random dictionary
    random_dictionary = generate_random_dictionary()

    # Save the dictionary to file
    save_dictionary_to_file(random_dictionary, 'ex4_dict.dat')

    # Load the dictionary from file
    loaded_dictionary = load_dictionary_from_file('ex4_dict.dat')

    # Print the loaded dictionary
    print("Loaded Dictionary:")
    print_dictionary(loaded_dictionary)

if __name__ == "__main__":
    main()
