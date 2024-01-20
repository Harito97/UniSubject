class Node:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class BinarySearchTree:

    """
    Cây nhị phân tìm kiếm.

    Các phần tử trên mỗi node là số nguyên
    Mỗi node là một đối tượng thuộc lớp Node dưới đây

    Mỗi node có 2 con là left và right, trong đó
    left < node < right


    Chú ý, với bài tập về cây, các phương thức thường được viết
    bằng các hàm đệ quy, sinh viên có thể viết thêm các hàm phụ trợ nếu cần
    """

    def __init__(self):
        """
        Các thao tác trên cây nhị phân sẽ được thực hiện thông qua tham chiếu tới
        nút gốc root
        """
        self.root = None

    def getRoot(self):
        return self.root

    # Sinh viên hoàn thiện các hàm dưới đây
    # 2 hàm addNode và buildTreeFromList cần được hoàn thiện trước và chính xác,
    # nếu 2 hàm này chưa hoàn thiện
    # thì các hàm sau sẽ không được chấm điểm

    # Sinh viên cần hoàn thiện các hàm dưới đây

    # ===========================================================================================


    def addNode(self, number):
        """
        Thêm một node mới vào cây nhị phân tìm kiếm

        :param node: Node mới cần thêm
        :return: None
        """
        if self.root is None:
            self.root = Node(number, None, None)
        else:
            self.__addNode(self.root, Node(number, None, None))

    def __addNode(self, currentNode, newNode):
        """
        Phương thức trợ giúp cho addNode, thực hiện thêm một node mới vào cây nhị phân tìm kiếm

        :param currentNode: Node hiện tại đang xét
        :param newNode: Node mới cần thêm
        :return: None
        """
        if newNode.val < currentNode.val:
            if currentNode.left is None:
                currentNode.left = newNode
            else:
                self.__addNode(currentNode.left, newNode)
        else:
            if currentNode.right is None:
                currentNode.right = newNode
            else:
                self.__addNode(currentNode.right, newNode)

    def buildTreeFromList(self, datas):
        """
        Phương thức dựng cây nhị phân tìm kiếm
        từ danh sách các phần tử datas (danh sách các số nguyên)
        phần tử đầu tiên trong danh sách là node gốc (root)
        Hàm này bắt buộc cần làm đúng
        """
        for number in datas:
            self.addNode(number)
        return self.root

    def search(self, val):
        """
        Tìm kiếm xem giá trị val có trong cây hay không,
        Nếu có trả lại True, ngược lại trả lại False
        """
        return self.__search(self.root, val)

    def __search(self, node, val):
        if node is None:
            return False
        if node.val == val:
            return True
        if node.val < val:
            return self.__search(node.right, val)
        else:
            return self.__search(node.left, val)

    def preOrder(self):
        """
        Hàm trả lại danh sách các giá trị trên các node trong cây theo thứ tự trước (tiền thứ tự)
        node -> left -> right

        Hàm này thường được viết dưới dạng đệ quy, nếu cần các bạn nên viết thêm các hàm phụ trợ
        """
        result_list = []
        return self.__preOrder(self.root, result_list)

    def __preOrder(self, node, result_list):
        if node is None:
            return result_list

        result_list.append(node.val)
        self.__preOrder(node.left, result_list)
        self.__preOrder(node.right, result_list)
        return result_list

    def inOrder(self):
        """
        Hàm trả lại danh sách các giá trị trên các node trong cây theo thứ tự giữa (trung thứ tự)
        left -> node -> right

        Hàm này thường được viết dưới dạng đệ quy, nếu cần các bạn nên viết thêm các hàm phụ trợ

        """
        result_list = []
        return self.__inOrder(self.root, result_list)

    def __inOrder(self, node, result_list):
        if node is None:
            return result_list
        self.__inOrder(node.left, result_list)
        result_list.append(node.val)
        self.__inOrder(node.right, result_list)
        return result_list

    def postOrder(self):
        """
         Hàm trả lại danh sách các giá trị trên các node trong cây theo thứ tự sau (hậu thứ tự)
        left -> right -> node

         Hàm này thường được viết dưới dạng đệ quy, nếu cần các bạn nên viết thêm các hàm phụ trợ

        """
        result_list = []
        return self.__postOrder(self.root, result_list)

    def __postOrder(self, node, result_list):
        if node is None:
            return result_list
        self.__postOrder(node.left, result_list)
        self.__postOrder(node.right, result_list)
        result_list.append(node.val)
        return result_list

    def getHeight(self):
        """
        Hàm trả lại độ cao của cây,

        Độ cao của cây là số cạnh nhiều nhất trên các đường từ node gốc tới node lá
        """
        return self.__height(self.root) - 1

    def __height(self, node):
        if node is None:
            return 0
        else:
            return 1 + max(self.__height(node.left), self.__height(node.right))

    def getSumLeftChild(self, node):
        """
        Hàm tính tổng các giá trị trên cây con trái của node
        """
        if node is None:
            return 0
        sum_result = 0
        sum_result += self.__getSum(node.left)
        return sum_result

    def getSumRightChild(self, node):
        """
        Hàm tính tổng các giá trị trên cây con phải của node
        """
        if node is None:
            return 0
        sum_result = 0
        sum_result += self.__getSum(node.right)
        return sum_result

    def __getSum(self, node):
        if node is None:
            return 0
        sum_result = node.val
        sum_result += self.__getSum(node.left)
        sum_result += self.__getSum(node.right)
        return sum_result

    def getTilt(self):
        """
        Hàm tính độ nghiêng của cây,
        Độ nghiêng của cây được tính bằng tổng độ nghiêng của các node trong cây
        Độ nghiêng của mỗi node được tính bằng
        giá trị tuyệt đối của (tổng các giá trị trên cây con trái trừ đi tổng các giá trị trên cây
        con phải của node đó)
        """

        # Cách 1:
        self.total_tilt = 0

        def calculateTilt(node):
            if node is None:
                return 0
            left_sum = calculateTilt(node.left)
            right_sum = calculateTilt(node.right)
            tilt = abs(left_sum - right_sum)
            self.total_tilt += tilt
            return left_sum + right_sum + node.val

        calculateTilt(self.root)
        return self.total_tilt

        # Cách 2:
        # sum_tilt = 0

        # def calculateTilt(node):
        #     nonlocal sum_tilt
        #     if node is None:
        #         return 0
        #     tilt = abs(self.getSumLeftChild(node) - self.getSumRightChild(node))
        #     sum_tilt += tilt
        #     calculateTilt(node.left)
        #     calculateTilt(node.right)

        # calculateTilt(self.root)
        # return sum_tilt


# Những dòng dưới đây là code chạy thử chương trình, sinh viên không cần chỉnh sửa

if __name__ == "__main__":
    bst = BinarySearchTree()
    datas = [25, 15, 50, 10, 22, 35, 70, 4, 12, 18, 24, 31, 44, 66, 90]
    bst.buildTreeFromList(datas)

    print('Search 7:',bst.search(7))
    print('Search 12:',bst.search(12))

    print('PreOrder:',bst.preOrder())
    print('InOrder:',bst.inOrder())
    print('PostOrder:',bst.postOrder())
    print('Get height:',bst.getHeight())
    print('Sum of left child tree:',bst.getSumLeftChild(bst.getRoot()))
    print('Sum of right child tree:',bst.getSumRightChild(bst.getRoot()))
    print('Tilt of tree:',int(bst.getTilt()))
