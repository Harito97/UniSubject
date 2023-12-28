// 3. Viết chương trình sum.cpp

// - Đầu vào của hàm là 2 mảng integer có N phần tử A, B

// - Đầu ra là mảng integer có N phần tử C sao cho C[i] = A[i] + B[i]

// - Gợi ý: mỗi thread thực hiện độc lập

#include <iostream>
#include <vector>
#include <omp.h>
#include <chrono> // Thêm lệnh này để sử dụng std::chrono

// Hàm tính tổng cho từng phần tử của mảng A và B theo multi threads
void sumArrays_MultiThreads(const std::vector<int> &A, const std::vector<int> &B, std::vector<int> &C, int start, int end)
{
#pragma omp parallel for
    for (int i = start; i < end; ++i)
    {
        C[i] = A[i] + B[i];
    }
}

// Hàm tính tổng cho từng phần tử của mảng A và B theo single thread
void sumArrays_SingleThread(const std::vector<int> &A, const std::vector<int> &B, std::vector<int> &C, int start, int end)
{
    for (int i = 0; i < A.size(); ++i)
    {
        C[i] = A[i] + B[i];
    }
}

int main()
{
    int N = 5; // Số phần tử của mảng

    std::vector<int> A = {1, 2, 3, 4, 5};  // Mảng A
    std::vector<int> B = {6, 7, 8, 9, 10}; // Mảng B
    std::vector<int> C(N);                 // Mảng C chứa kết quả

    int numThreads = omp_get_max_threads(); // Số lượng luồng tối đa được hỗ trợ

    int blockSize = N / numThreads; // Kích thước của mỗi phần tử mà một luồng xử lý

    // Đo thời gian chạy theo hướng đa luồng
    auto start = std::chrono::high_resolution_clock::now();
// Tạo các luồng và chia công việc cho từng luồng
#pragma omp parallel num_threads(numThreads)
    {
        int threadID = omp_get_thread_num();
        int start = threadID * blockSize;
        int end = (threadID == numThreads - 1) ? N : (threadID + 1) * blockSize;
        sumArrays_MultiThreads(A, B, C, start, end);
    }
    auto end = std::chrono::high_resolution_clock::now();
    auto duration = std::chrono::duration_cast<std::chrono::nanoseconds>(end - start).count();
    std::cout << "Time taken by multi threads: " << duration << " ns" << std::endl;

    // In kết quả
    for (int i = 0; i < N; ++i)
    {
        std::cout << C[i] << " ";
    }
    std::cout << std::endl;

    std::vector<int> D(N);  // Mảng D chứa kết quả
    // Đo thời gian theo hướng đơn luồng
    start = std::chrono::high_resolution_clock::now();
    sumArrays_SingleThread(A, B, D, 0, N);
    end = std::chrono::high_resolution_clock::now();
    duration = std::chrono::duration_cast<std::chrono::nanoseconds>(end - start).count();
    std::cout << "Time taken by single thread: " << duration << " ns" << std::endl;

    // In kết quả
    for (int i = 0; i < N; ++i)
    {
        std::cout << C[i] << " ";
    }
    std::cout << std::endl;

    return 0;
}

// Nhận xét kết quả in ra
// Time taken by multi threads: 3883053 ns
// 7 9 11 13 15 
// Time taken by single thread: 352 ns
// 7 9 11 13 15 
// Multi chạy chậm hơn 10000 lần so với single thread
// Với số phần tử nhỏ thì chưa thấy multi threads chạy nhanh hơn single thread
// Tuy nhiên với số phần tử lớn thì multi threads chạy nhanh hơn single thread