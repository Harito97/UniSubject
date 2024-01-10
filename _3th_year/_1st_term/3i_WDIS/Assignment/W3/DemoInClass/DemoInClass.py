# I. API get để truy vấn thông tin dữ liệu

# 1. Lấy thông tin cơ bản: Hello World
# Truy cập bằng: http://127.0.0.1:8000/
# Output: {"message": "Hello World"}
'''
from fastapi import FastAPI 
 
app = FastAPI() 
 
@app.get("/") 
async def root(): 
    return {"message": "Hello World"}
'''

# 2. Lấy thông tin cơ bản 
# dùng tham số theo địa chỉ
# Truy cập bằng: http://127.0.0.1:8000/items/foo
# Output: {"item_id": "foo"}
'''
from fastapi import FastAPI 
 
app = FastAPI() 
 
@app.get("/items/{item_id}") 
async def read_item(item_id): 
    return {"item_id": item_id}
'''

# 3. Lấy thông tin cơ bản 
# dùng tham số theo truy vấn 
# Truy cập bằng: http://127.0.0.1:8000/items/soap
# Output: {"detail":[{"loc":["query","needy"],"msg":"field required","type":"value_error.missing"}]}
'''
from fastapi import FastAPI 
 
app = FastAPI() 
 
@app.get("/items/soap") 
async def read_user_item(needy: str, skip: int = 0, limit: int | None = None): 
    item = {"needy": needy, "skip": skip, "limit": limit} 
    return item
'''

# 4. Request Body:
# Gửi data từ 1 máy khác thông qua API
'''

'''
from fastapi import FastAPI, HTTPException 
from pydantic import BaseModel 
 
class Item(BaseModel): 
    name: str 
    description: str | None = None 
    price: float 
    tax: float | None = None 
 
app = FastAPI() 
 
items = []

# GET: Lấy danh sách item 
@app.get("/items/") 
async def list_items(): 
    return items 
 
# POST: Tạo item mới 
@app.post("/items/") 
async def create_item(item: Item): 
    return item
    items.append(item) 
    return {"message": "Item created successfully", "item": item} 
 
# PUT: Cập nhật thông tin item 
@app.put("/items_update/{item_id}") 
async def update_item(item_id: int, updated_item: Item): 
    if item_id < 0 or item_id >= len(items): 
        raise HTTPException(status_code=404, detail="Item not found") 
 
    items[item_id] = updated_item 
 
    return {"message": "Item updated successfully", "item": updated_item} 
 
# DELETE: Xóa item 
@app.delete("/items_delete/{item_id}") 
async def delete_item(item_id: int): 
    if item_id < 0 or item_id >= len(items): 
        raise HTTPException(status_code=404, detail="Item not found") 
 
    deleted_item = items.pop(item_id) 
    return {"message": f"Item with ID {item_id} has been deleted", 
"deleted_item": deleted_item}
