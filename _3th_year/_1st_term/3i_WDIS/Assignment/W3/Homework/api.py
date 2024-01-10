import datetime
from fastapi import FastAPI, HTTPException
from contextlib import contextmanager
import pydantic as pd

app = FastAPI()

#########################################################################
# Định nghĩa các bảng dữ liệu

class CHUYENBAY(pd.BaseModel):
    MaCB: str
    GaDi: str
    GaDen: str
    DoDai: int
    GioDi: str
    GioDen: str
    ChiPhi: int


class MAYBAY(pd.BaseModel):
    MaMB: int
    Loai: str
    TamBay: int


class NHANVIEN(pd.BaseModel):
    MaNV: str
    Ten: str
    Luong: int


class CHUNGNHAN(pd.BaseModel):
    MaNV: str
    MaMB: int


#############################################################################
# Kết nối với cơ sở dữ liệu
import mysql.connector

host = "localhost"
user = "root"
password = ""
database = "Aviation_Database"

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

conn = mysql.connector.connect(
    host=host, user=user, password=password, database=database
)
cursor = conn.cursor()

#########################################################################
# Định nghĩa các phương thức cho bảng CHUYENBAY
# GET: Lấy danh sách chuyenbay


@app.get("/get_chuyenbays")
async def list_chuyenbays():
    try:
        cursor.execute("SELECT * FROM CHUYENBAY")
        return cursor.fetchall()
    except Exception as e:
        return e


# POST: Tạo chuyenbay mới
@app.post("/post_chuyenbay")
async def create_chuyenbay(chuyenbay: CHUYENBAY):
    try:
        cursor.execute(
            "INSERT INTO CHUYENBAY (MaCB, GaDi, GaDen, DoDai, GioDi, GioDen, ChiPhi)\
                    VALUES (%s, %s, %s, %s, %s, %s, %s)",
            (
                chuyenbay.MaCB,
                chuyenbay.GaDi,
                chuyenbay.GaDen,
                chuyenbay.DoDai,
                chuyenbay.GioDi,
                chuyenbay.GioDen,
                chuyenbay.ChiPhi,
            ),
        )
        cursor.commit()
        return {"message": "chuyenbay created successfully", "chuyenbay": chuyenbay}
    except Exception as e:
        return e


# PUT: Cập nhật thông tin chuyenbay
@app.put("/update_chuyenbay")
async def update_chuyenbay(chuyenbay: CHUYENBAY):
    try:
        cursor.execute(
            "UPDATE CHUYENBAY\
                    SET GaDi = %s, GaDen = %s, DoDai = %s, GioDi = %s, GioDen = %s, ChiPhi = %s\
                    WHERE MaCB = %s;",
            (
                chuyenbay.GaDi,
                chuyenbay.GaDen,
                chuyenbay.DoDai,
                chuyenbay.GioDi,
                chuyenbay.GioDen,
                chuyenbay.ChiPhi,
                chuyenbay.MaCB,
            ),
        )
        cursor.commit()
        return {
            "message": f"chuyenbay with ID {chuyenbay.MaCB} has been updated",
            "updated_chuyenbay": chuyenbay,
        }
    except Exception as e:
        return e


# DELETE: Xóa chuyenbay
@app.delete("/delete_chuyenbay/{MaCB}")
async def delete_chuyenbay(MaCB: str):
    try:
        cursor.execute("SELECT * FROM CHUYENBAY WHERE MaCB = %s;", (MaCB,))
        deleted_chuyenbay = cursor.fetchall()
        cursor.execute("DELETE FROM CHUYENBAY WHERE MaCB = %s;", (MaCB,))
        return {
            "message": f"chuyenbay with ID {MaCB} has been deleted",
            "deleted_chuyenbay": deleted_chuyenbay,
        }
    except Exception as e:
        return e


#########################################################################
# Định nghĩa các phương thức cho bảng MAYBAY
# GET: Lấy danh sách maybay
@app.get("/get_maybays/")
async def list_maybays():
    try:
        cursor.execute("SELECT * FROM MAYBAY")
        results = cursor.fetchall()
        return results
    except Exception as e:
        return e


# POST: Tạo maybay mới
@app.post("/post_maybay")
async def create_maybay(maybay: MAYBAY):
    try:
        cursor.execute(
            "INSERT INTO MAYBAY (MaMB, Loai, TamBay)\
                        VALUES (%s, %s, %s);",
            (maybay.MaMB, maybay.Loai, maybay.TamBay),
        )
        conn.commit()
        return {"message": "maybay created successfully", "maybay": maybay}
    except Exception as e:
        return e


# PUT: Cập nhật thông tin maybay
@app.put("/update_maybay")
async def update_maybay(upmaybay: MAYBAY):
    try:
        cursor.execute(
            "UPDATE MAYBAY\
                SET Loai = %s, TamBay = %s\
                WHERE MaMB = %s;",
            (upmaybay.Loai, upmaybay.TamBay, upmaybay.MaMB),
        )
        conn.commit()
        return {
            "message": f"maybay with ID {upmaybay.MaMB} has been updated",
            "updated_maybay": upmaybay,
        }
    except Exception as e:
        return e


# DELETE: Xóa maybay
@app.delete("/delete_maybay/{MaMB}")
async def delete_maybay(MaMB: int):
    try:
        cursor.execute("DELETE FROM MAYBAY WHERE MaMB = %s;", (MaMB,))
        return {"message": f"maybay with ID {MaMB} has been deleted"}
    except Exception as e:
        return e


#########################################################################
# Định nghĩa các phương thức cho bảng NHANVIEN
# GET: Lấy danh sách nhanvien


@app.get("/get_nhanviens/")
async def list_nhanviens():
    cursor.execute("SELECT * FROM NHANVIEN")
    results = cursor.fetchall()
    return results


# POST: Tạo nhanvien mới
@app.post("/post_nhanvien")
async def create_nhanvien(nhanvien: NHANVIEN):
    try:
        cursor.execute(
            "INSERT INTO NHANVIEN (MaNV, Ten, Luong)\
                        VALUES (%s, %s, %s);",
            (nhanvien.MaNV, nhanvien.Ten, nhanvien.Luong),
        )
        conn.commit()
    except Exception as e:
        return e
    return {"message": "nhanvien created successfully", "nhanvien": nhanvien}


# PUT: Cập nhật thông tin nhanvien
@app.put("/update_nhanvien")
async def update_nhanvien(nhanvien: NHANVIEN):
    try:
        cursor.execute(
            "UPDATE NHANVIEN\
                    SET Ten = %s, Luong = %s\
                    WHERE MaNV = %s;",
            (nhanvien.Ten, nhanvien.Luong, nhanvien.MaNV),
        )
        conn.commit()
    except Exception as e:
        return e
    return {
        "message": f"nhanvien with ID {nhanvien.MaNV} has been updated",
        "updated_nhanvien": nhanvien,
    }


# DELETE: Xóa nhanvien
@app.delete("/delete_nhanvien/{MaNV}")
async def delete_nhanvien(MaNV: str):
    try:
        cursor.execute("SELECT * FROM NHANVIEN WHERE MaNV = %s;", (MaNV,))
        deleted_nhanvien = cursor.fetchall()
        cursor.execute("DELETE FROM NHANVIEN WHERE MaNV = %s;", (MaNV,))
    except Exception as e:
        return e
    return {
        "message": f"nhanvien with ID {MaNV} has been deleted",
        "deleted_nhanvien": deleted_nhanvien,
    }


#########################################################################
# Định nghĩa các phương thức cho bảng CHUNGNHAN
# GET: Lấy danh sách nhanvien
@app.get("/get_chungnhans")
async def list_chungnhans():
    try:
        cursor.execute("SELECT * FROM CHUNGNHAN")
        results = cursor.fetchall()
    except Exception as e:
        return e
    return results


# POST: Tạo chungnhan mới
@app.post("/post_chungnhan")
async def create_chungnhan(chungnhan: CHUNGNHAN):
    try:
        cursor.execute(
            "INSERT INTO CHUNGNHAN (MaNV, MaMB)\
                        VALUES (%s, %s);",
            (chungnhan.MaNV, chungnhan.MaMB),
        )
        conn.commit()
    except Exception as e:
        return e
    return {"message": "chungnhan created successfully", "chungnhan": chungnhan}


# PUT: Cập nhật thông tin chungnhan
# Hàm này bị vô nghĩa vì chỉ có 2 thuộc tính trong bảng và cả 2 đều là khóa


# DELETE: Xóa chungnhan
@app.delete("/delete_chungnhan/{MaNV}/{MaMB}")
async def delete_chungnhan(MaNV: str, MaMB: int):
    try:
        cursor.execute(
            "SELECT * FROM CHUNGNHAN WHERE MaNV = %s AND MaMB = %s;", (MaNV, MaMB)
        )
        deleted_chungnhan = cursor.fetchall()
        cursor.execute(
            "DELETE FROM CHUNGNHAN WHERE MaNV = %s AND MaMB = %s;", (MaNV, MaMB)
        )
    except Exception as e:
        return e
    return {
        "message": f"chungnhan with ID {MaNV}:{MaMB} has been deleted",
        "deleted_chungnhan": deleted_chungnhan,
    }


#########################################################################
# Hết các API cần viết

# cursor.close()
# conn.close()
