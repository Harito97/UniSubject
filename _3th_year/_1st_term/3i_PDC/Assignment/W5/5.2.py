# Cách 1: Dùng mảng phụ 
def zeroMove(fileName):
    '''
    Hoàn thiện phương thức zeroMove(fileName), phương thức này thực hiện việc đọc các số nguyên

    từ file fileName, các số nguyên được viết trên 1 dòng, mỗi số cách nhau bởi 1 dấu cách. Lưu các số này vào
    
    trong một danh sách theo đúng thứ tự trong fileName
    
    Thực hiện việc di chuyển các số 0 về phía bên phải của danh sách trong khi vẫn giữ nguyên thứ tự của các số khác.
    
    Hàm zeroMove trả lại danh sách sau khi thực hiện việc di chuyển số 0.
    
    
    
    > Ví dụ cho file data.txt có nội dung như sau:
    
    0 1 0 3 12
    
    > Kết quả trả về là
    
    [1, 3, 12, 0, 0]
    '''
    
    with open(fileName, "rt") as f:
        nums = f.read().split(" ")
        nums = list(map(int, nums))
        result_sort = [0] * len(nums)
        index = 0
        for num in nums:
            if num != 0:
                result_sort[index] = num
                index += 1
    return result_sort

# Cách 2: Dùng 1 mảng duy nhất để tiết kiệm bộ nhớ 
def zeroMove(fileName):    
    with open(fileName, "rt") as f:
        nums = f.read().split(" ")
        nums = list(map(int, nums))
        
        is_next = True

        while(is_next):
            is_next = False

            for i in range(len(nums) - 1):
                if nums[i] == 0 and nums[i + 1] != 0:
                    nums[i], nums[i + 1] = nums[i + 1], nums[i]
                    is_next = True 
    return nums

# Cách 3: Dùng so sánh 