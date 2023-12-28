class Function:

    STANDARD_ERROR = 0.0000000001
    X_0 = 0

    def sin(x, e):
        # Use Maclaurin series to approximate sin(x) = x - x^3/3! + x^5/5! - x^7/7! + ...
        global STANDARD_ERROR
        e = STANDARD_ERROR if e is None else e

        result = 0
        index = 1
        x_2 = x * x 
        error = x

        while (abs(error) > e):
            result += error
            error *= - x_2 / ((index + 1) * (index + 2))
            index += 2 

        result += error
        error *= - x_2 / ((index + 1) * (index + 2))
        return result + error
    
    def cos(x, e):
        # Use Maclaurin series to approximate cos(x) = 1 - x^2/2! + x^4/4! - x^6/6! + ...
        global STANDARD_ERROR
        e = STANDARD_ERROR if e is None else e

        result = 1 
        index = 2
        x_2 = x * x
        error = -0.5 * x_2  

        while (abs(error) > e):
            result += error 
            error *= - x_2 / ((index + 1) * (index + 2))
            index += 2
        
        result += error 
        error *= - x_2 / ((index + 1) * (index + 2))
        return result + error

    def tan(x, e): 
        e = Function.sqrt(e)
        return Function.sin(x, e) / Function.cos(x, e)
    
    def cot(x, e):
        e = Function.sqrt(e)
        return Function.cos(x, e) / Function.sin(x, e)
    
    def sinh(x, e):
        # Use Maclaurin series to approximate sinh(x) = x + x^3/3! + x^5/5! + x^7/7! + ...
        global STANDARD_ERROR
        e = STANDARD_ERROR if e is None else e

        result = 0
        index = 1
        x_2 = x * x 
        error = x

        while (abs(error) > e):
            result += error
            error *= x_2 / ((index + 1) * (index + 2))
            index += 2 

        result += error
        error *= x_2 / ((index + 1) * (index + 2))
        return result + error
    
    def cosh(x, e):
        # Use Maclaurin series to approximate cos(x) = 1 + x^2/2! + x^4/4! + x^6/6! + ...
        global STANDARD_ERROR
        e = STANDARD_ERROR if e is None else e

        result = 1 
        index = 2
        x_2 = x * x
        error = 0.5 * x_2  

        while (abs(error) > e):
            result += error 
            error *= x_2 / ((index + 1) * (index + 2))
            index += 2
        
        result += error 
        error *= x_2 / ((index + 1) * (index + 2))
        return result + error
    
    def tanh(x, e):
        pass 
    
    def sqrt(x, e):
        # Use Maclaurin series to approximate sqrt(x) = ???
        # Use equations solving (sqrt(x)^2) - x = 0
        global STANDARD_ERROR
        e = STANDARD_ERROR * 0.0000000001 if e is None else e

        return e 
        


