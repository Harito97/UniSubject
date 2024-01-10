class Polynomial:
    def __init__(self, coefficients):
        self.coefficients = coefficients
    def add(self, other):
        return Polynomial([a + b for a, b in zip(self.coefficients, other.coefficients)])
    def sub(self, other):
        return Polynomial([a - b for a, b in zip(self.coefficients, other.coefficients)])
    def multi(self, other):
        result = []
        for i in range(len(other.coefficients)):
            row = []
            for j in range(len(self.coefficients)):
                row.append(other.coefficients[i] * self.coefficients[j])
            result.append(row)
        return result

    def print_poly(coefficients):
        if coefficients == []:
            return "0"
        if type(coefficients[0]) != list:
            string = "f = "
            end_index = len(coefficients) - 1
            for i in range(end_index):
                string += str(coefficients[i]) + "*x_" + str(i) + " + "
            return string + str(coefficients[end_index]) + "*x_" + str(len(coefficients) - 1)
        else:
            string = "f = "
            end_index_i = len(coefficients) - 1
            end_index_j = len(coefficients[0]) - 1
            for i in range(end_index_i + 1):
                for j in range(end_index_j + 1):
                    if i == end_index_i and j == end_index_j:
                        break
                    string += str(coefficients[i][j]) + "*x_" + str(i) + "*" +  "x_" + str(j) + " + "
            return string + str(coefficients[end_index_i][end_index_j]) + "*x_" + str(end_index_i) + "*" +  "x_" + str(end_index_j)

poly1 = Polynomial([1, 2, 3])
poly2 = Polynomial([4, 5, 6])

print(Polynomial.print_poly(poly1.add(poly2).coefficients))
print(Polynomial.print_poly(poly2.sub(poly1).coefficients))
print(Polynomial.print_poly(poly1.multi(poly2)))

'''
Output:
f = 5*x_0 + 7*x_1 + 9*x_2
f = 3*x_0 + 3*x_1 + 3*x_2
f = 4*x_0*x_0 + 8*x_0*x_1 + 5*x_1*x_0 + 10*x_1*x_1 + 18*x_2*x_2
'''