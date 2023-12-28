from fastapi import FastAPI, Request, Form
from fastapi.responses import HTMLResponse, JSONResponse
from fastapi.templating import Jinja2Templates
import mysql.connector

app = FastAPI()
templates = Jinja2Templates(directory="templates") 

# Kết nối đến cơ sở dữ liệu
from contextlib import contextmanager

host = "localhost"
user = "root"
password = ""
database = "quan_ly_de_an"

@contextmanager
def connect_to_database():
    conn = mysql.connector.connect(
        host=host, user=user, password=password, database=database
    )
    cursor = conn.cursor()
    try:
        yield conn, cursor
    except Exception as e:
        print(f"Lỗi: {e}")
    finally:
        cursor.close()
        conn.close()

@app.get("/home/{data_table}", response_class=HTMLResponse)
async def read_data(request: Request, data_table: str):
    records = []
    columns_name = []
    with connect_to_database() as (conn, cursor):
        try:
            query = f"SELECT COLUMN_NAME\
                        FROM INFORMATION_SCHEMA.COLUMNS\
                        WHERE TABLE_NAME = '{ data_table }'"
            cursor.execute(query)
            columns_name = cursor.fetchall()

            query = f"SELECT * FROM {data_table}"
            cursor.execute(query)
            results = cursor.fetchall()
            records = [row for row in results]
        except Exception as e:
            print(f"Lỗi: {e}")
    
    # print(columns_name)
    # print(records)
    return templates.TemplateResponse("home.html", {"request": request, "data_table": data_table, "columns_name": columns_name, "records": records})
