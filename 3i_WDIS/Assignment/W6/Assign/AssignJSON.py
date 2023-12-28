# Bài tập: Xuất ra tất cả file JSON ứng với tất cả các bảng trong CSDL "quan_ly_de_an". 

from fastapi import FastAPI
from fastapi.responses import JSONResponse
from contextlib import contextmanager
import json
import mysql.connector

app = FastAPI()

host = "localhost"
user = "root"
password = ""
database = "quan_ly_de_an"

@contextmanager
def connect_to_database():
    conn = mysql.connector.connect(
        host=host, user=user, password=password, database=database
    )
    cursor = conn.cursor(dictionary=True)  # Use dictionary cursor
    try:
        yield conn, cursor
    except Exception as e:
        print(f"Lỗi: {e}")
    finally:
        cursor.close()
        conn.close()

def data_from_mysql(data_table):
    with connect_to_database() as (conn, cursor):
        query = f'SELECT * FROM {data_table}'
        cursor.execute(query)
        data = cursor.fetchall()
        return data

@app.get("/json-data/{data_table}")
def get_json_data(data_table: str):
    return JSONResponse(content=data_from_mysql(data_table))

@app.get("/export-json/{data_table}")
def export_to_json(data_table: str):
    filename = "data.json"
    data = data_from_mysql(data_table)

    with open(filename, "w") as json_file:
        json.dump(data, json_file, ensure_ascii=False, indent=4, default=str)

    return {"message": f"Exported data to {filename}"}
