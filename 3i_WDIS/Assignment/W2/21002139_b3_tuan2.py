class Point:
    def __init__(self, x, y):
        self.x = x
        self.y = y
    def distance(self, other):
        return ((self.x - other.x)**2 + (self.y - other.y)**2)**0.5
    def __str__(self):
        return "({0}, {1})".format(self.x, self.y)
    
p1 = Point(1, 2)
p2 = Point(4, 2)
print("Point 1: " + p1.__str__())
print("Point 2: " + p2.__str__())

print("Distance of p1 and p2: " + str(p1.distance(p2)))