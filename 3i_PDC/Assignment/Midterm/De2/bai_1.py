## De 2. 

## Bai 1.1
def image_feature(img, size):
    # img = [   [1,2,3,4,5,6],
    #           [2,3,4,5,6,1],
    #           [3,4,5,6,1,2],
    #           [4,5,6,1,2,3],
    #           [5,6,1,2,3,4],
    #           [6,1,2,3,4,5]   ]
    # size = (3, 3)
    # Slice 4 part:
    # slice = 1 2 3     4 5 6
    #         2 3 4     5 6 1
    #         3 4 5     6 1 2
    #
    #         4 5 6     1 2 3
    #         5 6 1     2 3 4
    #         6 1 2     3 4 5
    # Calculate: Avg of each part
    M = len(img)
    N = len(img[0])
    v, h = size
    result = []
    for i in range(0, M, v):
        for j in range(0, N, h):
            rows = img[i : i + v]  # slice the row
            p = []
            for r in rows:
                p.append(r[j : j + h])
            result.append(sum([sum(t) for t in p]) / (v * h))
    return result


if __name__ == "__main__":
    ## Test 1.1
    img = [   [1,2,3,4,5,6],
              [2,3,4,5,6,1],
              [3,4,5,6,1,2],
              [4,5,6,1,2,3],
              [5,6,1,2,3,4],
              [6,1,2,3,4,5]   ]
    print(image_feature(img, (3,3)))