from PIL import Image

# Tạo một danh sách các tên tệp ảnh theo thứ tự tăng dần
file_names = [f'page{"0" + str(i) if i < 10 else i}_1.png' for i in range(1, 14)]

# Mở tất cả các tệp ảnh và thêm chúng vào danh sách
images = [Image.open(file_name) for file_name in file_names]

# Lấy kích thước của ảnh đầu tiên
width, height = images[0].size

# Tạo một ảnh mới với kích thước của ảnh đầu tiên và đặt màu nền là trắng
combined_image = Image.new('RGB', (width, height * len(images)), color='white')

# Ghép các ảnh vào ảnh kết quả
for i, img in enumerate(images):
    combined_image.paste(img, (0, i * height))

# Lưu ảnh kết quả
combined_image.save('combined_image.jpg')

# Đóng tất cả các ảnh đã mở
for img in images:
    img.close()
