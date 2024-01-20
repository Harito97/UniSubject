"""
Bài 1: 
Viết chương trình mô tả một số lệnh tạo tệp và thư mục như sau: 
Chương trình nhập vào các lệnh từ bàn phím,  
1.  Lệnh mkdir tạo thư mục 
2.  Lệnh touch tạo tệp 
3.  Lệnh ls hiển thị các tệp, thư mục hiện có trong đường dẫn 
4.  Lệnh cd chuyển đường dẫn đến thư mục khác 
Gợi ý: dùng các hàm trong module os.
"""

import os

class FileManager:
    def __init__(self):
        self.current_path = os.getcwd()

    def execute_command(self, command):
        tokens = command.split()
        if not tokens:
            return

        command_type = tokens[0]
        if command_type == "mkdir":
            self.create_directory(tokens[1])
        elif command_type == "touch":
            self.create_file(tokens[1])
        elif command_type == "ls":
            self.list_contents()
        elif command_type == "cd":
            self.change_directory(tokens[1])
        elif command_type == "pwd":
            print(os.getcwd())
        else:
            print("Invalid command")

    def create_directory(self, directory_name):
        new_directory_path = os.path.join(self.current_path, directory_name)
        os.makedirs(new_directory_path)
        print(f"Created directory: {new_directory_path}")

    def create_file(self, file_name):
        new_file_path = os.path.join(self.current_path, file_name)
        with open(new_file_path, "w") as file:
            file.write("This is a sample file content.")
        print(f"Created file: {new_file_path}")

    def list_contents(self):
        contents = os.listdir(self.current_path)
        print("Contents in the current directory:")
        for item in contents:
            print(item)

    def change_directory(self, new_directory):
        new_path = os.path.join(self.current_path, new_directory)
        if os.path.exists(new_path) and os.path.isdir(new_path):
            self.current_path = new_path
            print(f"Changed directory to: {new_path}")
        else:
            print(f"Directory not found: {new_path}")

def main():
    file_manager = FileManager()

    while True:
        command = input("Enter command (type 'exit' to quit): ")
        if command.lower() == "exit":
            break
        file_manager.execute_command(command)

if __name__ == "__main__":
    main()
