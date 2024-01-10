from fastapi import FastAPI 
import json 
 
app = FastAPI() 
 
# Một ví dụ đơn giản về dữ liệu từ CSDL MySQL 
data_from_mysql = { 
    "username": "csdlweb", 
    "email": "csdlweb@hus.edu.vn", 
    "website": "csdlweb.hus.edu.vn", 
    "title": "Tìm hiểu về JSON" 
} 
 
# Đường dẫn để hiển thị dữ liệu JSON lên web 
@app.get("/json-data") 
def get_json_data(): 
    return data_from_mysql 
 
# Đường dẫn để xuất dữ liệu từ CSDL MySQL ra file JSON 
@app.get("/export-json") 
def export_to_json(): 
    filename = "data.json" 
    with open(filename, "w") as json_file: 
        json.dump(data_from_mysql, json_file, indent=4) 
    return {"message": f"Exported data to {filename}"} 
 
# Ở đây, chúng ta đã tạo một ứng dụng FastAPI với hai đường dẫn: 
# • /json-data: Đường dẫn này trả về dữ liệu JSON từ biến data_from_mysql. 
# • /export-json: Đường dẫn này sẽ xuất dữ liệu từ biến data_from_mysql ra file 
# JSON có tên data.json. 
# Khi bạn truy cập vào /json-data trên trình duyệt, bạn sẽ nhận được dữ liệu JSON 
# được trả về dưới dạng: 
# { 
#     "username": "csdlweb", 
#     "email": "csdlweb@hus.edu.vn", 
#     "website": "csdlweb.hus.edu.vn", 
#     "title": "Tìm hiểu về JSON" 
# } 
