"""
Bài 10: Viết chương trình xây dựng  từ  điển  dạng  cây  tiền  tố,  tạo  các  lớp,  xây  dựng  các 
phương thức hợp lý để chương trình có các chức năng như: 
- Thêm 1 từ vào từ điển 
- Xóa 1 từ khỏi từ điển 
- Đếm số từ trong từ điển 
- Tìm kiếm một từ trong từ điển 
- In ra các từ có trong từ điển 
- In ra các từ có tiền tố p (p là tham số) 
Tham khảo file prefixTree.pdf về cây tiền tố. 
"""

class TrieNode:
    def __init__(self):
        self.children = {}
        self.is_end_of_word = False

class Trie:
    def __init__(self):
        self.root = TrieNode()

    def insert(self, word):
        node = self.root
        for char in word:
            if char not in node.children:
                node.children[char] = TrieNode()
            node = node.children[char]
        node.is_end_of_word = True

    def delete(self, word):
        def _delete(node, word, index):
            if index == len(word):
                node.is_end_of_word = False
                return len(node.children) == 0
            char = word[index]
            if char not in node.children:
                return False
            should_delete = _delete(node.children[char], word, index + 1)
            if should_delete:
                del node.children[char]
                return len(node.children) == 0
            return False

        _delete(self.root, word, 0)

    def count_words(self):
        def _count_words(node):
            count = 0
            if node.is_end_of_word:
                count += 1
            for child_node in node.children.values():
                count += _count_words(child_node)
            return count

        return _count_words(self.root)

    def search(self, word):
        node = self.root
        for char in word:
            if char not in node.children:
                return False
            node = node.children[char]
        return node.is_end_of_word

    def print_words(self):
        def _print_words(node, current_word):
            if node.is_end_of_word:
                print(current_word)
            for char, child_node in node.children.items():
                _print_words(child_node, current_word + char)

        _print_words(self.root, "")

    def print_words_with_prefix(self, prefix):
        node = self.root
        for char in prefix:
            if char not in node.children:
                return
            node = node.children[char]

        def _print_words_with_prefix(node, current_word):
            if node.is_end_of_word:
                print(prefix + current_word)
            for char, child_node in node.children.items():
                _print_words_with_prefix(child_node, current_word + char)

        _print_words_with_prefix(node, "")

def test():
    # Example Usage
    trie = Trie()
    trie.insert("apple")
    trie.insert("app")
    trie.insert("application")
    trie.insert("banana")
    trie.insert("bat")

    print("Words in the trie:")
    trie.print_words()

    print("\nWords with prefix 'app':")
    trie.print_words_with_prefix("app")

    print("\nTotal number of words in the trie:", trie.count_words())

    print("\nSearching for 'apple':", trie.search("apple"))
    print("Searching for 'orange':", trie.search("orange"))

    trie.delete("app")
    print("\nAfter deleting 'app', words in the trie:")
    trie.print_words()

test()