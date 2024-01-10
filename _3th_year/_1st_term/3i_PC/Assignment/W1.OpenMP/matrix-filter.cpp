#include <cstdio>
#include <vector>
#include <omp.h>
using namespace std;

void applyMatrixFilter(vector<vector<int>>& matrix, vector<vector<int>>& filter) {
    int rows = matrix.size();
    int cols = matrix[0].size();
    int filterSize = filter.size();

    vector<vector<int>> result(rows, vector<int>(cols, 0));

    #pragma omp parallel for collapse(2)
    for (int i = 1; i < rows - 1; i++) {
        for (int j = 1; j < cols - 1; j++) {
            int sum = 0;
            for (int k = 0; k < filterSize; k++) {
                for (int l = 0; l < filterSize; l++) {
                    int rowIndex = i - filterSize / 2 + k;
                    int colIndex = j - filterSize / 2 + l;

                    if (rowIndex >= 0 && rowIndex < rows && colIndex >= 0 && colIndex < cols) {
                        sum += matrix[rowIndex][colIndex] * filter[k][l];
                    }
                }
            }
            result[i][j] = sum;
        }
    }

    // Gán ma trận kết quả vào ma trận ban đầu
    matrix = result;
}

int main() {
    vector<vector<int>> matrix = {
        {0, 0, 0, 0, 0, 0, 0, 0, 1},
        {0, 0, 0, 0, 0, 0, 0, 1, 1},
        {0, 0, 0, 0, 0, 0, 1, 1, 1},
        {0, 0, 0, 0, 0, 1, 1, 1, 1},
        {0, 0, 0, 0, 1, 1, 1, 1, 1},
        {0, 0, 0, 1, 1, 1, 1, 1, 1},
        {0, 0, 1, 1, 1, 1, 1, 1, 1},
        {0, 1, 1, 1, 1, 1, 1, 1, 1},
        {1, 1, 1, 1, 1, 1, 1, 1, 1}
    };

    vector<vector<int>> filter = {
        {0, -1, 0},
        {-1, 4, -1},
        {0, -1, 0}
    };

    // Áp dụng bộ lọc ma trận
    applyMatrixFilter(matrix, filter);

    // In ma trận kết quả
    for (const auto& row : matrix) {
        for (int value : row) {
            printf("%2d ", value);
        }
        printf("\n");
    }

    return 0;
}