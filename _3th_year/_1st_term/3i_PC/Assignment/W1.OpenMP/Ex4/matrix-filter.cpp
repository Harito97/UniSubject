// 4. Viết trương trình tính matrix-filter.cpp

// - Đầu vào của hàm là 1 ma trận NxN giá trị integer A, 1 ma trận filter 3x3 F như sau

// - Đầu ra là 1 ma trận NxN B sao cho B[i] = F[a][b]* A[i+a][i+b], quy ước điểm giữa ma trận F là 0,0

// Ý tưởng cách giải quyết theo hướng đa luồng
// Đầu tiên, ta có hàm applyFilter để tính ma trận kết quả B dựa trên ma trận A và ma trận lọc F.
// Hàm này sử dụng #pragma omp parallel for để thực hiện vòng lặp song song trên ma trận B.
// Ta sử dụng collapse(2) để gộp hai vòng lặp thành một vòng lặp duy nhất để tận dụng song song hóa.

// // Trong vòng lặp, ta tính toán giá trị của mỗi phần tử B[i][j] bằng cách lấy tổng của tích các phần tử tương ứng của ma trận A và ma trận lọc F.
// Ta sử dụng omp atomic để đảm bảo tính toán được thực hiện an toàn trên các phần tử B[i][j] trong quá trình đa luồng.

// // Trong hàm main, ta khởi tạo ma trận A và ma trận lọc F với các giá trị mẫu.
// Sau đó, ta gọi hàm applyFilter để tính ma trận kết quả B và in ma trận B ra màn hình.

#include <iostream>
#include <vector>
#include <omp.h>
#include <chrono> // Thêm lệnh này để sử dụng std::chrono

// Hàm tính ma trận kết quả B dựa trên ma trận A và ma trận lọc F theo đa luồng
std::vector<std::vector<int>> applyFilter_MultiThreads(const std::vector<std::vector<int>> &A, const std::vector<std::vector<int>> &F)
{
    int N = A.size();
    std::vector<std::vector<int>> B(N, std::vector<int>(N, 0)); // Ma trận kết quả B

    int filterSize = F.size();
    int filterOffset = filterSize / 2;

#pragma omp parallel for collapse(2)
    for (int i = 0; i < N; ++i)
    {
        for (int j = 0; j < N; ++j)
        {
            for (int a = 0; a < filterSize; ++a)
            {
                for (int b = 0; b < filterSize; ++b)
                {
                    int rowIndex = i + a - filterOffset;
                    int colIndex = j + b - filterOffset;

                    if (rowIndex >= 0 && rowIndex < N && colIndex >= 0 && colIndex < N)
                    {
#pragma omp atomic
                        B[i][j] += F[a][b] * A[rowIndex][colIndex];
                    }
                }
            }
        }
    }

    return B;
}

// Hàm tính ma trận kết quả B dựa trên ma trận A và ma trận lọc F theo đơn luồng
std::vector<std::vector<int>> applyFilter_SingleThread(const std::vector<std::vector<int>> &A, const std::vector<std::vector<int>> &F)
{
    int N = A.size();
    std::vector<std::vector<int>> B(N, std::vector<int>(N, 0)); // Ma trận kết quả B

    int filterSize = F.size();
    int filterOffset = filterSize / 2;

    for (int i = 0; i < N; ++i)
    {
        for (int j = 0; j < N; ++j)
        {
            for (int a = 0; a < filterSize; ++a)
            {
                for (int b = 0; b < filterSize; ++b)
                {
                    int rowIndex = i + a - filterOffset;
                    int colIndex = j + b - filterOffset;

                    if (rowIndex >= 0 && rowIndex < N && colIndex >= 0 && colIndex < N)
                    {
                        B[i][j] += F[a][b] * A[rowIndex][colIndex];
                    }
                }
            }
        }
    }

    return B;
}

int main()
{
    int N = 9; // Kích thước ma trận

    std::vector<std::vector<int>> A = {
        {0, 0, 0, 0, 0, 0, 0, 0, 1},
        {0, 0, 0, 0, 0, 0, 0, 1, 1},
        {0, 0, 0, 0, 0, 0, 1, 1, 1},
        {0, 0, 0, 0, 0, 1, 1, 1, 1},
        {0, 0, 0, 0, 1, 1, 1, 1, 1},
        {0, 0, 0, 1, 1, 1, 1, 1, 1},
        {0, 0, 1, 1, 1, 1, 1, 1, 1},
        {0, 1, 1, 1, 1, 1, 1, 1, 1},
        {1, 1, 1, 1, 1, 1, 1, 1, 1}}; // Ma trận A

    std::vector<std::vector<int>> F = {
        {0, -1, 0},
        {-1, 4, -1},
        {0, -1, 0}}; // Ma trận lọc F - quy ước điểm giữa ma trận F là 0

    // Đo thời gian chạy theo hướng đa luồng
    auto start = std::chrono::high_resolution_clock::now();

    std::vector<std::vector<int>> B = applyFilter_MultiThreads(A, F); // Ma trận kết quả B

    auto end = std::chrono::high_resolution_clock::now();
    auto duration = std::chrono::duration_cast<std::chrono::nanoseconds>(end - start).count();
    std::cout << "Time taken by multi thread: " << duration << " ns" << std::endl;
    // In ma trận kết quả B
    for (int i = 0; i < N; ++i)
    {
        for (int j = 0; j < N; ++j)
        {
            std::cout << B[i][j] << " ";
        }
        std::cout << std::endl;
    }

    // Đo thời gian chạy theo hướng đơn luồng
    start = std::chrono::high_resolution_clock::now();

    std::vector<std::vector<int>> C = applyFilter_SingleThread(A, F); // Ma trận kết quả C

    end = std::chrono::high_resolution_clock::now();
    duration = std::chrono::duration_cast<std::chrono::nanoseconds>(end - start).count();
    std::cout << "Time taken by single thread: " << duration << " ns" << std::endl;
    // In ma trận kết quả C
    for (int i = 0; i < N; ++i)
    {
        for (int j = 0; j < N; ++j)
        {
            std::cout << C[i][j] << " ";
        }
        std::cout << std::endl;
    }

    return 0;
}

// Nhận xét kết quả in ra
// Time taken by multi thread: 3732115 ns
// 0 0 0 0 0 0 0 -2 3 
// 0 0 0 0 0 0 -2 2 1 
// 0 0 0 0 0 -2 2 0 1 
// 0 0 0 0 -2 2 0 0 1 
// 0 0 0 -2 2 0 0 0 1 
// 0 0 -2 2 0 0 0 0 1 
// 0 -2 2 0 0 0 0 0 1 
// -2 2 0 0 0 0 0 0 1 
// 3 1 1 1 1 1 1 1 2 
// Time taken by single thread: 32578 ns
// 0 0 0 0 0 0 0 -2 3 
// 0 0 0 0 0 0 -2 2 1 
// 0 0 0 0 0 -2 2 0 1 
// 0 0 0 0 -2 2 0 0 1 
// 0 0 0 -2 2 0 0 0 1 
// 0 0 -2 2 0 0 0 0 1 
// 0 -2 2 0 0 0 0 0 1 
// -2 2 0 0 0 0 0 0 1 
// 3 1 1 1 1 1 1 1 2 

// Như vậy trong trường hợp này (input nhỏ) với chip chạy như này 
// thì dùng single thread hóa ra lại cho kết quả nhanh hơn so với dùng multi threads
// Tuy nhiên với input lớn thì multi threads chạy nhanh hơn single thread