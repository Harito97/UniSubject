class Rectangle:
    def __init__(self, width, height):
        self.width = width
        self.height = height
    def area(self):
        return self.width * self.height
    def perimeter(self):
        return 2 * (self.width + self.height)
    def __str__(self):
        return f"Rectangle(width={self.width}, height={self.height})"
    
class Square(Rectangle):
    def __init__(self, side):
        super().__init__(side, side)
    def __str__(self):
        return f"Square(side={self.width})"
    
a = float(input("Enter width of rectangle: "))
b = float(input("Enter height of rectangle: "))
rec = Rectangle(a, b)
print("Rectangle: " + str(rec))
print("Area of rectangle: " + str(rec.area()))
print("Perimeter of rectangle: " + str(rec.perimeter()))

c = float(input("Enter side of square: "))
sq = Square(c)
print("Square: " + str(sq))
print("Area of square: " + str(sq.area()))
print("Perimeter of square: " + str(sq.perimeter()))