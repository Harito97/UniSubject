def sovle_equation(a, b, c):
    import math 
    if a == 0:
        if b == 0:
            if c == 0:
                # PT vo so nghiem
                return None
            else:
                return []
        else:
            # b != 0
            return [-c / b]

    # a != 0
    delta = b**2 - 4 * a * c
    if delta < 0:
        import cmath
        x1 = complex(-b/ 2/a, - abs(delta) /2/a)
        x2 = complex(-b/ 2/a, abs(delta) /2/a)
        return [x1, x2]
    elif delta == 0:
        x = -b / (2 * a)
        return [x, x]
    else:
        x1 = (-b + math.sqrt(delta)) / (2 * a)
        x2 = (-b - math.sqrt(delta)) / (2 * a)
        return sorted([x1, x2])

# Giai pt bac 2: ax^2 + bx + c = 0
print("Giai pt ax^2 + bx + c = 0")
a = float(input("a = "))
b = float(input("b = "))
c = float(input("c = "))
print("Nghiem thu duoc la: " + str(sovle_equation(a, b, c)))