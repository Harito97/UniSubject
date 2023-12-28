'''
Bài 4:
Một công ty phần mềm có nhiều nhân viên (Employee), mỗi tháng công ty cần tính
và trả lương cho nhân viên của mình. Tuy nhiên, công việc tính lương không hề đơn
giản, nó đòi hỏi rất nhiều thời gian và tính toán cẩn thận. Bạn hãy xây dượng một
chương trình giúp công ty giải quyết vấn đề trên. Biết rằng mỗi nhân viên có một
mã số, họ tên, năm sinh và một mức lương cơ bản (MLCB). Công thức tính lương
như sau:

+ Nếu là quản lý (Manager) thì tiền lương sẽ được tính bằng MLCB + MLCB x 25%
+ Nếu là nhà phân tích dữ liệu (Data Scientist) thì tiền lương sẽ được tính bằng
MLCB + MLCBx20% + số dự án tham gia trong tháng x 1500$
+ Nếu là lập trình viên (Developer) thì tiền lương sẽ được tính bằng MLCB +
số dự án thực hiện trong tháng x 1000$
+ Các nhân viên khác được trả lương bằng MLCB

Xây dựng các lớp hợp lý, tạo lớp EmployeeManager để quản lý thông tin các nhân
viên trong công ty.
'''

class Employee:
    
    def __init__(self, eid, name, year, basicSalary):
        self.eid = eid
        self.name = name
        self.year = year
        self.basicSalary = basicSalary     
        
    def getSalary(self):
        return self.basicSalary
    
    
class Manager(Employee):

    # Nạp chồng phương thức  tính lương
    def getSalary(self):
        return self.basicSalary * 1.25
    
class DataScientist(Employee):
    
    # Hàm dựng thêm 1 đối project là số dự án  làm trong tháng
    def __init__(self,eid, name, year, basicSalary, project):
        super().__init__(eid, name, year, basicSalary)
        self.project = project
        
    # Nạp chồng phương thức tính lương
    def getSalary(self):
        return self.basicSalary * 1.2 + self.project * 1500
    
    
class Developer(DataScientist):
    
    #Nạp chồng phương thức tính lương
    def getSalary(self):
        return self.basicSalary + self.project * 1000
    


def loadEmploysFromFile(filename):
    '''
    Phương thức đọc danh sách các nhân viên từ filename, mỗi thông tin của nhân viên lưu trên từng dòng theo thứ tự sau:
    Mã nhân viên (xâu)
    Họ tên (xâu)
    Năm sinh (số nguyên)
    Mức lương cơ bản (số thực)
    Số dự án (số nguyên) (chỉ DataScientist và Developer có dòng này)
    
    
    Chú ý: 
    - Nếu Mã nhân viên bắt đầu bằng E thì  là nhân viên bình thường Employee
    - Nếu Mã nhân viên bắt đầu bằng M thì  là Quản lý Manager
    - Nếu Mã nhân viên bắt đầu bằng DS thì là nhà phân tích dữ liệu DataScientist
    - Nếu Mã nhân viên bắt đầu bằng DV thì là lập trình viên Developer
    
    Các nhân viên được đưa lần lượt vào danh sách employees, hàm sẽ trả về danh sách này.
    
    '''
    
    employees = []
    with open(filename, "r") as f:
        eid = f.readline().strip()
        while eid != "":
            name = f.readline().strip()
            year = int(f.readline().strip())
            basicSalary = float(f.readline().strip())
            if eid.startswith("E"):
                employees.append(Employee(eid, name, year, basicSalary))
            elif eid.startswith("M"):
                employees.append(Manager(eid, name, year, basicSalary))
            elif eid.startswith("DS"):
                employees.append(DataScientist(eid, name, year, basicSalary, int(f.readline().strip())))
            elif eid.startswith("DV"):
                employees.append(Developer(eid, name, year, basicSalary, int(f.readline().strip())))
            eid = f.readline()    
    return employees

'''
Failed tests
Test 1: test 1
Test 2: test 2
Test 1: test 1
Incorrect program output
--- Input ---

 data1.txt


--- Program output ---

Traceback (most recent call last):
  File "Main.py", line 5, in <module>
    employees = EmployeeManagement.loadEmploysFromFile(filename)
  File "/home/p11482/EmployeeManagement.py", line 64, in loadEmploysFromFile
    year = int(f.readline())
ValueError: invalid literal for int() with base 10: 'Nguyễn Thị Học\n'


--- Expected output (exact text)---

ID =   M01 Name =  Nguyễn Văn Quản  Salary =  3750.0
ID =   M02 Name =  Trần Thị Lý  Salary =  3250.0
ID =   E01 Name =  Ngọc Thị Trinh  Salary =  1000.0
ID =   E02 Name =  Nguyễn Văn Bảo  Salary =  800.0
ID =   DS01 Name =  Trần Văn Khoa  Salary =  4800.0
ID =   DS02 Name =  Nguyễn Thị Học  Salary =  6420.0
ID =   DV01 Name =  Hoàng Văn Lập  Salary =  3300.0
ID =   DV02 Name =  Nguyễn Cao Trình  Salary =  4400.0


Test 2: test 2
Incorrect program output
--- Input ---

 data2.txt


--- Program output ---

Traceback (most recent call last):
  File "Main.py", line 5, in <module>
    employees = EmployeeManagement.loadEmploysFromFile(filename)
  File "/home/p11482/EmployeeManagement.py", line 64, in loadEmploysFromFile
    year = int(f.readline())
ValueError: invalid literal for int() with base 10: 'Nguyễn Thị Học\n'


--- Expected output (exact text)---

ID =   E01 Name =  Ngọc Thị Trinh  Salary =  1150.0
ID =   E02 Name =  Nguyễn Văn Bảo  Salary =  700.0
ID =   DS01 Name =  Trần Văn Khoa  Salary =  4680.0
ID =   DS02 Name =  Nguyễn Thị Học  Salary =  6780.0
ID =   DV01 Name =  Hoàng Văn Lập  Salary =  3300.0
ID =   DV02 Name =  Nguyễn Cao Trình  Salary =  4500.0
ID =   M01 Name =  Nguyễn Văn Quản  Salary =  4375.0
ID =   M02 Name =  Trần Thị Lý  Salary =  3250.0


Summary of tests

+------------------------------+
|  2 tests run/ 0 tests passed |
+------------------------------+
'''