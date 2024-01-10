## De 1.


## Bai 1.1
def get_longest_commseq(i, seq1, seq2):
    l = 1
    is_next = True

    # while is_next and l + i <= len(seq1):
    while is_next:
        is_next = False
        # for j in range(len(seq2) - l):
        for j in range(len(seq2) - l + 1):
            check = True
            for t in range(l):
                # if seq1[i + t] != seq2[j + t]:
                if (
                    i + t < len(seq1)
                    and j + t < len(seq2)
                    and seq1[i + t] != seq2[j + t]
                ):
                    check = False
                    break
            if check:
                l += 1
                is_next = True
                break

    return seq1[i : i + l - 1]


def find_longest_comseq(seq1, seq2):
    """
    Eg: seq1=[1,2,3,4,5,5]
    Eg: seq2=[2,3,4,5,1,2]
    Output: [2,3,4,5]
    """
    comm = []
    for i in range(len(seq1)):
        r = get_longest_commseq(i, seq1, seq2)
        if len(r) > len(comm):
            comm = r
    return comm


## Bai 1.2
def get_similar(v1, v2):
    # v1, v2 same size
    # return number of element is the same in v1 and v2
    return sum([1 for i in range(len(v1)) if v1[i] == v2[i]])


## Bai 1.3
def count_customer(bill_list):
    # bill_list = [(bill_id, customer_id, total)]
    # return number of customer
    return len(set([b[1] for b in bill_list]))


## Bai 1.4
def get_payment_list(bill_list):
    # bill_list = [(bill_id, customer_id, total)]
    # return [(customer_id, sum_payment)] sort for key = (sum_payment, customer_id) reverse = True
    cids = list(set([b[1] for b in bill_list]))
    result = [(c, sum([b[2] for b in bill_list if b[1] == c])) for c in cids]
    result.sort(key=lambda x: (x[1], x[0]), reverse=True)
    return result


if __name__ == "__main__":
    ## Test 1.1
    # seq1 = [1, 2, 2, 2, 2, 3, 1, 2, 3, 4, 5, 1, 2]
    # seq2 = [1, 2, 3, 1, 2, 3, 4, 5, 3, 2, 1]
    # Output: [2, 3, 1, 2, 3, 4, 5]
    seq1 = [1, 2, 3, 4, 5, 5]
    seq2 = [2, 3, 4, 5, 1, 2, 3, 6]
    # Output: [2,3,4,5]
    print(find_longest_comseq(seq1, seq2))

    ## Test 1.2
    v1 = [1, 2, 3, 1, 2, 3, 4, 5, 3, 2, 1]
    v2 = [1, 2, 2, 2, 2, 3, 1, 2, 3, 4, 5]
    # Output: 5
    print(get_similar(v1, v2))

    bill_list = [(1, 1, 2334), (32, 21, 434), (4, 323, 1212), (32, 1, 23)]

    ## Test 1.3
    # Output: 3
    print(count_customer(bill_list))

    ## Test 1.4
    # Output: [(1, 2357), (323, 1212), (21, 434)]
    print(get_payment_list(bill_list))
