#include<stdio.h>

/* Main function, executed on host (CPU) */
int main(void)
{
    int size = 10;
    
    /* 1. allocate memory on GPU */

    float *d_A = NULL;
    if (cudaMalloc((void **)&d_A, size) != cudaSuccess)
        exit(EXIT_FAILURE);
    float *d_B = NULL;
    cudaMalloc((void **)&d_B, size); 
    /* For clarity we'll not check for err */
    float *d_C = NULL;
    cudaMalloc((void **)&d_C, size);


    /* 2. Copy data from Host to GPU */

    cudaMemcpy(d_A, h_A, size, cudaMemcpyHostToDevice);
    cudaMemcpy(d_B, h_B, size, cudaMemcpyHostToDevice);


    /* 3. Execute GPU kernel */

    /* Calculate number of blocks and threads */
    int threadsPerBlock = 256;
    int blocksPerGrid = (numElements + threadsPerBlock - 1) /
                        threadsPerBlock;
    /* Launch the Vector Add CUDA Kernel */
    vectorAdd<<<blocksPerGrid, threadsPerBlock>>>(d_A, d_B,
                                                  d_C, numElements);
    /* Wait for all the threads to complete */
    cudaDeviceSynchronize();


    /* 4. Copy data from GPU back to Host */

    cudaMemcpy(h_C, d_C, size, cudaMemcpyDeviceToHost);


    /* 5. Free GPU memory */

    cudaFree(d_A);
    cudaFree(d_B);
    cudaFree(d_C);


    return (0);
}