import mysql.connector 
 
host = "localhost" 
user = "your_user" 
password = "your_password" 
database = "your_database" 
 
try: 
    conn = mysql.connector.connect( 
        host=host, 
        user=user, 
        password=password, 
        database=database 
    ) 
 
    cursor = conn.cursor() 
 
    cursor.execute("SELECT * FROM your_table") 
    result = cursor.fetchall() 
 
    for row in result: 
        print(row) 
 
    cursor.close() 
    conn.close() 
 
except Exception as e: 
    print(f"Lỗi: {e}") 