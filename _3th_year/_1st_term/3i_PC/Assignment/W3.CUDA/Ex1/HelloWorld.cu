#include <stdio.h>

/* Function executed on device (GPU */
__global__ void hello(void)
{
    printf("\tHello from GPU: thread %d and block %d\n",
           threadIdx.x,
           blockIdx.x);
}

/* Main function, executed on host (CPU) */
int main(void)
{
    int NUM_BLOCKS = 4;
    int BLOCK_WIDTH = 3;
    /* print message from CPU */
    printf("Hello Cuda!\n");
    /* execute function on device (GPU) */
    hello<<<NUM_BLOCKS, BLOCK_WIDTH>>>();
    /* wait until all threads finish their job */
    cudaDeviceSynchronize();
    /* print message from CPU */
    printf("Welcome back to CPU!\n");
    return (0);
}
