"""
Bài 2: Viết chương trình duyệt, và in ra cây thư mục của 1 đường dẫn. 
"""

import os

def print_directory_tree(path, indent=""):
    if os.path.isdir(path):
        print(f"{indent}[{os.path.basename(path)}]")
        indent += "    "
        for item in os.listdir(path):
            item_path = os.path.join(path, item)
            print_directory_tree(item_path, indent)
    else:
        print(f"{indent}{os.path.basename(path)}")

def main(path='/mnt/DataK/Univer/Subject/3i_PDC'):
    temp = input("Enter the directory path: ")
    if temp != '':
        path = temp
    print("Directory tree:")
    print_directory_tree(path)

if __name__ == "__main__":
    main()
